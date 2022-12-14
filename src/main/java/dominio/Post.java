/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import datos.PostDao;
import interfaces.InterfazPost;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class Post implements Serializable {

    static Scanner ent = new Scanner(System.in);
    public int id_post;
    public Date fecha_publicacion;
    public int id_usuario; //FOREIGN KEY 
    public int id_cancion; //FOREIGN KEY 
    public String descripcion;

    public Post() {
    }
    
    

    public Post(int id_post, Date fecha_publicacion, int id_usuario, int id_cancion, String descripcion) {
        this.id_post = id_post;
        this.fecha_publicacion = fecha_publicacion;
        this.id_usuario = id_usuario;
        this.id_cancion = id_cancion;
        this.descripcion = descripcion;
    }

    public Post(int id_usuario, int id_cancion, String descripcion) {

        this.fecha_publicacion = Date.valueOf(LocalDate.now());
        this.id_usuario = id_usuario;
        this.id_cancion = id_cancion;
        this.descripcion = descripcion;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_cancion() {
        return id_cancion;
    }

    public void setId_cancion(int id_cancion) {
        this.id_cancion = id_cancion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post{");
        sb.append("id_post=").append(id_post);
        sb.append(", fecha_publicacion=").append(fecha_publicacion);
        sb.append(", id_usuario=").append(id_usuario);
        sb.append(", id_cancion=").append(id_cancion);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }

    public static void publicarPost(int id) throws SQLException {
        InterfazPost postDao = new PostDao();
        String nombre_cancion;
        String descripcion = "";
        int id_cancion = -1;
        ent.nextLine();
        System.out.println("-----------------------------------------");
        System.out.println("--           PUBLICAR POST            ---");
        System.out.println("-----------------------------------------");
        System.out.println("--Introduce el nombre de la cancion : ");
        
        nombre_cancion = ent.nextLine();
        if (Cancion.estaCancion(nombre_cancion) == true) {
            id_cancion = Cancion.estaIDCancion(nombre_cancion);
            System.out.println("Introduce descripcion del post: ");
            descripcion = ent.nextLine();
        } else {
            System.out.println("El nombre de la cancion no se encuentra en el sistema.");
        }
        if (id_cancion != -1) {
            Post post = new Post(id, id_cancion, descripcion);
            postDao.insertar(post);
            System.out.println("Post publicado correctamente");
        } else {
            System.out.println("No se ha publicado el post");
        }

    }
    
    
    public static List<Post> seleccionarPost() {
        InterfazPost postDao = new PostDao();
        List<Post> postLista = null;
        try {
            postLista = postDao.seleccionar();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return postLista;
    }
    
    
    public static boolean estaPost(int id) {
        Post p = null;
        boolean esta = false;
        for (int i = 0; i < p.seleccionarPost().size(); i++) {
            if (id==p.seleccionarPost().get(i).getId_post()){
                esta = true;
            }
        }
        return esta;
        
    }
    
    
    public static Post devolverPost(int id){
        Post p = new Post();
        for (int i = 0; i < p.seleccionarPost().size(); i++) {
            if(id == p.seleccionarPost().get(i).getId_usuario()){
                p = p.seleccionarPost().get(i);
            }
        }
        return p;
    }

}
