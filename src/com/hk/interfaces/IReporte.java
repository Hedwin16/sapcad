package com.hk.interfaces;

import com.hk.models.Reporte;
import java.util.List;

public interface IReporte extends CRUD<Reporte>{
    public Reporte leerReporte(Reporte reporte);
    public int getIdUltimoReporte();
    public int idExisteReporteHoy();
    public List<Reporte> buscarReporte(int id);
}
