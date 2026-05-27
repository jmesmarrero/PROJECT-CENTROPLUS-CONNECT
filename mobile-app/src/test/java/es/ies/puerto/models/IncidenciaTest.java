package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IncidenciaTest {

    Incidencia incidencia;
    Long id = 1L;
    Long idUsuario = 1L;
    String asunto = "asunto";
    String descripcion = "descripcion";
    String fechaStr = "26/05/2026";
    EstadoIncidencia estado = EstadoIncidencia.valueOf("estado");

    @BeforeEach
    void setup() {
         incidencia = new Incidencia(id, idUsuario, asunto, descripcion, fechaStr, estado);

    }

    @Test
    void incidenciaNotNull() {
        Assertions.assertNotNull(incidencia);
    }

    @Test
    void incidenciaEqualsTrueTest() {
        Incidencia incidenciaNueva = new Incidencia(id);
        Assertions.assertEquals(incidencia, incidenciaNueva);

    }
}
