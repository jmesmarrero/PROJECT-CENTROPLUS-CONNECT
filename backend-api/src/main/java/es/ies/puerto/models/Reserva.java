package es.ies.puerto.models;

import java.util.Objects;

public class Reserva {

    private Long id;
    private Long idUsuario;
    private Long idActividad;
    private String fecha;
    private EstadoReserva estado;

    public Reserva() {
    }

    public Reserva(Long id) {
        this.id = id;
    }

    public Reserva(Long id, Long idUsuario, Long idActividad, String fecha, EstadoReserva estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", idUsuario=" + idUsuario + ", idActividad=" + idActividad + ", fecha=" + fecha
                + ", estado=" + estado + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Reserva)) {
            return false;
        }
        Reserva reserva = (Reserva) obj;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
