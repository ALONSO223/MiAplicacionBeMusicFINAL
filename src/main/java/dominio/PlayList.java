/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.sql.Time;
import java.util.ArrayList;
import java.time.Duration;
import dominio.Cancion;

/**
 *
 * @author alooo
 */
public class PlayList {
    public int id_playlist;
    public ArrayList<Cancion> CancionesInsertadas = new ArrayList<>();
    public int contadoresPlayList;
    
    public PlayList(ArrayList<Cancion> cn){
        this.CancionesInsertadas = cn;
        this.id_playlist = id_playlist;
        this.contadoresPlayList = contadoresPlayList;
        incrementar();
        
    }
    
    public int incrementar(){
        return contadoresPlayList++;
    }

    public int getId_playlist() {
        return id_playlist;
    }

    public void setId_playlist(int id_playlist) {
        this.id_playlist = id_playlist;
    }

    public ArrayList<Cancion> getCancionesInsertadas() {
        return CancionesInsertadas;
    }

    public void setCancionesInsertadas(ArrayList<Cancion> CancionesInsertadas) {
        this.CancionesInsertadas = CancionesInsertadas;
    }

    public int getContadoresPlayList() {
        return contadoresPlayList;
    }

    public void setContadoresPlayList(int contadoresPlayList) {
        this.contadoresPlayList = contadoresPlayList;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayList{");
        sb.append("id_playlist=").append(id_playlist);
        sb.append(", CancionesInsertadas=").append(CancionesInsertadas);
        sb.append('}');
        return sb.toString();
    }

    public void agregarCancion(Cancion c){
        if(CancionesInsertadas.size()>5){
            System.out.println("No se pueden agregar más de 5 canciones a cada PlayList");
        }else{
            this.CancionesInsertadas.add(c);
        }
    }
    
    //Calculamos la duracion de toda la PlayList, necesitamos agregar
    //la duración de cada canción en forma de Campo en la Clase Cancion
   
    public double calcularDuracion(){
        int duracion = 0;
        for(Cancion dato: CancionesInsertadas){
            duracion = duracion + (dato.duracion_cancion.getMinutes()*60) + dato.duracion_cancion.getSeconds();
                   // ((duracion.getMinutes()*60)+duracion.getSeconds());
        }
        return duracion;
    }
    
     
    
    
}