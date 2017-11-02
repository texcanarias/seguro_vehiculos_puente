/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author antonio
 */
public class Contrato_model {

    public Contrato_model(){}
    
    /**
     * Numero de poliza
     */
    private String NumeroPoliza;
    /**
     * Estado de la garantía. [A]ceptada [P]agado [F]acturado [X]]Anulada
     * [C]aducada
     */
    private Character IdEstado;
    private String Marca;
    private String Modelo;
    /**
     * Número de matricula.
     */
    private String Matricula;
    /**
     * Fecha de su primera matriculacion
     */
    private String FechaPrimeraMatriculacion;
    /**
     * Los kilómetros que tiene el coche en el momento de su aseguramiento
     */
    private Integer KilometrosActuales;
    /**
     * Si tiene o no caja automática.
     */
    private boolean CajaAutomatica;
    /**
     * Rango de caballos de este vehículo.
     */
    private Integer IdCaballos;
    /**
     * Categoria con respecto a la cilindrada del vehículo. * Hasta 1600cc * De
     * 1601 a 2000 cc * De 2001 a 3000 cc * > 3001 cc (categoria especial)
     */
    private Integer IdCategoria;
    /**
     * Si el vehículo es un todo terreno.
     */
    private boolean TodoTerreno;
    /**
     * Si es un vehículo industrial de hasta 3500Kg
     */
    private boolean Industrial;
    /**
     * Fecha en la que se recibe la solicitud de Garantia
     */
    private String FechaRecepcion;
    /**
     * Fecha del ingreso
     */
    private String FechaIngreso;
    /**
     * Fecha de pago de la garantía
     */
    private String FechaPago;
    /**
     * Fecha de inicio de la garantía
     */
    private String FechaInicio;
    /**
     * Fecha de finalizacion de la garantía
     */
    private String FechaFinalizacion;
    /**
     * Forma de pago:   T - Tarjeta
     *                  D - Domicialización
     *                  R - Transferencia
     *                  NULL - No se ha realizado el pago
     */
    private char IdFormaPago;
    /**
     * Precio final asignado.
     */
    private Float Precio;
    /**
     * Precio con los impuestos aplicados
     */
    private Float PrecioImp;
    /**
     * Tipo de IVA aplicado
     */
    private Float TipoIva;
    /**
     * Observaciones y comentarios que se pueden llevar a cabo sobre esta
     * garantía.
     */
    private String Comentarios;
    private Propietario_model Propietario;
    private Concesionario_model Concesionario;
    private Garantia_model Garantia;
    
    /**
     * Cadena que contiene la cuenta corriente
     */
    private String CCC;
    
    /**
     * Identificador del comercial en ACCESS
     */
    private Integer IdComercialAccess;

    public String getNumeroPoliza() {
        return NumeroPoliza;
    }

    public void setNumeroPoliza(String NumeroPoliza) {
        this.NumeroPoliza = NumeroPoliza;
    }

