package es.ies.puerto.services;

import java.util.List;

import es.ies.puerto.models.Actividad;

public interface IActividadService {

     /**
     * Funcion para crear actividad
     * 
     * @param actividad actividad a crear
     * @return ture si se ha creado correctamente o false en caso contrario
     */
    boolean create(Actividad actividad);

   /**
    * Funcion para encontrar actividad por id
    * @param id identificador unico apra encontrar actividad
    * @return actividad encontrada por su id
    */
    Actividad findById(Long id);

    /**
     * Funcion para encontrar todas las actividades
     * @return todas las actividades
     */
    List<Actividad> findAll();

    /**
     * Funcion para actualizar actividad 
     * @param actividad actividad a actualizar
     * @return true si se ha actualizado correctamente or False en caso contrario
     */
    boolean update(Actividad actividad);

    /**
     * Funcion para eliminar actividad por id
     * @param id parametro identificador unico
     * @return true si se ha eliminado correctamente o false en caso contrario
     */
    boolean deleteById(Long id);

    /**
     * Funcion para buscar actividad por nombre
     * @param nombre parametro String para buscar actividad
     * @return actividad con ese nombre
     */
    Actividad findByNombre(String nombre);

    boolean reservarPlaza(Long id);
    boolean cancelarPlaza(Long id);
}
