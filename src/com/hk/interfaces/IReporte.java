package com.hk.interfaces;

import com.hk.models.Reporte;

public interface IReporte extends CRUD<Reporte>{
    public void leerReporte(Reporte reporte);
    public int getIdUltimoReporte();
    public int idExisteReporteHoy();
}
