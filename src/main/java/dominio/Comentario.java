/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import com.mycompany.miaplicacionbemusic.MiAplicacionBeMusic;
import datos.ComentarioDao;
import interfaces.InterfazComentario;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;
import java.time.*;

/**
 *
 * @author Alumno Mañana
 */
public class Comentario implements Serializable {

    static Scanner ent = new Scanner(System.in);

    public int id_comentario;
    public String reacciones_foto;
    public int valoracion_usuario;
    public String comentario;
    public Date fecha_publicacion;
    public int id_post;
    public int id_usuario;//FOREIGN KEY 

    public Comentario(int id_comentario, String reacciones_foto, int valoracion_usuario, String comentario, Date fecha_publicacion, int id_usuario, int id_post) {
        this.id_comentario = id_comentario;
        this.reacciones_foto = reacciones_foto;
        this.valoracion_usuario = valoracion_usuario;
        this.comentario = comentario;
        this.fecha_publicacion = fecha_publicacion;
        this.id_usuario = id_usuario;
        this.id_post = id_post;
    }

    public Comentario(String reacciones_foto, int valoracion_usuario, String comentario, int id_usuario, int id_post) {
        this.reacciones_foto = reacciones_foto;
        this.valoracion_usuario = valoracion_usuario;
        this.comentario = comentario;
        this.fecha_publicacion = Date.valueOf(LocalDate.now());
        this.id_usuario = id_usuario;
        this.id_post = id_post;
    }

    public Comentario() {
    }

    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public int getValoracion_usuario() {
        return valoracion_usuario;
    }

    public void setValoracion_usuario(int valoracion_usuario) {
        this.valoracion_usuario = valoracion_usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentarios(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getReacciones_foto() {
        return reacciones_foto;
    }

    public void setReacciones_foto(String reacciones_foto) {
        this.reacciones_foto = reacciones_foto;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Post{");
        sb.append("id_comentario=").append(id_comentario);
        sb.append(", reacciones=").append(reacciones_foto);
        sb.append(", valoracion_usuario=").append(valoracion_usuario);
        sb.append(", comentario=").append(comentario);
        sb.append(", hora=").append(fecha_publicacion);
        sb.append(", id_usuario=").append(id_usuario);
        sb.append(", id_post=").append(id_post);
        sb.append('}');
        return sb.toString();
    }

    public static void publicarComentario(int id) throws SQLException {
        //Comentario(String reacciones_foto, int valoracion_usuario, String comentario, int id_usuario, int id_post)
        InterfazComentario postDao = new ComentarioDao();
        String reaccion = "url:";
        int valoracion = -1;
        String comentario;
        int id_post;
        System.out.println("-----------------------------------------");
        System.out.println("--           PUBLICAR POST            ---");
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        MiAplicacionBeMusic.visualizarPosts();
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");
        System.out.println("--Introduce el id del post que quieres comentar: ");
        id_post = ent.nextInt();
        if (Post.estaPost(id_post) == true) {
            ent.nextLine();
            System.out.println("Va a comentar este post " + Post.devolverPost(id_post) + ",\nEsta seguro de que quiere comentarlo? (S/N): ");
            String opcion = ent.nextLine();
            if ("S".equals(opcion.toUpperCase())) {
                System.out.println("--Introduce la foto para reaccionar si no quieres reaccionarlo con foto deja el apartado vacio: ");
                reaccion = ent.nextLine();
                System.out.println("--Introduce la valoracion (1-10) si no quieres valorarla deja el apartado vacio: ");
                valoracion = ent.nextInt();
                ent.nextLine();
                System.out.println("--Introduce el comentario que quieres publicar en el post, si no quieres publicar un comentario deja el apartado vacío: ");
                comentario = ent.nextLine();
                Comentario c = new Comentario(reaccion,valoracion,comentario,id,id_post);
                postDao.insertar(c);
                System.out.println("Comentario publicado correcatmente.");   
            }else{
                System.out.println("No se ha publoicado comentario, si quiere publicarlo vuelve a intentarlo.");
            }
        }else{
            System.out.println("No se ha encontrado el post con id"+id_post);
        }

    }

    public static List<Comentario> seleccionarComentario() {
        InterfazComentario comentarioDao = new ComentarioDao();
        List<Comentario> comentarioLista = null;
        try {
            comentarioLista = comentarioDao.seleccionar();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return comentarioLista;
    }

    public static int estaIDComentario(String comentario) {
        Comentario cm = null;
        int id = 0;
        for (int i = 0; i < cm.seleccionarComentario().size(); i++) {
            if (comentario.equals(cm.seleccionarComentario().get(i).getId_comentario())) {
                id = cm.getId_comentario();
            }
        }
        return id;

    }

}


