/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author antonio
 */
public class modelo {
        /**
     * El Id que tiene la base de datos Access
     */
    protected int IdRemoto;
    
    /**
     * El Id que tiene la base de datos MySql
     */
    protected int Id;
    
    public modelo(){
        this.Id = -1;
        this.IdRemoto = -1;
    }
    
    public int getIdRemoto() {
        return IdRemoto;
    }

    public void setIdRemoto(int IdRemoto) {
        this.IdRemoto = IdRemoto;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }    
    
    public String getNombre(){
        return "";
    }
    
    public String getEmail(){
        return "";
    }
}
