package es.ies.puerto.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.models.Reserva;

public interface ReservaService {

    Reserva crear(Reserva reserva) throws SQLException;

    Optional<Reserva> buscarPorId(Long id) throws SQLException;

    List<Reserva> buscarTodos() throws SQLException;

    boolean actualizar(Reserva reserva) throws SQLException;

    boolean eliminarPorId(Long id) throws SQLException;

    List<Reserva> buscarPorUsuario(Long idUsuario) throws SQLException;

    List<Reserva> buscarPorActividad(Long idActividad) throws SQLException;

    List<Reserva> buscarPorUsuarioDni(String dni) throws SQLException;

    List<Reserva> buscarPorActividadNombre(String nombre) throws SQLException;
}