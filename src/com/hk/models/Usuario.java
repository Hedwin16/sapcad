
package com.hk.models;


public class Usuario {
    private Integer id_usuario;
    private String usuario;
    private String clave;
    private int tipo;

    public Usuario(Integer id_admin, String usuario, String clave, int tipo) {
        this.id_usuario = id_admin;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario(String usuario, String clave, int tipo, int estado) {
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario() {
    }
    
    

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_admin) {
        this.id_usuario = id_admin;
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
    
}
