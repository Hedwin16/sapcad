package com.hk.models;

public class Reporte {
    private int id_reporte;
    private String nombre;
    private int tipo;

    public Reporte(int id_reporte, String nombre, int tipo) {
        this.id_reporte = id_reporte;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Reporte() {
    }

    public int getId_reporte() {
        return id_reporte;
    }

    public void setId_reporte(int id_reporte) {
        this.id_reporte = id_reporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
