package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.exceptions.NotFoundException;
import com.example.batoiflix.modelo.dao.interfaces.TemporadaDAOInterface;
import com.example.batoiflix.modelo.entities.Temporada;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

@Service
public class TemporadaDAO implements TemporadaDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla temporada
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    @Autowired
    MySQLConnection mySQLConnection;

    public TemporadaDAO(@Autowired MySQLConnection mySQLConnection) {
        this.mySQLConnection = mySQLConnection;
    }

    /**
     * El metodo pagina el resultado de la busqueda de temporada por id de Serie en la base de datos
     *
     * @param idSerie es la id de la Serie
     * @return devuelve un array de todas las temporadas con la id de Serie
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public ArrayList<Temporada> getByIdSerie(int idSerie) {
        ArrayList<Temporada> temporadas = new ArrayList<>();

        String sql = "SELECT * FROM temporadas WHERE id_serie = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idSerie);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                temporadas.add(mapFromResultSet(resultSet));
            }

            return temporadas;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * Este metodo guarda una Temporada en la base de datos
     *
     * @param temporada La temporada a guardar
     * @return devuelve si se ha guardado correctamente la Temporada
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public boolean save(Temporada temporada) {
        return insert(temporada);
    }

    private boolean insert(Temporada temporada) {
        String sql = "INSERT INTO temporadas (id_serie, id_temporada, anyo_lanzamiento, guion, num_capitulos) VALUES (?,?,?,?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, temporada.getSerie().getId());
            ps.setInt(2, temporada.getIdTemporada());
            ps.setInt(3, temporada.getAnyoLanzamiento());
            ps.setString(4, temporada.getGuion());
            ps.setInt(5, temporada.getCapitulos());
            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * El metodo pagina el resultado de la busqueda de temporada por id de Serie y id de Temporada
     *
     * @param idSerie es la id de la Serie
     * @param idTemporada es la id de la Temporada
     * @return devuelve una temporada en concreto
     * @throws NotFoundException si hay error en la conectividad en la base de datos
     */
    @Override
    public Temporada getById(int idSerie, int idTemporada){
        Temporada temporada = findById(idSerie, idTemporada);

        if(temporada == null){
            throw new NotFoundException("No existe esta temporada");
        }

        return temporada;
    }

    /**
     * El metodo pagina el resultado de la busqueda de temporada por id de Serie y id de Temporada
     *
     * @param idSerie es la id de la Serie
     * @param idTemporada es la id de la Temporada
     * @return devuelve una temporada en concreto
     */
    public Temporada findById(int idSerie, int idTemporada) {
        String sql = "SELECT * FROM temporadas WHERE id_serie = ? AND id_temporada = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idSerie);
            preparedStatement.setInt(2, idTemporada);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapFromResultSet(resultSet);
            }

            return null;
        } catch (SQLException e) {
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
    private Temporada mapFromResultSet(ResultSet resultSet) {
        try {
            return new Temporada(resultSet.getInt("id_serie"), resultSet.getInt("id_temporada"),
                    resultSet.getInt("anyo_lanzamiento"), resultSet.getString("guion"),
                    resultSet.getInt("num_capitulos"));
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
}