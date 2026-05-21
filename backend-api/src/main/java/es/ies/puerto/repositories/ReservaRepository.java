package es.ies.puerto.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.models.Reserva;

/**
 * Contrato de acceso a datos para las reservas.
 */
public interface ReservaRepository {

    /**
     * Crea una nueva reserva.
     *
     * @param reserva reserva a crear
     * @return reserva creada
     * @throws SQLException si ocurre un error al guardar en la base de datos
     */
    Reserva create(Reserva reserva) throws SQLException;

    /**
     * Busca una reserva por su identificador.
     *
     * @param id identificador de la reserva
     * @return reserva encontrada, o vacio si no existe
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    Optional<Reserva> findById(Long id) throws SQLException;

    /**
     * Obtiene todas las reservas almacenadas.
     *
     * @throws SQLException si ocurre un error al consultar la base de datos
     * @return lista de reservas
     */
    List<Reserva> findAll() throws SQLException;

    /**
     * Actualiza una reserva existente.
     *
     * @param reserva reserva con los datos actualizados
     * @return true si se actualizo alguna fila, false en caso contrario
     * @throws SQLException si ocurre un error al actualizar la base de datos
     */
    boolean update(Reserva reserva) throws SQLException;

    /**
     * Elimina una reserva por su identificador.
     *
     * @param id identificador de la reserva
     * @return true si se elimino alguna fila, false en caso contrario
     * @throws SQLException si ocurre un error al eliminar en la base de datos
     */
    boolean deleteById(Long id) throws SQLException;

    /**
     * Obtiene las reservas asociadas a un usuario.
     *
     * @param idUsuario identificador del usuario
     * @return lista de reservas del usuario
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Reserva> findByUsuario(Long idUsuario) throws SQLException;

    /**
     * Obtiene las reservas asociadas a una actividad.
     *
     * @param idActividad identificador de la actividad
     * @return lista de reservas de la actividad
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Reserva> findByActividad(Long idActividad) throws SQLException;

    /**
     * Busca reservas por DNI del usuario usando INNER JOIN con usuarios.
     *
     * @param dni dni del usuario
     * @return lista de reservas del usuario
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Reserva> findByUsuarioDni(String dni) throws SQLException;

    /**
     * Busca reservas por nombre de actividad usando INNER JOIN con actividades.
     *
     * @param nombreActividad nombre de la actividad
     * @return lista de reservas de la actividad
     * @throws SQLException si ocurre un error al consultar la base de datos
     */
    List<Reserva> findByActividadNombre(String nombreActividad) throws SQLException;
}
