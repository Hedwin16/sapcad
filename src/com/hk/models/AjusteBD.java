package com.hk.models;

public class AjusteBD {
    String hostIP;
    String usuario;
    String clave;
    String puerto;

    public AjusteBD(String host, String usuario, String clave, String puerto) {
        this.hostIP = host;
        this.usuario = usuario;
        this.clave = clave;
        this.puerto = puerto;
    }

    public AjusteBD() {
    }

    public String getHost() {
        return hostIP;
    }

    public void setHost(String host) {
        this.hostIP = host;
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

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    @Override
    public String toString() {
        return "AjusteBD{" + "host=" + hostIP + ", usuario=" + usuario + ", clave=" + clave + ", puerto=" + puerto + '}';
    }
    
    
}
