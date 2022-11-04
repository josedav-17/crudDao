package com.mycompany.recursoshumanos.dominio;

/**
 *
 * @author jdcar
 */
public class Funcionarios {
    
    private int id_fun;
    private String Tipoid_fun;
    private String nombre_fun;
    private String apellido_fun;
    private String estado_fun;
    private String sexo_fun;
    private String direccion_fun;
    private int telefono_fun;
    private String Nacimiento_fun;

    public int getId_fun() {
        return id_fun;
    }

    public void setId_fun(int id_fun) {
        this.id_fun = id_fun;
    }

    public String getTipoid_fun() {
        return Tipoid_fun;
    }

    public void setTipoid_fun(String Tipoid_fun) {
        this.Tipoid_fun = Tipoid_fun;
    }

    public String getNombre_fun() {
        return nombre_fun;
    }

    public void setNombre_fun(String nombre_fun) {
        this.nombre_fun = nombre_fun;
    }

    public String getApellido_fun() {
        return apellido_fun;
    }

    public void setApellido_fun(String apellido_fun) {
        this.apellido_fun = apellido_fun;
    }

    public String getEstado_fun() {
        return estado_fun;
    }

    public void setEstado_fun(String estado_fun) {
        this.estado_fun = estado_fun;
    }

    public String getSexo_fun() {
        return sexo_fun;
    }

    public void setSexo_fun(String sexo_fun) {
        this.sexo_fun = sexo_fun;
    }

    public String getDireccion_fun() {
        return direccion_fun;
    }

    public void setDireccion_fun(String direcion_fun) {
        this.direccion_fun = direcion_fun;
    }

    public int getTelefono_fun() {
        return telefono_fun;
    }

    public void setTelefono_fun(int telefono_fun) {
        this.telefono_fun = telefono_fun;
    }

    public String getNacimiento_fun() {
        return Nacimiento_fun;
    }

    public void setNacimiento_fun(String Nacimiento_fun) {
        this.Nacimiento_fun = Nacimiento_fun;
    }

    @Override
    public String toString() {
        return "funcionario{" + "id_fun=" + id_fun + ", Tipoid_fun=" + Tipoid_fun + ", nombre_fun=" + nombre_fun + ", apellido_fun=" + apellido_fun + ", estado_fun=" + estado_fun + ", sexo_fun=" + sexo_fun + ", direccion_fun=" + direccion_fun + ", telefono_fun=" + telefono_fun + ", Nacimiento_fun=" + Nacimiento_fun + '}';
    }
   
}
