/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static conexion.Conexion.close;
import static conexion.Conexion.getConnection;
import dominio.Amigos;
import dominio.Post;
import interfaces.InterfazAmigos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alooo
 */
public class AmigosDao implements InterfazAmigos{
       
    private static final String SQL_SELECT = "SELECT * FROM Amigos";

    private static final String SQL_INSERT = "INSERT INTO Amigos ("
            + "idAmigo1,"
            + "idAmigo2,"
            + "fecha_amistad"
            + ") VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE Amigos SET "
            + "idAmigo1 = ?"
            + "idAmigo2 = ?"
            + "fecha_amistad = ?"
            + "WHERE id_amistad = ?";

    private static final String SQL_DELETE = "DELETE FROM Amigos WHERE id_amistad = ?";

    // Método que nos lista todas las personas de nuestro sistema
    @Override
    public List<Amigos> seleccionar() throws SQLException {

        // Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Amigos amistad = null;
        List<Amigos> amigos = new ArrayList<>();

        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();

        while (rs.next()) {
            
            int id_amistad = rs.getInt("id_amistad");
            int idAmigo1 = rs.getInt("idAmigo1");
            int idAmigo2 = rs.getInt("idAmigo2");
            Date fecha_amistad = rs.getDate("fecha_amistad");

            
            // Instacio un nuevo objeto
            amigos.add(new Amigos(id_amistad,idAmigo1,idAmigo2,fecha_amistad));
        }

        close(rs);
        close(stmt);
        close(conn);

        return amigos;
    }

    @Override
    public int insertar(Amigos amigos) throws SQLException {
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
            
            stmt.setInt(1, amigos.getIdAmigo1());
            stmt.setInt(2, amigos.getIdAmigo2());
            stmt.setDate(3,amigos.getFecha_amistad());

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
    public int actualizar(Amigos amigos) {
        //Inicializo mis componentes/variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setInt(1, amigos.getIdAmigo1());
            stmt.setInt(2, amigos.getIdAmigo2());
            stmt.setDate(3,amigos.getFecha_amistad());

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
