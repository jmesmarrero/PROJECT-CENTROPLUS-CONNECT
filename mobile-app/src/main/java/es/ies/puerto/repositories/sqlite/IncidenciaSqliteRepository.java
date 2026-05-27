package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.repositories.IncidenciaRepository;

public class IncidenciaSqliteRepository extends SQLiteConnectionManager implements IncidenciaRepository {

    public IncidenciaSqliteRepository(String databaseUrl) {
        super(databaseUrl);
    }

    @Override
    public Incidencia create(Incidencia incidencia) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "INSERT INTO incidencias (id_usuario, asunto, descripcion, fecha, estado) VALUES (?, ?, ?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {

            sentencia.setLong(1, incidencia.getIdUsuario());
            sentencia.setString(2, incidencia.getAsunto());
            sentencia.setString(3, incidencia.getDescripcion());
            sentencia.setString(4, incidencia.getFecha());
            sentencia.setString(5, incidencia.getEstado().name());

            sentencia.executeUpdate();

            try (ResultSet generatedKeys = sentencia.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    incidencia.setId(generatedKeys.getLong(1));
                }
            }

            return incidencia;
        }
    }

    @Override
    public Incidencia findById(Long id) throws SQLException {

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "SELECT id, id_usuario, asunto, descripcion, fecha, estado FROM incidencias WHERE id = ?")) {

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
    public List<Incidencia> findAll() throws SQLException {
        List<Incidencia> incidencias = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "SELECT id, id_usuario, asunto, descripcion, fecha, estado FROM incidencias");
                ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {
                incidencias.add(mapRow(resultado));
            }
        }

        return incidencias;
    }

    @Override
    public boolean update(Incidencia incidencia) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(
                        "UPDATE incidencias SET id_usuario = ?, asunto = ?, descripcion = ?, fecha = ?, estado = ? WHERE id = ?")) {

            sentencia.setLong(1, incidencia.getIdUsuario());
            sentencia.setString(2, incidencia.getAsunto());
            sentencia.setString(3, incidencia.getDescripcion());
            sentencia.setString(4, incidencia.getFecha());
            sentencia.setString(5, incidencia.getEstado().name());
            sentencia.setLong(6, incidencia.getId());

            return sentencia.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement("DELETE FROM incidencias WHERE id = ?")) {

            sentencia.setLong(1, id);

            return sentencia.executeUpdate() > 0;
        }
    }

    @Override
    public List<Incidencia> findByUsuario(Long idUsuario) throws SQLException {
        List<Incidencia> incidenciasByUsuario = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT id, id_usuario, asunto, descripcion, fecha, estado FROM incidencias WHERE id_usuario = ?")) {

            sentencia.setLong(1, idUsuario);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    incidenciasByUsuario.add(mapRow(resultado));
                }
            }
        }

        return incidenciasByUsuario;
    }

    @Override
    public List<Incidencia> findByEstado(EstadoIncidencia estado) throws SQLException {
        List<Incidencia> incidenciasByEstado = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT id, id_usuario, asunto, descripcion, fecha, estado FROM incidencias WHERE estado = ?")) {

            sentencia.setString(1, estado.name());

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    incidenciasByEstado.add(mapRow(resultado));
                }
            }
        }

        return incidenciasByEstado;
    }

    @Override
    public List<Incidencia> findByUsuarioDni(String dni) throws SQLException {
        List<Incidencia> incidenciasByUsuarioDni = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT i.id, i.id_usuario, i.asunto, i.descripcion, i.fecha, i.estado FROM incidencias i INNER JOIN usuarios u ON i.id_usuario = u.id WHERE u.dni = ?")) {

            sentencia.setString(1, dni);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    incidenciasByUsuarioDni.add(mapRow(resultado));
                }
            }
        }

        return incidenciasByUsuarioDni;
    }

    @Override
    public List<Incidencia> findByUsuarioEmail(String email) throws SQLException {
        List<Incidencia> incidenciasByUsuarioEmail = new ArrayList<>();

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "SELECT i.id, i.id_usuario, i.asunto, i.descripcion, i.fecha, i.estado FROM incidencias i INNER JOIN usuarios u ON i.id_usuario = u.id WHERE u.email = ?")) {

            sentencia.setString(1, email);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    incidenciasByUsuarioEmail.add(mapRow(resultado));
                }
            }
        }

        return incidenciasByUsuarioEmail;
    }

    private Incidencia mapRow(ResultSet resultado) throws SQLException {

        Incidencia incidencia = new Incidencia();
        incidencia.setId(resultado.getLong("id"));
        incidencia.setIdUsuario(resultado.getLong("id_usuario"));
        incidencia.setAsunto(resultado.getString("asunto"));
        incidencia.setDescripcion(resultado.getString("descripcion"));
        incidencia.setFecha(resultado.getString("fecha"));
        incidencia.setEstado(EstadoIncidencia.valueOf(resultado.getString("estado")));
        return incidencia;
    }
}