package es.ies.puerto.repositories.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.repositories.IncidenciaRepository;
import es.ies.puerto.repositories.sqlite.SQLiteConnectionManager;

public class IncidenciaRepositoryImpl extends SQLiteConnectionManager implements IncidenciaRepository {

    public IncidenciaRepositoryImpl(String databaseUrl) {
        super(databaseUrl);
    }

    @Override
    public Incidencia create(Incidencia incidencia) throws SQLException {
        throw new UnsupportedOperationException("Pendiente de implementar");
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
