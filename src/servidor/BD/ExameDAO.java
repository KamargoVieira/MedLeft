package servidor.BD;

import java.sql.*;
import servidor.entidades.Exame;

public class ExameDAO {
    
    Connection connection;
    Statement stm;
    
    public boolean adcExame(Exame e) throws SQLException{
        
        if(validaExame(e.getTipo())){
            return false;
        } else {
            
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            this.stm = connection.createStatement();
        
            String sql = "INSERT INTO Exame (tipo,valor)VALUES('"+e.getTipo()+"','"+e.getValor()+"')";
            stm.executeUpdate(sql);
            
            this.stm.close();
            this.connection.close();
            
            return true;
        }
    }
    
    public boolean validaExame(String tipo) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();
        
        String sql = "SELECT * FROM Exame WHERE tipo = '"+tipo+"'";

        ResultSet result = stm.executeQuery(sql);
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            if(rs.getString("tipo").equals(tipo)){
                stm.close();
                connection.close();
                return true;
            }
        }
        return false;
    }
    
    public Exame getExame(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        
        String sql = "SELECT * FROM Exame WHERE id = ?;";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
        
        Exame e;
        e = new Exame(result.getString("tipo"), result.getDouble("valor"));
        e.setId(id);
        
        preparedStatement.close();
        this.connection.close();
        
        return e;
        
    }
    
    public String getE(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        
        String sql = "SELECT * FROM Exame WHERE id = ?;";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
               
        preparedStatement.close();
        this.connection.close();
        
        return result.getString("tipo")+"@"+result.getInt("id")+"@"+result.getDouble("valor");
    }

    public boolean removeExame(String tipo) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
        this.stm = connection.createStatement();
        
        String sql = "DELETE FROM Exame WHERE tipo = '"+tipo+"'";
        
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
}
