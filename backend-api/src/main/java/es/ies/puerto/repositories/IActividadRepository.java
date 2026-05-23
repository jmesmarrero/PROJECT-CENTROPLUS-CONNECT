package es.ies.puerto.repositories;

import java.util.List;

import es.ies.puerto.models.Actividad;

public interface IActividadRepository {

    boolean create(Actividad actividad);

    Actividad findById(Long id);

    List<Actividad> findAll();

    boolean update(Actividad actividad);

    boolean deleteById(Long id);

    Actividad findByNombre(String nombre);

}
