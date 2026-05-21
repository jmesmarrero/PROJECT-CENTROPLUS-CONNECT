package es.ies.puerto.repositories.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.models.Reserva;
import es.ies.puerto.repositories.ReservaRepository;
import es.ies.puerto.repositories.sqlite.SQLiteConnectionManager;

public class ReservaRepositoryImpl extends SQLiteConnectionManager implements ReservaRepository {

    public ReservaRepositoryImpl(String databaseUrl) {
        super(databaseUrl);
    }

    @Override
    public Reserva create(Reserva reserva) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
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
