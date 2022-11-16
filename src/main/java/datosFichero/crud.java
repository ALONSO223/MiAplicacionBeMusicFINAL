/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosFichero;

import dominio.Cancion;

/**
 *
 * @author alooo
 */
public interface crud {
    
    public abstract void crearArchivo(String nombre);
    public abstract void leerArchivoCancion(String nombreArchivo);
    public abstract void escribirArchivoCancion(String nombreArchivo, Cancion canci);
    
}
