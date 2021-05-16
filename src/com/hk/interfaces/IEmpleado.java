package com.hk.interfaces;

import com.hk.models.Empleado;
import java.util.List;

public interface IEmpleado extends CRUD<Empleado>{
    public int getIdNuevoEmpleado();
    public Empleado getEmpleadoPorId(int id);
    public List<Empleado> buscarEmpleados(String busqueda);
}
