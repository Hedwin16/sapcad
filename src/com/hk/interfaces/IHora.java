package com.hk.interfaces;

import com.hk.models.Hora;
import java.util.List;

public interface IHora extends CRUD<Hora>{
    
    public boolean insertarHoras(Hora hora, int cedula);
    public List<Hora> recuperarHorasEmpleado(int ced, String desde, String hasta);
    public List<Hora> recuperarHorasMensuales(int mes, int anio);
    public List<Hora> recuperarHorasDiarias();
    public boolean existeRegistro();
    public void totalHorasDiarias(Hora hora, int ced);
    public String obtenerHora();
    public int idHoraRegistrada(int ced);
    
}
