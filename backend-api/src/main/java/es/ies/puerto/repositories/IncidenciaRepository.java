package es.ies.puerto.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;

/**
 * Contrato de acceso a datos para las incidencias.
 */
public interface IncidenciaRepository {

    /**
     * Crea una nueva incidencia.
     *
     * @param incidencia incidencia a crear
     * @return incidencia creada
     * @throws SQLException si ocurre un error al guardar en la base de datos
     */
    Incidencia create(Incidencia incidencia) throws SQLException;

    /**
     * Busca una incidencia por su identificador.
     *
     * @param id identificador de la incidencia
     * @return incidencia encontrada, o vacio si no existe
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    Optional<Incidencia> findById(Long id) throws SQLException;

    /**
     * Obtiene todas las incidencias almacenadas.
     *
     * @throws SQLException si ocurre un error al consultar la base de datos
     * @return lista de incidencias
     */
    List<Incidencia> findAll() throws SQLException;

    /**
     * Actualiza una incidencia existente.
     *
     * @param incidencia incidencia con los datos actualizados
     * @return true si se actualizo alguna fila, false en caso contrario
     * @throws SQLException si ocurre un error al actualizar la base de datos
     */
    boolean update(Incidencia incidencia) throws SQLException;

    /**
     * Elimina una incidencia por su identificador.
     *
     * @param id identificador de la incidencia
     * @return true si se elimino alguna fila, false en caso contrario
     * @throws SQLException si ocurre un error al eliminar en la base de datos
     */
    boolean deleteById(Long id) throws SQLException;

    /**
     * Obtiene las incidencias asociadas a un usuario.
     *
     * @param idUsuario identificador del usuario
     * @return lista de incidencias del usuario
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Incidencia> findByUsuario(Long idUsuario) throws SQLException;

    /**
     * Obtiene las incidencias por estado.
     *
     * @param estado estado de la incidencia
     * @return lista de incidencias con ese estado
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Incidencia> findByEstado(EstadoIncidencia estado) throws SQLException;

    /**
     * Busca incidencias por DNI del usuario usando INNER JOIN con usuarios.
     *
     * @param dni dni del usuario
     * @return lista de incidencias del usuario
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Incidencia> findByUsuarioDni(String dni) throws SQLException;

    /**
     * Busca incidencias por email del usuario usando INNER JOIN con usuarios.
     *
     * @param email email del usuario
     * @return lista de incidencias del usuario
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Incidencia> findByUsuarioEmail(String email) throws SQLException;
}
