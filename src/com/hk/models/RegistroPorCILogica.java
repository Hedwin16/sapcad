package com.hk.models;

import com.hk.controllers.ReconocimientoController;
import com.hk.dao.EmpleadoDAO;
import com.hk.dao.HoraDAO;
import com.hk.interfaces.IEmpleado;
import com.hk.interfaces.IHora;
import javax.swing.JOptionPane;

public class RegistroPorCILogica {

    Hora hora;
    IEmpleado eDao = new EmpleadoDAO();

    public void registarPorCedula(int cedula) {
        String message = "";
        int resultado;
        IHora hdao = new HoraDAO();
        this.hora = new Hora();
        int id_hora = 0;
        id_hora = hdao.idHoraRegistrada(cedula);
        if (id_hora > 0) {
            this.hora.setId_hora(id_hora);
        }
        if (eDao.existeCedula(cedula)) {
            resultado = hdao.insertarHoras(this.hora, cedula);
            switch (resultado) {
                case 0:
                    message = "Error al registrar";
                    break;
                case 1:
                    message = "Registrada Hora de Entrada";
                    break;
                case 2:
                    message = "Registrada Hora de Salida";
                    break;
                case 3:
                    message = "Ya existe una hora de salida registrada por el empleado hoy";
                    break;
            }
            JOptionPane.showMessageDialog(null, message);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el empleado");
        }

    }
}
