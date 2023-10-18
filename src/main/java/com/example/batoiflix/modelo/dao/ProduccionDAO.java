package com.example.batoiflix.modelo.dao;

import com.example.batoiflix.exceptions.DatabaseConnectionError;
import com.example.batoiflix.exceptions.NotFoundException;
import com.example.batoiflix.modelo.dao.interfaces.ProduccionDAOInterface;
import com.example.batoiflix.modelo.entities.*;
import com.example.batoiflix.modelo.enums.Calificacion;
import com.example.batoiflix.modelo.enums.Genero;
import com.example.batoiflix.utils.database.MySQLConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class ProduccionDAO implements ProduccionDAOInterface {
    /**
     * Esta clase se encarga de hacer las consultas a la tabla produccion
     *
     *
     * @author Arantxa, Cintia, Andreu
     * @version 3.7
     * @since 2.1 (junio de 2022)
     */
    @Autowired
    MySQLConnection mySQLConnection;

    public ProduccionDAO(@Autowired MySQLConnection mySQLConnection){
        this.mySQLConnection = mySQLConnection;
    }
    /**
     * El metodo busca el actor por id
     *
     * @param id es el numero de identificacion del actor
     * @return devuelve el actor con ese id
     * @throws NotFoundException si la el actor es null
     */
    public Actor getByIdActor(int id){
        Actor actor = findByIdActor(id);

        if(actor == null){
            throw new NotFoundException("No existe el actor");
        }

        return actor;
    }
    /**
     * El metodo busca en la base de datos el actor con ese identificador
     *
     * @param id es el numero de identificacion del actor
     * @return devuelve el actor con ese id o null
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    public Actor findByIdActor(int id){
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM actores WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetActor(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo pagina el resultado de la busqueda de producciones por titulo en la base de datos
     *
     * @param titulo es el titulo que queremos buscar
     * @param page es el numero de pagina que queremos paginar
     * @param pageSize es el limite de registros que queremos por pagina
     * @return devuelve la entidad paginaresult de la pagina que hemos pedido
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public PaginateResult getByTitlePagined(String titulo, int page, int pageSize) {
        ArrayList<Produccion> produccions = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM producciones WHERE titulo LIKE ? LIMIT ? OFFSET ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"%"+titulo+"%");
            preparedStatement.setInt(2,pageSize+1);
            preparedStatement.setInt(3,offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            boolean quedanMas = (produccions.size() >= pageSize+1);
            if (quedanMas){
                produccions.remove(produccions.size()-1);
            }
            return new PaginateResult(produccions,quedanMas,pageSize);
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo pagina el resultado de la busqueda de producciones por genero en la base de datos
     *
     * @param genero es el genero por el que queremos buscar
     * @param page es el numero de pagina que queremos paginar
     * @param pageSize es el limite de registros que queremos por pagina
     * @return devuelve la entidad paginaresult de la pagina que hemos pedido
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public PaginateResult getByGenerePagined(String genero, int page, int pageSize) {
        ArrayList<Produccion> produccions = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM producciones WHERE genero LIKE ? LIMIT ? OFFSET ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"%"+genero+"%");
            preparedStatement.setInt(2,pageSize+1);
            preparedStatement.setInt(3,offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            boolean quedanMas = (produccions.size() >= pageSize+1);
            if (quedanMas){
                produccions.remove(produccions.size()-1);
            }
            return new PaginateResult(produccions,quedanMas,pageSize);
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo pagina el resultado de la busqueda de producciones por genero y titulo en la base de datos
     *
     * @param genero es el genero por el que queremos buscar
     * @param titulo es el titulo por el que queremos buscar
     * @param page es el numero de pagina que queremos paginas
     * @param pageSize es el limite de registros que queremos por paginar
     * @return devuelve la entidad paginaresult de la pagina que hemos pedido
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public PaginateResult getByGenereAndTitlePagined(String genero, String titulo, int page, int pageSize) {
        ArrayList<Produccion> produccions = new ArrayList<>();
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM producciones WHERE genero LIKE ? AND titulo LIKE ? LIMIT ? OFFSET ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"%"+genero+"%");
            preparedStatement.setString(2,"%"+titulo+"%");
            preparedStatement.setInt(3,pageSize+1);
            preparedStatement.setInt(4,offset);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            boolean quedanMas = (produccions.size() >= pageSize+1);
            if (quedanMas){
                produccions.remove(produccions.size()-1);
            }
            return new PaginateResult(produccions,quedanMas,pageSize);
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo busca en la tabla productores por el nombre del productor
     *
     * @param nombre es el nombre del productor por el que se quiere buscar
     * @return devuelve el productor que coincida con el nombre
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    public Productor findByNombreProductor(String nombre){
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM productores WHERE nombre LIKE '%s%%'", nombre);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetProductor(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo obtiene el director con ese id
     *
     * @param id es el identificador del director
     * @return devuelve el director que coincida con el id
     * @throws NotFoundException tira la excepcion cuando el director con ese id no existe
     */
    public Director getByIdDirector(int id){
        Director director = findByIdDirector(id);

        if(director == null){
            throw new NotFoundException("No existe director con ese id");
        }

        return director;
    }
    /**
     * El metodo busca en la base de datos un director con ese id
     *
     * @param id es el identificador del director
     * @return devuelve el director que coincida con el id
     * @throws DatabaseConnectionError tira la excepcion cuando hay error de conectividad con la base de datos
     */
    public Director findByIdDirector(int id){
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM directores WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetDirector(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo obtiene el productor con ese id
     *
     * @param id es el identificador del productor
     * @return devuelve el productor que coincida con el id
     * @throws NotFoundException tira la excepcion cuando el director con ese id no existe
     */
    public Productor getByIdProductor(int id){
        Productor productor = findByIdProductor(id);

        if(productor == null){
            throw new NotFoundException("No hay productor con ese id");
        }

        return productor;
    }
    /**
     * El metodo busca en la base de datos un productor con ese id
     *
     * @param id es el identificador del productor
     * @return devuelve el productor que coincida con el id
     * @throws DatabaseConnectionError tira la excepcion cuando hay error de conectividad con la base de datos
     */
    public Productor findByIdProductor(int id){
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM productores WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetProductor(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * El metodo coje todas las producciones de la base de datos
     *
     * @return devuelve una lista con todas las producciones de la base de datos
     * @throws DatabaseConnectionError tira la excepcion cuando hay error de conectividad con la base de datos
     */
    @Override
    public ArrayList<Produccion> findAll() {
        ArrayList<Produccion> usersList = new ArrayList<>();

        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM producciones";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                usersList.add(mapFromResulsetProduccion(resultSet));
            }

            return usersList;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo pagina las peliculas de la base de datos
     *
     * @param page es el numero de pagina que queremos paginar
     * @param pageSize es el limite de registros que queremos por pagina
     * @return devuelve la entidad paginaresult de la pagina que hemos pedido
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public PaginateResult findAllPelicula(int page, int pageSize) {
        ArrayList<Produccion> produccions = new ArrayList<>();
        int offset = (page-1)*pageSize;
        String sql = String.format("SELECT * FROM producciones WHERE tipo = ? LIMIT %d OFFSET %d",pageSize+1,offset);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"Pelicula");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            boolean quedanMas = (produccions.size() >= pageSize+1);
            if (quedanMas){
                produccions.remove(produccions.size()-1);
            }
            return new PaginateResult(produccions,quedanMas,pageSize);
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo pagina todas la producciones ordenas como el usuario eliga
     *
     * @param page es el numero de pagina que queremos paginar
     * @param pageSize es el limite de registros que queremos por pagina
     * @param order es el orden por el que quieren ordenar
     * @return devuelve la entidad paginaresult de la pagina que hemos pedido
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public PaginateResult findAllOrder(int page, int pageSize, String order) {
        ArrayList<Produccion> produccions = new ArrayList<>();
        int offset = (page-1)*pageSize;
        String sql = String.format("SELECT * FROM producciones ORDER BY fecha_lanzamiento %s LIMIT %d OFFSET %d",order,pageSize+1,offset);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            boolean quedanMas = (produccions.size() >= pageSize+1);
            if (quedanMas){
                produccions.remove(produccions.size()-1);
            }
            return new PaginateResult(produccions,quedanMas,pageSize);
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo pagina todas las series
     *
     * @param page es el numero de pagina que queremos paginar
     * @param pageSize es el limite de registros que queremos por pagina
     * @return devuelve la entidad paginaresult de la pagina que hemos pedido
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public PaginateResult findAllSeries(int page, int pageSize) {
        ArrayList<Produccion> produccions = new ArrayList<>();
        int offset = (page-1)*pageSize;
        String sql = String.format("SELECT * FROM producciones WHERE tipo = ? LIMIT %d OFFSET %d",pageSize+1,offset);
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,"Serie");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            boolean quedanMas = (produccions.size() >= pageSize+1);
            if (quedanMas){
                produccions.remove(produccions.size()-1);
            }
            return new PaginateResult(produccions,quedanMas,pageSize);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * El guarda o actualiza el registro en la base de datos
     *
     * @param produccion es la produccion que queremos introducir o actualizar en la base de datos
     * @return devuelve true o false si se actualiza o inserta la produccion
     */
    @Override
    public boolean save(Produccion produccion) {
        if (getByIdProduccion(produccion.getId()) == null){
            produccion = getProduccionFinal(produccion);
            insert(produccion);
            ArrayList<Actor> actores = getActores(produccion.getActores());
            for (int i = 0; i < actores.size(); i++) {
                if(actores.get(i).getCodigo() != -1){
                    insertActoresProduccion(actores.get(i), produccion);
                }
            }
            return insertPlataformaANDDisponibilidad(produccion);
        } else {
            insertPlataformaANDDisponibilidad(produccion);
            return update(produccion);
        }
    }
    /**
     * El metodo busca en la base de datos la produccion con ese id
     *
     * @param idProduccion el identificador de la produccion
     * @return devuelve la produccion que coincide con el identificador
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public Produccion getByIdProduccion(int idProduccion) {
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM producciones WHERE id = " + idProduccion;
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetProduccion(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo busca en la base de datos las 15 producciones mas visitadas
     *
     * @return devuelve una lista de producciones mas recomendadas
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    @Override
    public ArrayList<Produccion> findAllRecomendadas() {
        ArrayList<Produccion> produccions = new ArrayList<>();
        String sql = String.format("SELECT p.* FROM producciones p LEFT JOIN visualizaciones v ON p.id = v.id_produccion GROUP BY p.id ORDER BY COUNT(v.id_produccion) DESC LIMIT %d,%d",0,15);

        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                produccions.add(mapFromResulsetProduccion(resultSet));
            }
            return produccions;
        }catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * El metodo actualiza los datos del registro en la base de datos
     *
     * @param produccion es la produccion que se quiere actualizar
     * @return devuelve true o false dependiendo si ha sido posible actualizar el registro
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean update(Produccion produccion){
        String sql = "UPDATE producciones SET titulo = ?, calificacion = ?, fecha_lanzamiento = ?, duracion = ?, genero = ?, " +
                "director = ?, guion = ?, portada = ?, tipo = ?, id_productora = ?, web = ?, disponible = ? WHERE id = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(13, produccion.getId());
            ps.setString(1, produccion.getTitulo());
            ps.setString(2, produccion.getCalificacion().toString());
            ps.setDate(3, Date.valueOf(produccion.getFechaLanzamiento()));
            ps.setInt(4, produccion.getDuracion());
            ps.setString(5, getCadenaGeneros(produccion.getGenero()));
            ps.setInt(6, produccion.getDirector().getId());
            ps.setString(7, produccion.getGuion());
            ps.setString(8, produccion.getPortada());
            ps.setString(9, produccion.getClass().getSimpleName());
            ps.setInt(10, produccion.getProductor().getId());
            ps.setString(11, produccion.getWeb());
            ps.setBoolean(12, true);
            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }

    }
    /**
     * El metodo inserta los datos del registro en la base de datos
     *
     * @param produccion es la produccion que se quiere insertar
     * @return devuelve true o false dependiendo si ha sido posible insertar el registro
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insert(Produccion produccion){
        String sql = "INSERT INTO producciones (id, titulo, calificacion, fecha_lanzamiento, duracion, genero, " +
                "director, guion, portada, tipo, id_productora, web, disponible) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, produccion.getId());
            ps.setString(2, produccion.getTitulo());
            ps.setString(3, produccion.getCalificacion().toString());
            ps.setDate(4, Date.valueOf(produccion.getFechaLanzamiento()));
            ps.setInt(5, produccion.getDuracion());
            ps.setString(6, getCadenaGeneros(produccion.getGenero()));
            ps.setInt(7, produccion.getDirector().getId());
            ps.setString(8, produccion.getGuion());
            ps.setString(9, produccion.getPortada());
            ps.setString(10, produccion.getClass().getSimpleName());
            ps.setInt(11, produccion.getProductor().getId());
            ps.setString(12, produccion.getWeb());
            ps.setBoolean(13, true);

            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }

    }
    /**
     * El metodo inserta el productor en la base de datos
     *
     * @param productor es la productor que se quiere insertar
     * @return devuelve true o false dependiendo si ha sido posible insertar el registro
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertProductor(Productor productor){
        String sql = "INSERT INTO productores (id, nombre) VALUES (?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, productor.getNombre());

            int afectedRows = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoincremental = rs.getInt(1);
                productor.setId(autoincremental);
            }

            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo inserta el director en la base de datos
     *
     * @param director es la productor que se quiere insertar
     * @return devuelve true o false dependiendo si ha sido posible insertar el registro
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertDirector(Director director){
        String sql = "INSERT INTO directores (id, nombre) VALUES (?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, director.getNombre());

            int afectedRows = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoincremental = rs.getInt(1);
                director.setId(autoincremental);
            }

            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo inserta el actor en la base de datos
     *
     * @param actor es la actor que se quiere insertar
     * @return devuelve true o false dependiendo si ha sido posible insertar el registro
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertActores(Actor actor){
        String sql = "INSERT INTO actores (id, nombre) VALUES (?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, actor.getNombre());

            int afectedRows = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoincremental = rs.getInt(1);
                actor.setCodigo(autoincremental);
            }

            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo es el mapeo para crear una produccion
     *
     * @param resultSet son los datos que tendra la produccion
     * @return devuelve la produccion con los datos
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private Produccion mapFromResulsetProduccion(ResultSet resultSet){
        try{
            if (resultSet.getString("Tipo").equals("Pelicula")){
                return new Pelicula(resultSet.getInt("id"), resultSet.getString("titulo"),
                        getCalificacion(resultSet.getString("calificacion")),
                        resultSet.getDate("fecha_lanzamiento").toLocalDate(), resultSet.getInt("duracion"),
                        getGeneros(resultSet.getString("genero")), getByIdDirector(resultSet.getInt("director")),
                        getActoresByIdProduccion(resultSet.getInt("id")), resultSet.getString("guion"),
                        resultSet.getString("portada"), getByIdProductor(resultSet.getInt("id_productora")),
                        resultSet.getString("web"));
            }else {
                return new Serie(resultSet.getInt("id"), resultSet.getString("titulo"),
                        getCalificacion(resultSet.getString("calificacion")),
                        resultSet.getDate("fecha_lanzamiento").toLocalDate(), resultSet.getInt("duracion"),
                        getGeneros(resultSet.getString("genero")), getByIdDirector(resultSet.getInt("director")),
                        getActoresByIdProduccion(resultSet.getInt("id")), resultSet.getString("guion"),
                        resultSet.getString("portada"), getByIdProductor(resultSet.getInt("id_productora")),
                        resultSet.getString("web"));
            }

            } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El busca los actores por id
     *
     * @param idProduccion es el id de la produccion que queremos saber los actores
     * @return devuelve una lista de acotres que pertenecen a la produccion
     * @throws NotFoundException si no encuenta los actores
     */
    public ArrayList<Actor> getActoresByIdProduccion(int idProduccion){
        ArrayList<Actor> actores = findActoresByIdProduccion(idProduccion);

        if(actores == null){
            throw new NotFoundException("No existe actores en esta produccion");
        }

        return actores;
    }
    /**
     * El metodo busca en la base de datos los actores de una produccion
     *
     * @param idProduccion es el identificador de la produccion
     * @return devuelve una lista de actores que forman parte de la produccion
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    public ArrayList<Actor> findActoresByIdProduccion(int idProduccion){
        ArrayList<Actor> actores = new ArrayList<>();

        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM actores_producciones WHERE id_produccion = " + idProduccion;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                actores.add(mapFromResulsetActoresProducciones(resultSet));
            }

            return actores;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }

    }
    /**
     * El metodo mapea un actor de una produccion
     *
     * @param resultSet son los datos que tendra el actor
     * @return devuelve el actor con los datos
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private Actor mapFromResulsetActoresProducciones(ResultSet resultSet){
        try{
            return getByIdActor(resultSet.getInt("id_actor"));
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }


    /**
     * El metodo mapea un actor de una produccion
     *
     * @param resultSet son los datos que tendra el actor
     * @return devuelve el actor con los datos
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private Actor mapFromResulsetActor(ResultSet resultSet){
        try{
            return new Actor(resultSet.getInt("id"), resultSet.getString("nombre"));
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo mapea un director de una produccion
     *
     * @param resultSet son los datos que tendra el director
     * @return devuelve el director con los datos
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private Director mapFromResulsetDirector(ResultSet resultSet){
        try{
            return new Director(resultSet.getInt("id"), resultSet.getString("nombre"));
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo mapea un productor de una produccion
     *
     * @param resultSet son los datos que tendra el productor
     * @return devuelve el productor con los datos
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private Productor mapFromResulsetProductor(ResultSet resultSet){
        try{
            return new Productor(resultSet.getInt("id"), resultSet.getString("nombre"));
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * Obtiene el enum de la calificacion
     *
     * @param cadena es la cadena que sera igual que la calificacion
     * @return devuelve calificacion correspondiente
     */
    private Calificacion getCalificacion(String cadena){
        if(cadena.equalsIgnoreCase("G")){
            return Calificacion.G;
        } else if (cadena.equalsIgnoreCase("GP")) {
            return Calificacion.PG;
        } else if (cadena.equalsIgnoreCase("GP_13")) {
            return Calificacion.PG_13;
        } else if (cadena.equalsIgnoreCase("R")) {
            return Calificacion.R;
        } else {
            return Calificacion.X;
        }
    }
    /**
     * Obtiene los generos a partir de una cadena
     *
     * @param cadenaGeneros es la cadena que contiene los generos
     *
     * @return devuelve una lista de generos
     */
    private ArrayList<Genero> getGeneros(String cadenaGeneros){
        Genero[] allGeneros = {
                Genero.ADVENTURE, Genero.ACTION, Genero.ANIMATION, Genero.BIOGRAPHY, Genero.FANTASY,
                Genero.DRAMA, Genero.CRIME, Genero.FAMILY, Genero.HORROR, Genero.HISTORY, Genero.MUSICAL, Genero.SPORT,
                Genero.COMEDY, Genero.SCI_FI, Genero.MISTERY, Genero.WESTERN, Genero.ROMANCE, Genero.THRILLER,
        };

        ArrayList<Genero> generos = new ArrayList<>();
        String[] generosCadena = cadenaGeneros.split(",");

        for (int i = 0; i < generosCadena.length; i++) {
            for (int j = 0; j < allGeneros.length; j++) {
                if(allGeneros[j].toString().equalsIgnoreCase(generosCadena[i])){
                    generos.add(allGeneros[j]);
                }
            }
        }

        return generos;
    }
    /**
     * Obtiene los generos en cadena a partir de una lista de generos
     *
     * @param generos es la cadena que contiene los generos
     *
     * @return la codena correspondiente de los geenros
     */
    private String getCadenaGeneros(ArrayList<Genero> generos){
        StringBuilder cadena = new StringBuilder();

        for (int i = 0; i < generos.size(); i++) {
            cadena.append(generos.get(i).toString());
            cadena.append(",");
        }

        return String.valueOf(cadena) ;
    }
    /**
     * Permite guardar en la base de datos el productor y el director de una produccion
     *
     * @param produccion de la produccion que queremos guardarlos
     *
     * @return devuelve la produccion
     */
    private Produccion getProduccionFinal(Produccion produccion){

        Productor productor = findByNombreProductor(produccion.getProductor().getNombre());

        if(productor == null){
            insertProductor(produccion.getProductor());
            Productor productorNew = findByNombreProductor(produccion.getProductor().getNombre());
            produccion.setProductor(productorNew);
        } else {
            produccion.setProductor(productor);
        }

        Director director = findByNombreDirector(produccion.getDirector().getNombre());

        if(director == null){
            insertDirector(produccion.getDirector());
            Director directorNew = findByNombreDirector(produccion.getDirector().getNombre());
            produccion.setDirector(directorNew);
        } else {
            produccion.setDirector(director);
        }
        return produccion;
    }
    /**
     * El metodo busca en la base de datos en la tabla actores a partir del nombre
     *
     * @param nombre es el nombre del actor
     * @return devuelve el actor que se identifica con ese nombre
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    public Actor findByNombreActor(String nombre){

        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM actores WHERE nombre LIKE '%s%%'", nombre);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetActor(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }

    /**
     * El metodo busca en la base de datos en la tabla director a partir del nombre
     *
     * @param nombre es el nombre del director
     * @return devuelve el director que se identifica con ese nombre
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    public Director findByNombreDirector(String nombre){
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM directores WHERE nombre LIKE '%s%%'", nombre);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetDirector(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo inserta en la tabla la produccion y la plataforma donde encontrarla
     *
     * @param produccion es de la produccion de la que queremos guardar las plataformas
     * @return devuelve si a sido posible insertalo o no
     */
    private boolean insertPlataformaANDDisponibilidad(Produccion produccion){
        ArrayList<Plataforma> plataformas = produccion.getPlataformas();
        int cont = 0;
        for (int i = 0; i < plataformas.size(); i++) {
            Plataforma plataforma = findByNombrePlataforma(plataformas.get(i).getNombre());
            if(plataforma == null){
                insertPlataforma(plataformas.get(i));
                insertExtrasPlataformas(plataformas.get(i));
                Plataforma plataformaBuscada = findByNombrePlataforma(plataformas.get(i).getNombre());
                if (insertDisponibilidadPlataforma(new DisponiblidadPlataforma(produccion.getId(), plataformaBuscada.getCodigo()))){
                    cont++;
                }
            } else {
                if(insertDisponibilidadPlataforma(new DisponiblidadPlataforma(produccion.getId(), plataforma.getCodigo()))){
                    cont ++;
                }
            }
        }
        return cont == plataformas.size();

    }
    /**
     * El metodo inserta en la tabla plataforma la plataforma
     *
     * @param plataforma es de la plataforma que queremos insertar
     * @return devuelve si a sido posible insertalo o no
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertPlataforma(Plataforma plataforma){
        String sql = "INSERT INTO plataforma (id, nombre, url, icono) VALUES (?,?,?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setNull(1, Types.INTEGER);
            ps.setString(2, plataforma.getNombre());
            ps.setNull(3, Types.NULL);
            ps.setNull(4, Types.NULL);

            int afectedRows = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int autoincremental = rs.getInt(1);
                plataforma.setCodigo(autoincremental);
            }

            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo inserta en la tabla disponibilidad_plataforma la plataforma y la produccion
     *
     * @param disponiblidadPlataforma es de la plataforma y produccion que queremos insertar
     * @return devuelve si a sido posible insertalo o no
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertDisponibilidadPlataforma(DisponiblidadPlataforma disponiblidadPlataforma){
        String sql = "INSERT INTO disponibilidad_plataforma (id_produccion, id_plataforma) VALUES (?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, disponiblidadPlataforma.getIdProduccion());
            ps.setInt(2, disponiblidadPlataforma.getIdPlataforma());

            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo busca por el nombre de la plataforma en la base de datos
     *
     * @param nombre es el nombre de la plataforma
     * @return devuelve la plataforma correspondiente
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    public Plataforma findByNombrePlataforma(String nombre){
        try {
            Connection connection = mySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = String.format("SELECT * FROM plataforma WHERE nombre LIKE '%s%%'", nombre);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return mapFromResulsetPlataforma(resultSet);
            }

            return null;
        } catch (SQLException e) {
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo mapeao la plataforma
     *
     * @param resultSet son los datos de la platadforma
     * @return devuelve la plataforma con los datos
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private Plataforma mapFromResulsetPlataforma(ResultSet resultSet){
        try{
            return new Plataforma(resultSet.getInt("id"), resultSet.getString("nombre"),
                    resultSet.getString("url"), resultSet.getString("icono"));
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo inserta en la tabla actores produccion la produccion y los actores de esta
     *
     * @param actores son los actores de la produccion
     * @param produccion es la produccion
     * @return devuelve si se han podido insertar
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertActoresProduccion(Actor actores, Produccion produccion){
        String sql = "INSERT INTO actores_producciones (id_produccion, id_actor) VALUES (?,?)";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1,produccion.getId());
            ps.setInt(2,actores.getCodigo());

            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
    /**
     * El metodo devuelve los actores o los inserta
     *
     * @param actores son los actores de la produccion
     * @return devuelve una lista de los actores
     */
    private ArrayList<Actor> getActores(ArrayList<Actor> actores){
        for (int i = 0; i < actores.size(); i++) {
            Actor actores1 = findByNombreActor(actores.get(i).getNombre());
            if(actores1 == null){
                insertActores(actores.get(i));
            }
        }
        ArrayList<Actor> actoresNews = new ArrayList<>();

        for (int i = 0; i < actores.size(); i++) {
            actoresNews.add(findByNombreActor(actores.get(i).getNombre()));
        }

        return actoresNews;
    }
    /**
     * El metodo inserta los extras de las plataformas
     *
     * @param plataforma es de la plataforma de la que queremos insertar los nuevos datos
     * @return devuelve si se han podido insertar
     * @throws DatabaseConnectionError si hay error en la conectividad en la base de datos
     */
    private boolean insertExtrasPlataformas(Plataforma plataforma) {
        String sql = "UPDATE plataforma set url = ?, icono = ? WHERE nombre = ?";
        String url;
        String icono;
        String nombre = plataforma.getNombre();
        switch (nombre) {
            case "HBO":
                url = "https://www.hbomax.com/";
                icono = "https://t1.gstatic.com/images?q=tbn:ANd9GcQVMPj1eYI6uhLfHTdLp5a_3CVuh91RU_9oGEPAUXmC96fPKDa7";
                break;
            case "Rakuten TV":
                url = "https://rakuten.tv/";
                icono = "https://play-lh.googleusercontent.com/83p_CXCRvPSQRcZQvFrPJYvDralOoYJiK-hP4zuK8ChjD0-F1e5Sc3kyVe-DjOMiHGs";
                break;
            case "Netflix":
                url = "https://www.netflix.com/es/";
                icono = "https://yt3.googleusercontent.com/haakxzxYsFMSdeXaCrA_Yag87fANjsALOmZwEqjxzeAeeLGVfZdVSbwhr1cGadkn5Qdy9fwA=s900-c-k-c0x00ffffff-no-rj";
                break;
            case "Amazon Prime Video":
                url = "https://www.primevideo.com/";
                icono = "https://play-lh.googleusercontent.com/Y7drWZZo_F2GBE1RhjR1irOkE3yrtPorHS1U9YkLKAu1DnTjQ8gNbcRmrBtkd3tnHQ";
                break;
            case "DISNEY +":
                url = "https://www.disneyplus.com/";
                icono = "https://i.pinimg.com/736x/5c/2c/f5/5c2cf5c486deffa55f5bdfc35054fb0d.jpg";
                break;
            case "Popcornflix":
                url = "https://popcornflix.com/";
                icono = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPiDgyFqThjTcsTxyWsP2r3hI2zSoRz-2j5MyRCOO48eMava6yKlALG80nhQYyvfth-q8&usqp=CAU";
                break;
            case "Apple TV+":
                url = "https://www.apple.com/es/apple-tv-plus/";
                icono = "https://www.apple.com/v/apple-tv-plus/ae/images/meta/apple-tv__e7aqjl2rqzau_og.png";
                break;
            default:
                return false;
        }

        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, url);
            ps.setString(2, icono);
            ps.setString(3, nombre);
            int afectedRows = ps.executeUpdate();
            return afectedRows > 0;
        } catch (SQLException e){
            throw new DatabaseConnectionError(e.getMessage());
        }
    }
}