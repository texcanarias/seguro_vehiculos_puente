/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Garantia_model;

/**
 *
 * @author antonio
 */
public class garantia extends Enlace{
    public garantia(){
        super();
    }
    
    /**
     * Recogemos una garantia concreta
     * @param Integer Id Identificador del concesionario
     */
    protected Garantia_model getItemMySql(Integer Id) {
        
        Garantia_model A = new Garantia_model();
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();
            String Sql;
            Sql = "   SELECT " +
                    "   ftn_agg_garantia.Nombre, " +
                    "   ftn_agg_garantia.FechaInicio, " +
                    "   ftn_agg_garantia.FechaFinal, " +
                    "   ftn_agg_garantia.IdTipoGarantia, " +
                    "   (SELECT Meses FROM ftn_agg_garantia_vigencia WHERE Id = ftn_agg_garantia_detalle.ftn_gag_garantia_vigenciaId) as Meses " +
                    " FROM " +
                    "   ftn_agg_garantia " +
                    "   JOIN " +
                    "       ftn_agg_garantia_detalle " +
                    "   ON " +
                    "       ftn_agg_garantia_detalle.Id = " + Id +
                    "       AND " +
                    "       ftn_agg_garantia.Id = ftn_agg_garantia_detalle.ftn_gag_garantiaId";
            

            ResultSet rs = st.executeQuery(Sql);
            
            while (rs.next()) {
                A.setId(Id);
                A.setNombre(rs.getString("Nombre"));
                A.setFechaInicio(rs.getString("FechaInicio"));
                A.setFechaFinal(rs.getString("FechaFinal"));
                A.setIdTipoGarantia(rs.getInt("IdTipoGarantia"));
                A.setMeses(rs.getInt("Meses"));
            }
            
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. garantia.getItemMySql (getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado. garantia.getItemMySql (getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return A;
    }
    
}
