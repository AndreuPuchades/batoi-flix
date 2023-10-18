package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.modelo.dao.interfaces.FavoritosDAOInterface;
import com.example.batoiflix.modelo.entities.Favorito;
import com.example.batoiflix.modelo.entities.Pelicula;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

@Service
public class FavoritosDAO implements FavoritosDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla favoritos
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    @Autowired
    MySQLConnection mySQLConnection;

    public FavoritosDAO(@Autowired MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }
    /**
     * Inserta un registro en la base de datos cuando el usuario marca una produccion como favorita
     *
     * @param usuario es el usuario que ha marcado como favorito la produccion
     * @param produccion es la produccion que el usuario a marcado como favorita.
     * @return devuelve true o false si ha sido posible insertar el registro o no.
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    @Override
    public boolean insertFavoritos(Usuario usuario, Produccion produccion) {
        String sql = "INSERT INTO favoritos (id_produccion, id_usuario) VALUES (?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,produccion.getId());
            ps.setInt(2,usuario.getCodigo());
            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }

    }
    /**
     * Es el metodo encargado de buscar en la tabla todas las producciones que un usuario en
     * concreto a marcado como favorito
     *
     * @param usuario es el usuario del que queremos buscar las producciones favoritas
     * @return devuelve una lista de favoritos que contendra el id del usuario y de la produccion
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    @Override
    public ArrayList<Favorito> findByIdUsuario(Usuario usuario){
        ArrayList<Favorito> favoritos = new ArrayList<>();

        try(Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement()){
            String sql = "SELECT * FROM favoritos WHERE id_usuario = " + usuario.getCodigo();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                favoritos.add(mapToResultSet(resultSet));
            }

            return favoritos;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Devuelve si el usuario ya ha marcado la produccion como favorita
     *
     * @param produccion es la producion de la que queremos saber si esta ya en favoritos
     * @param usuario es el usuario del que queremos saber si ya ha marcado la produccion como favorita
     * @return true o false si esncuentra ya el usuario y la produccion en la tabla
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    @Override
    public boolean estaEnFavorito(Produccion produccion, Usuario usuario) {
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM favoritos WHERE id_produccion = %d AND id_usuario = %d",
                    produccion.getId(), usuario.getCodigo());
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet.next();

        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }

    }
    /**
     * Elimina de la tabla favoritos la produccion que el usuario elimina de favoritos
     *
     * @param produccion es la produccion que el usuario a marcado para eliminar de favoritos
     * @param  usuario es el usuario que va a eliminar de favoritos la produccion
     * @return true o false si ha podido eliminar el registro de la base de datos
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    @Override
    public boolean removeFavorito(Produccion produccion, Usuario usuario) {
        int afectedRows;
        String sql = "DELETE FROM favoritos WHERE id_produccion = ? AND id_usuario = ?";

        try (Connection connection = mySQLConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, produccion.getId());
            preparedStatement.setInt(2, usuario.getCodigo());
            afectedRows = preparedStatement.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Devuelve la favorito que se crea tras con el resulset
     *
     * @param resultSet es el resulset que conseguimos tras la llamada a la tabla de la base de datos
     * @return devuelve el favorito que contiene el usuario y la produccion
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    private Favorito mapToResultSet(ResultSet resultSet){
        try{
            return new Favorito(new Usuario(resultSet.getInt("id_usuario")),
                    new Pelicula(resultSet.getInt("id_produccion")));
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
}