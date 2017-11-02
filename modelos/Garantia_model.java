/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author antonio
 */
public class Garantia_model {
    /**
     * Identificador único
     */
    private Integer Id;
    
    /**
     * Nombre de la garantía
     */
    private String Nombre;
    
    /**
     * Fecha de inicio de vigencia de la tarifa
     */
    private String FechaInicio;
    
    /**
     * Fecha final de vigencia de la tarifa
     */
    private String FechaFinal;
    
    /**
     * 1 Oferta destinada a concesionarios 0 al resto de clientes
     */
    private Boolean Concesionario; 
    
    /**
     * Identificador de la garantía.
     * Se han sacado de la tabla TiposGarantias
     */
    private Integer IdTipoGarantia;
    
    /**
     * El número de meses que cubre la garantia
     */
    private Integer Meses;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public Boolean getConcesionario() {
        return Concesionario;
    }

    public void setConcesionario(Boolean Concesionario) {
        this.Concesionario = Concesionario;
    }

    public Integer getIdTipoGarantia() {
        return IdTipoGarantia;
    }

    public void setIdTipoGarantia(Integer IdTipoGarantia) {
        this.IdTipoGarantia = IdTipoGarantia;
    }

    public Integer getMeses() {
        return Meses;
    }

    public void setMeses(Integer Meses) {
        this.Meses = Meses;
    }

    @Override
    public String toString() {
        String Cadena = "";
        Cadena += "##############"+"\n";
        Cadena += "Garantia "+"\n";
        Cadena += "##############"+"\n";
        Cadena += "[Id] " + this.Id + "\n";
        Cadena += "[Nombre] " + this.Nombre + "\n";
        Cadena += "[FechaInicio] " + this.FechaInicio + "\n";
        Cadena += "[FechaFinal] " + this.FechaFinal + "\n";
        Cadena += "[Concesionario] " + this.Concesionario + "\n";
        Cadena += "[IdTipoGarantia] "+ this.IdTipoGarantia + "\n";
        Cadena += "[Meses] " + this.Meses + "\n";
        return Cadena;
    }
    
    
}