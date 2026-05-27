package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.TipoUsuario;
import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.IUsuarioRepository;

public class UsuarioRepository extends SQLiteConnectionManager implements IUsuarioRepository {

    public UsuarioRepository(String databaseUrl) {
        super(databaseUrl);

    }

    @Override
    public boolean create(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, dni, email, telefono, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {

                String nombre = resultado.getString("nombre");
                String dni = resultado.getString("dni");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultado.getString("tipo_usuario"));

                return new Usuario(id, nombre, dni, email, telefono, tipoUsuario);

            }

        } catch (Exception e) {
            System.err.println("No se ha podido encontrar Usuario por id: " + id);
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                String dni = resultado.getString("dni");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultado.getString("tipo_usuario"));

                Usuario usuario = new Usuario(id, nombre, dni, email, telefono, tipoUsuario);
                usuarios.add(usuario);
            }
            return usuarios;

        } catch (Exception e) {
            System.err.println("No se han encontrado usuarios");
            return new ArrayList<>();
        }
    }

    @Override
    public boolean update(Usuario usuario) {

        String sql = "UPDATE usuarios SET nombre=?, dni=?, email=?, telefono=?, tipo_usuario=? WHERE id = ?";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {

            sentencia.setString(1, usuario.getNombre());
            sentencia.setString(2, usuario.getDni());
            sentencia.setString(3, usuario.getEmail());
            sentencia.setString(4, usuario.getTelefono());
            sentencia.setString(5, usuario.getTipoUsuario().name());
            sentencia.setLong(6, usuario.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("No se ha podido actualizar usuario: " + usuario);
            return false;
        }

    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("No se ha podido eliminar usuario con id: " + id);
            return false;
        }

    }

    @Override
    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, email);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                String dni = resultado.getString("dni");
                // String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                TipoUsuario tipoUsuario = TipoUsuario.valueOf(resultado.getString("tipo_usuario"));

                return new Usuario(id, nombre, dni, email, telefono, tipoUsuario);
            }
        } catch (Exception e) {
            System.err.println("no se pudo encontrar usuario por email: " + email);
        }
        return null;
    }

}
