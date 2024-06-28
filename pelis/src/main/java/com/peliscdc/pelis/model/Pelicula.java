/**
 * @author JuanBallini
 */

package com.peliscdc.pelis.model;
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
    private String portada;

    // Constructor
    public Pelicula(Integer id, String titulo, Date fechaLanzamiento, Integer puntuacion, Time duracion,
            String descripcion, String idioma, Boolean estrenada, String portada) {
        this.id = id;
        this.titulo = titulo;
        this.fechaLanzamiento = fechaLanzamiento;
        this.puntuacion = puntuacion;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.idioma = idioma;
        this.estrenada = estrenada;
        this.portada = portada;
    }
    //constructor sin id
    public Pelicula(String titulo2, Date fechaLanzamiento2, Integer puntuacion2, Time duracion2, String descripcion2,
            String idioma2, Boolean estrenada2, String portada2) {
                this.titulo = titulo2;
                this.fechaLanzamiento = fechaLanzamiento2;
                this.puntuacion = puntuacion2;
                this.duracion = duracion2;
                this.descripcion = descripcion2;
                this.idioma = idioma2;
                this.estrenada = estrenada2;
                this.portada = portada2;
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

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getPortada() {
        return portada;
    }

}
