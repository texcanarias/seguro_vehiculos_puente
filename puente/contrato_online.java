/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Contrato_historico_model;
import modelos.Contrato_model;
import modelos.Marca_modelo_model;

/**
 *
 * @author antonio
 */
public class contrato_online extends EnlaceDual {

    /**
     * Constructor.
     */
    public contrato_online() {
        this.TablaAccess = ""; //No hay relacion.
        this.TablaMySql = "ftn_agg_contrato";
    }

    /**
     * Recogemos del sistema de persistencia mysql todos los contratos.
     *
     * @return
     */
    protected ArrayList getItemsMySql() {
        ArrayList<Contrato_model> Devolucion = new ArrayList<Contrato_model>();

        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " Id, "
                    + " IdEstado,"
                    + " ftn_agg_propietarioId, "
                    + " ftn_agg_garantia_detalleId, "
                    + " ftn_agg_concesionarioId, "
                    + " ftn_agg_modeloId, "
                    + " NumeroPoliza, "
                    + " Matricula, "
                    + " IF(FechaPrimeraMatriculacion IS NULL,'',FechaPrimeraMatriculacion) as FechaPrimeraMatriculacion, "
                    + " KilometrosActuales, "
                    + " CajaAutomatica, "
                    + " IdCaballos, "
                    + " IdCategoria, "
                    + " TodoTerreno, "
                    + " Industrial, "
                    + " IF(FechaRecepcion IS NULL,'',FechaRecepcion) as FechaRecepcion, "
                    + " IF(FechaIngreso IS NULL,'',FechaIngreso) as FechaIngreso, "
                    + " IF(FechaPago IS NULL,'',FechaPago) as FechaPago,"
                    + " IF(FechaInicio IS NULL,'',FechaInicio) as FechaInicio,"
                    + " IF(FechaFinalizacion IS NULL,'',FechaFinalizacion) as FechaFinalizacion,"
                    + " IdFormaPago, "
                    + " Precio, "
                    + " PrecioImp, "
                    + " TipoIva, "
                    + " Comentarios, "
                    + " CCC "
                    + "FROM "
                    + " ftn_agg_contrato "
                    + "WHERE "
                    + " Sincronizar = 1");

            while (rs.next()) {
                Contrato_model A = new Contrato_model();
                A.setIdEstado(rs.getString("IdEstado").charAt(0));
                A.setNumeroPoliza(rs.getString("NumeroPoliza"));
                A.setMatricula(rs.getString("Matricula"));
                A.setFechaPrimeraMatriculacion(rs.getString("FechaPrimeraMatriculacion"));
                A.setKilometrosActuales(rs.getInt("KilometrosActuales"));
                A.setCajaAutomatica(rs.getBoolean("CajaAutomatica"));
                A.setIdCaballos(rs.getInt("IdCaballos"));
                A.setIdCategoria(rs.getInt("IdCategoria"));
                A.setTodoTerreno(rs.getBoolean("TodoTerreno"));
                A.setIndustrial(rs.getBoolean("Industrial"));
                A.setFechaRecepcion(rs.getString("FechaRecepcion"));
                A.setFechaIngreso(rs.getString("FechaIngreso"));
                A.setFechaPago(rs.getString("FechaPago"));
                A.setFechaInicio(rs.getString("FechaInicio"));
                A.setFechaFinalizacion(rs.getString("FechaFinalizacion"));
                A.setIdFormaPago(rs.getString("IdFormaPago").charAt(0));
                A.setPrecio(rs.getFloat("Precio"));
                A.setPrecioImp(rs.getFloat("PrecioImp"));
                A.setTipoIva(rs.getFloat("TipoIva"));
                A.setComentarios(rs.getString("Comentarios"));
                A.setCCC(rs.getString("CCC"));

                //Cogemos los datos relacionados
                concesionario ObJConcesionario = new concesionario();
                A.setConcesionario(ObJConcesionario.getItemMySql(rs.getInt("ftn_agg_concesionarioId")));

                propietario ObjPropietario = new propietario();
                A.setPropietario(ObjPropietario.getItemMySql(rs.getInt("ftn_agg_propietarioId")));

                garantia ObjGarantia = new garantia();
                A.setGarantia(ObjGarantia.getItemMySql(rs.getInt("ftn_agg_garantia_detalleId")));

                marca_modelo ObjMarcaModelo = new marca_modelo();
                Marca_modelo_model marca_modelo_model = ObjMarcaModelo.getItemMySql(rs.getInt("ftn_agg_modeloId"));
                A.setMarca(marca_modelo_model.getMarca());
                A.setModelo(marca_modelo_model.getModelo());

                Devolucion.add(A);
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. (contrato_online.getItemsMySql)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (contrato_online.getItemsMySql)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return Devolucion;
    }

