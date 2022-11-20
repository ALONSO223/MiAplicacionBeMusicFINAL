
package datos;

import static conexion.Conexion.close;
import static conexion.Conexion.getConnection;
import dominio.Cancion;
import interfaces.InterfazUsuario;
import dominio.Usuario;
import interfaces.InterfazCancion;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 *
 * @author Alonso Pérez-Olleros Castillejo
 */

public class CancionDao implements InterfazCancion{
      
    private static final String SQL_SELECT = "SELECT * FROM Cancion";
    
    private static final String SQL_INSERT = "INSERT INTO Cancion ("
            + "nombre_cancion,"
            + "artista,"
            + "nombre_album,"
            + "portada,"
            + "duracion_cancion,"
            + "fecha_cancion"
            + ") VALUES (?,?,?,?,?,?)";
    
    private static final String SQL_UPDATE = "UPDATE Cancion SET "
            + "nombre_cancion = ?"
            + "artista = ?"
            + "nombre_album = ?"
            + "portada = ?"
            + "duracion_cancion = ?"
            + "fecha_cancion = ?"
            + "WHERE id_usuario = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Cancion WHERE id_cancion = ?";
    
    // Método que nos lista todas las personas de nuestro sistema

    @Override
    public List<Cancion> seleccionar() throws SQLException {
        
        // Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cancion cancion = null;
        List<Cancion> canciones = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
           
            int id_cancion = rs.getInt("id_cancion");
            String nombre_cancion = rs.getString("nombre_cancion");
            String artista = rs.getString("artista");
            String nombre_album = rs.getString("nombre_album");
            String portada = rs.getString("portada");
            int fecha_cancion = rs.getInt("fecha_cancion");
            Time duracion_cancion = rs.getTime("duracion_cancion");
            
            // Instacio un nuevo objeto
            canciones.add( new Cancion(id_cancion,nombre_cancion,artista,nombre_album,portada,duracion_cancion,fecha_cancion));
        }

        close(rs);
        close(stmt);
        close(conn);
        
        return canciones;
    }

    @Override
    public int insertar(Cancion cancion) throws SQLException{
                // Declaro e inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            //1. establecemos la conexion 
            conn = getConnection();
            
            //2. Preparo mi instruccion para ejecutarla con la base de datos 
            stmt = conn.prepareStatement(SQL_INSERT);
            //3. Asignamos los valores a los ? de la consulta
            stmt.setString(1,cancion.getNombre_cancion());
            stmt.setString(2,cancion.getArtista());
            stmt.setString(3,cancion.getNombre_album());
            stmt.setString(4,cancion.getPortada());
            stmt.setTime(5,cancion.getDuracion_cancion());
            stmt.setInt(6, cancion.getFecha_cancion());
            //stmt.setDate(8,usuario.getFecha_alta());
            //Ejecuto la query
            registros = stmt.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
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
        public int actualizar(Cancion cancion){
        //Inicializo mis componentes/variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1,cancion.getNombre_cancion());
            stmt.setString(2,cancion.getArtista());
            stmt.setString(3,cancion.getNombre_album());
            stmt.setString(4,cancion.getPortada());
            stmt.setTime(5,cancion.getDuracion_cancion());
            stmt.setInt(6, cancion.getFecha_cancion());
            
            
            registro = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally{
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
    public int eliminar (int id){
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