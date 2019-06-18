/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BD;

import java.sql.*;
import servidor.entidades.Prontuario;

/**
 *
 * @author denilsondsousa
 */
public class ProntuarioDAO {

    private Connection connection;

    public String getProntuario(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Prontuario WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        if (result == null) {
            return null;
        } else {
            return result.getString("cpf") + "@" + result.getString("usuario") + "@" + result.getString("queixaprincipal") + "@" + result.getString("historicofamiliar") + "@" + result.getString("obs") + "@" + result.getString("altura") + "@" + result.getString("peso") + "@" + result.getString("hemoglucoteste") + "@" + result.getString("frequenciacardiaca") + "@" + result.getString("pressaosistotica") + "@" + result.getString("pressaodiastolica") + "@" + result.getString("obs2");
        }

    }

    public String getP(String usuario) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Prontuario WHERE usuario = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, usuario);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        if (result == null) {
            return null;
        } else {
            return result.getString("cpf") + "@" + result.getString("usuario") + "@" + result.getString("queixaprincipal") + "@" + result.getString("historicofamiliar") + "@" + result.getString("obs") + "@" + result.getString("altura") + "@" + result.getString("peso") + "@" + result.getString("hemoglucoteste") + "@" + result.getString("frequenciacardiaca") + "@" + result.getString("pressaosistotica") + "@" + result.getString("pressaodiastolica") + "@" + result.getString("obs2");
        }

    }

    public void atualizaProntuario(Prontuario p) throws SQLException {
        if (verificaProntuario(p.getCpf())) {
            
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

            String sqlInsert = "UPDATE Prontuario SET "
                    + "usuario = ?,"
                    + "queixaprincipal = ?,"
                    + "historicofamiliar = ?,"
                    + "obs = ?,"
                    + "altura = ?,"
                    + "peso = ?,"
                    + "hemoglucoteste = ?,"
                    + "frequenciacardiaca = ?,"
                    + "pressaosistotica = ?,"
                    + "pressaodiastolica = ?,"
                    + "obs2 = ?"
                    + "WHERE cpf = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, p.getUsuario());
            preparedStatement.setString(2, p.getQueixaprincipal());
            preparedStatement.setString(3, p.getHistoricofamiliar());
            preparedStatement.setString(4, p.getObs());
            preparedStatement.setString(5, p.getAltura());
            preparedStatement.setString(6, p.getPeso());
            preparedStatement.setString(7, p.getHemoglucoteste());
            preparedStatement.setString(8, p.getFrequenciacardiaca());
            preparedStatement.setString(9, p.getPressaosistotica());
            preparedStatement.setString(10, p.getPressaodiastolica());
            preparedStatement.setString(11, p.getObs2());
            preparedStatement.setString(12, p.getCpf());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
            
        } else {
            
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

            String sqlInsert = "INSERT INTO Prontuario ("
                    + "cpf,"
                    + "usuario,"
                    + "queixaprincipal,"
                    + "historicofamiliar,"
                    + "obs,"
                    + "altura,"
                    + "peso,"
                    + "hemoglucoteste,"
                    + "frequenciacardiaca,"
                    + "pressaosistotica,"
                    + "pressaodiastolica,"
                    + "obs2"
                    + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, p.getCpf());
            preparedStatement.setString(2, p.getUsuario());
            preparedStatement.setString(3, p.getQueixaprincipal());
            preparedStatement.setString(4, p.getHistoricofamiliar());
            preparedStatement.setString(5, p.getObs());
            preparedStatement.setString(6, p.getAltura());
            preparedStatement.setString(7, p.getPeso());
            preparedStatement.setString(8, p.getHemoglucoteste());
            preparedStatement.setString(9, p.getFrequenciacardiaca());
            preparedStatement.setString(10, p.getPressaosistotica());
            preparedStatement.setString(11, p.getPressaodiastolica());
            preparedStatement.setString(12, p.getObs2());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
            
        }
    }

    private boolean verificaProntuario(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Prontuario WHERE cpf = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();

        connection.close();

        if (result == null) {
            return false;
        } else if (result.getString("cpf").equals(cpf)) {
            return true;
        }
        return false;
    }
}
