
package com.mycompany.recursoshumanos.controller;

import java.sql.SQLException;
import java.util.List;

import com.mycompany.recursoshumanos.data.FuncionariosDao;
import com.mycompany.recursoshumanos.dominio.Funcionarios;

/**
 *
 * @author jdcar
 */
public class FuncionarioController {

    private static FuncionariosDao funcionariosDao;

    //crear un nuevo funcionario de acuerdo a funcionariosDao
    public static void crear(Funcionarios funcionario) throws SQLException {
        funcionariosDao = new FuncionariosDao();
        funcionariosDao.crear(funcionario);
    }
    

    //actualizar un funcionario de acuerdo a funcionariosDao
    public static void actualizar(Funcionarios funcionario) throws SQLException {
        funcionariosDao = new FuncionariosDao();
        funcionariosDao.actualizar(funcionario);
    }

    //eliminar un funcionario por id de acuerdo a funcionariosDao
    public static void eliminar(int funcionario) throws SQLException {
        funcionariosDao = new FuncionariosDao();
        funcionariosDao.eliminar(funcionario);
    }

    //obtener todos los funcionarios de acuerdo a funcionariosDao
    public static List<Funcionarios> obtener () throws SQLException {
        funcionariosDao = new FuncionariosDao();
        return funcionariosDao.obtener();
    }


    public static Funcionarios obtenerPorID(int funcionario) throws SQLException {
        funcionariosDao = new FuncionariosDao();
        return funcionariosDao.obtenerPorID(funcionario);
    }
    
}

     
    
