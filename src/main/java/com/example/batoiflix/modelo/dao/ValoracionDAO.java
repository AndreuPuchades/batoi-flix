package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.modelo.dao.interfaces.ValoracionesDAOInterface;
import com.example.batoiflix.modelo.entities.Pelicula;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.modelo.entities.Valoracion;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

@Service
public class ValoracionDAO implements ValoracionesDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla valoraciones
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    @Autowired
    private MySQLConnection mySQLConnection;

    public ValoracionDAO(@Autowired MySQLConnection mySQLConnection){
        this.mySQLConnection = mySQLConnection;
    }

    /**
     * Guarda directamente los datos de una valoracion en la base de datos
     *
     * @param valoracion es la Valoracion que queremos insertar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    @Override
    public boolean save(Valoracion valoracion) {
        String sql = "INSERT INTO valoraciones (id_produccion, id_usuario, comentario, valoracion) VALUES (?,?,?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,valoracion.getProduccion().getId());
            preparedStatement.setInt(2,valoracion.getUsuario().getCodigo());
            preparedStatement.setString(3,valoracion.getComentario());
            preparedStatement.setInt(4,valoracion.getValoracion());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Busca en la base de datos una valoracion a partir del id del usuario
     *
     * @param usuario es el Usuario
     * @return devuelve las Valoraciones todo lo que coincide con la id de usuario
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    @Override
    public ArrayList<Valoracion> findByIdUsuario(Usuario usuario) {
        ArrayList<Valoracion> valoracions = new ArrayList<>();

        try(Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement()){
            String sql = "SELECT * FROM valoraciones WHERE id_usuario = " + usuario.getCodigo();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                valoracions.add(matToResultSet(resultSet));
            }

            return valoracions;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Busca en la base de datos una valoracion a partir del id del usuario y del id de la produccion
     *
     * @param usuario es el Usuario
     * @param produccion es la produccion
     * @return devuelve las Valoraciones que coincidan con el usuario y la produccion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    @Override
    public Valoracion findByIdUsuarioAndProduccion(Usuario usuario,Produccion produccion) {

        try(Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement()){
            String sql = "SELECT * FROM valoraciones WHERE id_usuario = " + usuario.getCodigo()+" AND id_produccion = "+produccion.getId();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return matToResultSet(resultSet);
            }

        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
        return null;
    }

    /**
     * Elimina de la tabla Valoraciones la valoracion que el usuario elimina de Valoraciones
     *
     * @param idProduccion es el idProduccion que el usuario a marcado para eliminar de valoraciones
     * @param  idUsuario es el idUsuario que va a eliminar de valoraciones
     * @return true o false si ha podido eliminar el registro de la base de datos
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    public boolean remove(int idProduccion, int idUsuario){
        int afectedRows = 0;
        String sql = "DELETE FROM valoraciones WHERE id_produccion = ? AND id_usuario = ?";

        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1, idProduccion);
            preparedStatement.setInt(2, idUsuario);
            afectedRows = preparedStatement.executeUpdate();

            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Nos devuelve la valoracion con los datos de la base de datos
     *
     * @param resultSet es un registro de la base de datos
     * @return devuelve la valoracion con los datos de la base de datos
     */
    private Valoracion matToResultSet(ResultSet resultSet){
        try {
            return new Valoracion(new Pelicula(resultSet.getInt("id_produccion")),
                    new Usuario(resultSet.getInt("id_usuario")), resultSet.getString("comentario"),
                    resultSet.getInt("valoracion"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}