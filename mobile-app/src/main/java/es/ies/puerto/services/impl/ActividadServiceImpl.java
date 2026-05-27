package es.ies.puerto.services.impl;

import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.repositories.sqlite.ActividadRepository;
import es.ies.puerto.services.IActividadService;
import es.ies.puerto.validators.ActividadValidator;

public class ActividadServiceImpl implements IActividadService {

    private final ActividadRepository repo;

    public ActividadServiceImpl(ActividadRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean create(Actividad actividad) {
        if (!ActividadValidator.actividadValida(actividad)) {
            return false;
        }
        return repo.create(actividad);
    }

    @Override
    public Actividad findById(Long id) {
        if (!ActividadValidator.idValido(id)) {
            return null;
        }
        return repo.findById(id);
    }

    @Override
    public List<Actividad> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean update(Actividad actividad) {
        if (!ActividadValidator.actividadValida(actividad)) {
            return false;
        }
        return repo.update(actividad);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!ActividadValidator.idValido(id)) {
            return false;
        }
        return repo.deleteById(id);
    }

    @Override
    public Actividad findByNombre(String nombre) {
        if (!ActividadValidator.nombreValido(nombre)) {
            return null;
        }
        return repo.findByNombre(nombre);
    }

}
