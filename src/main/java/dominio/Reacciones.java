/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author Alumno Mañana
 */
public class Reacciones implements Serializable{
    public int id_reaccion;
    public String comentario;
    public int valoracion;
    public String reaccion; //reaccion con foto
    public int id_post; //FOREIGN KEY 
    
    
    
}
