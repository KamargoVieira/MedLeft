package servidor.BD;

import java.sql.*;
import servidor.entidades.Funcionario;

public class FuncionarioDAO {

    Connection connection;
    Statement  stm;

    public boolean adcFuncionario(Funcionario f) throws SQLException {

        if (validaLogin(f.getUsuario())) {
            return false;
        } else {

            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            this.stm = connection.createStatement();           
            
            String sql = "INSERT INTO Funcionario (nome,cpf,usuario,senha) VALUES('"+f.getNome()+"','"+f.getCpf()+"','"+f.getUsuario()+"','"+f.getSenha()+"')";
            stm.executeUpdate(sql);            
            stm.close();
            connection.close();
            return true;
        }

    }

    public Funcionario getFuncionario(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

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

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();
        
        String sql = "SELECT * FROM Funcionario WHERE cpf = '"+cpf+"'";
        ResultSet result = stm.executeQuery(sql);

        while(result.next()){
            if(result.getString("cpf").equals(cpf)){
                String str = result.getString("nome") + "@" + result.getString("cpf") + "@" + result.getString("usuario") + "@" + result.getString("senha");
                stm.close();
                connection.close();
                return str;
            }
        }
        stm.close();
        connection.close();
        return  null;
    }

    public boolean validaLogin(String usuario, String senha) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this. stm = connection.createStatement();      
      
        String sql = "SELECT * FROM Funcionario WHERE usuario = '"+usuario+ "' and senha ='" + senha+"'";        
        
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

    public boolean validaLogin(String usuario) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();
        
        String sql = "SELECT * FROM Funcionario WHERE usuario = '"+usuario+"'";       

        ResultSet result = stm.executeQuery(sql);
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("usuario").equals(usuario)){
                stm.close();
                connection.close();
                return true;
            }
        }
        stm.close();
        connection.close();
        return false;
    }

    public boolean removeFuncionario(String cpf) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();

        String sql = "DELETE FROM Funcionario WHERE cpf = '"+cpf+"'";
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

    public boolean atualizaFuncionario(Funcionario f) throws SQLException {

        if (alterarFuncionarioAux(f.getUsuario(),f.getCpf())) {
            return false;
        } else {

            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            this.stm = connection.createStatement();

            String sql = "UPDATE Funcionario SET nome = '"+ f.getNome()+"', usuario = '"+f.getUsuario()+"', senha = '"+f.getSenha()+"' WHERE cpf = '"+f.getCpf()+"'";
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

    private boolean alterarFuncionarioAux(String usuario, String cpf) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();
        
        String sql = "SELECT * FROM Funcionario WHERE usuario = '"+usuario+"'";       

        ResultSet result = stm.executeQuery(sql);
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("usuario").equals(usuario) && !(rs.getString("cpf").equals(cpf))){
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
