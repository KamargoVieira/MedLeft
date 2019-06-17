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

    public boolean adcMedico(Medico m) throws SQLException {

        if (validaLogin(m.getUsuario(), m.getSenha())) {
            return false;
        } else {

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

            return true;
        }
    }

    public Medico getMedico(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Medico WHERE cpf = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        Medico m;
        m = new Medico(result.getString("nome"), result.getString("cpf"), result.getString("usuario"), result.getString("senha"), result.getString("especialidade"));

        preparedStatement.close();
        connection.close();

        return m;
    }

    public String getM(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Medico WHERE cpf = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();

        connection.close();

        if (result == null) {
            return null;
        } else {
            return result.getString("nome") + "@" + result.getString("cpf") + "@" + result.getString("usuario") + "@" + result.getString("senha") + "@" + result.getString("especialidade");
        }
    }

    public boolean validaLogin(String usuario, String senha) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Medico WHERE usuario = ?;";

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

        String sql = "SELECT * FROM Medico WHERE usuario = ?;";

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

    public boolean removeMedico(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "DELETE FROM Cliente WHERE cpf = ?;";

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

    public boolean atualizaMedico(Medico m) throws SQLException {

        if (validaLogin(m.getUsuario())) {
            return false;
        } else {
            
            this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

            String sqlInsert = "UPDATE Medico SET "
                    + "nome = ?,"
                    + "usuario = ?,"
                    + "senha = ?,"
                    + "especialidade = ?,"
                    + " WHERE cpf = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, m.getNome());
            preparedStatement.setString(2, m.getUsuario());
            preparedStatement.setString(3, m.getSenha());
            preparedStatement.setString(4, m.getEspecialidade());
            preparedStatement.setString(5, m.getCpf());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();

            return true;
        }

    }
}
