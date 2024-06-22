/**
 * @author JuanBallini
 */

package com.example.peliculas.model;
import java.sql.Time;
import java.sql.Date;

public class Pelicula {
    private Integer id;
    private String titulo;
    private Date fechaLanzamiento;
    private Integer puntuacion;
    private Time duracion;
    private String descripcion;
    private String idioma;
    private Boolean estrenada;

    // Constructor
    public Pelicula(Integer id, String titulo, Date fechaLanzamiento, Integer puntuacion, Time duracion,
            String descripcion, String idioma, Boolean estrenada) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.puntuacion = puntuacion;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.idioma = idioma;
        this.estrenada = estrenada;
    }

    //Setters y Getters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Boolean getEstrenada() {
        return estrenada;
    }

    public void setEstrenada(Boolean estrenada) {
        this.estrenada = estrenada;
    }

    

    

}
