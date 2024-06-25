package com.example.peliculas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnector {

    //Creo un método para conectarse a la base de datos
    public Statement conectarseABaseDeDatos(){
        try {

            // Defino la conexion a la base de datos
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas", "root", "");

            // Creación de un statement para ejecutar consultas
            Statement statement = connection.createStatement();

            //Devuelvo el objeto "statement"
            return statement;

        } catch (Exception e) { //Ejecuta un error si el "try" no funciona
            e.printStackTrace();

            // Opcional: lanzar una RuntimeException para propagar el error de conexion
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
        
        //return null;
    }
}
