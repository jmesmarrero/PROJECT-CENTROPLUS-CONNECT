package es.ies.puerto.repositories;
import java.util.List;

import es.ies.puerto.models.Usuario;

public interface IUsuarioRepository {

    boolean create(Usuario usuario);

    Usuario findById(Long id);

    List<Usuario> findAll();

    boolean update(Usuario usuario);

    boolean deleteById(Long id);

    Usuario findByEmail(String email);

}
