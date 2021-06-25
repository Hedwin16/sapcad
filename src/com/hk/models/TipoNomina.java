package com.hk.models;

public class TipoNomina {
    private Integer id_nomina;
    private String nombre_nomina;

    public TipoNomina(Integer id_nomina, String nombre_nomina) {
        this.id_nomina = id_nomina;
        this.nombre_nomina = nombre_nomina;
    }

    public TipoNomina() {
    }

    public Integer getId_nomina() {
        return id_nomina;
    }

    public void setId_nomina(Integer id_nomina) {
        this.id_nomina = id_nomina;
    }

    public String getNombre_nomina() {
        return nombre_nomina;
    }

    public void setNombre_nomina(String nombre_nomina) {
        this.nombre_nomina = nombre_nomina;
    }
    
    
}
