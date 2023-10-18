package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.exceptions.NotFoundException;
import com.example.batoiflix.modelo.dao.interfaces.UsuarioDAOInterface;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.enums.TipoUsuario;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

@Service
public class UsuarioDAO implements UsuarioDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla usuarios
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    MySQLConnection mySQLConnection;

    public UsuarioDAO(@Autowired MySQLConnection mySQLConnection){
        this.mySQLConnection = mySQLConnection;
    }

    /**
     * El metodo coje todas los Usuarios de la base de datos
     *
     * @return devuelve una lista con todas los usuarios de la base de datos
     * @throws DatabaseConnectionError tira la excepcion cuando hay error de conectividad con la base de datos
     */
    @Override
    public ArrayList<Usuario> findAll() {
        String sql = "SELECT * FROM usuarios";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                usuarios.add(mapFromResultSet(rs));
            }
            return usuarios;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * El guarda o actualiza el registro en la base de datos
     *
     * @param usuario es el Usuario que queremos introducir o actualizar en la base de datos
     * @return devuelve true o false si se actualiza o inserta el Usuario
     */
    @Override
    public boolean save(Usuario usuario) {
        if (usuario.getCodigo() < 0){
            return insert(usuario);
        } else {
            return update(usuario);
        }
    }

    /**
     * El metodo obtiene el Usuario con ese id
     *
     * @param id es el identificador del director
     * @return devuelve el Usuario que coincida con el id
     * @throws NotFoundException tira la excepcion cuando el director con ese id no existe
     */
    private Usuario findByID(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return mapFromResultSet(rs);
            }
            return null;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * El metodo obtiene el director con ese email
     *
     * @param email es el email del usuario
     * @return devuelve el director que coincida con el email
     * @throws NotFoundException tira la excepcion cuando el director con ese email no existe
     */
    @Override
    public Usuario findByEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return mapFromResultSet(rs);
            }
            return null;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * El metodo obtiene el director con ese email
     *
     * @param email es el email del usuario
     * @return devuelve el director que coincida con el email
     * @throws DatabaseConnectionError tira la excepcion cuando el director con ese email no existe
     */
    @Override
    public Usuario findByEmailWithContrasenya(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
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
     * El metodo obtiene el director con ese id
     *
     * @param id es el id del usuario
     * @return devuelve el director que coincida con el id
     * @throws NotFoundException tira la excepcion cuando el director con ese id no existe
     */
    @Override
    public Usuario getByID(int id) {
        Usuario usuario = findByID(id);
        if (usuario!= null){
            return usuario;
        }
        throw new NotFoundException("Usuario con id "+ id + " no encontrado");
    }

    /**
     * El metodo obtiene el director con ese email
     *
     * @param email es el email del usuario
     * @return devuelve el director que coincida con el email
     * @throws NotFoundException tira la excepcion cuando el director con ese email no existe
     */
    @Override
    public Usuario getByEmail(String email) {
        Usuario usuario = findByEmail(email);
        if (usuario != null){
            return usuario;
        } else {
            throw new RuntimeException("Usuario con email "+ email + " no encontrado");
        }
    }

    /**
     * Actualiza los datos del Usuario
     *
     * @param usuario es el Usuario que queremos actualizar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private boolean update(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, contraseña = ?, tipo = ? WHERE email = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellidos());
            preparedStatement.setString(3, usuario.getContrasenyaHash());
            preparedStatement.setString(4,usuario.getTipoUsuario().toString());
            preparedStatement.setString(5,usuario.getEmail());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Inserta los datos del Usuario en la base de datos
     *
     * @param usuario es el Usuario que queremos insertar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private boolean insert(Usuario usuario) {
        String sql = "INSERT INTO usuarios (id, nombre, apellidos, email, contraseña, tipo) VALUES (?,?,?,?,?,?)";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setNull(1, Types.NULL);
            preparedStatement.setString(2,usuario.getNombre());
            preparedStatement.setString(3,usuario.getApellidos());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getContrasenyaHash());
            preparedStatement.setString(6, usuario.getTipoUsuario().toString());

            int comprobador = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                int autoIncremental = resultSet.getInt(1);
                usuario.setCodigo(autoIncremental);
                return true;
            }
            return comprobador > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Devuelve la Temporada que se crea tras con el resulset
     *
     * @param resultSet es el resulset que conseguimos tras la llamada a la tabla de la base de datos
     * @return devuelve la Temporada
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    private Usuario mapFromResultSet(ResultSet resultSet) {
        try{
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String email = resultSet.getString("email");
            int id = resultSet.getInt("id");
            String password = resultSet.getString("contraseña");
            TipoUsuario tipoUsuario = getTipoUsuario(resultSet.getString("tipo"));
            return new Usuario(id,nombre,apellidos,email,password,tipoUsuario);
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Busca en la base de datos un Usuario a partir de su nombre y sus apellidos
     *
     * @param nombre es el nombre del Usuario
     * @param apellidos es el apellidos del Usuario
     * @return devuelve el Usuario que coincide con el nombre y apellidos
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    @Override
    public Usuario findByName(String nombre, String apellidos) {
        String sql = "SELECT * FROM usuarios WHERE nombre = ? AND apellidos = ?";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,apellidos);
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
     * Devuelve el Tipo de Usuario en forma de objeto
     *
     * @param cadena es el tipo de Usuario en string
     * @return devuelve el Usuario que coincide con el nombre y apellidos
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private TipoUsuario getTipoUsuario(String cadena){
        if(cadena.equalsIgnoreCase("usuario")){
            return TipoUsuario.USUARIO;
        } else {
            return TipoUsuario.ADMIN;
        }
    }
}