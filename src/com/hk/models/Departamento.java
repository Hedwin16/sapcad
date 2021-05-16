package com.hk.models;

public class Departamento {
    private Integer id_departamento;
    private String nombre_departamento;

    public Departamento(Integer id_departamento, String nombre_departamento) {
        this.id_departamento = id_departamento;
        this.nombre_departamento = nombre_departamento;
    }

    public Departamento() {
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }
    
}
