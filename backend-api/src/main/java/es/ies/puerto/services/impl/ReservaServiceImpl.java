package es.ies.puerto.services.impl;

import java.sql.SQLException;
import java.util.List;

import es.ies.puerto.models.Reserva;
import es.ies.puerto.repositories.ReservaRepository;
import es.ies.puerto.services.ReservaService;
import es.ies.puerto.validators.ReservaValidator;

public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Reserva crear(Reserva reserva) throws SQLException {
        if (reserva == null || !ReservaValidator.esIdValido(reserva.getIdUsuario())
                || !ReservaValidator.esIdValido(reserva.getIdActividad())
                || !ReservaValidator.esTextoValido(reserva.getFecha())
                || !ReservaValidator.esEstadoValido(reserva.getEstado())) {
            throw new IllegalArgumentException("Datos de la reserva invalidos");
        }

        return reservaRepository.create(reserva);
    }

    @Override
    public Reserva buscarPorId(Long id) throws SQLException {
        if (!ReservaValidator.esIdValido(id)) {
            throw new IllegalArgumentException("El id es invalido");
        }
        return reservaRepository.findById(id);
    }

    @Override
    public List<Reserva> buscarTodos() throws SQLException {
        return reservaRepository.findAll();
    }

    @Override
    public boolean actualizar(Reserva reserva) throws SQLException {
        if (reserva == null
                || !ReservaValidator.esIdValido(reserva.getId())
                || !ReservaValidator.esIdValido(reserva.getIdUsuario())
                || !ReservaValidator.esIdValido(reserva.getIdActividad())
                || !ReservaValidator.esTextoValido(reserva.getFecha())
                || !ReservaValidator.esEstadoValido(reserva.getEstado())) {
            throw new IllegalArgumentException("Datos de la reserva invalidos");
        }
        return reservaRepository.update(reserva);
    }

    @Override
    public boolean eliminarPorId(Long id) throws SQLException {
        if (!ReservaValidator.esIdValido(id)) {
            throw new IllegalArgumentException("El id es invalido");
        }
        return reservaRepository.deleteById(id);
    }

    @Override
    public List<Reserva> buscarPorUsuario(Long idUsuario) throws SQLException {
        if (!ReservaValidator.esIdValido(idUsuario)) {
            throw new IllegalArgumentException("El idUsuario es invalido");
        }
        return reservaRepository.findByUsuario(idUsuario);
    }

    @Override
    public List<Reserva> buscarPorActividad(Long idActividad) throws SQLException {
        if (!ReservaValidator.esIdValido(idActividad)) {
            throw new IllegalArgumentException("El idActividad es invalido");
        }
        return reservaRepository.findByActividad(idActividad);
    }

    @Override
    public List<Reserva> buscarPorUsuarioDni(String dni) throws SQLException {
        if (!ReservaValidator.esDniValido(dni)) {
            throw new IllegalArgumentException("El dni es invalido");
        }
        return reservaRepository.findByUsuarioDni(dni);
    }

    @Override
    public List<Reserva> buscarPorActividadNombre(String nombre) throws SQLException {
        if (!ReservaValidator.esTextoValido(nombre)) {
            throw new IllegalArgumentException("El nombre es invalido");
        }
        return reservaRepository.findByActividadNombre(nombre);
    }

}