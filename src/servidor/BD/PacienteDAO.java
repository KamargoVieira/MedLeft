package servidor.BD;

import java.sql.*;
import servidor.entidades.Paciente;

public class PacienteDAO {

    Connection connection;
    Statement stm;

    public boolean adcPaciente(Paciente p) throws SQLException {
        
        if (validaLogin(p.getUsuario(), p.getSenha())) {
            return false;
        } else {
        
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            this.stm = connection.createStatement();
            
            String sql = "INSERT INTO Paciente (Nome, CPF, Usuario, Senha, data_de_nascimento,Endereco, Bairro, Municipio, Estado, Telefone, Celular)"
                    + "VALUES('"+p.getNome()+"','"+p.getCpf()+"','"+p.getUsuario()+"','"+p.getSenha()+"','"+p.getDataNasc()+"','"
                    +p.getEndereco()+"','"+p.getBairro()+"','"+p.getMunicipio()+"','"+p.getEstado()+"','"+p.getTelefone()+"','"+p.getCelular()+"')";
           
            stm.executeUpdate(sql);            
            stm.close();
            connection.close();
            return true;
        }
    }

    public Paciente getPaciente(String cpf) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

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
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM Paciente WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet result = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();

        return result.getString("Nome")+"@"+result.getString("CPF")+"@"+result.getString("Usuario")+"@"+result.getString("Senha")+"@"+result.getString("Identificacao")+"@"+result.getString("data_de_nascimento")+"@"+result.getString("Endereço")+"@"+result.getString("Bairro")+"@"+result.getString("Municipio")+"@"+result.getString("Estado")+"@"+result.getString("Telefone")+"@"+result.getString("Celular");

    }

    public boolean validaLogin(String usuario, String senha) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this. stm = connection.createStatement();      
      
        String sql = "SELECT * FROM Paciente WHERE usuario = '"+usuario+ "' and senha ='" + senha+"'";        
        
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("usuario").equals(usuario) && rs.getString("senha").equals(senha)){
                stm.close();
                connection.close();
                return true;
            }
        }
        stm.close();
        connection.close();
        return false;
    }
}
