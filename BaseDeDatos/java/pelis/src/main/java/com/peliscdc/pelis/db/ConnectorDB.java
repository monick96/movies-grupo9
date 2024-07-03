package com.peliscdc.pelis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectorDB {
    //atributo estatico que almacena la conexion a la db
    private static Connection conn;
    //atributo estatico para hacer consultas sql
    private static Statement st;

    //método statico para conectarse a la base de datos
    static{
        try {

            // Defino la conexion a la base de datos
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas", "root", "");

            // Creación de un statement para ejecutar consultas
            st = conn.createStatement();

        } catch (Exception e) { //Ejecuta un error si el "try" no funciona
            e.printStackTrace();
        }
        
    }
    //metodos getter /setters
    public static Connection getConn() {
        return conn;
    }

    public static Statement getSt() {
        return st;
    }
}
