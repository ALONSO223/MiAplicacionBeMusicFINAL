/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

/**
 *
 * @author Alumno Mañana
 */


// posteriormente conectaremos la aplicacion al servidor api de Spotify 


public class Cancion implements Serializable{
    public int id_cancion;
    public String nombre_cancion;
    public String nombre_album; 
    public String portada; //url conectado con la base de datos en la que esta el url de la imagen de la portada de la cancion IMAGEN
    public Date fecha_cancion;
    public Time duracion_cancion; 
    
    public Cancion(int id_cancion, String nombre_cancion, String nombre_album, String portada, Time duracion_cancion, Date fecha_cancion) {
        this.id_cancion = id_cancion;
        this.nombre_cancion = nombre_cancion;
        this.nombre_album = nombre_album;
        this.portada = portada;
        this.duracion_cancion = duracion_cancion;
        this.fecha_cancion = fecha_cancion;
        
    }

    public Cancion(String nombre_cancion, String nombre_album, String portada,Time duracion_cancion, Date fecha_cancion) {
        this.nombre_cancion = nombre_cancion;
        this.nombre_album = nombre_album;
        this.portada = portada;
        this.duracion_cancion = duracion_cancion;
        this.fecha_cancion = fecha_cancion;
        
    }

    
    
    public Cancion() {
    }

    public int getId_cancion(){
        return id_cancion;
    }
    

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getNombre_album() {
        return nombre_album;
    }

    public void setNombre_album(String nombre_album) {
        this.nombre_album = nombre_album;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public Time getDuracion_cancion() {
        return duracion_cancion;
    }

    public void setDuracion_cancion(Time duracion_cancion) {
        this.duracion_cancion = duracion_cancion;
    }
    
    

    public Date getFecha_cancion() {
        return fecha_cancion;
    }

    public void setFecha_cancion(Date fecha_cancion) {
        this.fecha_cancion = fecha_cancion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id_cancion;
        hash = 97 * hash + Objects.hashCode(this.nombre_cancion);
        hash = 97 * hash + Objects.hashCode(this.nombre_album);
        hash = 97 * hash + Objects.hashCode(this.portada);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        if (this.id_cancion != other.id_cancion) {
            return false;
        }
        if (!Objects.equals(this.nombre_cancion, other.nombre_cancion)) {
            return false;
        }
        if (!Objects.equals(this.nombre_album, other.nombre_album)) {
            return false;
        }
        return Objects.equals(this.portada, other.portada);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cancion{");
        sb.append("id_cancion=").append(id_cancion);
        sb.append(", nombre_cancion=").append(nombre_cancion);
        sb.append(", nombre_album=").append(nombre_album);
        sb.append(", portada=").append(portada);
        sb.append(", duración cancion en segundos= ").append(duracion_cancion);
        sb.append(", fecha_cancion=").append(fecha_cancion);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
