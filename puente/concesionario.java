package puente;

import java.sql.*;
import modelos.modelo;
import modelos.Concesionario_model;
import modelos.Usuario_model;
import java.util.ArrayList;

/**
 *
 * @author antonio
 * @version 20130260
 */
public class concesionario extends EnlaceDual {
    public concesionario() {
        super();
        this.TablaAccess = "Clientes";
        this.TablaMySql = "ftn_agg_concesionario";
    }

    /**
     * Recogemos los Items modificados de una tabla.
     */
    protected ArrayList getItemsAccess() {
        ArrayList<Concesionario_model> Devolucion = new ArrayList<Concesionario_model>();

        if (null == this.ConnAccess) {
            this.CrearConnAccess();
        }
        try {
            Statement st = this.ConnAccess.createStatement();


            ResultSet rs = st.executeQuery("SELECT "
                    + " IdCliente, "
                    + " IIF(ISNULL(NIF),'',NIF) as CNIF,"
                    + " IIF(ISNULL(NombreCliente),'',NombreCliente) as CNombreCliente, "
                    + " IIF(ISNULL(Direccion),'',Direccion) as CDireccion, "
                    + " IIF(ISNULL(Poblacion),'',Poblacion) as CPoblacion, "
                    + " IIF(ISNULL(CP),'48000',CP) as CCP, "
                    + " IIF(ISNULL(Telefono1),'',Telefono1) as CTelefono1, "
                    + " IIF(ISNULL(Telefono2),'48000',Telefono2) as CTelefono2, "
                    + " IIF(ISNULL(Fax),'',Fax) as CFax,"
                    + " IIF(ISNULL([E-mail]),'',[E-mail]) as CEMail, "
                    + " IIF(ISNULL([IdComercial]),0,[IdComercial]) as CIdComercial "
                    + "FROM "
                    + " Clientes "
                    + "WHERE "
                    + " Sincronizar = True ");
            while (rs.next()) {
                Concesionario_model A = new Concesionario_model();
                A.setIdRemoto(rs.getInt("IdCliente"));
                A.setCif(rs.getString("CNIF"));
                A.setNombre(rs.getString("CNombreCliente"));
                A.setDireccion(rs.getString("CDireccion"));
                A.setLocalidad(rs.getString("CPoblacion"));
                A.setCP(rs.getString("CCP"));
                A.setIdProvincia(A.getCP().substring(0, 2));
                A.setTelefono(rs.getString("CTelefono1") + "," + rs.getString("CTelefono2"));
                A.setFax(rs.getString("CFax"));
                A.setWeb("");
                A.setEmail(rs.getString("CEMail"));
                A.setIdComercialAccess(rs.getInt("CIdComercial"));
                Devolucion.add(A);
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. concesionario.getItemsAccess (getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado. concesionario.getItemsAccess (getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return Devolucion;
    }

    /**
     * Recogemos los Items modificados de una tabla.
     */
    protected ArrayList getItemsMySql() {
        ArrayList<Concesionario_model> Devolucion = new ArrayList<Concesionario_model>();

        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();


            ResultSet rs = st.executeQuery("SELECT "
                    + " Id, "
                    + " IF(Cif IS NULL,'',Cif) as Cif ,"
                    + " IF(Nombre IS NULL,'',Nombre) as Nombre , "
                    + " IF(Direccion IS NULL,'',Direccion) as Direccion , "
                    + " IF(Localidad IS NULL,'',Localidad) as Localidad , "
                    + " IdProvincia, "
                    + " IF(CP IS NULL,'',CP) as CP,"
                    + " IF(Telefono IS NULL,'',Telefono) as Telefono , "
                    + " IF(Fax IS NULL,'',Fax) as Fax , "
                    + " IF(Email IS NULL,'',Email) as Email , "
                    + " IF(Web IS NULL,'',Web) as Web,"
                    + " IdRemoto "
                    + "FROM "
                    + " ftn_agg_concesionario "
                    + "WHERE "
                    + " Sincronizar = 1");
            while (rs.next()) {
                Concesionario_model A = new Concesionario_model();
                A.setId(rs.getInt("Id"));
                A.setIdRemoto(rs.getInt("IdRemoto"));
                A.setCif(rs.getString("Cif"));
                A.setNombre(rs.getString("Nombre"));
                A.setDireccion(rs.getString("Direccion"));
                A.setLocalidad(rs.getString("Localidad"));
                //A.setCP(rs.getString("CP"));
                A.setIdProvincia(rs.getString("IdProvincia"));
                A.setTelefono(rs.getString("Telefono"));
                A.setFax(rs.getString("Fax"));
                //A.setWeb(rs.getString("Web"));
                A.setEmail(rs.getString("Email"));
                Devolucion.add(A);
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. concesionario.getItemsMySql (getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  concesionario.getItemsMySql (getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return Devolucion;
    }

    /**
     * Intenta obtene el Id remoto que está relacionado con el Id local.
     *
     * @param IdLocal Id del objeto local
     * @return Un entero si localiza el Id y un -1 si no lo localiza
     */
    protected int getIdRemoto(int IdLocal) {
        int IdRemoto = -1;
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " Id "
                    + "FROM "
                    + " ftn_agg_concesionario "
                    + "WHERE "
                    + " IdRemoto = " + IdLocal);
            while (rs.next()) {
                IdRemoto = rs.getInt("Id");
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. (getIdRemoto)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (getIdRemoto)");
            System.out.println(eb);
        }

        return IdRemoto;
    }

    /**
     * Transferir registros desde la base ACCESS a MYSQL
     *
     * @param Obj
     */
    protected void exportarItemAccess(Concesionario_model Obj) {
        String Sql;
        if (-1 == Obj.getId()) {
            //Creamos un objeto de tipo usuario para darlo de alta
            Usuario_model ObjUsuario = new Usuario_model();
            ObjUsuario.setId(-1);
            ObjUsuario.setNombre(Obj.getNombre());
            ObjUsuario.setApellidos("");
            ObjUsuario.setUsuario(Obj.getNombre());
            ObjUsuario.setPass();
            ObjUsuario.setTipo_usuario_Id(Usuario_model.UsuarioConcesionario);
            ObjUsuario.setEMail(Obj.getEmail());

            //Registramos el objeto usuario.
            Usuario ObjUsuarioPer = new Usuario();
            ObjUsuarioPer.exportarItem(ObjUsuario);

            Sql = "     INSERT INTO"
                    + "     ftn_agg_concesionario "
                    + " SET"
                    + "     Cif = ? ,"
                    + "     Nombre = ? ,"
                    + "     Direccion = ? ,"
                    + "     Localidad = ? ,"
                    + "     IdProvincia = ? ,"
                    + "     CP = ? ,"
                    + "     IdZona = 'N',"
                    + "     Telefono = ? ,"
                    + "     Fax = ? ,"
                    + "     Web = ? ,"
                    + "     Email = ? ,"
                    + "     IdRemoto = ? ,"
                    + "     Sincronizar = 0,"
                    + "     IdComercialAccess = ? ";


            if (null == this.ConnMySql)
                this.CrearConnMySql();

            try {
                PreparedStatement pst = this.ConnMySql.prepareStatement(Sql, Statement.RETURN_GENERATED_KEYS);

                //Tenemos que pasar las string condificadas en UTF8
                pst.setString(1, Obj.getCif());
                pst.setString(2, Obj.getNombre());
                pst.setString(3, Obj.getDireccion());
                pst.setString(4, Obj.getLocalidad());
                pst.setInt(5, Obj.getIdProvincia());
                pst.setString(6, Obj.getCP());
                pst.setString(7, Obj.getTelefono());
                pst.setString(8, Obj.getFax());
                pst.setString(9, Obj.getWeb());
                pst.setString(10, Obj.getEmail());
                pst.setInt(11, Obj.getIdRemoto());
                pst.setInt(12, Obj.getIdComercialAccess());
                pst.executeUpdate();

                System.out.println("Insertamos el concesionario (ftn_agg_concesionario) "+Obj.getNombre());                              
                
                ResultSet rs = pst.getGeneratedKeys();
                rs.next();
                Obj.setId(rs.getInt(1));
                rs.close();
                pst.close();
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos mysql. (Concesionario.exportarItem)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Concesionario.exportarItem)");
                System.out.println(eb);
                System.out.println(Sql);
            }

            //Hemos registrar la relación entre el usuario y el concesionario
            if (-1 != ObjUsuario.getId() && -1 != Obj.getId()) {
                Sql = "     INSERT INTO "
                        + "     ftn_agg_registro_usuarios_concesionarios"
                        + " SET"
                        + "     ftn_registro_usuariosId = " + ObjUsuario.getId() + ","
                        + "     ftn_agg_concesionarioId = " + Obj.getId() + " ";
                if (null == this.ConnMySql) {
                    this.CrearConnMySql();
                }
                try {
                    Statement st = this.ConnMySql.createStatement();
                    st.executeUpdate(Sql);
                    st.close();
                } catch (SQLException ea) {
                    System.out.println("Error en la conexión con la base de datos mysql. (Concesionario.exportarItem 2)");
                    System.out.println("[" + ea.getErrorCode() + "] " + ea);
                    System.out.println(Sql);
                } catch (Exception eb) {
                    System.out.println("Error indeterminado.  (Concesionario.exportarItem 2)");
                    System.out.println(eb);
                }
            } else {
                System.out.println("Para el concesionario " + Obj.getId() + " no se ha podido crear un usuario.");
            }
        } else {
            //Hacemos un update
            //Registramos el objeto concesionario            
            Sql = "     UPDATE"
                    + "     ftn_agg_concesionario "
                    + " SET"
                    + "     Cif = ? ,"
                    + "     Nombre = ? ,"
                    + "     Direccion = ? ,"
                    + "     Localidad = ? ,"
                    + "     IdProvincia = ? ,"
                    + "     CP = ? ,"
                    + "     IdZona = 'N',"
                    + "     Telefono = ? ,"
                    + "     Fax = ? ,"
                    + "     Web = ? ,"
                    + "     Email = ? ,"
                    + "     Sincronizar = 0 ,"
                    + "     IdComercialAccess = ? "
                    + "WHERE"
                    + "     Id = ? ";

            if (null == this.ConnMySql) {
                this.CrearConnMySql();
            }
            try {
                PreparedStatement pst = this.ConnMySql.prepareStatement(Sql);
                pst.setString(1, Obj.getCif());
                pst.setString(2, Obj.getNombre());
                pst.setString(3, Obj.getDireccion());
                pst.setString(4, Obj.getLocalidad());
                pst.setInt(5, Obj.getIdProvincia());
                pst.setString(6, Obj.getCP());
                pst.setString(7, Obj.getTelefono());
                pst.setString(8, Obj.getFax());
                pst.setString(9, Obj.getWeb());
                pst.setString(10, Obj.getEmail());
                pst.setInt(11, Obj.getIdComercialAccess());                
                pst.setInt(12, Obj.getId());

                pst.executeUpdate();
                pst.close();
                
                System.out.println("Actualiamos el concesionario (ftn_agg_concesionario) "+Obj.getNombre()+" con IdComercial "+Obj.getIdComercialAccess()+" en Id "+Obj.getId());                              

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
        if (-1 != Obj.getIdRemoto()) {
            Sql = "     UPDATE "
                    + "     Clientes "
                    + " SET"
                    + "     Sincronizar = False "
                    + " WHERE"
                    + "     IdCliente = " + Obj.getIdRemoto();

            if (null == this.ConnAccess) {
                this.CrearConnAccess();
            }
            try {
                Statement st = this.ConnAccess.createStatement();
                st.executeUpdate(Sql);
                System.out.println("Actualizamos (Sincronizar=False) Clientes Id="+Obj.getIdRemoto());
                st.close();
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos access. (Concesionario.exportarItem reset)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Concesionario.exportarItem reset)");
                System.out.println(eb);
                System.out.println(Sql);
            }
        }
    }

    /**
     * Transferir registros desde la base MYSQL a ACCESS
     *
     * @param Obj
     */
    protected void exportarItemMySql(Concesionario_model Obj) {
        String Sql;
        if (-1 == Obj.getIdRemoto()) {
            //No se permiten hacer insercciones desde la web.
        } else {
            //Hacemos un update
            //Registramos el objeto concesionario            
            Sql = "     UPDATE"
                    + "     Clientes "
                    + " SET"
                    + "     NIF = ? ,"
                    + "     NombreCliente = ? ,"
                    + "     Direccion = ? ,"
                    + "     Poblacion = ? ,"
                    + "     Provincia = ? ,"
                    + "     CP = ? ,"
                    + "     Telefono1 = ? ,"
                    + "     Telefono2 = ? ,"
                    + "     Fax = ? ,"
                    + "     [E-mail] = ? ,"
                    + "     Sincronizar = False "
                    + "WHERE"
                    + "     IdCliente = ? ";

            if (null == this.ConnAccess) {
                this.CrearConnAccess();
            }
            try {
                PreparedStatement pst = this.ConnAccess.prepareStatement(Sql);

                String[] Telefono = new String[2];
                Telefono[0] = "";
                Telefono[1] = "";
                Telefono = Obj.getTelefono().split(",");
                                
                pst.setString(1, Obj.getCif());
                pst.setString(2, Obj.getNombre());
                pst.setString(3, Obj.getDireccion());
                pst.setString(4, Obj.getLocalidad());
                pst.setString(5, Provincias[Obj.getIdProvincia()]);
                pst.setString(6, Obj.getCP());
                pst.setString(7, Telefono[0]);
                pst.setString(8, Telefono[1]);
                pst.setString(9, Obj.getFax());
                pst.setString(10, Obj.getEmail());
                pst.setInt(11, Obj.getIdRemoto());

                int RegistrosActualizados = pst.executeUpdate();
                pst.close();
                                
                System.out.println("Actualizamos el registro access (Clientes)" + Obj.getIdRemoto());

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
        if (-1 != Obj.getId()) {
            Sql = "     UPDATE "
                    + "     ftn_agg_concesionario "
                    + " SET"
                    + "     Sincronizar = 0 "
                    + " WHERE"
                    + "     Id = " + Obj.getId();

            if (null == this.ConnMySql) {
                this.CrearConnMySql();
            }
            try {
                Statement st = this.ConnMySql.createStatement();
                st.executeUpdate(Sql);
                st.close();
                System.out.println("Quitamos la bandera de sincronizacion (ftn_agg_concesionario) a "+Obj.getId());
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos access. (Concesionario.exportarItem reset)");
                System.out.println("[" + ea.getErrorCode() + "] " + ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Concesionario.exportarItem reset)");
                System.out.println(eb);
                System.out.println(Sql);
            }
        }
    }
    
    
    /**
     * Para un vector de objetos los exporta de ACCESS al sistema con MySql
     * @param Importacion 
     */
    protected void setItemsAccess(ArrayList<modelo> Importacion){
        for(int i=0;i<Importacion.size();++i){            
            int IdFoton = this.getIdRemoto(Importacion.get(i).getIdRemoto());
            Importacion.get(i).setId(IdFoton);
           
            
            if(Importacion.get(0).getClass().toString().equals("class modelos.Concesionario_model"))    
                this.exportarItemAccess((Concesionario_model) Importacion.get(i));
            else{
                //System.out.println("Otro caso");
            }
        }
    }

    /**
     * Para un vector de objetos los exporta de MySql al sistema con Access
     * @param Importacion 
     */
    protected void setItemsMySql(ArrayList<modelo> Importacion){
        for(int i=0;i<Importacion.size();++i){                        
            if(Importacion.get(0).getClass().toString().equals("class modelos.Concesionario_model"))    
                this.exportarItemMySql((Concesionario_model) Importacion.get(i));
            else{
               // System.out.println("Otro caso");
            }
        }
    }    
    
    
    /**
     * Recogemos un concesionario concreto
     * @param Integer Id Identificador del concesionario
     */
    protected Concesionario_model getItemMySql(Integer Id) {
        
        Concesionario_model A = new Concesionario_model();
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " Id, "
                    + " IFNULL(Cif, '') as Cif,"
                    + " IFNULL(Nombre, '') as Nombre, "
                    + " IFNULL(Direccion, '') as Direccion, "
                    + " IFNULL(Localidad, '') as Localidad, "
                    + " IFNULL(IdProvincia, 45) as IdProvincia, "
                    + " IFNULL(CP, '') as CP, "
                    + " IFNULL(Telefono, '') as Telefono, "
                    + " IFNULL(Fax, '') as Fax, "
                    + " IFNULL(Email, '') as Email, "
                    + " IFNULL(Web, '') as Web, "
                    + " IFNULL(IdRemoto, 1) as IdRemoto "
                    + "FROM "
                    + " ftn_agg_concesionario "
                    + "WHERE "
                    + " Id = " + Id);
           
            while (rs.next()) {
                A.setId(rs.getInt("Id"));
                A.setIdRemoto(rs.getInt("IdRemoto"));
                A.setCif(rs.getString("Cif"));
                A.setNombre(rs.getString("Nombre"));
                A.setDireccion(rs.getString("Direccion"));
                A.setLocalidad(rs.getString("Localidad"));
                A.setCP(rs.getString("CP"));
                A.setIdProvincia(rs.getString("IdProvincia"));
                A.setTelefono(rs.getString("Telefono"));
                A.setFax(rs.getString("Fax"));
                A.setWeb(rs.getString("Web"));
                A.setEmail(rs.getString("Email"));
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. concesionario.getItemMySql (getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado. concesionario.getItemMySql (getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return A;
    }   
}