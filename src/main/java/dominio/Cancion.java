/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import static com.mycompany.miaplicacionbemusic.MiAplicacionBeMusic.menu;
import datos.CancionDao;
import com.mycompany.miaplicacionbemusic.MiAplicacionBeMusic;
import interfaces.InterfazCancion;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */


// posteriormente conectaremos la aplicacion al servidor api de Spotify 


public class Cancion implements Serializable{
    static Scanner ent = new Scanner(System.in);
    
    
    public int id_cancion;
    public String nombre_cancion;
    public String nombre_album; 
    public String artista;
    public String portada; //url conectado con la base de datos en la que esta el url de la imagen de la portada de la cancion IMAGEN
    public int fecha_cancion; //año de salida de la cancion
    public Time duracion_cancion; 
    
    public Cancion(int id_cancion, String nombre_cancion,String artista, String nombre_album, String portada, Time duracion_cancion, int fecha_cancion) {
        this.id_cancion = id_cancion;
        this.nombre_cancion = nombre_cancion;
        this.artista = artista;
        this.nombre_album = nombre_album;
        this.portada = portada;
        this.duracion_cancion = duracion_cancion;
        this.fecha_cancion = fecha_cancion;
        
    }

    public Cancion(String nombre_cancion, String nombre_album,String artista, String portada,Time duracion_cancion, int fecha_cancion) {
        this.nombre_cancion = nombre_cancion;
        this.nombre_album = nombre_album;
        this.artista = artista;
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
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
    
    public int getFecha_cancion() {
        return fecha_cancion;
    }

    public void setFecha_cancion(int fecha_cancion) {
        this.fecha_cancion = fecha_cancion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nombre_cancion);
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
        return Objects.equals(this.nombre_cancion, other.nombre_cancion);
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCancion{");
        sb.append("id_cancion=").append(id_cancion);
        sb.append(", nombre_cancion=").append(nombre_cancion);
        sb.append(", artista=").append(artista);
        sb.append(", nombre_album=").append(nombre_album);
        sb.append(", portada=").append(portada);
        sb.append(", duración cancion en segundos= ").append(duracion_cancion);
        sb.append(", fecha_cancion=").append(fecha_cancion);
        sb.append("} \n");
        return sb.toString();
    }

        public static void registrarCancion() throws SQLException {
        InterfazCancion cancionDao = new CancionDao();
            
        String nombre_cancion;
        String artista;
        String nombre_album;
        String portada;
        int fecha_cancion;
        String duracion_cancion;
        System.out.println("-----------------------------------------");
        System.out.println("--         REGISTRO CANCION           ---");
        System.out.println("-----------------------------------------");
        System.out.println("--Introduce nombre de la canción: ");
        nombre_cancion = ent.nextLine();
        System.out.println("--Artista: ");
        artista = ent.nextLine();
        System.out.println("--Nombre del album: ");
        nombre_album = ent.nextLine();
        System.out.println("--Portada del album/canción: ");
        portada = ent.nextLine();
        System.out.println("--Año de la canción: ");
        fecha_cancion = ent.nextInt();
        System.out.println("--Duración de la cancion(con el siguiente formato[HH:MM:SS]): ");
        duracion_cancion = ent.nextLine();
        duracion_cancion = ent.nextLine();
        Time duracion = Time.valueOf(duracion_cancion);

        Cancion cancionRegistro = new Cancion(nombre_cancion,artista, nombre_album, portada, duracion, fecha_cancion);

        if (nombre_cancion != null && fecha_cancion != 0 && duracion_cancion != null) {
            boolean esta = MiAplicacionBeMusic.canList.contains(cancionRegistro);
            if (esta == false) {
                cancionDao.insertar(cancionRegistro);
                MiAplicacionBeMusic.canList.add(cancionRegistro);
                System.out.println("Canción registrada y almacenada correctamente en la aplicación!");
                System.out.println("En cuanto la canción este verificada se podrá insertar en los posts.");
            } else if (esta == true) {
                System.out.println("La canción insertada ya se encuentra en la aplicación, \nporfavor introduzca una que todavia no esté registrada.");
                MiAplicacionBeMusic.menu();
            }
        } else {
            System.out.println("El nombre de la canción, el año y la duración son campos obligatorios,\n porfavor rellenelos para poder registrar la cancion correctament");
        }
    }
    
    
    
}
