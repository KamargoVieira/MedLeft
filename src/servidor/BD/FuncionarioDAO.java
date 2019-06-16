 
package servidor.BD;

import java.sql.*;
import servidor.entidades.Funcionario;

public class FuncionarioDAO {

    Connection connection;

    public void adcFuncionario(Funcionario f) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sqlInsert = "INSERT INTO Funcionario ("
                + "nome,"
                + "cpf,"
                + "usuario,"
                + "senha"
                + ") VALUES(?,?,?,?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, f.getNome());
        preparedStatement.setString(2, f.getCpf());
        preparedStatement.setString(3, f.getUsuario());
        preparedStatement.setString(4, f.getSenha());
        
        preparedStatement.executeUpdate();
        
        preparedStatement.close();
        
        connection.close();

    }
    
    public Funcionario getFuncionario(String cpf) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        Funcionario f;
        f = new Funcionario(result.getString("nome"), result.getString("cpf"), result.getString("usuario"), result.getString("senha"));
        
        preparedStatement.close();
        connection.close();
        
        return f;
    }
    
    public String getF(String cpf) throws SQLException{
        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();
        
        return result.getString("nome")+"@"+result.getString("cpf")+"@"+result.getString("usuario")+"@"+result.getString("senha");
    }
}
