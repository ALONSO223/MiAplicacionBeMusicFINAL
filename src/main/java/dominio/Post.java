/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.io.Serializable;
import java.util.*;
import java.time.*;

/**
 *
 * @author Alumno Mañana
 */
public class Post implements Serializable{
    public int id_post;
    public String reacciones;
    public int valoracion_usuario;
    public String comentarios;
    public LocalDateTime hora;
    public int id_usuario;//FOREIGN KEY 
    public int id_reaccion; //FOREIGN KEY 
    
}
