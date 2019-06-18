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

    public boolean adcMedico(Medico m) throws SQLException, ClassNotFoundException {

        if (validaLogin(m.getUsuario())) {
            return false;
        } else {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            Statement stm = connection.createStatement();
            String sql = "INSERT INTO Medico (nome,cpf,usuario,senha,especialidade) VALUES('" + m.getNome() + "','" + m.getCpf() + "','" + m.getUsuario() + "','" + m.getSenha() + "','" + m.getEspecialidade() + "')";
            stm.executeUpdate(sql);
            stm.close();
            connection.close();
            return true;
        }
    }

    public Medico getMedico(String cpf) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

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

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "SELECT * FROM Medico WHERE cpf = '" + cpf + "'";
        ResultSet result = stm.executeQuery(sql);

        while (result.next()) {
            if (result.getString("cpf").equals(cpf)) {
                String str = result.getString("nome") + "@" + result.getString("cpf") + "@" + result.getString("usuario") + "@" + result.getString("senha") + "@" + result.getString("especialidade");
                stm.close();
                connection.close();
                return str;
            }
        }
        stm.close();
        connection.close();
        return null;

    }

    public boolean validaLogin(String usuario, String senha) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "SELECT * FROM Medico WHERE usuario = '" + usuario + "' and senha ='" + senha + "'";

        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("usuario").equals(usuario) && rs.getString("senha").equals(senha)) {
                stm.close();
                connection.close();
                return true;
            }
        }
        stm.close();
        connection.close();
        return false;
    }

    public boolean validaLogin(String usuario) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "SELECT * FROM Medico WHERE usuario = '" + usuario + "'";

        ResultSet result = stm.executeQuery(sql);
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("usuario").equals(usuario)) {
                stm.close();
                connection.close();
                return true;
            }
        }
        stm.close();
        connection.close();
        return false;
    }

    public boolean alterarMedicoAux(String usuario, String cpf) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "SELECT * FROM Medico WHERE usuario = '" + usuario + "'";

        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("usuario").equals(usuario) && !(rs.getString("cpf").equals(cpf))) {
                stm.close();
                connection.close();
                return true;
            }
        }
        stm.close();
        connection.close();
        return false;
    }

    public boolean removeMedico(String cpf) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "DELETE FROM Medico WHERE cpf = '" + cpf + "'";
        int linhasDelet = stm.executeUpdate(sql);

        if (linhasDelet == 1) {
            stm.close();
            connection.close();
            return true;
        } else {
            stm.close();
            connection.close();
            return false;
        }
    }

    public boolean atualizaMedico(Medico m) throws SQLException {

        if (alterarMedicoAux(m.getUsuario(), m.getCpf())) {
            return false;
        } else {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            Statement stm = connection.createStatement();

            String sql = "UPDATE Medico SET nome = '" + m.getNome() + "', usuario = '" + m.getUsuario() + "', senha = '" + m.getSenha() + "', especialidade = '" + m.getEspecialidade() + "' WHERE cpf = '" + m.getCpf() + "'";
            int linhasatualizadas = stm.executeUpdate(sql);
            if (linhasatualizadas == 1) {
                stm.close();
                connection.close();
                return true;
            } else {
                stm.close();
                connection.close();
                return false;
            }
        }

    }
}
