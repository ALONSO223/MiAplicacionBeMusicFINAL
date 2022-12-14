/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static conexion.Conexion.close;
import static conexion.Conexion.getConnection;
import dominio.Comentario;
import dominio.Post;
import interfaces.InterfazPost;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class PostDao implements InterfazPost{
    
    private static final String SQL_SELECT = "SELECT * FROM Post";

    private static final String SQL_INSERT = "INSERT INTO Post ("
            + "fecha_publicacion,"
            + "usuario_id_usuario,"
            + "canciones_id_cancion,"
            + "descripcion"
            + ") VALUES (?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE Post SET "
            + "fecha_publicacion = ?"
            + "usuario_id_usuario = ?"
            + "canciones_id_cancion = ?"
            + "descripcion = ?"
            + "WHERE id_post = ?";

    private static final String SQL_DELETE = "DELETE FROM Post WHERE id_post = ?";

    // Método que nos lista todas las personas de nuestro sistema
    @Override
    public List<Post> seleccionar() throws SQLException {

        // Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Post post = null;
        List<Post> posts = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            
            int id_post = rs.getInt("id_post");
            Date fecha_publicacion = rs.getDate("fecha_publicacion");
            int id_usuario = rs.getInt("usuario_id_usuario");
            int id_cancion = rs.getInt("canciones_id_cancion");
            String descripcion = rs.getString("descripcion");
            
            // Instacio un nuevo objeto
            posts.add(new Post(id_post,fecha_publicacion,id_usuario,id_cancion,descripcion));
        }

        close(rs);
        close(stmt);
        close(conn);

        return posts;
    }

    @Override
    public int insertar(Post post) throws SQLException {
        // Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            //1. establecemos la conexion 
            conn = getConnection();

            //2. Preparo mi instruccion para ejecutarla con la base de datos 
            stmt = conn.prepareStatement(SQL_INSERT);
            //3. Asignamos los valores a los ? de la consulta
            
            stmt.setDate(1, post.getFecha_publicacion());
            stmt.setInt(2, post.getId_usuario());
            stmt.setInt(3,post.getId_cancion());
            stmt.setString(4, post.getDescripcion());

            //Ejecuto la query
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int actualizar(Post post) {
        //Inicializo mis componentes/variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setDate(1, post.getFecha_publicacion());
            stmt.setInt(2, post.getId_usuario());
            stmt.setInt(3,post.getId_cancion());
            stmt.setString(4, post.getDescripcion());


            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    @Override
    public int eliminar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, id);

            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registro;
    }
    
}
