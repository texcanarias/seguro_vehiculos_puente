/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 * Este es el modelo de la tabla access encargada de registrar los contratos.
 * @author antonio
 */
public class Contrato_historico_model {

    private String NGarantia;
    private Integer ftn_agg_concesionario_IdRemoto;
    private Integer IdComercial;
    private Integer TipoVehiculo;
    private String Marca;
    private String Modelo;
    private String Matricula;
    private String FechaPrimeraMatriculacion;
    private Integer KilometrosActuales;
    private String NombreApellidos;
    private String Direccion;
    private String CodPostal;
    private String Poblacion;
    private String Provincia;
    private String CIF;
    private String CIFExtranjero;
    private String Telefono;
    private String Fax;
    private Integer TipoGarantia;
    private String Duracion;
    private String Precio;
    private String FormaPago;
    private String FechaRecepcion;
    private String FechaInicio;
    private String FechaFinalizacion;
    private String Observaciones;
    private String FechaPago;
    private Boolean CajaAutomatica;
    private Boolean Pagado;
    private Boolean Anulada;
    private String CCC; //Numero de Cuenta
    
    private Boolean Facturar;
    private Boolean Facturado;
    private Boolean Aceptada;


    /**
     * Constructor
     */
    public Contrato_historico_model() {
        this.Pagado = false;
        this.Anulada = false;
        this.Facturar = false;
        this.Facturado = false;
        this.Aceptada = false;
    }

    public String getNGarantia() {
        return NGarantia;
    }

    public void setNGarantia(String NGarantia) {
        NGarantia = NGarantia.trim();
        if (NGarantia.equals("")) {
            NGarantia = "Sin determinar";
        }
        this.NGarantia = NGarantia;
    }

    public Integer getFtn_agg_concesionario_IdRemoto() {
        return ftn_agg_concesionario_IdRemoto;
    }

    public void setFtn_agg_concesionario_IdRemoto(Integer ftn_agg_concesionario_IdRemoto) {
        this.ftn_agg_concesionario_IdRemoto = ftn_agg_concesionario_IdRemoto;
    }

    public Integer getIdComercial() {
        return IdComercial;
    }

    public void setIdComercial(Integer IdComercial) {
        this.IdComercial = IdComercial;
    }

    public Integer getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(Integer TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }

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

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getFechaPrimeraMatriculacion() {
        return FechaPrimeraMatriculacion;
    }

    public void setFechaPrimeraMatriculacion(String FechaPrimeraMatriculacion) {
        this.FechaPrimeraMatriculacion = FechaPrimeraMatriculacion;
    }

    public Integer getKilometrosActuales() {
        return KilometrosActuales;
    }

    public void setKilometrosActuales(Integer KilometrosActuales) {
        this.KilometrosActuales = KilometrosActuales;
    }

    public String getNombreApellidos() {
        return NombreApellidos;
    }

