package com.example.peliculas;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.example.peliculas.dao.PeliculaDAO;
import com.example.peliculas.model.Pelicula;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        List<Pelicula> listaPelis = peliculaDAO.listarPeliculas();

        for (Pelicula peli : listaPelis) {
            System.out.println(peli.getTitulo());
            System.out.println(peli.getPortada());
        }
        //pruebas
        /* 
        //objeto peli ingresado
        //Pelicula nuevaPeli = new Pelicula(titulo,fechaLanzamiento, puntuacion,duracion,descripcion, idioma, estrenada, portada );
        //Date fechaLanzamiento = Date.valueOf("2023-06-27"); // Formato: yyyy-MM-dd
        //Time duracion = Time.valueOf("01:30:00"); // Formato: HH:mm:ss
        Pelicula nuevaPeli = new Pelicula(" pelicula223",fechaLanzamiento, 8,duracion,"descripcion", "idioma",true, "portada" );
        
        // llamo al método que agrega o inserta una película en la db
        Boolean insertOk=peliculaDAO.addPeli(nuevaPeli);
        if (insertOk) {
            System.out.println("Se insertó correctamente");
        } else {
            System.out.println("Error en la inserción");
        }
        */
        //eliminar una peli por id
        /* 
        System.out.println("Ingrese id de la película a eliminar");
        Integer idPeli =scanner.nextInt();
        // llamo al método que elimina una película en la db
        Boolean delOk=peliculaDAO.delPeli(idPeli);
        if (delOk) {
            System.out.println("Se elimino correctamente");
        } else {
            System.out.println("Error en la eliminacion");
        }
        */
        ///update peli
        /* 
        Pelicula peliUpdate = new Pelicula(101,"pelicula",new Date(0),5,new Time(500),"cscv","gsdg",false,"gsdgsdgsd");
        boolean updateOk = peliculaDAO.updatePeli(peliUpdate);
        if (updateOk) {
            System.out.println("Se actualizo correctamente");
        }
        */


    }
}