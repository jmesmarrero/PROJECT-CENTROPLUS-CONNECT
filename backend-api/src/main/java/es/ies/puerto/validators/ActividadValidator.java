package es.ies.puerto.validators;

import es.ies.puerto.models.TipoActividad;

public class ActividadValidator {

    public static boolean idValido(Long id){
        
        return  id != null;
    }

    public static boolean nombreValido(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return false;
        }
        nombre = nombre.trim();
        return nombre.matches("^[A-ZÑÁÉÍÓÚ][a-zñáéíóú]{2,} ([A-ZÑÁÉÍÓÚ][a-zñáéíóú]{2,})?$");
    }

    public static boolean esTipoActividad(TipoActividad tipoActividad){
        if (tipoActividad == null) {
            return false;
        }
        return tipoActividad == TipoActividad.ACADEMICA || tipoActividad == TipoActividad.DEPORTIVA;
    }

    public static boolean duracionValida(Integer duracion){
        return duracion != null && duracion > 0;
    }

    public static boolean precioValido(Double precio){
        return precio != null && precio >= 0.0;
    }

    public static boolean plazaMaxValida(Integer plazasMaximas){
        return plazasMaximas != null && plazasMaximas > 0;
    }

    public static boolean plazaOcupaValida(Integer plazasOcupadas){
        return plazasOcupadas != null && plazasOcupadas >= 0;
    }

    public static boolean plazasValidas(Integer plazasMaximas, Integer plazasOcupadas){
        if (plazasMaximas == null || plazasOcupadas == null) {
            return false;
        }
        return plazasOcupadas < plazasMaximas;
    }
    

}

