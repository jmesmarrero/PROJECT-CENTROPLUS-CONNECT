package es.ies.puerto.repositories.sqlite;

import java.util.List;

import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.IUsuarioRepository;

public class UsuarioRepository implements IUsuarioRepository {

    

    public boolean create(Usuario usuario){
        return false;
    }

    public Usuario findById(Long id){
        return null;
    }

    public List<Usuario> findAll(){
        return null;
    }

    public boolean update(Usuario usuario){
        return false;
    }

    public boolean deleteById(Long id){
        return false;
    }

    public Usuario findByEmail(String email){
        return null;
    }

}


