package servidor.BD;

import java.sql.*;
import servidor.entidades.Exame;

public class ExameDAO {
    Connection connection;
    
    public boolean adcExame(Exame e) throws SQLException{
        
        if(validaExame(e.getTipo())){
            return false;
        } else {
            
            this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
            String sqlInsert = "INSERT INTO Exame ("
                    + "tipo,"
                    + "valor"
                    + ") VALUES(?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, e.getTipo());
            preparedStatement.setDouble(2, e.getValor());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            this.connection.close();
            
            return true;
        }
    }
    
    public boolean validaExame(String tipo) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "SELECT * FROM Exame WHERE tipo = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tipo);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();

        connection.close();

        if (result == null) {
            return false;
        } else{
            return true;
        }

    }
    
    public Exame getExame(Integer id) throws SQLException{
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
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
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");
        
        String sql = "SELECT * FROM Exame WHERE id = ?;";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        
        ResultSet result  = preparedStatement.executeQuery();
               
        preparedStatement.close();
        this.connection.close();
        
        return result.getString("tipo")+"@"+result.getInt("id")+"@"+result.getDouble("valor");
    }

    public boolean removeExame(String tipo) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:basededados.db");

        String sql = "DELETE FROM Exame WHERE tipo = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tipo);

        int linhasDelet = preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        if (linhasDelet == 1) {
            return true;
        } else {
            return false;
        }
    }
}
