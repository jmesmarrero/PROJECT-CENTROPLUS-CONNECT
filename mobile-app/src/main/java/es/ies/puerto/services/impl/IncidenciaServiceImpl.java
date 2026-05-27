package es.ies.puerto.services.impl;

import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.repositories.IncidenciaRepository;
import es.ies.puerto.services.IncidenciaService;
import es.ies.puerto.validators.IncidenciaValidator;

public class IncidenciaServiceImpl implements IncidenciaService {

    private final IncidenciaRepository incidenciaRepository;

    public IncidenciaServiceImpl(IncidenciaRepository incidenciaRepository) {
        this.incidenciaRepository = incidenciaRepository;
    }

    @Override
    public Incidencia crear(Incidencia incidencia) throws SQLException {
        if (incidencia == null
                || !IncidenciaValidator.esIdValido(incidencia.getIdUsuario())
                || !IncidenciaValidator.esTextoValido(incidencia.getAsunto())
                || !IncidenciaValidator.esTextoValido(incidencia.getDescripcion())
                || !IncidenciaValidator.esTextoValido(incidencia.getFecha())
                || !IncidenciaValidator.esEstadoValido(incidencia.getEstado())) {
            throw new IllegalArgumentException("Datos de la incidencia invalidos");
        }
        return incidenciaRepository.create(incidencia);
    }

    @Override
    public Incidencia buscarPorId(Long id) throws SQLException {
        if (!IncidenciaValidator.esIdValido(id)) {
            throw new IllegalArgumentException("El id es invalido");
        }
        return incidenciaRepository.findById(id);
    }

    @Override
    public List<Incidencia> buscarTodos() throws SQLException {
        return incidenciaRepository.findAll();
    }

    @Override
    public boolean actualizar(Incidencia incidencia) throws SQLException {
        if (incidencia == null
                || !IncidenciaValidator.esIdValido(incidencia.getId())
                || !IncidenciaValidator.esIdValido(incidencia.getIdUsuario())
                || !IncidenciaValidator.esTextoValido(incidencia.getAsunto())
                || !IncidenciaValidator.esTextoValido(incidencia.getDescripcion())
                || !IncidenciaValidator.esTextoValido(incidencia.getFecha())
                || !IncidenciaValidator.esEstadoValido(incidencia.getEstado())) {
            throw new IllegalArgumentException("Datos de la incidencia invalidos");
        }
        return incidenciaRepository.update(incidencia);
    }

    @Override
    public boolean eliminarPorId(Long id) throws SQLException {
        if (!IncidenciaValidator.esIdValido(id)) {
            throw new IllegalArgumentException("El id es invalido");
        }
        return incidenciaRepository.deleteById(id);
    }

    @Override
    public List<Incidencia> buscarPorUsuario(Long idUsuario) throws SQLException {
        if (!IncidenciaValidator.esIdValido(idUsuario)) {
            throw new IllegalArgumentException("El idUsuario es invalido");
        }
        return incidenciaRepository.findByUsuario(idUsuario);
    }

    @Override
    public List<Incidencia> buscarPorEstado(EstadoIncidencia estado) throws SQLException {
        if (!IncidenciaValidator.esEstadoValido(estado)) {
            throw new IllegalArgumentException("El estado es invalido");
        }
        return incidenciaRepository.findByEstado(estado);
    }

    @Override
    public List<Incidencia> buscarPorUsuarioDni(String dni) throws SQLException {
        if (!IncidenciaValidator.esDniValido(dni)) {
            throw new IllegalArgumentException("El dni es invalido");
        }
        return incidenciaRepository.findByUsuarioDni(dni);
    }

    @Override
    public List<Incidencia> buscarPorUsuarioEmail(String email) throws SQLException {
        if (!IncidenciaValidator.esTextoValido(email)) {
            throw new IllegalArgumentException("El email es invalido");
        }
        return incidenciaRepository.findByUsuarioEmail(email);
    }

}