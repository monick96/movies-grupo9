package com.example.peliculas.dao;

import java.sql.Statement;
import com.example.peliculas.db.MySQLConnector;
import java.sql.ResultSet;

/**
 * @author JuanBallini
 * Esta clase contiene las consultas/queries a la tabla "peliculas" de la base de datos
 */
public class PeliculaDAO {
    //atributo para ejecutar consultas sql
    private Statement st;
    
    //Constructor
    public PeliculaDAO() {
        //Creo una instancia de objeto de la clase MySQLConnector
        MySQLConnector mysql = new MySQLConnector();
        //Realizo la conexion a la base de datos y guardo el "statement" en st
        st = mysql.conectarseABaseDeDatos();
    }

    public void listarPeliculas(){
        try{
            //Realizo una consulta para traer los registros de la tabla "peliculas"
            ResultSet rs = st.executeQuery("SELECT * FROM peliculas");

            //Recorro cada uno de los registros de la tabla
            while (rs.next()) {
                System.out.println("id: " + rs.getString("id") + " titulo: " + rs.getString("titulo"));
            }
        } catch (Exception e) { //Ejecuta un error si el "try" no funciona
            e.printStackTrace();
        }
    }


}