    public Character getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(Character IdEstado) {
        this.IdEstado = IdEstado;
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

    public boolean isCajaAutomatica() {
        return CajaAutomatica;
    }

    public boolean getCajaAutomatica() {
        return this.CajaAutomatica;
    }

    public void setCajaAutomatica(boolean CajaAutomatica) {
        this.CajaAutomatica = CajaAutomatica;
    }

    public Integer getIdCaballos() {
        return IdCaballos;
    }

    public void setIdCaballos(Integer IdCaballos) {
        this.IdCaballos = IdCaballos;
    }

    public Integer getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(Integer IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public boolean isTodoTerreno() {
        return TodoTerreno;
    }

    public void setTodoTerreno(boolean TodoTerreno) {
        this.TodoTerreno = TodoTerreno;
    }

    public boolean isIndustrial() {
        return Industrial;
    }

    public void setIndustrial(boolean Industrial) {
        this.Industrial = Industrial;
    }

    public String getFechaRecepcion() {
        return FechaRecepcion;
    }

    public void setFechaRecepcion(String FechaRecepcion) {
        this.FechaRecepcion = FechaRecepcion;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFinalizacion() {
        return FechaFinalizacion;
    }

    public void setFechaFinalizacion(String FechaFinalizacion) {
        this.FechaFinalizacion = FechaFinalizacion;
    }

    public char getIdFormaPago() {
        return IdFormaPago;
    }

    public void setIdFormaPago(char IdFormaPago) {
        this.IdFormaPago = IdFormaPago;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public Float getPrecioImp() {
        return PrecioImp;
    }

    public void setPrecioImp(Float PrecioImp) {
        this.PrecioImp = PrecioImp;
    }

    public Float getTipoIva() {
        return TipoIva;
    }

    public void setTipoIva(Float TipoIva) {
        this.TipoIva = TipoIva;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    public Propietario_model getPropietario() {
        return Propietario;
    }

    public void setPropietario(Propietario_model Propietario) {
        this.Propietario = Propietario;
    }

    public Concesionario_model getConcesionario() {
        return Concesionario;
    }

    public void setConcesionario(Concesionario_model Concesionario) {
        this.Concesionario = Concesionario;
    }

    public Garantia_model getGarantia() {
        return Garantia;
    }

    public void setGarantia(Garantia_model Garantia) {
        this.Garantia = Garantia;
    }

    public String getCCC() {
        return CCC;
    }

    public void setCCC(String CCC) {
        this.CCC = CCC;
    }

    /**
     * Para un contrato sacamos un contrato historico equivalente.
     *
     * @return Contrato_historico_model
     */
    public Contrato_historico_model getContratoHistorico() {
        Contrato_historico_model Ch = new Contrato_historico_model();
        
        Ch.setNGarantia(this.NumeroPoliza);
        Ch.setFtn_agg_concesionario_IdRemoto(this.getConcesionario().getIdRemoto());
        Ch.setIdComercial(-1);
        Ch.setTipoVehiculo(1);
        Ch.setMarca(this.getMarca());
        Ch.setModelo(this.getModelo());
        Ch.setMatricula(this.getMatricula());
        Ch.setFechaPrimeraMatriculacion(this.getFechaPrimeraMatriculacion());
        Ch.setKilometrosActuales(this.getKilometrosActuales());

        //Datos del propietario
        Ch.setNombreApellidos(this.getPropietario().getNombre());
        Ch.setDireccion(this.getPropietario().getDomicilio0());
        Ch.setCodPostal(this.getPropietario().getCp0());
        Ch.setPoblacion(this.getPropietario().getLocalidad0());
        Ch.setProvincia(this.getPropietario().getProvincia0());
        Ch.setCIF(this.getPropietario().getCIF());
        Ch.setCIFExtranjero("");
        Ch.setTelefono(this.getPropietario().getTelefono());
        Ch.setFax(this.getPropietario().getFax());
        
        Ch.setTipoGarantia(this.getGarantia().getIdTipoGarantia());
        Ch.setDuracion(this.getGarantia().getMeses().toString());

        Ch.setPrecio(this.getPrecioImp().toString());

        //Formas de pago.
        Ch.setFormaPago("15"); //Pago por tarjeta
        if (this.getIdFormaPago() == 'R') //Pago por transferencia
            Ch.setFormaPago("2");
        if (this.getIdFormaPago() == 'D') //Pago por domicialiación
            Ch.setFormaPago("3");

        Ch.setFechaRecepcion(this.getFechaRecepcion());
        Ch.setFechaInicio(this.getFechaInicio());
        Ch.setFechaFinalizacion(this.getFechaFinalizacion());
        Ch.setObservaciones(this.getComentarios());
        Ch.setFechaPago(this.getFechaPago());
        Ch.setCajaAutomatica(this.getCajaAutomatica());

        //Estado de la garantía.
        if (this.getIdEstado() == 'X')
            Ch.setAnulada(true);
        if (this.getIdEstado() == 'P')
            Ch.setPagado(true);

        //Numero de cuenta corrienta para domicialiación bancaria
        Ch.setCCC(this.getCCC());
        
        return Ch;
    }

    @Override
    public String toString() {
        String A;
        A = "#############################\n";
        A += "Contrato \n";
        A += "#############################\n";        
        A += "[NumeroPoliza] " + this.NumeroPoliza + "\n";
        A += "[IdEstado] " + this.IdEstado + "\n";
        A += "[Marca] " + this.Marca + "\n";
        A += "[Modelo] " + this.Modelo + "\n";
        A += "[Matricula] " + this.Matricula + "\n";
        A += "[FechaPrimeraMatriculacion] " + this.FechaPrimeraMatriculacion + "\n";
        A += "[KilometrosActuales] " + this.KilometrosActuales + "\n";
        A += "[CajaAutomatica] " + this.CajaAutomatica + "\n";
        A += "[IdCaballos] " + this.IdCaballos + "\n";
        A += "[IdCategoria] " + this.IdCategoria + "\n";
        A += "[TodoTerreno] " + this.TodoTerreno + "\n";
        A += "[Industrial] " + this.Industrial + "\n";
        A += "[FechaRecepcion] " + this.FechaRecepcion + "\n";
        A += "[FechaIngreso] " + this.FechaIngreso + "\n";
        A += "[FechaPago] " + this.FechaPago + "\n";
        A += "[FechaInicio] " + this.FechaInicio + "\n";
        A += "[FechaFinalizacion] " + this.FechaFinalizacion + "\n";
        A += "[IdFormaPago] " + this.IdFormaPago + "\n";
        A += "[Precio] " + this.Precio + "\n";
        A += "[PrecioImp] " + this.PrecioImp + "\n";
        A += "[TipoIva] " + this.TipoIva + "\n";
        A += "[Comentarios] " + this.Comentarios + "\n";       
        A += "[CCC] " + this.CCC + "\n";
        A += "#############################\n";
        A += Propietario.toString();
        A += Concesionario.toString();
        A += Garantia.toString();
        return A;
    }
    
    
}