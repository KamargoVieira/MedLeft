package servidor.BD;

import java.sql.*;
import servidor.entidades.Funcionario;

public class FuncionarioDAO {

    Connection connection;

    public boolean adcFuncionario(Funcionario f) throws SQLException {

        if (validaLogin(f.getUsuario(), f.getSenha())) {
            return false;
        } else {

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
            
            return true;
        }

    }

    public Funcionario getFuncionario(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        Funcionario f;
        f = new Funcionario(result.getString("nome"), result.getString("cpf"), result.getString("usuario"), result.getString("senha"));

        preparedStatement.close();
        connection.close();

        return f;
    }

    public String getF(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Funcionario WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        return result.getString("nome") + "@" + result.getString("cpf") + "@" + result.getString("usuario") + "@" + result.getString("senha");
    }

    public boolean validaLogin(String usuario, String senha) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Funcionario WHERE usuario = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, usuario);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();

        connection.close();

        if (result == null) {
            return false;
        } else if (result.getString("usuario").equals(usuario) && result.getString("senha").equals(senha)) {
            return true;
        }
        return false;
    }
    
     public boolean validaLogin(String usuario) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Funcionario WHERE usuario = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, usuario);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();

        connection.close();

        if (result == null) {
            return false;
        } else if (result.getString("usuario").equals(usuario)) {
            return true;
        }
        return false;
    }

    public boolean removeFuncionario(String cpf) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "DELETE FROM Funcionario WHERE cpf = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        int linhasDelet = preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        if (linhasDelet == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizaFuncionario(Funcionario f) throws SQLException {
        
        if (validaLogin(f.getUsuario())) {
            return false;
        } else {
            
            this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

            String sqlInsert = "UPDATE Funcionario SET "
                    + "nome = ?,"
                    + "usuario = ?,"
                    + "senha = ?"
                    + " WHERE cpf = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, f.getNome());
            preparedStatement.setString(2, f.getUsuario());
            preparedStatement.setString(3, f.getSenha());
            preparedStatement.setString(4, f.getCpf());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();

            return true;
        }
    }
}
