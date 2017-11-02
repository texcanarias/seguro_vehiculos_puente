/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.*;

/**
 *
 * @author antonio
 * @version 20130260
 */
public class Enlace {

    protected static Connection ConnAccess;
    protected static Connection ConnMySql;
    protected Configuracion Config;
    protected String[] Provincias;

    /**
     * Constructor.
     *
     * @version 20130260
     */
    public Enlace() {
        this.ConnAccess = null;
        this.ConnMySql = null;
        this.Config = null;
    }

    /**
     * Finalizador.
     * 
     */
    public void finalize() {
        this.CerrarConexiones();
    }

    /**
     * Cerramos las conexiones con la base de datos cuando finalizamos el
     * programa.
     */
    public void CerrarConexiones(){
        try {
            this.ConnAccess.close();
            this.ConnMySql.close();
            this.ConnAccess = null;
            this.ConnMySql = null;
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos access. (finalize)");
        }
    }

    /**
     * Instancia el objeto Configuracion y llama al método Leer para configurar
     * sus propiedades.
     */
    private void CargarConfiguracion() {
        if (this.Config == null) {
            this.Config = new Configuracion();
            this.Config.Leer();
            System.out.println(this.Config);
        }

        Provincias = new String[53];
        Provincias[0] = "";
        Provincias[1] = "Álava";
        Provincias[2] = "Albacete";
        Provincias[3] = "Alicante";
        Provincias[4] = "Almería";
        Provincias[5] = "Ávila";
        Provincias[6] = "Badajoz";
        Provincias[7] = "Baleares";
        Provincias[8] = "Barcelona";
        Provincias[9] = "Burgos";
        Provincias[10] = "Cáceres";
        Provincias[11] = "Cádiz";
        Provincias[12] = "Castellón";
        Provincias[13] = "Ciudad Real";
        Provincias[14] = "Córdoba";
        Provincias[15] = "Coruña";
        Provincias[16] = "Cuenca";
        Provincias[17] = "Gerona";
        Provincias[18] = "Granada";
        Provincias[19] = "Guadalajara";
        Provincias[20] = "Guipúzcoa";
        Provincias[21] = "Huelva";
        Provincias[22] = "Huesca";
        Provincias[23] = "Jaén";
        Provincias[24] = "León";
        Provincias[25] = "Lérida";
        Provincias[26] = "La Rioja";
        Provincias[27] = "Lugo";
        Provincias[28] = "Madrid";
        Provincias[29] = "Málaga";
        Provincias[30] = "Murcia";
        Provincias[31] = "Navarra";
        Provincias[32] = "Orense";
        Provincias[33] = "Asturias";
        Provincias[34] = "Palencia";
        Provincias[35] = "Las Palmas";
        Provincias[36] = "Pontevedra";
        Provincias[37] = "Salamanca";
        Provincias[38] = "Santa Cruz de Tenerife";
        Provincias[39] = "Cantabria";
        Provincias[40] = "Segovia";
        Provincias[41] = "Sevilla";
        Provincias[42] = "Soria";
        Provincias[43] = "Tarragona";
        Provincias[44] = "Teruel";
        Provincias[45] = "Toledo";
        Provincias[46] = "Valencia";
        Provincias[47] = "Valladolid";
        Provincias[48] = "Vizcaya";
        Provincias[49] = "Zamora";
        Provincias[50] = "Zaragoza";
        Provincias[51] = "Ceuta";
        Provincias[52] = "Melilla";
    }

    /**
     * Se crear la conexión con la base de datos.
     *
     * @version 20130208
     */
    protected void CrearConnAccess() {
        try {
            this.CargarConfiguracion();

            //Obtenemos el driver para Access
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            //Obtenemos la conexión
            java.util.Properties prop = new java.util.Properties();
            prop.put("charSet", "iso-8859-1");

            this.ConnAccess = DriverManager.getConnection("jdbc:odbc:" + this.Config.getDsn(), prop);

            if (this.ConnAccess != null) {
                //System.out.println("Conexión Access establecida.");
            } else {
                System.out.println("Conexión Access NO establecida.");
            }
        } catch (SQLException ea) {
            System.out.println("DSN " + this.Config.getDsn());
            System.out.println("Error en la conexión con la base de datos access. (CrearConnAccess)");
            System.out.println(ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado. (CrearConnAccess)");
            System.out.println(eb);
        }
    }

    /**
     * Se crea la conexion con la base de datos mysql.
     * Más info en
     * http://www.chuidiang.com/java/mysql/mysql-java-basico.php .
     *
     * @version 20130208
     */
    protected void CrearConnMySql() {
        try {
            this.CargarConfiguracion();

            String Servidor = this.Config.getDireccion() + ":" + this.Config.getPuerto();
            String BaseDatos = this.Config.getBaseDatos();
            String Usuario = this.Config.getUsuario();
            String Clave = this.Config.getClave();

            //Obtenemos el driver para MySql
            Class.forName("com.mysql.jdbc.Driver");

            //Obtenemos la conexión
            java.util.Properties Prop = new java.util.Properties();
            Prop.put("charset", "UTF-8");
            Prop.put("characterEncoding", "UTF-8");
            Prop.put("useUnicode", "true");
            Prop.put("user", Usuario);
            Prop.put("password", Clave);
            
            this.ConnMySql = DriverManager.getConnection("jdbc:mysql://" + Servidor + "/" + BaseDatos, Prop); 
            
            //Pasamos una consulta para obligar a que la conexión esa en UTF8
            Statement st = this.ConnMySql.createStatement();
            st.executeQuery("SET NAMES 'UTF8' ");            
            st.close();
            
            if (this.ConnMySql != null) {
                //System.out.println("Conexión MySql establecida.");
            } else {
                System.out.println("Conexión MySql NO establecida.");
            }
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. (CrearConnMySql)");
            System.out.println(ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado. (CrearConnMySql)");
            System.out.println(eb);
        }

    }
}
