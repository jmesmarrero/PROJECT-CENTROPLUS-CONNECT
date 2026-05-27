package es.ies.puerto.services;

import java.util.List;

import es.ies.puerto.models.Usuario;

public interface IUsuarioService {

     /**
     * Funcion para crear un usuario
     * @param usuario usuario a crear
     * @return True si se ha creado al usuario correctamente o false lo contrario
     */
    boolean create(Usuario usuario);

    /**
     * Funcion para buscar usuario por id
     * @param id identificador unico de la clase
     * @return usuario con ese id
     */
    Usuario findById(Long id);

    /**
     * Funcion para encontrarlos a todos
     * @return todos los usuarios
     */
    List<Usuario> findAll();

    /**
     * Funcion para actualizar usuario
     * @param usuario usuario a actualizar
     * @return true si se ha actualizado correctamente o false lo contrario
     */
    boolean update(Usuario usuario);

    /**
     * Funcion para borrar usuario por su id
     * @param id identificador unico de la clase
     * @return true si se ha borrado correctamente o false caso contrario
     */
    boolean deleteById(Long id);

    /**
     * Funcion para buscar usuario por su email
     * @param email parametro para buscar al usuario por el email
     * @return usuario encontrado por su email
     */
    Usuario findByEmail(String email);

}
