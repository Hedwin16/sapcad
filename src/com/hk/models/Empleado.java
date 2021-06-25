package com.hk.models;

public class Empleado {
    private Integer id_empleado;
    private String nombres;
    private String apellidos;
    private int ci;
    private int id_departamento;
    private int id_nomina;
    private String cargo;
    
    public Empleado() {
    }
    public Empleado(Integer id_empleado, String nombres, String apellidos, int ci, int id_departamento,String cargo, int id_nomina) {
        this.id_empleado = id_empleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.id_departamento = id_departamento;
        this.id_nomina = id_nomina;
        this.cargo = cargo;
    }
    public Empleado(Integer id_empleado, String nombres, String apellidos, int ci, int id_departamento, String cargo) {
        this.id_empleado = id_empleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ci = ci;
        this.id_departamento = id_departamento;
        this.cargo = cargo;
    }
    
    public Integer getId_empleado() {
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
    
    public int getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(int id_nomina) {
        this.id_nomina = id_nomina;
    }
}
