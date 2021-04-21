package com.hk.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {
    private final Pattern regexSinEspacios = Pattern.compile("^[a-zA-ZáéíóúüñÑ0-9\\.'_-]{3,16}$");
    private final Pattern regexConEspacios = Pattern.compile(".");
    private final Pattern busqueda = Pattern.compile("", Pattern.CASE_INSENSITIVE);
    
    public boolean contieneEspaciosOCaracteresEspeciales(String campo){
        Matcher res = regexSinEspacios.matcher(campo);
        System.out.println(res.matches());
        return res.matches();
    }
    
    public boolean contieneCaracteresEspeciales(String campo){
        return false;
    }
    
    public boolean isNumeric(String cadena){
        try{
            Integer.parseInt(cadena);
            return true;
        }catch(NumberFormatException ne){
            return false;
        }
    }
   
}
