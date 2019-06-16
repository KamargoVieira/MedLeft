package servidor.BD;


import java.sql.*;
import servidor.entidades.Consulta;

public class ConsultaDAO {
    
    Connection connection;
    
    public void adcConsulta(Consulta c) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
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
    }
    
    public Consulta getConsulta(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Consulta WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        Consulta c;
        c = new Consulta(result.getString("cpf"), result.getInt("id"), result.getString("telefone"), result.getString("data"), result.getString("horario"), result.getString("observacoes"), result.getString("especialista"));
        
        preparedStatement.close();
        connection.close();
        
        return c;
    }
    
    public String getC(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Consulta WHERE id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();
        
        return result.getString("cpf")+"@"+result.getInt("id")+"@"+result.getString("telefone")+"@"+result.getString("data")+"@"+result.getString("horario")+"@"+result.getString("observacoes")+"@"+result.getString("especialista");
        
    }
}