    /**
     * Para un vector de objetos los exporta a ACCESS desde objetos creados de
     * la persistencia en MySql
     *
     * @param Importacion
     */
    protected void setItemsAccess(ArrayList<Contrato_model> Importacion) {
        for (int i = 0; i < Importacion.size(); ++i) {
            Contrato_historico_model A = Importacion.get(i).getContratoHistorico();
            if (null == this.ConnAccess) {
                this.CrearConnAccess();
            }
            String Sql = "";

            try {
                Statement st = this.ConnAccess.createStatement();
                Sql = "SELECT * FROM Garantias WHERE NGarantia = '" + A.getNGarantia().trim() + "' ";
                ResultSet rs = st.executeQuery(Sql);
                boolean Existe = false;
                while (rs.next())
                    Existe = true;

                String FechaPrimeraMatriculacion = A.getFechaPrimeraMatriculacion();
                if (FechaPrimeraMatriculacion.equals("0000-00-00") || FechaPrimeraMatriculacion.equals("")) 
                    FechaPrimeraMatriculacion = "null";
  

                String FechaRecepcion = A.getFechaRecepcion();
                if (FechaRecepcion.equals("0000-00-00") || FechaRecepcion.equals("")) 
                    FechaRecepcion = "null";
  
                String FechaInicio = A.getFechaInicio();
                if (FechaInicio.equals("0000-00-00") || FechaInicio.equals("")) 
                    FechaInicio = "null";
  
                String FechaFinalizacion = A.getFechaFinalizacion();
                if (FechaFinalizacion.equals("0000-00-00") || FechaFinalizacion.equals("")) 
                    FechaFinalizacion = "null";
  
                String FechaPago = A.getFechaPago();
                if (FechaPago.equals("0000-00-00") || FechaPago.equals("")) 
                    FechaPago = "null";
                    
                    
                if (!Existe) {
                    //Hacemos un insert                                        
                    Sql = "     INSERT INTO"
                            + "     Garantias "
                            + " (NGarantia, IdCliente, IdComercial,"
                            + "  TipoVehiculo, Marca, Modelo, ValorVenal,"
                            + "  Matricula, FechaPrimeraMatriculacion, NBastidor,"
                            + "  KilometrosActuales,Asistencia,"
                            + "  NombreApellidos,Direccion,CodPostal,"
                            + "  Poblacion, Provincia, CIF, "
                            + "  CIFExtranjero,Telefono, Fax,"
                            + "  TipoGarantia, Duracion, Precio,"
                            + "  Cobertura, FormaPago,Facturar,"
                            + "  Facturado,NPuntos, Aceptada,"
                            + "  FechaRecepcion, FechaInicio, Pagado, "
                            + "  FechaFinalizacion, Caducada ,"
                            + "  Observaciones, ImporteLimiteGarantia, LimiteGarantia, "
                            + "  ImportePagado, Rappel, Anulada, "
                            + "  Certiauto,CajaAutomatica, NCuenta )"
                            + " VALUES "
                            + "  (? ,?,0 "
                            + "   , 1  ,?,? ,0 "
                            + "   ,?,? ,'Nulo'"
                            + "   ,? ,0"
                            + "   ,? ,?,? "
                            + "    ,?, ?,? "
                            + "    , 'Nulo' ,?,?"
                            + "    ,? ,?,?"
                            + "   ,100,?, 0 "
                            + "   ,0 ,0 , 0"
                            + "   ,? , ? ,? "
                            + "   ,?,  0 "
                            + "   ,? ,0 ,0 "
                            + "   ,? ,0 ,? "
                            + "   ,0 , ?, ?)";

                    PreparedStatement pst = this.ConnAccess.prepareStatement(Sql);
                    pst.setString(1, A.getNGarantia());
                    pst.setInt(2, A.getFtn_agg_concesionario_IdRemoto());
                    pst.setString(3, A.getMarca().toUpperCase());
                    pst.setString(4, A.getModelo().toUpperCase());
                    pst.setString(5, A.getMatricula());
                    pst.setString(6, FechaPrimeraMatriculacion);
                    pst.setInt(7, A.getKilometrosActuales());
                    pst.setString(8, A.getNombreApellidos());
                    pst.setString(9, A.getDireccion());
                    pst.setString(10, A.getCodPostal());
                    pst.setString(11, A.getPoblacion());
                    pst.setString(12, A.getProvincia());
                    pst.setString(13, A.getCIF());
                    pst.setString(14, A.getTelefono());
                    pst.setString(15, A.getFax());
                    pst.setInt(16, A.getTipoGarantia());
                    pst.setString(17, A.getDuracion() + " meses");
                    pst.setBigDecimal(18, new BigDecimal(A.getPrecio()));
                    pst.setString(19, A.getFormaPago());
                    pst.setString(20, FechaRecepcion);
                    pst.setString(21, FechaInicio);
                    pst.setBoolean(22, A.getPagado());
                    pst.setString(23, FechaFinalizacion);
                    pst.setString(24, A.getObservaciones());
                    pst.setBigDecimal(25, new BigDecimal(A.getPrecio()));
                    pst.setBoolean(26, A.getAnulada());
                    pst.setBoolean(27, A.getCajaAutomatica());
                    pst.setString(28, A.getCCC());

                    pst.executeUpdate();
                    pst.close();
                } else {
                    //Hacemos un update
                    Sql = "     UPDATE"
                            + "     Garantias "
                            + " SET "
                            + "     IdCliente = ? "
                            + "     ,IdComercial = 0 " //Hay que poner el Id del comercial 
                            + "     ,TipoVehiculo = 1 "
                            + "     ,Marca = ? "
                            + "     ,Modelo = ? "
                            + "     ,ValorVenal = 0 "
                            + "     ,Matricula = ? "
                            + "     ,FechaPrimeraMatriculacion = ? "
                            + "     ,NBastidor = 'Nulo'"
                            + "     ,KilometrosActuales = ? "
                            + "     ,Asistencia = 0"
                            + "     ,NombreApellidos = ? "
                            + "     ,Direccion = ? "
                            + "     ,CodPostal = ? "
                            + "     ,Poblacion = ? "
                            + "     ,Provincia = ? "
                            + "     ,CIF = ? "
                            + "     ,CIFExtranjero = 'Nulo'"
                            + "     ,Telefono = ? "
                            + "     ,Fax = ? "
                            + "     ,TipoGarantia = ? "
                            + "     ,Duracion = ? "
                            + "     ,Precio = ? "
                            + "     ,Cobertura = 100"
                            + "     ,FormaPago = ? "
                            + "     ,Facturar = 0"
                            + "     ,Facturado = 0"
                            + "     ,NPuntos = 0"
                            + "     ,Aceptada = 0"
                            + "     ,FechaRecepcion = ? "
                            + "     ,FechaInicio = ? "
                            + "     ,Pagado = ? "
                            + "     ,FechaFinalizacion = ? "
                            + "     ,Caducada = 0 "
                            + "     ,Observaciones = ? "
                            + "     ,ImporteLimiteGarantia = 0"
                            + "     ,LimiteGarantia = 0"
                            + "     ,ImportePagado = ? "
                            + "     ,Rappel = 0"
                            + "     ,Anulada = ? "
                            + "     ,Certiauto = 0"
                            + "     ,CajaAutomatica = ? "
                            + "     ,NCuenta = ? "
                            + " WHERE "
                            + "     NGarantia = ? ";

                    PreparedStatement pst = this.ConnAccess.prepareStatement(Sql);

                    pst.setInt(1, A.getFtn_agg_concesionario_IdRemoto());
                    pst.setString(2, A.getMarca().toUpperCase());
                    pst.setString(3, A.getModelo().toUpperCase());
                    pst.setString(4, A.getMatricula());
                    pst.setString(5, FechaPrimeraMatriculacion);
                    pst.setInt(6, A.getKilometrosActuales());
                    pst.setString(7, A.getNombreApellidos());
                    pst.setString(8, A.getDireccion());
                    pst.setString(9, A.getCodPostal());
                    pst.setString(10, A.getPoblacion());
                    pst.setString(11, A.getProvincia());
                    pst.setString(12, A.getCIF());
                    pst.setString(13, A.getTelefono());
                    pst.setString(14, A.getFax());
                    pst.setInt(15, A.getTipoGarantia());
                    pst.setString(16, A.getDuracion() + " meses");
                    pst.setBigDecimal(17, new BigDecimal(A.getPrecio()));
                    pst.setString(18, A.getFormaPago());
                    pst.setString(19, FechaRecepcion);
                    pst.setString(20, FechaInicio);
                    pst.setBoolean(21, A.getPagado());
                    pst.setString(22, FechaFinalizacion);
                    pst.setString(23, A.getObservaciones());
                    pst.setBigDecimal(24, new BigDecimal(A.getPrecio()));
                    pst.setBoolean(25, A.getAnulada());
                    pst.setBoolean(26, A.getCajaAutomatica());
                    pst.setString(27, A.getCCC());
                    pst.setString(28, A.getNGarantia());

                    pst.executeUpdate();
                    pst.close();
                }
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos Access. (contrato_online.setItemsAccess)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println("SQL es " + Sql + " con Id= "+A.getNGarantia());
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (contrato_online.setItemsAccess)");
                System.out.println("[" + eb.getMessage() + "] " + eb);
                System.out.println("Causa " + eb.getCause());
            }

            Sql = "UPDATE ftn_agg_contrato SET Sincronizar = 0 WHERE NumeroPoliza LIKE '" + A.getNGarantia() + "%' ;";

            if (null == this.ConnMySql) {
                this.CrearConnMySql();
            }
            try {
                Statement st = this.ConnMySql.createStatement();
                int Dev = st.executeUpdate(Sql);
                System.out.println("Quitamos la bandera de sincronizacion en ftn_agg_contrato " + A.getNGarantia() + "[" + Dev + "]");
                st.close();
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos MySql. (Concesionario.exportarItem reset)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Concesionario.exportarItem reset)");
                System.out.println(eb);
                System.out.println(Sql);
            }

        }
    }
}
