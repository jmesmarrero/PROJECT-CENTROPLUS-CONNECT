package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

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
    public Optional<Reserva> findById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Reserva> findAll() throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public boolean update(Reserva reserva) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Reserva> findByUsuario(Long idUsuario) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Reserva> findByActividad(Long idActividad) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Reserva> findByUsuarioDni(String dni) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }

    @Override
    public List<Reserva> findByActividadNombre(String nombreActividad) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
    }
}
