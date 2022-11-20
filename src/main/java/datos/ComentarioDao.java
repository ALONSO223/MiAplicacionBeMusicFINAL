/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static conexion.Conexion.close;
import static conexion.Conexion.getConnection;
import dominio.Comentario;
import interfaces.InterfazComentario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class ComentarioDao implements InterfazComentario {

    private static final String SQL_SELECT = "SELECT * FROM Comentario";

    private static final String SQL_INSERT = "INSERT INTO Comentario ("
            + "reacciones_foto,"
            + "valoracion_usuario,"
            + "comentario,"
            + "fecha_publicacion,"
            + "usuario_id_usuario,"
            + "post_id_post"
            + ") VALUES (?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE Comentario SET "
            + "reacciones_foto = ?"
            + "valoracion_usuario = ?"
            + "comentario = ?"
            + "fecha_publicacion = ?"
            + "usuario_id_usuario = ?"
            + "post_id_post = ?"
            + "WHERE id_comentario = ?";

    private static final String SQL_DELETE = "DELETE FROM Comentario WHERE id_comentario = ?";

    // Método que nos lista todas las personas de nuestro sistema
    @Override
    public List<Comentario> seleccionar() throws SQLException {

        // Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Comentario comentario1 = null;
        List<Comentario> comentarios = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {

            int id_comentario = rs.getInt("id_comentario");
            String reacciones_foto = rs.getString("reacciones_foto");
            int valoracion_usuario = rs.getInt("valoracion_usuario");
            String comentario = rs.getString("comentario");
            Date fecha_publicacion = rs.getDate("fecha_publicacion");
            int id_usuario = rs.getInt("usuario_id_usuario");
            int id_post = rs.getInt("post_id_post");

            // Instacio un nuevo objeto
            comentarios.add(new Comentario(id_comentario, reacciones_foto, valoracion_usuario, comentario, fecha_publicacion, id_usuario, id_post));
        }

        close(rs);
        close(stmt);
        close(conn);

        return comentarios;
    }

    @Override
    public int insertar(Comentario comentario) throws SQLException {
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
            stmt.setString(1, comentario.getReacciones_foto());
            stmt.setInt(2, comentario.getValoracion_usuario());
            stmt.setString(3, comentario.getComentario());
            stmt.setDate(4, comentario.getFecha_publicacion());
            stmt.setInt(5, comentario.getId_usuario());
            stmt.setInt(6, comentario.getId_post());

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
    public int actualizar(Comentario comentario) {
        //Inicializo mis componentes/variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, comentario.getReacciones_foto());
            stmt.setInt(2, comentario.getValoracion_usuario());
            stmt.setString(3, comentario.getComentario());
            stmt.setDate(4, comentario.getFecha_publicacion());
            stmt.setInt(5, comentario.getId_usuario());
            stmt.setInt(6, comentario.getId_post());

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
