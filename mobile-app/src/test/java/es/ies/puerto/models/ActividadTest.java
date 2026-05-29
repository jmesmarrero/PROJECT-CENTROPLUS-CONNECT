package es.ies.puerto.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class ActividadTest {

    Actividad actividad;
    Long id = 1L;
    String nombre = "Nombre";
    TipoActividad tipo = TipoActividad.valueOf("DEPORTIVA");
    Integer duracion = 1;
    Double precio = 2.0;
    Integer plazas = 5;
    Integer ocupadas = 1;

    @BeforeEach
    void setup() {
        actividad = new Actividad(id, nombre, tipo, duracion, precio, plazas, ocupadas);

    }

    @DisplayName("Test verifica not null")
    @Order(1)
    @Test
    void actividadNotNullTest() {
        Assertions.assertNotNull(actividad, "La clase actividad no puede ser nula");
    }

    @DisplayName("Test evrifica equals true")
    @Order(2)
    @Test
    void actividadEqualsTrueTest() {
        Actividad actividadNueva = new Actividad(1L);
        Assertions.assertEquals(actividad, actividadNueva, "Deber ser igual");
    }

    @DisplayName("Test verifica quals false")
    @Order(3)
    @Test
    void actividadEqualsFalseTest() {
        Actividad actividadNueva = new Actividad(2L);
        Assertions.assertNotEquals(actividad, actividadNueva, "Deber ser igual");
    }

    @DisplayName("Test verifica quals de la misma clase")
    @Order(4)
    @Test
    void actividadEqualsTest() {

        Assertions.assertEquals(actividad, actividad, "Debe ser igual");
    }

    @DisplayName("Test verifica plazas")
    @Order(5)
    @Test
    void actividadPlazasDisponibles(){
        actividad.cancelarPlaza();
        Assertions.assertEquals(plazas-ocupadas+1, actividad.plazasDisponibles());

    }

}
