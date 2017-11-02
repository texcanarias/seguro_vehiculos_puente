/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Contrato_historico_model;

/**
 *
 * @author antonio
 */
public class contrato_historico extends EnlaceDual {

    public contrato_historico() {
        super();
        this.TablaAccess = "Garantias";
        this.TablaMySql = "ftn_agg_contrato_historico";
    }

    /**
     * Metodo de prueba que cuenta el numero de registros de una tabla.
     *
     * @version 20130208
     */
    protected int ContarRegistrosAccess() {
        int Total = 0;
        if (null == this.ConnAccess) {
            this.CrearConnAccess();
        }
        try {
            Statement st = this.ConnAccess.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " count(*) as Total "
                    + "FROM "
                    + " Garantias "
                    + "WHERE "
                    + " Sincronizar = True");

            rs.next();
            Total = rs.getInt("Total");
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. (ContarRegistrosAccess)");
            System.out.println(ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (ContarRegistrosAccess)");
            System.out.println(eb);
        }
        return Total;
    }

    /**
     * Recogemos los Items modificados de una tabla.
     */
    protected ArrayList getItemsAccess() {
        ArrayList<Contrato_historico_model> Devolucion = new ArrayList<Contrato_historico_model>();

        if (null == this.ConnAccess) {
            this.CrearConnAccess();
        }
        try {
            Statement st = this.ConnAccess.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " NGarantia,"
                    + " IdCliente,"
                    + " IdComercial,"
                    + " TipoVehiculo,"
                    + " Marca,"
                    + " Modelo,"
                    + " IIF(ISNULL(Matricula),'',Matricula) as CMatricula,"
                    + " FechaPrimeraMatriculacion,"
                    + " IIF(ISNULL(KilometrosActuales),0,KilometrosActuales) as CKilometrosActuales,"
                    + " IIF(ISNULL(NombreApellidos),'',NombreApellidos) as CNombreApellidos,"
                    + " IIF(ISNULL(Direccion),'',Direccion) as CDireccion,"
                    + " IIF(ISNULL(CodPostal),'',CodPostal) as CCodPostal,"
                    + " IIF(ISNULL(Poblacion),'',Poblacion) as CPoblacion,"
                    + " IIF(ISNULL(Provincia),43,Provincia) as CProvincia,"
                    + " IIF(ISNULL(CIF),'',CIF) as CCIF,"
                    + " IIF(ISNULL(CIFExtranjero),'',CIFExtranjero) as CCIFExtranjero,"
                    + " IIF(ISNULL(Telefono),'',Telefono) as CTelefono,"
                    + " IIF(ISNULL(Fax),'',Fax) as CFax,"
                    + " IIF(ISNULL(TipoGarantia),1,TipoGarantia) as CTipoGarantia,"
                    + " IIF(ISNULL(Duracion),'',Duracion) as CDuracion,"
                    + " IIF(ISNULL(Precio), 0.00,Precio) as CPrecio,"
                    + " IIF(ISNULL(FormaPago), '',FormaPago) as CFormaPago,"
                    + " FechaRecepcion,"
                    + " FechaInicio,"
                    + " Pagado,"
                    + " FechaFinalizacion,"
                    + " IIF(ISNULL(Observaciones), '',Observaciones) as CObservaciones,"
                    + " Anulada,"
                    + " FechaPago,"
                    + " CajaAutomatica, "
                    + " Facturar, "
                    + " Facturado, "
                    + " Aceptada, "
                    + " Pagado, "
                    + " Anulada, "
                    + " IIF(ISNULL(NCuenta), '',NCuenta) as CNCuenta "
                    + "FROM "
                    + " Garantias "
                    + "WHERE "
                    + " Sincronizar = True ");
            while (rs.next()) {
                Contrato_historico_model A = new Contrato_historico_model();
                A.setNGarantia(rs.getString("NGarantia"));
                A.setFtn_agg_concesionario_IdRemoto(rs.getInt("IdCliente"));
                A.setIdComercial(rs.getInt("IdComercial"));
                A.setTipoVehiculo(rs.getInt("TipoVehiculo"));
                A.setMarca(rs.getString("Marca"));
                A.setModelo(rs.getString("Modelo"));
                A.setMatricula(rs.getString("CMatricula"));
                A.setFechaPrimeraMatriculacion(rs.getString("FechaPrimeraMatriculacion"));
                A.setKilometrosActuales(rs.getInt("CKilometrosActuales"));
                A.setNombreApellidos(rs.getString("CNombreApellidos"));
                A.setDireccion(rs.getString("CDireccion"));
                A.setCodPostal(rs.getString("CCodPostal"));
                A.setPoblacion(rs.getString("CPoblacion"));
                A.setProvincia(rs.getString("CProvincia"));
                A.setCIF(rs.getString("CCIF"));
                A.setCIFExtranjero(rs.getString("CCIFExtranjero"));
                A.setTelefono(rs.getString("CTelefono"));
                A.setFax(rs.getString("CFax"));
                A.setTipoGarantia(rs.getInt("CTipoGarantia"));
                A.setDuracion(rs.getString("CDuracion"));
                A.setPrecio(rs.getString("CPrecio"));
                A.setFormaPago(rs.getString("CFormaPago"));
                A.setFechaRecepcion(rs.getString("FechaRecepcion"));
                A.setFechaInicio(rs.getString("FechaInicio"));
                A.setPagado(rs.getBoolean("Pagado"));
                A.setFechaFinalizacion(rs.getString("FechaFinalizacion"));
                A.setObservaciones(rs.getString("CObservaciones"));
                A.setAnulada(rs.getBoolean("Anulada"));
                A.setFechaPago(rs.getString("FechaPago"));
                A.setCajaAutomatica(rs.getBoolean("CajaAutomatica"));
                A.setCCC(rs.getString("CNCuenta"));
                Devolucion.add(A);
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. (contrato_historico.getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (contrato_historico.getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return Devolucion;
    }

    /**
     * Transferir registros desde la base ACCESS a MYSQL
     *
     * @param Obj
     */
    protected void exportarItemAccess(Contrato_historico_model Obj) {
        String Sql = "";
        /*Averiguamos si ya se ha metido el registro con anterioridad para saber
         si es un insert o un update*/
        int Total = 0;
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();
            Sql = "    SELECT"
                    + " count(*) as Total "
                    + "FROM "
                    + " ftn_agg_contrato_historico "
                    + "WHERE"
                    + " NGarantia = '" + Obj.getNGarantia() + "'";

            ResultSet rs = st.executeQuery(Sql);

            rs.next();
            Total = rs.getInt("Total");
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos mysql. (contrato_historico.exportarItem)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
            System.out.println(Sql);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (contrato_historico.exportarItem)");
            System.out.println(eb);
            System.out.println(Sql);
        }

        if (0 == Total) {
            Sql = "     INSERT INTO"
                    + "     ftn_agg_contrato_historico "
                    + " SET"
                    + "     NGarantia = ? ,"
                    + "     ftn_agg_concesionario_IdRemoto = ? ,"
                    + "     TipoVehiculo = ? ,"
                    + "     Marca = ? ,"
                    + "     Modelo = ? ,"
                    + "     Matricula = ?,"
                    + "     FechaPrimeraMatriculacion = ? ,"
                    + "     KilometrosActuales = ? ,"
                    + "     NombreApellidos = ? ,"
                    + "     Direccion = ? ,"
                    + "     CodPostal = ? ,"
                    + "     Poblacion = ? ,"
                    + "     Provincia = ? ,"
                    + "     CIF = ? ,"
                    + "     CIFExtranjero = ? ,"
                    + "     Telefono = ? ,"
                    + "     Fax = ? ,"
                    + "     TipoGarantia = ? ,"
                    + "     Duracion = ? ,"
                    + "     Precio = ? ,"
                    + "     FormaPago = ? ,"
                    + "     FechaRecepcion = ? ,"
                    + "     FechaInicio = ? ,"
                    + "     Pagado = ? ,"
                    + "     FechaFinalizacion = ? ,"
                    + "     Observaciones = ? ,"
                    + "     Anulada = ? ,"
                    + "     FechaPago = ? ,"
                    + "     CajaAutomatica = ? ";

            if (null == this.ConnMySql) {
                this.CrearConnMySql();
            }
            try {
                PreparedStatement pst = this.ConnMySql.prepareStatement(Sql);

                pst.setString(1, Obj.getNGarantia());
                pst.setInt(2, Obj.getFtn_agg_concesionario_IdRemoto());
                pst.setInt(3, Obj.getTipoVehiculo());
                pst.setString(4, Obj.getMarca());
                pst.setString(5, Obj.getModelo());
                pst.setString(6, Obj.getMatricula());
                pst.setString(7, Obj.getFechaPrimeraMatriculacion());
                pst.setInt(8, Obj.getKilometrosActuales());
                pst.setString(9, Obj.getNombreApellidos());
                pst.setString(10, Obj.getDireccion());
                pst.setString(11, Obj.getCodPostal());
                pst.setString(12, Obj.getPoblacion());
                pst.setString(13, Obj.getProvincia());
                pst.setString(14, Obj.getCIF());
                pst.setString(15, Obj.getCIFExtranjero());
                pst.setString(16, Obj.getTelefono());
                pst.setString(17, Obj.getFax());
                pst.setInt(18, Obj.getTipoGarantia());
                pst.setString(19, Obj.getDuracion());
                pst.setString(20, Obj.getPrecio());
                pst.setString(21, Obj.getFormaPago());
                pst.setString(22, Obj.getFechaRecepcion());
                pst.setString(23, Obj.getFechaInicio());
                pst.setBoolean(24, Obj.getPagado());
                pst.setString(25, Obj.getFechaFinalizacion());
                pst.setString(26, Obj.getObservaciones());
                pst.setBoolean(27, Obj.getAnulada());
                pst.setString(28, Obj.getFechaPago());
                pst.setBoolean(29, Obj.getCajaAutomatica());

                System.out.println("Insertamos en ftn_agg_contrato_historico " + Obj.getNGarantia());

                pst.executeUpdate();
                pst.close();
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos mysql. (contrato_historico.exportarItem)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (contrato_historico.exportarItem)");
                System.out.println(eb);
                System.out.println(Sql);
            }
        } else {
            //Hacemos un update
            //Registramos el objeto concesionario            
            Sql = "     UPDATE"
                    + "     ftn_agg_contrato_historico "
                    + " SET"
                    + "     ftn_agg_concesionario_IdRemoto = ? ,"
                    + "     TipoVehiculo = ? ,"
                    + "     Marca = ? ,"
                    + "     Modelo = ? ,"
                    + "     Matricula = ?,"
                    + "     FechaPrimeraMatriculacion = ? ,"
                    + "     KilometrosActuales = ? ,"
                    + "     NombreApellidos = ? ,"
                    + "     Direccion = ? ,"
                    + "     CodPostal = ? ,"
                    + "     Poblacion = ? ,"
                    + "     Provincia = ? ,"
                    + "     CIF = ? ,"
                    + "     CIFExtranjero = ? ,"
                    + "     Telefono = ? ,"
                    + "     Fax = ? ,"
                    + "     TipoGarantia = ? ,"
                    + "     Duracion = ? ,"
                    + "     Precio = ? ,"
                    + "     FormaPago = ? ,"
                    + "     FechaRecepcion = ? ,"
                    + "     FechaInicio = ? ,"
                    + "     Pagado = ? ,"
                    + "     FechaFinalizacion = ? ,"
                    + "     Observaciones = ? ,"
                    + "     Anulada = ? ,"
                    + "     FechaPago = ? ,"
                    + "     CajaAutomatica = ? "
                    + " WHERE "
                    + "     NGarantia = ?  ";

            if (null == this.ConnMySql) {
                this.CrearConnMySql();
            }
            try {
                PreparedStatement pst = this.ConnMySql.prepareStatement(Sql);

                pst.setInt(1, Obj.getFtn_agg_concesionario_IdRemoto());
                pst.setInt(2, Obj.getTipoVehiculo());
                pst.setString(3, Obj.getMarca());
                pst.setString(4, Obj.getModelo());
                pst.setString(5, Obj.getMatricula());
                pst.setString(6, Obj.getFechaPrimeraMatriculacion());
                pst.setInt(7, Obj.getKilometrosActuales());
                pst.setString(8, Obj.getNombreApellidos());
                pst.setString(9, Obj.getDireccion());
                pst.setString(10, Obj.getCodPostal());
                pst.setString(11, Obj.getPoblacion());
                pst.setString(12, Obj.getProvincia());
                pst.setString(13, Obj.getCIF());
                pst.setString(14, Obj.getCIFExtranjero());
                pst.setString(15, Obj.getTelefono());
                pst.setString(16, Obj.getFax());
                pst.setInt(17, Obj.getTipoGarantia());
                pst.setString(18, Obj.getDuracion());
                pst.setString(19, Obj.getPrecio());
                pst.setString(20, Obj.getFormaPago());
                pst.setString(21, Obj.getFechaRecepcion());
                pst.setString(22, Obj.getFechaInicio());
                pst.setBoolean(23, Obj.getPagado());
                pst.setString(24, Obj.getFechaFinalizacion());
                pst.setString(25, Obj.getObservaciones());
                pst.setBoolean(26, Obj.getAnulada());
                pst.setString(27, Obj.getFechaPago());
                pst.setBoolean(28, Obj.getCajaAutomatica());
                pst.setString(29, Obj.getNGarantia());

                System.out.println("Actualizamos en ftn_agg_contrato_historico " + Obj.getNGarantia());

                pst.executeUpdate();
                pst.close();

            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos mysql. (Concesionario.exportarItem 3)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Concesionario.exportarItem 3)");
                System.out.println(eb);
            }

        }
        //Como hemos terminado de pasar los concesionarios pasamos los campos 'Sincronizar' a 0.
        Sql = "UPDATE Garantias SET Sincronizar = false WHERE NGarantia = '" + Obj.getNGarantia() + "';";

        if (null == this.ConnAccess) {
            this.CrearConnAccess();
        }
        try {
            Statement st = this.ConnAccess.createStatement();
            int Dev = st.executeUpdate(Sql);
            System.out.println(Sql);
            System.out.println("Quitamos bandera de sincronización en Garantia a " + Obj.getNGarantia() + "[" + Dev + "]");
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. (contrato_historico.exportarItem reset)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
            System.out.println(Sql);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (contrato_historico.exportarItem reset)");
            System.out.println(eb);
            System.out.println(Sql);
        }
    }

    /**
     * Para un vector de objetos los exporta de ACCESS al sistema con MySql
     *
     * @param Importacion
     */
    protected void setItemsAccess(ArrayList<Contrato_historico_model> Importacion) {
        for (int i = 0; i < Importacion.size(); ++i) {
            System.out.println((Contrato_historico_model) Importacion.get(i));
            this.exportarItemAccessNuevo((Contrato_historico_model) Importacion.get(i));
            this.exportarItemAccess((Contrato_historico_model) Importacion.get(i));
        }
    }

    /**
     * Transferir registros desde la base ACCESS a MYSQL
     *
     * @param Obj
     */
    protected void exportarItemAccessNuevo(Contrato_historico_model Obj) {
        String Sql = "";
        /*Averiguamos si ya se ha metido el registro con anterioridad para saber
         si es un insert o un update*/
        int Total = 0;
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();
            Sql = "    SELECT"
                    + " count(*) as Total "
                    + "FROM "
                    + " ftn_agg_contrato "
                    + "WHERE"
                    + " NumeroPoliza LIKE '%" + Obj.getNGarantia() + "%'";

            ResultSet rs = st.executeQuery(Sql);
            rs.next();
            Total = rs.getInt("Total");
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos mysql. (contrato_historico.exportarItem)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
            System.out.println(Sql);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (contrato_historico.exportarItem)");
            System.out.println(eb);
            System.out.println(Sql);
        }

        Character IdEstado = '-';
        if (Obj.getPagado()) {
            IdEstado = 'P';
        }
        if (Obj.getAnulada()) {
            IdEstado = 'X';
        }
        if (Obj.getAceptada() || Obj.getFacturar()) {
            IdEstado = 'A';
        }
        if (Obj.getFacturado()) {
            IdEstado = 'F';
        }

        if (0 != Total && IdEstado != '-') {
            //Hacemos un update
            //Registramos el objeto concesionario            
            Sql = "     UPDATE"
                    + "     ftn_agg_contrato "
                    + " SET"
                    + "     IdEstado = '" + IdEstado.toString() + "' ,"
                    + "     CCC = '" + Obj.getCCC() + "' ,"
                    + "     Matricula = '" + Obj.getMatricula() + "' " + " WHERE "
                    + "     NumeroPoliza LIKE '%" + Obj.getNGarantia() + "%'  ";

            if (null == this.ConnMySql) {
                this.CrearConnMySql();
            }
            try {
                Statement st = this.ConnMySql.createStatement();
                st.executeUpdate(Sql);
                st.close();
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos mysql. (Concesionario.exportarItem 3)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Concesionario.exportarItem 3)");
                System.out.println(eb);
            }

            //Recuperamos el Id del propietario para poder cambiar sus datos.
            Integer IdPropietario = 0;
            try {
                Statement st = this.ConnMySql.createStatement();
                Sql = "    SELECT"
                        + " ftn_agg_propietarioId "
                        + "FROM "
                        + " ftn_agg_contrato "
                        + "WHERE"
                        + " NumeroPoliza LIKE '%" + Obj.getNGarantia() + "%' "
                        + "LIMIT 1";

                ResultSet rs = st.executeQuery(Sql);
                rs.next();
                IdPropietario = rs.getInt("ftn_agg_propietarioId");
                st.close();
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos mysql. (contrato_historico.exportarItem)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (contrato_historico.exportarItem)");
                System.out.println(eb);
                System.out.println(Sql);
            }

            //Hacemos los cambios sobre los campos Cif,Telefono,Fax de la tabla ftn_agg_propietario
            if (0 != IdPropietario) {
                try {

                    Sql = "     UPDATE"
                            + "     ftn_agg_propietario "
                            + " SET"
                            + "     Cif = ? ,"
                            + "     Telefono = ? ,"
                            + "     Fax = ? "
                            + " WHERE "
                            + "     Id = ?  ";

                    PreparedStatement st = this.ConnMySql.prepareStatement(Sql);
                    st.setString(1, Obj.getCIF());
                    st.setString(2, Obj.getTelefono());
                    st.setString(3, Obj.getFax());
                    st.setInt(4, IdPropietario);
                    st.executeUpdate();

                    //Recuperamos el ftn_registro_usuariosId de ftn_agg_propietario
                    Integer IdRegistroUsuario;
                    Sql = " SELECT"
                            + "     ftn_registro_usuariosId "
                            + "FROM "
                            + "     ftn_agg_propietario"
                            + " WHERE "
                            + "     Id = " + IdPropietario + "  ";
                    ResultSet rs = st.executeQuery(Sql);
                    rs.next();
                    IdRegistroUsuario = rs.getInt("ftn_registro_usuariosId");

                    //Grabamos los datos en ftn_registro_usuario
                    Sql = "     UPDATE"
                            + "     ftn_registro_usuarios "
                            + " SET"
                            + "     Nombre = ? "
                            + " WHERE "
                            + "     Id = ?  ";

                    st = this.ConnMySql.prepareStatement(Sql);
                    st.setString(1, Obj.getNombreApellidos());
                    st.setInt(2, IdRegistroUsuario);

                    st.executeUpdate();

                    //Grabamos los datos en  ftn_agg_propietario_domicilio
                    Sql = "     UPDATE"
                            + "     ftn_agg_propietario_domicilio "
                            + " SET"
                            + "     Domicilio = ? ,"
                            + "     Localidad = ? ,"
                            + "     Cp = ? ,"
                            + "     IdProvincia = ?"
                            + " WHERE "
                            + "     ftn_agg_propietarioId = ? "
                            + "     AND"
                            + "     Prioridad = 0 ";

                    st = this.ConnMySql.prepareStatement(Sql);
                    st.setString(1, Obj.getNombreApellidos());
                    st.setString(2, Obj.getDireccion());
                    st.setString(3, Obj.getCodPostal());
                    st.setString(4, Obj.getProvincia());
                    st.setInt(5, IdPropietario);

                    st.executeUpdate();                    
                    st.close();
                } catch (SQLException ea) {
                    System.out.println("Error en la conexión con la base de datos mysql. (contrato_historico.exportarItem)");
                    System.out.println("[" + ea.getErrorCode() + "] " + ea);
                    System.out.println(Sql);
                } catch (Exception eb) {
                    System.out.println("Error indeterminado.  (contrato_historico.exportarItem)");
                    System.out.println(eb);
                    System.out.println(Sql);
                }
            }
        }
    }
}
