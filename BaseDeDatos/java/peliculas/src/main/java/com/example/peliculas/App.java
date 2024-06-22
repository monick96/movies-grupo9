package com.example.peliculas;

import com.example.peliculas.dao.PeliculaDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        peliculaDAO.listarPeliculas();
    }
}
