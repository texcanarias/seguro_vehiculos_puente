/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.*;
import modelos.Usuario_model;

/**
 *
 * @author antonio
 */
public class Usuario extends Enlace
{
    protected void exportarItem(Usuario_model Obj){
        String Sql;
        if(-1 == Obj.getId()){
            //Creamos un objeto de tipo usuario para darlo de alta
            Sql =   "INSERT INTO "
                    +   "ftn_registro_usuarios "
                    +"SET"
                    + " Usuario = ? ,"
                    + " Pass = ? ,"
                    + " Nombre = ? ,"
                    + " Apellidos = ? ,"
                    + " FechaAlta = curdate(),"
                    + " EMail =  ? , "
                    + " tipo_usuario_Id = ? ,"
                    + " ActivoId = ? ,"
                    + " IntentosLogin = ? ";
            
            if (null == this.ConnMySql)
                       this.CrearConnMySql();
            try{
                PreparedStatement pst = this.ConnMySql.prepareStatement(Sql,Statement.RETURN_GENERATED_KEYS);

                pst.setString(1, Obj.getUsuario());
                pst.setString(2, Obj.getPass());
                pst.setString(3, Obj.getNombre());
                pst.setString(4, Obj.getApellidos());
                pst.setString(5, Obj.getEMail());
                pst.setInt(6, Obj.getTipo_usuario_Id());
                pst.setBoolean(7, Obj.getActivoId());
                pst.setInt(8, Obj.getIntentosLogin());
                
                pst.executeUpdate();
                
                //Statement st = this.ConnMySql.createStatement();
                //st.executeUpdate(Sql,Statement.RETURN_GENERATED_KEYS);
                ResultSet rs = pst.getGeneratedKeys();
                rs.next();
                Obj.setId(rs.getInt(1));      
                rs.close();
                pst.close();            
                System.out.println("Insertamos el usuario (ftn_registro_usuarios) "+Obj.getUsuario());
                
            } catch (SQLException ea) {
                System.out.println("Error en la conexión con la base de datos mysql. (Usuario.exportarItem)");
                System.out.println("["+ea.getErrorCode()+"] "+ea);
                System.out.println(Sql);
            } catch (Exception eb) {
                System.out.println("Error indeterminado.  (Usuario.exportarItem)");
                System.out.println(eb);
                System.out.println(Sql);
            }                        
        }
        else{
            //Hacemos un update
            Sql = "";
        }
    }    
}
