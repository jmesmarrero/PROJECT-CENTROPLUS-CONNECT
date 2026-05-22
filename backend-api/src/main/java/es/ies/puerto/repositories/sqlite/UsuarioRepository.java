package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.IUsuarioRepository;

public class UsuarioRepository extends SQLiteConnectionManager implements IUsuarioRepository {

    protected UsuarioRepository(String databaseUrl) {
        super(databaseUrl);

    }

    @Override
    public boolean create(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, dni, email, telefono, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getDni());
            sentencia.setString(3, usuario.getEmail());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getTipoUsuario().name());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("no se pudo crear usuario" + usuario);
            return false;
        }
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public boolean update(Usuario usuario) {
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public Usuario findByEmail(String email) {
        return null;
    }

}
