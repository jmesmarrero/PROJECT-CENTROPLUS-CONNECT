package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.EstadoReserva;
import es.ies.puerto.models.Reserva;
import es.ies.puerto.repositories.ReservaRepository;

public class ReservaSqliteRepository extends SQLiteConnectionManager implements ReservaRepository {

    public ReservaSqliteRepository(String databaseUrl) {
        super(databaseUrl);
    }

    @Override
    public Reserva create(Reserva reserva) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "INSERT INTO reservas (id_usuario, id_actividad, fecha, estado) VALUES (?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {

            sentencia.setLong(1, reserva.getIdUsuario());
            sentencia.setLong(2, reserva.getIdActividad());
            sentencia.setString(3, reserva.getFecha());
            sentencia.setString(4, reserva.getEstado().name());

            sentencia.executeUpdate();

            try (ResultSet generatedKeys = sentencia.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reserva.setId(generatedKeys.getLong(1));
                }
            }

            return reserva;
        }
    }

    @Override
    public Reserva findById(Long id) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "SELECT id, id_usuario, id_actividad, fecha, estado FROM reservas WHERE id = ?")) {

            sentencia.setLong(1, id);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    return mapRow(resultado);
                }
                return null;
            }
        }
    }

    @Override
    public List<Reserva> findAll() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "SELECT id, id_usuario, id_actividad, fecha, estado FROM reservas");
                ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                reservas.add(mapRow(resultado));
            }
        }

        return reservas;
    }

    @Override
    public boolean update(Reserva reserva) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "UPDATE reservas SET id_usuario = ?, id_actividad = ?, fecha = ?, estado = ? WHERE id = ?")) {

            sentencia.setLong(1, reserva.getIdUsuario());
            sentencia.setLong(2, reserva.getIdActividad());
            sentencia.setString(3, reserva.getFecha());
            sentencia.setString(4, reserva.getEstado().name());
            sentencia.setLong(5, reserva.getId());

            return sentencia.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement("DELETE FROM reservas WHERE id = ?")) {

            sentencia.setLong(1, id);

            return sentencia.executeUpdate() > 0;
        }
    }

    @Override
    public List<Reserva> findByUsuario(Long idUsuario) throws SQLException {
        List<Reserva> reservasByUsuario = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT id, id_usuario, id_actividad, fecha, estado FROM reservas WHERE id_usuario = ?")) {

            sentencia.setLong(1, idUsuario);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    reservasByUsuario.add(mapRow(resultado));
                }
            }
        }

        return reservasByUsuario;
    }

    @Override
    public List<Reserva> findByActividad(Long idActividad) throws SQLException {
        List<Reserva> reservasByActividad = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT id, id_usuario, id_actividad, fecha, estado FROM reservas WHERE id_actividad = ?")) {

            sentencia.setLong(1, idActividad);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    reservasByActividad.add(mapRow(resultado));
                }
            }
        }

        return reservasByActividad;
    }

    @Override
    public List<Reserva> findByUsuarioDni(String dni) throws SQLException {
        List<Reserva> reservasByUsuarioDni = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT r.id, r.id_usuario, r.id_actividad, r.fecha, r.estado FROM reservas r INNER JOIN usuarios u ON r.id_usuario = u.id WHERE u.dni = ?")) {

            sentencia.setString(1, dni);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    reservasByUsuarioDni.add(mapRow(resultado));
                }
            }
        }

        return reservasByUsuarioDni;
    }

    @Override
    public List<Reserva> findByActividadNombre(String nombreActividad) throws SQLException {
        List<Reserva> reservasByActividadNombre = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT r.id, r.id_usuario, r.id_actividad, r.fecha, r.estado FROM reservas r INNER JOIN actividades a ON r.id_actividad = a.id WHERE a.nombre = ?")) {

            sentencia.setString(1, nombreActividad);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    reservasByActividadNombre.add(mapRow(resultado));
                }
            }
        }

        return reservasByActividadNombre;
    }

    private Reserva mapRow(ResultSet resultado) throws SQLException {

        Reserva reserva = new Reserva();
        reserva.setId(resultado.getLong("id"));
        reserva.setIdUsuario(resultado.getLong("id_usuario"));
        reserva.setIdActividad(resultado.getLong("id_actividad"));
        reserva.setFecha(resultado.getString("fecha"));
        reserva.setEstado(EstadoReserva.valueOf(resultado.getString("estado")));
        return reserva;
    }
}