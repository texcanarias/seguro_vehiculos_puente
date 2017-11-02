/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelos.Marca_modelo_model;

/**
 *
 * @author antonio
 */
public class marca_modelo extends Enlace{
    public marca_modelo(){
        super();
    }
    
    /**
     * Recogemos una garantia concreta
     * @param Integer Id Identificador del concesionario
     */
    protected Marca_modelo_model getItemMySql(Integer Id) {
        
        Marca_modelo_model A = new Marca_modelo_model();
        if (null == this.ConnMySql) {
            this.CrearConnMySql();
        }
        try {
            Statement st = this.ConnMySql.createStatement();
            String Sql;
            Sql = " SELECT " +
                  "     ftn_agg_marca.Nombre as Marca, " +
                  "     ftn_agg_modelo.Nombre as Modelo, " +
                  "     ftn_agg_modelo.IdCategoria as IdCategoria " +
                  "FROM " +
                  "    ftn_agg_modelo " +
                  "    JOIN " +
                  "        ftn_agg_marca " +
                  "    ON " +
                  "        ftn_agg_modelo.Id = " + Id +
                  "        AND " +
                  "        ftn_agg_marca.Id = ftn_agg_modelo.ftn_agg_marcaId;";

            ResultSet rs = st.executeQuery(Sql);
            
            while (rs.next()) {
                A.setMarca(rs.getString("Marca"));
                A.setModelo(rs.getString("Modelo"));
                A.setTipoVehiculo("Reservado");
            }
            
            rs.close();
            st.close();
        } catch (SQLException ea) {
            System.out.println("Error en la conexión con la base de datos MySql. marca_modelo.getItemMySql (getItems)");
            System.out.println("[" + ea.getErrorCode() + "] " + ea);
        } catch (Exception eb) {
            System.out.println("Error indeterminado. marca_modelo.getItemMySql  (getItems)");
            System.out.println("[" + eb.getMessage() + "] " + eb);
            System.out.println("Causa " + eb.getCause());
        }
        return A;
    }
    
}
