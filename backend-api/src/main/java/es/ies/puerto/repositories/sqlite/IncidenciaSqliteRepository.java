package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

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
    public Optional<Incidencia> findById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Incidencia> findAll() throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public boolean update(Incidencia incidencia) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Incidencia> findByUsuario(Long idUsuario) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Incidencia> findByEstado(EstadoIncidencia estado) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Incidencia> findByUsuarioDni(String dni) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Incidencia> findByUsuarioEmail(String email) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
