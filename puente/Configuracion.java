package puente;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 * Carga la configuración desde un fichero XML
 *
 * @author antonio
 */
public class Configuracion {

    private String Dsn;
    private String Direccion;
    private String Puerto;
    private String BaseDatos;
    private String Usuario;
    private String Clave;
    
    /**
     * Constructor por defecto
     */
    public Configuracion() {
        this.Dsn = "";
        this.Direccion = "";
        this.Puerto = "";
        this.BaseDatos = "";
        this.Usuario = "";
        this.Clave = "";
    }

    /**
     * Leemos el fichero config.xml para obtener los datos de configuración.
     * http://www.developerfusion.com/code/2064/a-simple-way-to-read-an-xml-file-in-java/
     * @version 20130208
     */
    public void Leer() {                
        try {
            File xml_file = new File("config.xml");
            //File xml_file = new File("./src/puente/config.xml");
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml_file);
            doc.getDocumentElement().normalize();
            
            this.Dsn = doc.getElementsByTagName("dsn").item(0).getChildNodes().item(0).getNodeValue();
            
            this.Direccion = doc.getElementsByTagName("direccion").item(0).getChildNodes().item(0).getNodeValue();

            this.Puerto = doc.getElementsByTagName("puerto").item(0).getChildNodes().item(0).getNodeValue();
            
            this.BaseDatos = doc.getElementsByTagName("base_datos").item(0).getChildNodes().item(0).getNodeValue();
            
            this.Usuario = doc.getElementsByTagName("usuario").item(0).getChildNodes().item(0).getNodeValue();

            this.Clave = doc.getElementsByTagName("clave").item(0).getChildNodes().item(0).getNodeValue();
            
        } catch (Exception eb) {
            System.out.println("Error indeterminado. (Configuracion.Leer())");
            System.out.println(eb);
            System.exit(1);
        }

    }
    
    /**
     * Construye la información de conexión.
     * @return Información sobre los parámetros de conexión.
     */
    private String Volcar(){
        String Cadena = "";
        Cadena += "DSN = "+this.Dsn+"\n";
        Cadena += "Dirección = "+this.Direccion+"\n";
        Cadena += "Puerto = "+this.Puerto+"\n";
        Cadena += "Base de datos = "+this.BaseDatos+"\n";
        Cadena += "Usuario = "+this.Usuario+"\n";
        Cadena += "Clave = "+this.Clave+"\n";
        return Cadena;
    }

    public String getDsn() {
        return this.Dsn;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public String getPuerto() {
        return this.Puerto;
    }

    public String getBaseDatos() {
        return this.BaseDatos;
    }

    public String getUsuario() {
        return this.Usuario;
    }

    public String getClave() {
        return this.Clave;
    }

    @Override
    public String toString() {
        return this.Volcar() + "Configuracion de conexiones a la base de datos ";
    }   
}