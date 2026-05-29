package es.ies.puerto.models;

import java.util.Objects;

public class Actividad {

    private Long id;
    private String nombre;
    private TipoActividad tipoActividad;
    private Integer duracion;
    private Double precio;
    private Integer plazasMaximas;
    private Integer plazasOcupadas;

    /**
     * Constructor vacio
     */
    public Actividad() {
    }

    /**
     * Constructor con el identificador unico
     * 
     * @param id identificador unico de la clase
     */
    public Actividad(Long id) {
        this.id = id;
    }

    /**
     * Constructor de la clase
     * 
     * @param id             Identificasdor de actividad
     * @param nombre         nombre de actividad
     * @param tipoActividad  tipo de actividad
     * @param duracion       minutos de la actividad
     * @param precio         Precio de la actividad
     * @param plazasMaximas  plazas de la actividad
     * @param plazasOcupadas plazas ocuapdas de la actividad
     */
    public Actividad(Long id, String nombre, TipoActividad tipoActividad, Integer duracion, Double precio,
            Integer plazasMaximas,
            Integer plazasOcupadas) {
        this.id = id;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.duracion = duracion;
        this.precio = precio;
        this.plazasMaximas = plazasMaximas;
        this.plazasOcupadas = plazasOcupadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPlazasMaximas() {
        return plazasMaximas;
    }

    public void setPlazasMaximas(Integer plazasMaximas) {
        this.plazasMaximas = plazasMaximas;
    }

    public Integer getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(Integer plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public Integer plazasDisponibles() {
        return plazasMaximas - plazasOcupadas;
    }

    public void cancelarPlaza() {
        if (plazasOcupadas > 0) {
            plazasOcupadas--;
        }

    }

    public void reservarPlaza() {
        if (plazasOcupadas < plazasMaximas) {
            plazasOcupadas++;
        }
    }

    @Override
    public String toString() {
        return "Actividad [id=" + id + ", nombre=" + nombre + ", tipoActividad=" + tipoActividad + ", duracion="
                + duracion + ", precio=" + precio + ", plazasMaximas=" + plazasMaximas + ", plazasOcupadas="
                + plazasOcupadas + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Actividad)) {
            return false;
        }
        Actividad actividad = (Actividad) obj;

        return Objects.equals(id, actividad.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
