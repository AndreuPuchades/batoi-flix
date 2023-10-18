package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.exceptions.NotFoundException;
import com.example.batoiflix.modelo.dao.interfaces.PlataformaDAOInterface;
import com.example.batoiflix.modelo.entities.Plataforma;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class PlataformaDAO implements PlataformaDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla plataforma
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    @Autowired
    MySQLConnection mySQLConnection;

    public PlataformaDAO(@Autowired MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }
    /**
     * El metodo coje todas las plataformas que tenemos en la base de datos
     *
     * @return devuelve la lista de plataformas que tenemos en la base de datos
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    @Override
    public ArrayList<Plataforma> findAll() {
        String sql = "SELECT * FROM plataforma";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ArrayList<Plataforma> plataformas = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                plataformas.add(mapFromResultSet(rs));
            }
            return plataformas;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Busca en la base de datos una plataforma a partir de un id
     *
     * @param id es el numero de identificacion de la plataforma
     * @return devuelve la plataforma que coincide con el id
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private Plataforma findById(int id){
        String sql = "SELECT * FROM plataforma WHERE id = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return mapFromResultSet(rs);
            }
            return null;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Busca la plataforma a partir del identificador de la plataforma
     *
     * @param id es el numero de identificacion de la plataforma
     * @return devuelve la plataforma que coincide con el id
     * @throws NotFoundException si no se ha encontrado en la base de datos
     */
    @Override
    public Plataforma getById(int id){
        Plataforma plataforma = findById(id);
        if (plataforma != null){
            return plataforma;
        }
        throw new NotFoundException("No existe esta plataforma");
    }
    /**
     * Busca en la base de datos una plataforma a partir de su nombre
     *
     * @param nombre es el nombre de la plataforma
     * @return devuelve la plataforma que coincide con el nombre
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private Plataforma findByName(String nombre){
        String sql = "SELECT * FROM plataforma WHERE nombre = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,nombre);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return mapFromResultSet(rs);
            }
            return null;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Busca la plataforma a partir del nombre de la plataforma
     *
     * @param nombre es el nombre de la plataforma
     * @return devuelve la plataforma que coincide con el id
     * @throws NotFoundException si no se ha encontrado en la base de datos
     */
    public Plataforma getByName(String nombre){
        Plataforma plataforma = findByName(nombre);
        if (plataforma != null){
            return plataforma;
        }
        throw new NotFoundException("No existe esta plataforma");
    }
    /**
     * Inserta o actualiza la plataforma en la base de datos
     *
     * @param plataforma es la plataforma que queremos introducir en la base de datos
     * @return devuelve true o false si ha sido posible insertarlo o actualizarlo
     */
    public boolean save(Plataforma plataforma) {
        if (plataforma.getCodigo() < 0) {
            return insert(plataforma);
        } else {
            return update(plataforma);
        }
    }

    /**
     * Actualiza los datos de una plataforma
     *
     * @param plataforma es la plataforma que queremos actualizar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private boolean update(Plataforma plataforma) {
        String sql = "UPDATE plataforma SET id = ?, nombre = ?, url = ?,icono = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, plataforma.getCodigo());
            preparedStatement.setString(2, plataforma.getNombre());
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, null);
            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Inserta los datos de una plataforma en la base de datos
     *
     * @param plataforma es la plataforma que queremos insertar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private boolean insert(Plataforma plataforma) {
        String sql = "INSERT INTO plataforma (id, nombre, url,icono) VALUES (?,?,?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, plataforma.getCodigo());
            preparedStatement.setString(2, plataforma.getNombre());
            preparedStatement.setString(3, null);
            preparedStatement.setString(4, null);
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int autoIncremental = resultSet.getInt(1);
                plataforma.setCodigo(autoIncremental);
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * Nos devuelve la plataforma con los datos de la base de datos
     *
     * @param resultSet es un registro de la base de datos
     * @return devuelve la plataforma con los datos de la base de datos
     */
    private Plataforma mapFromResultSet(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String web = resultSet.getString("url");
            String icono = resultSet.getString("icono");
            return new Plataforma(id, nombre,web,icono);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
