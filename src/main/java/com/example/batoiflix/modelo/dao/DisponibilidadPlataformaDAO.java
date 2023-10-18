package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.modelo.dao.interfaces.DisponibilidadPlataformaDAOInterface;
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
public class DisponibilidadPlataformaDAO implements DisponibilidadPlataformaDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla disponibilidad plataforma
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    @Autowired
    MySQLConnection mySQLConnection;
    /**
     * Devuelve una Plataforma creada solo con el id
     *
     * @param resultSet es el resulset que conseguimos tras la llamada a la base de datos
     * @return devuelve la plataforma solo con la id
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    private Plataforma mapFromResultSet(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("id_plataforma");
            return new Plataforma(id);
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Consulta a la base de datos las plataformas en las que esta una produccion
     *
     * @param idProduccion es el id de la produccion que queremos saber las plataformas
     * @return devuelve la lista de plataformas donde se encuentra la produccion
     * @throws DatabaseConnectionError si no se puede conecatra a la base de datos
     */
    @Override
    public ArrayList<Plataforma> plataformasDisponibles(int idProduccion){
        String sql = "SELECT * FROM disponibilidad_plataforma WHERE id_produccion = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idProduccion);
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
}
