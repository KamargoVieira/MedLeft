/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BD;

import java.sql.*;
import servidor.entidades.Paciente;

/**
 *
 * @author kamargo
 */
public class PacienteDAO {

    Connection connection;

    public boolean adcPaciente(Paciente p) throws SQLException {
        
        if (validaLogin(p.getUsuario(), p.getSenha())) {
            return false;
        } else {
        
            this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

            String sqlInsert = "INSERT INTO Paciente ("
                    + "Nome,"
                    + "CPF,"
                    + "Usuario,"
                    + "Senha,"
                    + "Identificacao,"
                    + "data_de_nascimento,"
                    + "Endereço,"
                    + "Bairro,"
                    + "Municipio,"
                    + "Estado,"
                    + "Telefone,"
                    + "Celular,"
                    + "Email"
                    + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setString(2, p.getCpf());
            preparedStatement.setString(3, p.getUsuario());
            preparedStatement.setString(4, p.getSenha());
            preparedStatement.setString(5, p.getIdentificacao());
            preparedStatement.setString(6, p.getDataNasc());
            preparedStatement.setString(7, p.getEndereco());
            preparedStatement.setString(8, p.getBairro());
            preparedStatement.setString(9, p.getMunicipio());
            preparedStatement.setString(10, p.getEstado());
            preparedStatement.setString(11, p.getTelefone());
            preparedStatement.setString(12, p.getCelular());
            preparedStatement.setString(13, "null");

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
            
            return true;
        }
    }

    public Paciente getPaciente(String cpf) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Paciente WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        Paciente p;
        p = new Paciente(result.getString("Nome"), result.getString("CPF"), result.getString("Usuario"), result.getString("Senha"), result.getString("Identificacao"), result.getString("data_de_nascimento"), result.getString("Endereço"), result.getString("Bairro"), result.getString("Municipio"), result.getString("Estado"), result.getString("Telefone"), result.getString("Celular"));

        preparedStatement.close();
        connection.close();

        return p;
    }
    
    public String getP(String cpf) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Paciente WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();

        return result.getString("Nome")+"@"+result.getString("CPF")+"@"+result.getString("Usuario")+"@"+result.getString("Senha")+"@"+result.getString("Identificacao")+"@"+result.getString("data_de_nascimento")+"@"+result.getString("Endereço")+"@"+result.getString("Bairro")+"@"+result.getString("Municipio")+"@"+result.getString("Estado")+"@"+result.getString("Telefone")+"@"+result.getString("Celular");

    }

    public boolean validaLogin(String usuario, String senha) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Paciente WHERE usuario = ?";

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
}
