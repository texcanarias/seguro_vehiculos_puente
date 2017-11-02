/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author antonio
 */
public class Marca_modelo_model {
    private String Marca;
    private String Modelo;
    
    /**
     * Tipo de vehículo.
     */
    private String TipoVehiculo;

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(String TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

    @Override
    public String toString() {
        return this.Marca + " " + this.Modelo + " " + this.TipoVehiculo;
    }
    
    
}
