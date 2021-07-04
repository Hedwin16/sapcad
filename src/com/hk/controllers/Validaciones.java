package com.hk.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    private final Pattern regexSinEspacios = Pattern.compile("^[a-zA-ZáéíóúüñÑ0-9\\.'_-]{1,100}$");
    private final Pattern regexConEspacios = Pattern.compile("^[ a-zA-ZáéíóúüñÑ0-9\\.'_-]{1,100}$");
    private final Pattern espaciosyPuntos = Pattern.compile("^[([01]?[0-9]2[0-3]):[0-5][0-9](:[0-5][0-9])]{1,100}$", Pattern.CASE_INSENSITIVE);
    
    public boolean contieneEspaciosOCaracteresEspeciales(String campo){
        Matcher res = regexSinEspacios.matcher(campo);
        System.out.println(res.matches());
        return !res.matches();
    }
    
    public boolean contieneCaracteresEspeciales(String campo){
        Matcher res = regexConEspacios.matcher(campo);
        System.out.println("Espacios: "+res.matches());
        return !res.matches();
    }
    public boolean contieneEspaciosYPuntos(String campo){
        Matcher res = espaciosyPuntos.matcher(campo);
        System.out.println("Espacios + Puntos: "+res.matches());
        return !res.matches();
    }
    public boolean isNumeric(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        }catch(NumberFormatException ne){
            return false;
        }
    }

    boolean isNumeric() {
        
        return true;
    }
   
}
