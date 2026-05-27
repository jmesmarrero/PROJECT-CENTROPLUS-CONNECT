package es.ies.puerto.repositories.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.TipoActividad;
import es.ies.puerto.repositories.IActividadRepository;

public class ActividadRepository extends SQLiteConnectionManager implements IActividadRepository {

    public ActividadRepository(String databaseUrl) {
        super(databaseUrl);

    }

    @Override
    public boolean create(Actividad actividad) {
        String sql = "INSERT INTO actividades (nombre, tipo_actividad, duracion, precio, plazas_maximas, plazas_ocupadas) VALUES (?,?,?,?,?,?)";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {

            sentencia.setString(1, actividad.getNombre());
            sentencia.setString(2, actividad.getTipoActividad().name());
            sentencia.setInt(3, actividad.getDuracion());
            sentencia.setDouble(4, actividad.getPrecio());
            sentencia.setInt(5, actividad.getPlazasMaximas());
            sentencia.setInt(6, actividad.getPlazasOcupadas());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("no se ha podido crear actividad: " + actividad);
            return false;
        }

    }

    @Override
    public Actividad findById(Long id) {
        String sql = "SELECT * FROM actividades WHERE id = ?";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {

            sentencia.setLong(1, id);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                // Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultado.getString("tipo_actividad"));
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");

                return new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas, plazasOcupadas);
            }

        } catch (Exception e) {
            System.err.println("No se pudo encontrar actividad por id: " + id);
        }
        return null;
    }

    @Override
    public List<Actividad> findAll() {
        List<Actividad> actividades = new ArrayList<>();
        String sql = "SELECT * FROM actividades";

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultado.getString("tipo_actividad"));
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");
                Actividad actividad = new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas,
                        plazasOcupadas);

                actividades.add(actividad);
            }
            return actividades;
        } catch (Exception e) {
            System.err.println("no se han podido encontrar las actividades");
            return new ArrayList<>();
        }

    }

    @Override
    public boolean update(Actividad actividad) {
        String sql = "UPDATE actividades SET nombre=?, tipo_actividad=?, duracion=?, precio=?, plazas_maximas=?, plazas_ocupadas=? WHERE id = ?";

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, actividad.getNombre());
            sentencia.setString(2, actividad.getTipoActividad().name());
            sentencia.setInt(3, actividad.getDuracion());
            sentencia.setDouble(4, actividad.getPrecio());
            sentencia.setInt(5, actividad.getPlazasMaximas());
            sentencia.setInt(6, actividad.getPlazasOcupadas());
            sentencia.setLong(7, actividad.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("no se ha podido encontrar actividad por el id");
            return false;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM actividades WHERE id = ?";

        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("no se ha podido encontrar borrar actividad con el id: " + id);
            return false;
        }
    }

    @Override
    public Actividad findByNombre(String nombre) {
        String sql = "SELECT * FROM actividades WHERE nombre = ?";
        try (Connection connection = this.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {

            sentencia.setString(1, nombre);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {

                Long id = resultado.getLong("id");
                // String nombre = resultado.getString("nombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultado.getString("tipo_actividad"));
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");

                return new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas, plazasOcupadas);
            }

        } catch (Exception e) {
            System.err.println("No se pudo encontrar actividad por nombre: " + nombre);
        }
        return null;
    }

}
