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
        //carga de todos los datos de las pelis por scanner
        // scanner para que el usuario ingrese datos de la peli
        Scanner scanner = new Scanner(System.in);
        /* 
        // ingreso de los datos
        System.out.println("Ingrese el título de la película");
        String titulo = scanner.nextLine();
        */
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
        /*
        //puntuacion
        System.out.println("Ingrese la puntuación de la película");
        Integer puntuacion=scanner.nextInt();
        */
        System.out.println("Ingrese duracion de la película en formato (HH:mm:ss)");
        String tiempoString = scanner.nextLine();
        //convertimos a localtime
        LocalTime duracionLocal = LocalTime.parse(tiempoString,DateTimeFormatter.ofPattern("HH:mm:ss"));
        //convertimos a time
        Time duracion = Time.valueOf(duracionLocal);
        /*
        System.out.println("Ingrese la descripcion de la película");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese idioma de la película");
        String idioma = scanner.nextLine();

        System.out.println("Se encuentra estrenada la película? (s o n)");
        String resp = scanner.nextLine().toLowerCase();
        Boolean estrenada = resp.equals("s")? true:false;

        System.out.println("Ingrese la url de la imágen de la película");
        String portada=scanner.nextLine();
        */
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