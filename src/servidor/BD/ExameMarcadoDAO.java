/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.BD;

import java.sql.*;
import servidor.entidades.ExameMarcado;

/**
 *
 * @author kamargo
 */
public class ExameMarcadoDAO {

    Connection connection;

    public boolean adcExameMarcado(ExameMarcado eM) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        if (validaExameMarcado(eM.getData(), eM.getHorario())) {
            return false;
        } else {
            String sqlInsert = "INSERT INTO ExameMacado ("
                    + "cpf,"
                    + "telefone,"
                    + "data,"
                    + "horario,"
                    + "observacoes,"
                    + "tipo"
                    + ") VALUES(?,?,?,?,?,?);";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, eM.getCpf());
            preparedStatement.setString(2, eM.getTelefone());
            preparedStatement.setString(3, eM.getData());
            preparedStatement.setString(4, eM.getHorario());
            preparedStatement.setString(5, eM.getObservacoes());
            preparedStatement.setString(6, eM.getTipo());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            connection.close();
            return true;
        }

    }

    public boolean validaExameMarcado(String data, String horario) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM ExameMarcado WHERE horario = ? and data = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, horario);
        preparedStatement.setString(2, data);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        if (result == null) {
            return false;
        } else {
            return true;
        }

    }

    public ExameMarcado getExameMarcado(Integer id) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM ExameMarcado WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        ExameMarcado eM;
        eM = new ExameMarcado(result.getString("cpf"), result.getString("telefone"), result.getString("data"), result.getString("horario"), result.getString("observacoes"), result.getString("tipo"));

        preparedStatement.close();
        connection.close();

        return eM;
    }

    public String getEM(Integer id) throws SQLException {

        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

        String sql = "SELECT * FROM ExameMarcado WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet result = preparedStatement.executeQuery();

        preparedStatement.close();
        connection.close();

        return result.getString("cpf")+"@"+result.getString("telefone")+"@"+result.getString("data")+"@"+result.getString("horario")+"@"+result.getString("observacoes")+"@"+result.getString("tipo");
    
    }

    public boolean confirmaExame(Integer id) throws SQLException {
        if (buscaExame(id)) {
            return false;
        } else {
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");

            String sqlInsert = "UPDATE ExameMarcado SET "
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

    public boolean buscaExame(Integer id) throws SQLException {
        
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            
        String sql = "SELECT * FROM ExameMarcado WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id); 
        
        ResultSet result = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();
        
        if(result == null){
            return false;
        }else{
            return true;
        }
        
    }
    
    private boolean buscaExameID(Integer id) throws SQLException{
        this.connection = DriverManager.getConnection("jdbc:sqlite:src/servidor/BD/basededados.db");
            
        String sql = "SELECT * FROM ExameMarcado WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id); 
        
        ResultSet result = preparedStatement.executeQuery();
        
        preparedStatement.close();
        connection.close();
        
        if(result == null){
            return false;
        }else{
            return true;
        }
    }
}
