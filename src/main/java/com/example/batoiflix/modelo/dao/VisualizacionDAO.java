package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.modelo.dao.interfaces.VisualizacionDAOInterface;
import com.example.batoiflix.modelo.entities.Produccion;
import com.example.batoiflix.modelo.entities.Usuario;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class VisualizacionDAO implements VisualizacionDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla visualizaciones
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    private MySQLConnection mySQLConnection;

    public VisualizacionDAO(@Autowired MySQLConnection mySQLConnection){
        this.mySQLConnection = mySQLConnection;
    }

    /**
     * Inserta la visualizacion en la base de datos
     *
     * @param usuario es el Usuario que queremos introducir en la base de datos
     * @param produccion es la Produccion que queremos introducir en la base de datos
     * @return devuelve true o false si ha sido posible insertarlo o actualizarlo
     */
    @Override
    public boolean save(Usuario usuario, Produccion produccion){
        return insert(usuario,produccion);
    }

    /**
     * Inserta los datos de una visualizacion en la base de datos
     *
     * @param usuario es el Usuario que queremos insertar
     * @param produccion es la Produccion que queremos insertar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    private boolean insert(Usuario usuario, Produccion produccion){
        String sql = "INSERT INTO visualizaciones (id_usuario, id_produccion) VALUES (?,?)";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,usuario.getCodigo());
            preparedStatement.setInt(2, produccion.getId());
            return preparedStatement.executeUpdate() == 2;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Te devuelve las veces que un usuario ha visto una produccion en concreto
     *
     * @param usuario es el Usuario que queremos buscar
     * @param produccion es la Produccion que queremos buscar
     * @return true o false si a sido posible la actualizacion
     * @throws DatabaseConnectionError si no se puede conectar a la base de datos
     */
    @Override
    public int getVisualizaciones(Usuario usuario, Produccion produccion){
        String sql = "SELECT COUNT(*) AS total_visualizaciones FROM visualizaciones WHERE id_produccion = ? ";
        try(Connection connection = mySQLConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, produccion.getId());
            ps.setInt(2, usuario.getCodigo());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("total_visualizaciones");
            }
            return 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
}
