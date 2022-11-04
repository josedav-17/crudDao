package com.mycompany.recursoshumanos.data;

import com.mycompany.recursoshumanos.dominio.Funcionarios;
import com.mycompany.recursoshumanos.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class FuncionariosDao {
    
    private static final String  GET_FUN = "SELECT * FROM funcionarios";
    
    private static final String CREATE_FUN = "insert into public.funcionarios"
        + "(Tipoid_fun, nombre_fun, apellido_fun, estado_fun, sexo_fun, direccion_fun, telefono_fun, nacimiento_fun)"
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    
    private static final String GET_FUN_BY_ID = "select * from funcionarios where id_fun = ?";
    
    private static final String UPDATE_FUN = "update public.funcionarios SET Tipoid_fun= ?, nombre_fun= ?, apellido_fun= ?, estado_fun= ?, sexo_fun=?, direccion_fun= ?, telefono_fun= ?, nacimiento_fun= ?";
    
    private static final String DELETE_FUN = "delete from funcionarios where id_fun = ?";
    
    //crear un funcionario
    public void crear(Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(CREATE_FUN);
            preparedStatement.setString(1, funcionario.getTipoid_fun());
            preparedStatement.setString(2, funcionario.getNombre_fun());
            preparedStatement.setString(3, funcionario.getApellido_fun());
            preparedStatement.setString(4, funcionario.getEstado_fun());
            preparedStatement.setString(5, funcionario.getSexo_fun());
            preparedStatement.setString(6, funcionario.getDireccion_fun());
            preparedStatement.setInt(7, funcionario.getTelefono_fun());
            preparedStatement.setString(8, funcionario.getNacimiento_fun());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al crear el funcionario: " + e.getMessage());
        } finally {
            if(connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement. close();
            }
        }        
}  
//obtener todos los funcionarios
    public List<Funcionarios> obtener() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios> funcionarios = new ArrayList<>();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUN);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Funcionarios funcionario = new Funcionarios();
                funcionario.setId_fun(resultSet.getInt("id_fun"));
                funcionario.setTipoid_fun(resultSet.getString("Tipoid_fun"));
                funcionario.setNombre_fun(resultSet.getString("nombre_fun"));
                funcionario.setApellido_fun(resultSet.getString("apellido_fun"));
                funcionario.setEstado_fun(resultSet.getString("estado_fun"));
                funcionario.setSexo_fun(resultSet.getString("sexo_fun"));
                funcionario.setDireccion_fun(resultSet.getString("direccion_fun"));
                funcionario.setTelefono_fun(resultSet.getInt("telefono_fun"));
                funcionario.setNacimiento_fun(resultSet.getString("nacimiento_fun"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los funcionarios: " + e.getMessage());
        } finally {
            if(connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement. close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        }
        return funcionarios;
    }
            
        
    //obtener un funcionario por id
    public Funcionarios obtenerPorID(int funcionario2) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionario = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUN_BY_ID);
            preparedStatement.setInt(1, funcionario2);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                funcionario = new Funcionarios();
                funcionario.setId_fun(resultSet.getInt("id_fun"));
                funcionario.setTipoid_fun(resultSet.getString("Tipoid_fun"));
                funcionario.setNombre_fun(resultSet.getString("nombre_fun"));
                funcionario.setApellido_fun(resultSet.getString("apellido_fun"));
                funcionario.setEstado_fun(resultSet.getString("estado_fun"));
                funcionario.setSexo_fun(resultSet.getString("sexo_fun"));
                funcionario.setDireccion_fun(resultSet.getString("direccion_fun"));
                funcionario.setTelefono_fun(resultSet.getInt("telefono_fun"));
                funcionario.setNacimiento_fun(resultSet.getString("nacimiento_fun"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el funcionario: " + e.getMessage());
        } finally {
            if(connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement. close();
            }
            if (resultSet != null){
                resultSet.close();
            }
        }
        return funcionario;
    }


//ACTUALIZAR FUNCIONARIO
    public void actualizar(Funcionarios funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUN);
            preparedStatement.setString(1, funcionario.getTipoid_fun());
            preparedStatement.setString(2, funcionario.getNombre_fun());
            preparedStatement.setString(3, funcionario.getApellido_fun());
            preparedStatement.setString(4, funcionario.getEstado_fun());
            preparedStatement.setString(5, funcionario.getSexo_fun());
            preparedStatement.setString(6, funcionario.getDireccion_fun());
            preparedStatement.setInt(7, funcionario.getTelefono_fun());
            preparedStatement.setString(8, funcionario.getNacimiento_fun());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el funcionario: " + e.getMessage());
        } finally {
            if(connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement. close();
            }
        }        
    }
    
    //ELIMINAR FUNCIONARIO
    public void eliminar(int funcionario) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUN);
            preparedStatement.setInt(1, funcionario);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el funcionario: " + e.getMessage());
        } finally {
            if(connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement. close();
            }
        }        
    }
    public Funcionarios obtenerFuncionario(Funcionarios funcionario) {
        return null;
    }
}


