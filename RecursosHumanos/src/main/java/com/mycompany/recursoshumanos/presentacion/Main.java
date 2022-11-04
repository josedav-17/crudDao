
package com.mycompany.recursoshumanos.presentacion;

import com.mycompany.recursoshumanos.controller.FuncionarioController;
import com.mycompany.recursoshumanos.dominio.Funcionarios;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void obtenerFuncionarios(FuncionarioController funcionarioController){
        try {
            List<Funcionarios> funcionarios = FuncionarioController.obtener();
            if(funcionarios.isEmpty()){
                System.out.println("No hay funcionarios registrados");
            }else{
                funcionarios.forEach((funcionario) -> {
                    System.out.println("id: " + funcionario.getId_fun());
                    System.out.println("Tipo ID: " + funcionario.getTipoid_fun());
                    System.out.println("Nombre: " + funcionario.getNombre_fun());
                    System.out.println("Apellido: " + funcionario.getApellido_fun());
                    System.out.println("Estado: " + funcionario.getEstado_fun());
                    System.out.println("Sexo: " + funcionario.getSexo_fun());
                    System.out.println("Direccion: " + funcionario.getDireccion_fun());
                    System.out.println("Telefono: " + funcionario.getTelefono_fun());
                    System.out.println("Fecha de nacimiento: " + funcionario.getNacimiento_fun());
                    System.out.println(" ");
                });
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los funcionarios: " + e.getMessage());
        }
    }

    public static void crear (FuncionarioController funcionarioController){ 
        try (Scanner Scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el tipo de identificacion");
            String Tipoid_fun = Scanner.nextLine();
            System.out.println("Ingrese el nombre");
            String nombre_fun = Scanner.nextLine();
            System.out.println("Ingrese el apellido");
            String apellido_fun = Scanner.nextLine();
            System.out.println("Ingrese el estado");
            String estado_fun = Scanner.nextLine();
            System.out.println("Ingrese el sexo");
            String sexo_fun = Scanner.nextLine();
            System.out.println("Ingrese la direccion");
            String Direccion_fun = Scanner.nextLine();
            System.out.println("Ingrese el telefono");
            int telefono_fun = Scanner.nextInt();
            System.out.println("Ingrese la fecha de nacimiento");
            String nacimiento_fun = Scanner.nextLine();
            System.out.println(" ");
            

            Funcionarios funcionario = new Funcionarios();
            funcionario.setTipoid_fun (Tipoid_fun);
            funcionario.setNombre_fun (nombre_fun);
            funcionario.setApellido_fun (apellido_fun);
            funcionario.setEstado_fun (estado_fun);
            funcionario.setSexo_fun (sexo_fun);
            funcionario.setDireccion_fun (Direccion_fun);
            funcionario.setTelefono_fun (telefono_fun);
            funcionario.setNacimiento_fun (nacimiento_fun);
            FuncionarioController.crear(funcionario);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    //editar funcionario
    public static void editar (FuncionarioController funcionarioController){
        try (Scanner Scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el id del funcionario");
            int id_fun = Scanner.nextInt();
            System.out.println("Ingrese el tipo de identificacion");
            String Tipoid_fun = Scanner.nextLine();
            System.out.println("Ingrese el nombre");
            String nombre_fun = Scanner.nextLine();
            System.out.println("Ingrese el apellido");
            String apellido_fun = Scanner.nextLine();
            System.out.println("Ingrese el estado");
            String estado_fun = Scanner.nextLine();
            System.out.println("Ingrese el sexo");
            String sexo_fun = Scanner.nextLine();
            System.out.println("Ingrese la direccion");
            String Direccion_fun = Scanner.nextLine();
            System.out.println("Ingrese el telefono");
            int telefono_fun = Scanner.nextInt();
            System.out.println("Ingrese la fecha de nacimiento");
            String nacimiento_fun = Scanner.nextLine();
            System.out.println(" ");

            Funcionarios funcionario = new Funcionarios();
            funcionario.setId_fun(id_fun);
            funcionario.setTipoid_fun (Tipoid_fun);
            funcionario.setNombre_fun (nombre_fun);
            funcionario.setApellido_fun (apellido_fun);
            funcionario.setEstado_fun (estado_fun);
            funcionario.setSexo_fun (sexo_fun);
            funcionario.setDireccion_fun (Direccion_fun);
            funcionario.setTelefono_fun (telefono_fun);
            funcionario.setNacimiento_fun (nacimiento_fun);
            FuncionarioController.actualizar(funcionario);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    //eliminar funcionario 
    public static void eliminar (FuncionarioController funcionarioController){
        try (Scanner Scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el id del funcionario");
            int id_fun = Scanner.nextInt();
            FuncionarioController.eliminar(id_fun);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    //obtener funcionario por id de acuerdo al controlador
    public static void obtenerPorId (FuncionarioController funcionarioController){
        try (Scanner Scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el id del funcionario");
            int id_fun = Scanner.nextInt();
            

            Funcionarios funcionario = FuncionarioController.obtenerPorID(id_fun);
            System.out.println("Funcionario es: " + funcionario);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) throws SQLException {
        FuncionarioController funcionarioController = new FuncionarioController();
        int opcion = -1;
        try (Scanner scanner = new Scanner(System.in)) {
            while (opcion != 0) {
                System.out.println("1. Listar funcionarios");
                System.out.println("2. Crear funcionario");
                System.out.println("3. Editar funcionario");
                System.out.println("4. Eliminar funcionario");
                System.out.println("5. Obtener funcionario por id");
                System.out.println("0. Salir");
                
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        obtenerFuncionarios(funcionarioController);
                        break;
                    case 2:
                        crear(funcionarioController);
                        break;
                    case 3:
                        editar(funcionarioController);
                        break;
                    case 4:
                        eliminar(funcionarioController);
                        break;
                    case 5:
                        obtenerPorId(funcionarioController);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}