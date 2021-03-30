
package com.hk.models;


public class Admin {
    private int id_admin;
    private String usuario;
    private String clave;
    private int tipo;
    private int estado;

    public Admin(int id_admin, String usuario, String clave, int tipo, int estado) {
        this.id_admin = id_admin;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Admin(String usuario, String clave, int tipo, int estado) {
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
