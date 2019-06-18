package servidor.BD;

import java.sql.*;
import servidor.entidades.Paciente;

public class PacienteDAO {

    Connection connection;
    Statement stm;

    public boolean adcPaciente(Paciente p) throws SQLException {

        if (validaLogin(p.getUsuario()) || validaCpf(p.getCpf())) {
            return false;
        } else {

            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            this.stm = connection.createStatement();

            String sql = "INSERT INTO Paciente (Nome, CPF, Usuario, Senha, data_de_nascimento,Endereco, Bairro, Municipio, Cep, Estado, Telefone, Celular)"
                    + "VALUES('" + p.getNome() + "','" + p.getCpf() + "','" + p.getUsuario() + "','" + p.getSenha() + "','" + p.getDataNasc() + "','"
                    + p.getEndereco() + "','" + p.getBairro() + "','" + p.getMunicipio() + "','" + p.getCep() + "','" + p.getEstado() + "','" + p.getTelefone() + "','" + p.getCelular() + "');";

            stm.executeUpdate(sql);
            stm.close();
            connection.close();
            return true;
        }
    }

    public String getP(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();

        String sql = "SELECT * FROM Paciente WHERE cpf = '" + cpf + "'";
        ResultSet result = stm.executeQuery(sql);

        while (result.next()) {
            if (result.getString("cpf").equals(cpf)) {
                String str = result.getString("Nome") + "@" + result.getString("CPF") + "@" + result.getString("Usuario") + "@" + result.getString("Senha") + "@" + result.getString("data_de_nascimento") + "@" + result.getString("Endereco") + "@" + result.getString("Bairro") + "@" + result.getString("Municipio") + "@" + result.getString("Cep") + "@" + result.getString("Estado") + "@" + result.getString("Telefone") + "@" + result.getString("Celular");
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

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();

        String sql = "SELECT * FROM Paciente WHERE usuario = '" + usuario + "' and senha ='" + senha + "'";

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

        String sql = "SELECT * FROM Paciente WHERE usuario = '" + usuario + "'";

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

    public boolean validaCpf(String cpf) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "SELECT * FROM Paciente WHERE cpf = '" + cpf + "'";

        ResultSet result = stm.executeQuery(sql);
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            if (rs.getString("cpf").equals(cpf)) {
                stm.close();
                connection.close();
                return true;
            }
        }
        stm.close();
        connection.close();
        return false;
    }

    public boolean alterarPacienteAux(String usuario, String cpf) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        Statement stm = connection.createStatement();

        String sql = "SELECT * FROM Paciente WHERE usuario = '" + usuario + "'";

        ResultSet result = stm.executeQuery(sql);
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

    public boolean atualizaPaciente(Paciente p) throws SQLException {
        if (alterarPacienteAux(p.getUsuario(), p.getCpf())) {
            return false;
        } else {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            Statement stm = connection.createStatement();

            String sql = "UPDATE Paciente SET nome = '" + p.getNome() + "', data_de_nascimento = '" + p.getDataNasc() + "', Endereco = '" + p.getEndereco() + "', Bairro = '" + p.getBairro() + "', Municipio = '" + p.getMunicipio() + "', Estado = '" + p.getEstado() + "', Telefone = '" + p.getTelefone() + "', Celular = '" + p.getCelular() + "', Usuario = '" + p.getUsuario() + "', Senha = '" + p.getSenha() + "',Cep = '" + p.getCep() + "' WHERE cpf = '" + p.getCpf() + "'";
            int linhasatualizadas = stm.executeUpdate(sql);

            stm.close();
            connection.close();
            return true;

        }
    }
}
