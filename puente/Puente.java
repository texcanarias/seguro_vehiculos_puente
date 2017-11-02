 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import vista.MainJFrame;
import vista.OkDialog;

/**
 *
 * @author antonio
 */
public class Puente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainJFrame Frame = new MainJFrame();
        Frame.setVisible(true);
        
        concesionario Objconcesionario = new puente.concesionario();
        contrato_historico ObjContrato = new puente.contrato_historico();
        contrato_online ObjContratoOnLine = new contrato_online();
        
        int TotalAlteradoA = Objconcesionario.ContarRegistrosAccess();
        int TotalAlteradoB = Objconcesionario.ContarRegistrosMySql();
        int TotalAlteradoC = ObjContrato.ContarRegistrosAccess();
        int TotalAlteradoD = ObjContratoOnLine.ContarRegistrosMySql();
        
        Integer Total =  TotalAlteradoA + TotalAlteradoB  + TotalAlteradoC + TotalAlteradoD;
        Frame.TotalRegistros(Total);
        Integer Acumulado = 0;
        
        System.out.println("Total  = " + Total);
        System.out.println("Concesionario (ACCESS) = " + TotalAlteradoA);
        System.out.println("Concesionario (MySql) = " + TotalAlteradoB);
        System.out.println("Contrato (ACCESS) " +  TotalAlteradoC);
        System.out.println("Contrato (MySql) " +  TotalAlteradoD);
        
        //Contamos los registros modificados en los concesionarios
        if (0 != TotalAlteradoA){
            //Obtenemos los objetos modificados y los pasamos al systema mysql.
            Objconcesionario.setItemsAccess(Objconcesionario.getItemsAccess());
            Acumulado += TotalAlteradoA;
            Frame.AjustarBarraProgreso(Acumulado);
        }            
        
        if(0 != TotalAlteradoB){
            Objconcesionario.setItemsMySql(Objconcesionario.getItemsMySql());
            Acumulado += TotalAlteradoB;
            Frame.AjustarBarraProgreso(Acumulado);
        }
        
        if (0 != TotalAlteradoC) {
            ObjContrato.setItemsAccess(ObjContrato.getItemsAccess());
            Acumulado += TotalAlteradoC;
            Frame.AjustarBarraProgreso(Acumulado);
        }        
        
        if(0 != TotalAlteradoD){
            ObjContratoOnLine.setItemsAccess(ObjContratoOnLine.getItemsMySql());
            Acumulado += TotalAlteradoD;
            Frame.AjustarBarraProgreso(Acumulado);
        }
        
        OkDialog Dialogo = new OkDialog(Frame, true);
        Dialogo.setVisible(true);
    }
}
