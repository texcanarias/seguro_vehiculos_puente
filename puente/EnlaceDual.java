/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author antonio
 */
public class EnlaceDual extends Enlace{
    protected String TablaAccess;
    protected String TablaMySql;
    
    public EnlaceDual(){
        super();
    }
    
    /**
     * Metodo de prueba que cuenta el numero de registros de una tabla.
     *
     * @version 20130208
     * @return Registro de Access.
     */
    protected int ContarRegistrosAccess() {
        int Total = 0;
        if (null == this.ConnAccess)
            this.CrearConnAccess();
        
        try {
            Statement st = this.ConnAccess.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " count(*) as Total "
                    + "FROM "
                    + this.TablaAccess
                    + " WHERE "
                    + " Sincronizar = True");

            rs.next();
            Total = rs.getInt("Total");
            System.out.println("Total a sincronizar de " + this.TablaAccess + " es " + Total);
            
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
     * Metodo que cuenta el numero de registros de concesionarios en la base de
     * datos web
     *
     * @version 20130212
     */
    protected int ContarRegistrosMySql() {
        int Total = 0;
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();

            ResultSet rs = st.executeQuery("SELECT "
                    + " count(*) as Total "
                    + "FROM "
                    + this.TablaMySql
                    + " WHERE "
                    + " Sincronizar = 1");

            rs.next();
            Total = rs.getInt("Total");
            System.out.println("Total a sincronizar de "+this.TablaMySql+" es "+Total);
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. (ContarRegistrosMySql)");
            System.out.println(ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado.  (ContarRegistrosMySql)");
            System.out.println(eb);
        }
        return Total;
    }   
}