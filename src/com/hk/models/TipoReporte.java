package com.hk.models;

public class TipoReporte {
    private int id_tipo_reporte;
    private String nombre;

    public TipoReporte() {
    }

    public TipoReporte(int id_tipo_reporte, String nombre) {
        this.id_tipo_reporte = id_tipo_reporte;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_tipo_reporte() {
        return id_tipo_reporte;
    }

    public void setId_tipo_reporte(int id_tipo_reporte) {
        this.id_tipo_reporte = id_tipo_reporte;
    }
    
    
}
