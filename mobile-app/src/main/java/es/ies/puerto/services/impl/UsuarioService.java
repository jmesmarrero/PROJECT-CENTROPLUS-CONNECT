package es.ies.puerto.services.impl;

import java.util.List;

import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.sqlite.UsuarioRepository;
import es.ies.puerto.services.IUsuarioService;
import es.ies.puerto.validators.UsuarioValidator;

public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }

    @Override
    public boolean create(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return false;
        }
        return repo.create(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        if (!UsuarioValidator.idValido(id)) {
            return null;
        }
        return repo.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean update(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return false;
        }
        return repo.update(usuario);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!UsuarioValidator.idValido(id)) {
            return false;
        }
        return repo.deleteById(id)  ;
    }

    @Override
    public Usuario findByEmail(String email) {
        if (!UsuarioValidator.emailValido(email)) {
            return null;
        }
        return repo.findByEmail(email);
    }

}
