/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 * Datos del propietario de un vehículo asegurado.
 * @author antonio
 */
public class Propietario_model {
    private String CIF;
    private String Nombre;
    private String Telefono;
    private String Fax;
    private String Email;

    private String Domicilio0;
    private String Localidad0;
    private String Cp0;
    private String Provincia0;

    private String Domicilio1;
    private String Localidad1;
    private String Cp1;
    private String Provincia1;

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDomicilio0() {
        return Domicilio0;
    }

    public void setDomicilio0(String Domicilio0) {
        this.Domicilio0 = Domicilio0;
    }

    public String getLocalidad0() {
        return Localidad0;
    }

    public void setLocalidad0(String Localidad0) {
        this.Localidad0 = Localidad0;
    }

    public String getCp0() {
        return Cp0;
    }

    public void setCp0(String Cp0) {
        this.Cp0 = Cp0;
    }

    public String getProvincia0() {
        return Provincia0;
    }

    public void setProvincia0(String Provincia0) {
        this.Provincia0 = Provincia0;
    }

    public String getDomicilio1() {
        return Domicilio1;
    }

    public void setDomicilio1(String Domicilio1) {
        this.Domicilio1 = Domicilio1;
    }

    public String getLocalidad1() {
        return Localidad1;
    }

    public void setLocalidad1(String Localidad1) {
        this.Localidad1 = Localidad1;
    }

    public String getCp1() {
        return Cp1;
    }

    public void setCp1(String Cp1) {
        this.Cp1 = Cp1;
    }

    public String getProvincia1() {
        return Provincia1;
    }

    public void setProvincia1(String Provincia1) {
        this.Provincia1 = Provincia1;
    }

    @Override
    public String toString() {
        String Cadena = "";
        Cadena += "##############"+"\n";
        Cadena += "Propietario "+"\n";
        Cadena += "##############"+"\n";
        Cadena += "[CIF] "+ this.CIF + "\n";
        Cadena += "[Nombre] "+ this.Nombre + "\n";
        Cadena += "[Telefono] "+ this.Telefono + "\n";
        Cadena += "[Fax] " + this.Fax + "\n";
        Cadena += "[EMail] " + this.Email + "\n";
        Cadena += "[Domicilio A] " + "\n";
        Cadena += "   [Domicilio] " + this.Domicilio0 + "\n";
        Cadena += "   [Localidad] " + this.Localidad0 + "\n";
        Cadena += "   [Cp] " + this.Cp0 + "\n";    
        Cadena += "   [Provincia] " + this.Provincia0 + "\n";
        Cadena += "[Domicilio B] " + "\n";
        Cadena += "   [Domicilio] " + this.Domicilio1 + "\n";
        Cadena += "   [Localidad] " + this.Localidad1 + "\n";
        Cadena += "   [Cp] " + this.Cp1 + "\n";    
        Cadena += "   [Provincia] " + this.Provincia1 + "\n";
        return Cadena;
    }
    
    
    
}
