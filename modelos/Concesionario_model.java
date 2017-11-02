/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author antonio
 */
public class Concesionario_model extends modelo {
    private String Cif;
    private String Nombre;
    private String Direccion;
    private String Localidad;
    private Integer IdProvincia;
    private String CP;
    private String Telefono;
    private String Fax;
    private String Web;
    private String Email;
    private Integer IdComercialAccess;

    public Concesionario_model(){
        super();
        this.Cif = "";
        this.Nombre = "";
        this.Direccion = "";
        this.Localidad = "";
        this.IdProvincia = 48;
        this.CP = "48000";
        this.Telefono = "";
        this.Fax = "";
        this.Web = "";
        this.Email = "@";
        this.IdComercialAccess = 0;
    }
    
    public String getCif() {
        return Cif;
    }

    public void setCif(String Cif) {
        if(Cif.equals("") || null == Cif)
            Cif = " ";                                
        this.Cif = Cif;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        if(Nombre.equals("") || null == Nombre)
            Nombre = " ";                                
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        if(Direccion.equals("") || null == Direccion)
            Direccion = " ";                                
        this.Direccion = Direccion;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        if(Localidad.equals("") || null == Localidad)
            Localidad = " ";                                
        this.Localidad = Localidad;
    }

    public Integer getIdProvincia() {
        return IdProvincia;
    }

    public void setIdProvincia(String IdProvincia) {
        if(IdProvincia.equals("") || null == IdProvincia)
            IdProvincia = "48";  
        try{
            this.IdProvincia = Integer.parseInt(IdProvincia);
        }
        catch (Exception e){
            this.IdProvincia = 48;
        }
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        if(CP.equals("") || null == CP)
            CP = "48000";
        if(CP.length() > 5)
            CP = CP.substring(0, 4);
        this.CP = CP;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        if(Telefono.equals("") || null == Telefono)
            Telefono = " ";                        
        this.Telefono = Telefono;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        if(Fax.equals("") || null == Fax)
            Fax = " ";                
        this.Fax = Fax;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String Web) {
        if(Web.equals("") || null == Web)
            Web = "";        
        this.Web = Web;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        if(Email.equals("") || null == Email)
            Email = "@";
        this.Email = Email;
    }

    public Integer getIdComercialAccess() {
        return IdComercialAccess;
    }

    public void setIdComercialAccess(Integer IdComercialAccess) {
        this.IdComercialAccess = IdComercialAccess;
    }

    @Override
    public String toString() {
        String Cadena = "";
        Cadena += "##############"+"\n";
        Cadena += "Concesionario "+"\n";
        Cadena += "##############"+"\n";
        Cadena += "[IdRemoto] "+this.IdRemoto+" \n";
        Cadena += "[Id] "+this.Id+" \n";
        Cadena += "[Cif] "+this.Cif+" \n";
        Cadena += "[Nombre] "+this.Nombre+" \n";
        Cadena += "[Direccion] "+this.Direccion+" \n";
        Cadena += "[Localidad] "+this.Localidad+" \n";
        Cadena += "[IdProvincia] "+this.IdProvincia+" \n";
        Cadena += "[CP] "+this.CP+" \n";
        Cadena += "[Telefono] "+this.Telefono+" \n";
        Cadena += "[Fax] "+this.Fax+"\n";
        Cadena += "[Web] "+this.Web+"\n";
        Cadena += "[Email] "+this.Email+"\n";
        Cadena += "[IdComercialAccess] "+this.IdComercialAccess+"\n";
        Cadena += "############"+"\n";
        return Cadena;
    }

    
            
}
