package com.peliscdc.pelis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peliscdc.pelis.dao.PeliculaDAO;
import com.peliscdc.pelis.model.Pelicula;

@RestController
public class PeliculaController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarPeliculas")
    public List<Pelicula> listarPeliculas()
    {
        PeliculaDAO peliDao = new PeliculaDAO();
        return peliDao.listarPeliculas();

    }

}
