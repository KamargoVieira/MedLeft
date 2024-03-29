package servidor.BD;

import java.sql.*;
import servidor.entidades.Consulta;

public class ConsultaDAO {

    Connection connection;

    public boolean adcConsulta(Consulta c) throws SQLException {

        if (buscaConsulta(c.getData(), c.getHorario())) {
            return false;
        } else {
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

            String sqlInsert = "INSERT INTO Consulta ("
                    + "cpf,"
                    + "telefone,"
                    + "data,"
                    + "horario,"
                    + "observacoes,"
                    + "especialista"
                    + ") VALUES(?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, c.getCpf());
            preparedStatement.setString(2, c.getTelefone());
            preparedStatement.setString(3, c.getData());
            preparedStatement.setString(4, c.getHorario());
            preparedStatement.setString(5, c.getObservacoes());
            preparedStatement.setString(6, c.getEspecialista());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
            return true;
        }

    }

    public Consulta getConsulta(Integer id) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Consulta WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        Consulta c;
        c = new Consulta(result.getString("especialista"), result.getString("cpf"), result.getString("telefone"), result.getString("data"), result.getString("horario"), result.getString("observacoes"), result.getString("status"));

        preparedStatement.close();
        connection.close();

        return c;
    }

    public String getC(Integer id) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Consulta WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        return result.getString("cpf") + "@" + result.getInt("id") + "@" + result.getString("telefone") + "@" + result.getString("data") + "@" + result.getString("horario") + "@" + result.getString("observacoes") + "@" + result.getString("especialista");

    }

    public boolean buscaConsulta(String data, String horario) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Consulta WHERE horario = ? and data = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, horario);
        preparedStatement.setString(2, data);

        ResultSet result = preparedStatement.executeQuery();

        if (result.next()) {
            preparedStatement.close();
            connection.close();
            return false;
        } else {
            preparedStatement.close();
            connection.close();
            return true;
        }
    }

    public boolean confirmaConsulta(Integer id) throws SQLException {
        if (buscaConsultaID(id)) {
            return false;
        } else {
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

            String sqlInsert = "UPDATE Consulta SET "
                    + "status = ?,"
                    + "WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, "confirmado");
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
            return true;
        }
    }

    private boolean buscaConsultaID(Integer id) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Consulta WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        if (result == null) {
            return false;
        } else {
            return true;
        }

    }

    public boolean alteraAtendimento(Integer id) throws SQLException {

        if (buscaConsultaID(id)) {
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

            String sqlInsert = "UPDATE Consulta SET "
                    + "atendimento = ?,"
                    + "WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, "atendido");
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();

            return true;
        } else {
            return false;
        }
    }

    public String getConsultasDoDia(String data) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Consulta WHERE data = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, data);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();

        connection.close();

        if (result == null) {
            return null;
        } else {

            String r = "";

            while (result.next()) {
                r = r + result.getInt("id") + "@" + result.getString("cpf") + "@" + result.getString("telefone") + "@" + result.getString("horario") + "@" + result.getString("data") + "@" + result.getString("antendimento") + "%";
            }

            return r;
        }

    }
}
