package com.example.peliculas.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.peliculas.db.ConnectorDB;
import com.example.peliculas.model.Pelicula;

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

    //agregar pelicula a DB
    public Boolean addPeli(Pelicula peli) {
        try {
            Statement st=ConnectorDB.getSt();
            String sql = "INSERT INTO peliculas (titulo, puntuacion, descripcion, idioma, portada) " +
                    "VALUES ('" + peli.getTitulo() + "', '" + peli.getPuntuacion() +
                    "', '" + peli.getDescripcion() + "', '" + peli.getIdioma() + "', '" + peli.getPortada() + "')";

            Integer cantInsert = st.executeUpdate(sql);    
            Boolean insertOk = (cantInsert==1);
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



}

