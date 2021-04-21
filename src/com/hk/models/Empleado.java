package com.hk.models;

public class Empleado {
    private int id_empleado;
    private String nombres;
    private String apellidos;
    private int ci;
    private int id_departamento;
    private String cargo;
    private boolean estado;
    
    public Empleado() {
    }

    public Empleado(int id_empleado, String nombres, String apellidos, int ci, int id_departamento, String cargo, boolean estado) {
        this.id_empleado = id_empleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.id_departamento = id_departamento;
        this.cargo = cargo;
        this.estado = estado;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }   
    
    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
