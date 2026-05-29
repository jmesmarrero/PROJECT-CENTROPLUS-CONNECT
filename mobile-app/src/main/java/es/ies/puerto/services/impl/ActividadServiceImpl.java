package es.ies.puerto.services.impl;

import java.util.List;

import javax.xml.validation.Validator;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.repositories.IActividadRepository;

import es.ies.puerto.services.IActividadService;
import es.ies.puerto.validators.ActividadValidator;

public class ActividadServiceImpl implements IActividadService {

    private final IActividadRepository repo;

    public ActividadServiceImpl(IActividadRepository repo) {
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

    @Override
    public boolean reservarPlaza(Long id) {
        if(!ActividadValidator.idValido(id)){
            return false;
        }

        Actividad actividadBuscar = repo.findById(id);
        if (actividadBuscar == null) {
            return false;
        }
        if (actividadBuscar.getPlazasOcupadas() >= actividadBuscar.getPlazasMaximas()) {
            return false;
        }
         actividadBuscar.reservarPlaza();
        return repo.update(actividadBuscar);
    }

    @Override
    public boolean cancelarPlaza(Long id) {
        if (!ActividadValidator.idValido(id)) {
            return false;
        }
        Actividad actividadCancelar = repo.findById(id);

        if (actividadCancelar == null) {
            return false;
        }
        if (actividadCancelar.getPlazasOcupadas() <= 0) {
            return false;
        }
        actividadCancelar.cancelarPlaza();
        return repo.update(actividadCancelar);

    }

    

}
