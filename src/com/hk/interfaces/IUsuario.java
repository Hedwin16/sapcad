
package com.hk.interfaces;

import com.hk.models.Usuario;


public interface IUsuario extends CRUD<Usuario>{
    public boolean validarSesion(String usuario, String clave);
    public int getTipoUsuario();
    public boolean existeUsuario(String user);
}
