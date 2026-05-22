package es.ies.puerto.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;

public interface IncidenciaService {

    Incidencia crear(Incidencia incidencia) throws SQLException;

    Optional<Incidencia> buscarPorId(Long id) throws SQLException;

    List<Incidencia> buscarTodos() throws SQLException;

    boolean actualizar(Incidencia incidencia) throws SQLException;

    boolean eliminarPorId(Long id) throws SQLException;

    List<Incidencia> buscarPorUsuario(Long idUsuario) throws SQLException;

    List<Incidencia> buscarPorEstado(EstadoIncidencia estado) throws SQLException;

    List<Incidencia> buscarPorUsuarioDni(String dni) throws SQLException;

    List<Incidencia> buscarPorUsuarioEmail(String email) throws SQLException;
}