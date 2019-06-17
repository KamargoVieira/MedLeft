/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BD;

import java.sql.*;
import servidor.entidades.Exame;

/**
 *
 * @author kamargo
 */
public class ExameDAO {
    Connection connection;
    
    public void adcExame(Exame e) throws SQLException{
       
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sqlInsert = "INSERT INTO Exame ("
                + "tipo,"
                + "valor"
                + ") VALUES(?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, e.getTipo());
        preparedStatement.setDouble(2, e.getValor());
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        
        this.connection.close();
    }
    
    public Exame getExame(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Exame WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        Exame e;
        e = new Exame(result.getString("tipo"), result.getDouble("valor"));
        e.setId(id);
        
        preparedStatement.close();
        this.connection.close();
        
        return e;
        
    }
    
    public String getE(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Exame WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
               
        preparedStatement.close();
        this.connection.close();
        
        return result.getString("tipo")+"@"+result.getInt("id")+"@"+result.getDouble("valor");
    }
}
