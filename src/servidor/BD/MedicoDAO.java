/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BD;

import java.sql.*;
import servidor.entidades.Medico;

/**
 *
 * @author kamargo
 */
public class MedicoDAO {
    
    Connection connection;
    
    public void adcMedico(Medico m) throws SQLException{
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sqlInsert = "INSERT INTO Medico ("
                + "nome,"
                + "cpf,"
                + "usuario,"
                + "senha,"
                + "especialidade"
                + ") VALUES(?,?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, m.getNome());
        preparedStatement.setString(2, m.getCpf());
        preparedStatement.setString(3, m.getUsuario());
        preparedStatement.setString(4, m.getSenha());
        preparedStatement.setString(5, m.getEspecialidade());
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        
        connection.close();
    }
    
    public Medico getMedico(String cpf) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Medico WHERE cpf = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        Medico m;
        m = new Medico(result.getString("nome"), result.getString("cpf"), result.getString("usuario"), result.getString("senha"), result.getString("especialidade"));
        
        preparedStatement.close();
        connection.close();
        
        return m;
    }
    
    public String getM(String cpf) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Medico WHERE cpf = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();
       
        return result.getString("nome")+"@"+result.getString("cpf")+"@"+result.getString("usuario")+"@"+result.getString("senha")+"@"+result.getString("especialidade");  

    }
}
