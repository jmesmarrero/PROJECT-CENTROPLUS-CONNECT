package es.ies.puerto.validators;

import es.ies.puerto.models.EstadoIncidencia;

public class IncidenciaValidator {

    public static boolean esIdValido(Long id) {
        return id != null && id > 0;
    }

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.isBlank();
    }

    public static boolean esEstadoValido(EstadoIncidencia estado) {
        return estado != null;
    }

    public static boolean esDniValido(String dni) {
    if (dni == null) {
        return false;
    }
    return dni.matches("^\\d{8}[A-Z]$");
}
}