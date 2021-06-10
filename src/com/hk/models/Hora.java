
package com.hk.models;

public class Hora {
    private Integer id_hora;
    private String hora_entrada;
    private String hora_salida;
    private String fecha;
    private String t_horas;

    public Hora() {
    }

    public Hora(Integer id_hora, String hora_entrada, String hora_salida, String fecha, String t_horas) {
        this.id_hora = id_hora;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.fecha = fecha;
        this.t_horas = t_horas;
    }

    public Integer getId_hora() {
        return id_hora;
    }

    public void setId_hora(int id_hora) {
        this.id_hora = id_hora;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getT_horas() {
        return t_horas;
    }

    public void setT_horas(String t_horas) {
        this.t_horas = t_horas;
    }

    
    
    
}
