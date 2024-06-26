package com.example.peliculas;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        //carga de todos los datos de las pelis
        // scanner para que el usuario ingrese datos de la peli
        Scanner scanner = new Scanner(System.in);
        /* 
        // ingreso de los datos
        System.out.println("Ingrese el título de la película");
        String titulo = scanner.nextLine();
        
        System.out.println("Ingrese fecha lanzamiento de la película en formato (yyyy-MM-dd)");
        String fechaString = scanner.nextLine();
        //Crear un objeto SimpleDateFormat parsear la fecha ingresada
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaUtil = null;
        try {
            fechaUtil = formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //fecha para sql
        java.sql.Date fechaLanzamiento  = new java.sql.Date(fechaUtil.getTime());
        
        //puntuacion
        System.out.println("Ingrese la puntuación de la película");
        Integer puntuacion=scanner.nextInt();

        System.out.println("Ingrese duracion de la película en horas");
        long tiempoHs = scanner.nextLong();
        long duracionMillis = tiempoHs * 3600000;//hs a milisegundos
        Time duracion = new Time(duracionMillis);

        System.out.println("Ingrese la descripcion de la película");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese idioma de la película");
        String idioma = scanner.nextLine();

        System.out.println("Se encuentra estrenada la película? (s o n)");
        String resp = scanner.nextLine().toLowerCase();
        Boolean estrenada = resp.equals("s")? true:false;

        System.out.println("Ingrese la url de la imágen de la película");
        String portada=scanner.nextLine();

        //objeto peli ingresado
        Pelicula nuevaPeli = new Pelicula(titulo,fechaLanzamiento, puntuacion,duracion,descripcion, idioma, estrenada, portada );
        
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

    }
}