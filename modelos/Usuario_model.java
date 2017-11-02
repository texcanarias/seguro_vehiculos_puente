/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 * Usuario del sistema
 * @author antonio
 */
public class Usuario_model extends modelo{
    public static final int UsuarioAdmin = 1;
    public static final int Usuariocliente = 6;
    public static final int UsuarioConcesionario = 7;
        
    /**
     * Nombre de usario
     */
    String Usuario;
    
    /**
     * Password del usuario
     */
    String Pass;
	
    /**
     * Nombre real del usuario
     */
    String Nombre;

    /**
     * Apellidos del usuario
     */
    String Apellidos;
    
    /**
     * Fecha en la que se dio de alta el usuario en el sistema
     */
    String FechaAlta; 
    
    /**
     * Fecha en la que se le permitió el acceso por última vez.
     */
    String FechaUltimoAcceso;
    
    String EMail;
    
    int tipo_usuario_Id;
    
    boolean ActivoId;
	
    int IntentosLogin;
    
    /**
     * Constructor por defecto
     */
    public Usuario_model(){
        super();
        this.Usuario = "";
        this.Pass = "";
        this.Nombre = "";
        this.Apellidos = "";
        this.FechaAlta = "";
        this.FechaUltimoAcceso = "";
        this.EMail = "";
        this.tipo_usuario_Id = this.UsuarioAdmin;
        this.ActivoId = false;
        this.IntentosLogin = 0;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass() {
        this.Pass = this.generarPass();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

    public String getFechaUltimoAcceso() {
        return FechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(String FechaUltimoAcceso) {
        this.FechaUltimoAcceso = FechaUltimoAcceso;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public int getTipo_usuario_Id() {
        return tipo_usuario_Id;
    }

    public void setTipo_usuario_Id(int tipo_usuario_Id) {
        this.tipo_usuario_Id = tipo_usuario_Id;
    }

    public boolean getActivoId() {
        return ActivoId;
    }

    public void setActivoId(boolean ActivoId) {
        this.ActivoId = ActivoId;
    }

    public int getIntentosLogin() {
        return IntentosLogin;
    }

    public void setIntentosLogin(int IntentosLogin) {
        this.IntentosLogin = IntentosLogin;
    }
    
    private String generarPass(){
        String Clave = "";
        for(int i=0 ; i<6 ; ++i)
            Clave += (char)((Math.random()*25)+65);
        return Clave;
    }

    @Override
    public String toString() {
        String Cadena = "";
        Cadena += "############"+"\n";
        Cadena += "[Id] "+this.Id +"\n";
        Cadena += "[Usuario] "+this.Usuario +"\n";
        Cadena += "[Pass] "+this.Pass +"\n";
        Cadena += "[Nombre] "+this.Nombre +"\n";
        Cadena += "[Apellidos] "+this.Apellidos +"\n";
        Cadena += "[Fecha alta] "+this.FechaAlta +"\n";
        Cadena += "[Fecha ultimo acceso] "+this.FechaUltimoAcceso +"\n";
        Cadena += "[Email] "+this.EMail +"\n";
        Cadena += "[Id tipo usuario] "+this.tipo_usuario_Id +"\n";
        Cadena += "[Id Activo] "+this.ActivoId +"\n";
        Cadena += "[Intentos login] "+this.IntentosLogin +"\n";
        Cadena += "############"+"\n";
        return Cadena;
    }
    
}