    public void setNombreApellidos(String NombreApellidos) {
        this.NombreApellidos = NombreApellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCodPostal() {
        return CodPostal;
    }

    public void setCodPostal(String CodPostal) {
        this.CodPostal = CodPostal;
    }

    public String getPoblacion() {
        return Poblacion;
    }

    public void setPoblacion(String Poblacion) {
        this.Poblacion = Poblacion;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getCIFExtranjero() {
        return CIFExtranjero;
    }

    public void setCIFExtranjero(String CIFExtranjero) {
        if(CIFExtranjero.isEmpty() || CIFExtranjero.equals("") || CIFExtranjero.equals("null"))
            CIFExtranjero = " ";
        this.CIFExtranjero = CIFExtranjero;
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

    public Integer getTipoGarantia() {
        return TipoGarantia;
    }

    public void setTipoGarantia(Integer TipoGarantia) {
        this.TipoGarantia = TipoGarantia;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        if(Duracion == null)
            Duracion = "0";
        this.Duracion = Duracion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getFormaPago() {
        return FormaPago;
    }

    public void setFormaPago(String FormaPago) {
        this.FormaPago = FormaPago;
    }

    public String getFechaRecepcion() {
        return FechaRecepcion;
    }

    public void setFechaRecepcion(String FechaRecepcion) {
        this.FechaRecepcion = FechaRecepcion;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Boolean getPagado() {
        return Pagado;
    }

    public void setPagado(Boolean Pagado) {
        this.Pagado = Pagado;
    }

    public String getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(String FechaFinalizacion) {
        this.FechaFinalizacion = FechaFinalizacion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        if(Observaciones.isEmpty() || Observaciones.equals(""))
            Observaciones = "Nulo";                
        this.Observaciones = Observaciones;
    }

    public Boolean getAnulada() {
        return Anulada;
    }

    public void setAnulada(Boolean Anulada) {
        this.Anulada = Anulada;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public Boolean getCajaAutomatica() {
        return CajaAutomatica;
    }

    public void setCajaAutomatica(Boolean CajaAutomatica) {
        this.CajaAutomatica = CajaAutomatica;
    }

    public String getCCC() {
        return CCC;
    }

    public void setCCC(String CCC) {
        this.CCC = CCC;
    }

    public Boolean getFacturar() {
        return Facturar;
    }

    public void setFacturar(Boolean Facturar) {
        this.Facturar = Facturar;
    }

    public Boolean getFacturado() {
        return Facturado;
    }

    public void setFacturado(Boolean Facturado) {
        this.Facturado = Facturado;
    }

    public Boolean getAceptada() {
        return Aceptada;
    }

    public void setAceptada(Boolean Aceptada) {
        this.Aceptada = Aceptada;
    }
    
    @Override
    public String toString() {
        String A;
        A = "#############################\n";
        A += "Contrato histórico \n";
        A += "#############################\n";
        A += "";
        A += "[Número garantía] " + this.NGarantia + "\n";
        A += "[Concesionario remoto] " + this.ftn_agg_concesionario_IdRemoto + "\n";
        A += "[IdComercial] " + this.IdComercial + "\n";
        A += "[Tipo vehículo] " + this.TipoVehiculo + "\n";
        A += "[Marca] " + this.Marca + "\n";
        A += "[Modelo] " + this.Modelo + "\n";
        A += "[Matricula] " + this.Matricula + "\n";
        A += "[Fecha primera matriculación] " + this.FechaPrimeraMatriculacion + "\n";
        A += "[Kilometros actuales] " + this.KilometrosActuales + "\n";
        A += "[Nombre y apellidos] " + this.NombreApellidos + "\n";
        A += "[Dirección] " + this.Direccion + "\n";
        A += "[CP] " + this.CodPostal + "\n";
        A += "[Población] " + this.Poblacion + "\n";
        A += "[Provincia] " + this.Provincia + "\n";
        A += "[CIF] " + this.CIF + "\n";
        A += "[CIF Extranjero] " + this.CIFExtranjero + "\n";
        A += "[Telefono] " + this.Telefono + "\n";
        A += "[Fax] " + this.Fax + "\n";
        A += "[Tipo de garantia] " + this.TipoGarantia + "\n";
        A += "[Duración] " + this.Duracion + "\n";
        A += "[Precio] " + this.Precio + "\n";
        A += "[Forma de pago] " + this.FormaPago + "\n";
        A += "[Fecha de recepción] " + this.FechaRecepcion + "\n";
        A += "[Fecha de inicio] " + this.FechaInicio + "\n";
        A += "[Fecha de finalización] " + this.FechaFinalizacion + "\n";
        A += "[Observaciones] " + this.Observaciones + "\n";
        A += "[Fecha de pago] " + this.FechaPago + "\n";
        A += "[Caja automática] " + this.CajaAutomatica + "\n";
        A += "[Pagado] " + this.Pagado + "\n";
        A += "[Anulado] " + this.Anulada + "\n";
        A += "[CCC] " + this.CCC + "\n";
        A += "[Facturar] " + this.Facturar + "\n";
        A += "[Facturado] " + this.Facturado + "\n";
        A += "[Aceptada] " + this.Aceptada + "\n";
        return A;
    }
}