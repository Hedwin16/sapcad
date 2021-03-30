
package com.hk.interfaces;

import java.util.List;

public interface CRUD<T> {
    public boolean insertar(T t);
    public List<T> mostrar();
    public boolean actualizar(T t);
    public boolean eliminar(int id);
    
}
