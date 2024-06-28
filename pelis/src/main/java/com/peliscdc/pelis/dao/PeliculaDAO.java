package com.peliscdc.pelis.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.peliscdc.pelis.db.ConnectorDB;
import com.peliscdc.pelis.model.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author JuanBallini
 * Esta clase contiene las consultas/queries a la tabla "peliculas" de la base de datos
 */
public class PeliculaDAO {
    
    //metodo listar peli
    public List<Pelicula> listarPeliculas(){
        try{
        
            //El método getSt() devuelve el objeto Statement previamente 
            //creado en la clase ConnectorDB
            Statement st = ConnectorDB.getSt();

            //Realizo una consulta para traer los registros de la tabla "peliculas"
            ResultSet rs = st.executeQuery("SELECT * FROM peliculas");

            //array liat para almacenar las pelis obtenidas de la db
            List<Pelicula> pelis = new ArrayList<Pelicula>();

            //recorremos el result set que contiene los registros de la tabla peliculas
            while (rs.next()) {
                //convertimos los registros en objeto pelicula
                Pelicula peli = new Pelicula(rs.getInt("id"), rs.getString("titulo"),
                    rs.getDate("fechaLanzamiento"), rs.getInt("puntuacion"), 
                    rs.getTime("duracion"),rs.getString("descripcion"),
                    rs.getString("idioma"), rs.getBoolean("estrenada"), 
                    rs.getString("portada"));
                
                //agregamos la pelicula a la lista
                pelis.add(peli);
                
                //System.out.println("id: " + rs.getString("id") + " titulo: " + rs.getString("titulo") + " portada: " + rs.getString("portada"));
            }
            return pelis;
        } catch (Exception e) { //Ejecuta un error si el "try" no funciona
            e.printStackTrace();
            throw new RuntimeException("Error al obtener registros de la base de datos", e);
        }
        //return null;
    }

    // agregar pelicula a DB// todos los campos excepto id
    public Boolean addPeli(Pelicula peli) {
        try {
            
            Connection conn = ConnectorDB.getConn();
            
            String sql = "INSERT INTO peliculas (titulo, fechaLanzamiento, puntuacion, duracion, descripcion, idioma, estrenada, portada) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, peli.getTitulo());
            ps.setDate(2, peli.getFechaLanzamiento());
            ps.setInt(3, peli.getPuntuacion());
            ps.setTime(4, peli.getDuracion());
            ps.setString(5, peli.getDescripcion());
            ps.setString(6, peli.getIdioma());
            ps.setBoolean(7, peli.getEstrenada());
            ps.setString(8, peli.getPortada());

            Integer cantInsert = ps.executeUpdate();
            Boolean insertOk = (cantInsert == 1);
            return insertOk;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    //eliminar pelicula de DB
    public Boolean delPeli(Integer idpeli) {
        try {
            Statement st=ConnectorDB.getSt();
            String sql = ("DELETE FROM peliculas WHERE id = "+ idpeli);

            Integer cantDel = st.executeUpdate(sql);    
            Boolean delOk = (cantDel==1);
            return delOk;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    public Boolean updatePeli(Pelicula peli) {
        try {
            Statement st = ConnectorDB.getSt();

            // consulta SQL para actualizar una película
            String sql = "UPDATE peliculas SET " +
                    "titulo = '" + peli.getTitulo() + "', " +
                    "puntuacion = " + peli.getPuntuacion() + ", " +
                    "descripcion = '" + peli.getDescripcion() + "', " +
                    "idioma = '" + peli.getIdioma() + "', " +
                    "portada = '" + peli.getPortada() + "' " +
                    "WHERE id = " + peli.getId();

            // Ejecutamos la consulta 
            Integer cantUpdate = st.executeUpdate(sql);
            Boolean updateOk = (cantUpdate == 1);
            return updateOk;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la película en la base de datos", e);
        }
    }


}

