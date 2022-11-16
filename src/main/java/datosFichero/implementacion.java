/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datosFichero;

import dominio.Cancion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author alooo
 */
public class implementacion implements crud {

    @Override
    public void crearArchivo(String nombre) {
        File archivo = new File(nombre);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            System.out.println("Se ha creado el archivo correctamente.");
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void leerArchivoCancion(String nombreArchivo) {
        BufferedReader entrada = null;
         
        //Declaramos el archivo
        File archivo = new File (nombreArchivo);
        try {
            //Creamos el descriptor de lecctura del fichero
           entrada = new BufferedReader(new FileReader(archivo));
            String lectura= entrada.readLine();
            //recorremos lectura hasta fin de fichero
            while(lectura!=null){
                System.out.println("Lectura= "+lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch(IOException ex){
            ex.printStackTrace(System.out);
        }finally{
            
        }
        
    }

    @Override
    public void escribirArchivoCancion(String nombreArchivo, Cancion canci) {
        PrintWriter salida = null;
        File archivo = new File(nombreArchivo);

        try { //se que el fichero existe
            salida = new PrintWriter(archivo);
            salida.print(canci);
            System.out.println("Se ha escrito el archivo correctamente.");
        } catch (FileNotFoundException ex) { //el fichero existe => excepcion
            ex.printStackTrace(System.out);
        } finally { //siempre se ejecuta
            salida.close();
        }
    }

}
