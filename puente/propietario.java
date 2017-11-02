/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Propietario_model;

/**
 *
 * @author antonio
 */
public class propietario extends Enlace{ 
    /**
     * Constructor por defecto.
     */
    public propietario() {
        super();
    }

    /**
     * Recogemos un propietario concreto.
     * @param Id Integer Identificador del concesionario
     * @return Propietario_model
     */
    protected Propietario_model getItemMySql(Integer Id) {
        
        Propietario_model A = new Propietario_model();
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();
            String Sql;
            Sql = "  SELECT "
                    + " IF(Cif IS NULL,'',Cif) as Cif,"
                    + " IF(Nombre IS NULL,'',Nombre) as Nombre ,"
                    + " IF(Telefono IS NULL,'',Telefono) as Telefono, "
                    + " IF(Fax IS NULL,'',Fax) as Fax, "
                    + " IF(EMail IS NULL,'',EMail) as EMail "
                    + " FROM "
                    + "   ftn_agg_propietario "
                    + "   JOIN "
                    + "       ftn_registro_usuarios "
                    + "   ON"
                    + "       ftn_registro_usuarios.Id = ftn_agg_propietario.ftn_registro_usuariosId "
                    + " WHERE "
                    + "   ftn_agg_propietario.Id = "+Id;
            ResultSet rs = st.executeQuery(Sql);
           
            while (rs.next()) {
                A.setCIF(rs.getString("Cif"));
                A.setNombre(rs.getString("Nombre"));
                A.setTelefono(rs.getString("Telefono"));
                A.setFax(rs.getString("Telefono"));
                A.setEmail(rs.getString("EMail"));
            }
            rs.close();
            
            //Obtenemos las direcciones.
            Sql = "SELECT " +
                    "    IF(Domicilio IS NULL,'',Domicilio) as Domicilio, " +
                    "    IF(Localidad IS NULL,'',Localidad) as Localidad, " +
                    "    IF(Cp IS NULL,'',Cp) as Cp,  " +
                    "    IdProvincia, " +
                    "    IdEstado " +
                    "FROM  " +
                    "    ftn_agg_propietario_domicilio " +
                    "WHERE " +
                    "    ftn_agg_propietarioId = " + Id;
            rs = st.executeQuery(Sql);
            int Contador = 0;
            while (rs.next()) {
                if(0 == Contador){
                    A.setDomicilio0(rs.getString("Domicilio"));
                    A.setLocalidad0(rs.getString("Localidad"));
                    A.setProvincia0(rs.getString("IdProvincia"));
                    A.setCp0(rs.getString("Cp"));
                }else{
                    A.setDomicilio1(rs.getString("Domicilio"));
                    A.setLocalidad1(rs.getString("Localidad"));
                    A.setProvincia1(rs.getString("IdProvincia"));
                    A.setCp1(rs.getString("Cp"));                    
                }
                ++Contador;
            }
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. propietario.getItemMySql (getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  propietario.getItemMySql (getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return A;
    }
        
}
