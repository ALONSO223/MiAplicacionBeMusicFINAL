/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static conexion.Conexion.close;
import static conexion.Conexion.getConnection;
import interfaces.InterfazUsuario;
import dominio.Usuario;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
 *
 * @author Alumno Mañana
 */
public class UsuarioDao implements InterfazUsuario{
      
    private static final String SQL_SELECT = "SELECT * FROM Usuario";
    
    private static final String SQL_INSERT = "INSERT INTO Usuario ("
            + "foto_perfil,"
            + "nombre_usuario,"
            + "contrasenna,"
            + "nombre,"
            + "apellidos,"
            + "correo,"
            + "telefono,"
            + "fecha_registro"
            + ") VALUES (?,?,?,?,?,?,?,?)";
    
    private static final String SQL_UPDATE = "UPDATE Usuario SET "
            + "foto_perfil = ?"
            + "nombre_usuario = ?"
            + "contrasenn = ?"
            + "nombre = ?"
            + "apellidos = ?"
            + "correo = ?"
            + "telefono = ?"
            + "fecha_alta = ?"
            + "WHERE id_usuario = ?";
    
    private static final String SQL_DELETE = "DELETE FROM Usuario WHERE id_usuario = ?";
    
    // Método que nos lista todas las personas de nuestro sistema

    @Override
    public  List<Usuario> seleccionar() throws SQLException {
        
        // Inicializo mis variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while (rs.next()){
            int id_usuario = rs.getInt("id_usuario");
            String foto_perfil = rs.getString("foto_perfil"); 
            String nombre_usuario = rs.getString("nombre_usuario");
            String nombre = rs.getString("nombre");
            String contrasenna = rs.getString("contrasenna");
            String apellidos = rs.getString("apellidos");
            String correo = rs.getString("correo");
            int telefono = rs.getInt("telefono");
            Date fecha_registro = rs.getDate("fecha_registro");
            
            
                     
            // Instacio un nuevo objeto
            usuarios.add(new Usuario(id_usuario,foto_perfil,nombre_usuario,contrasenna,nombre,apellidos,correo,telefono,fecha_registro));
        }

        close(rs);
        close(stmt);
        close(conn);
        
        return usuarios;
    }

    @Override
    public int  insertar(Usuario usuario) throws SQLException{
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
            stmt.setString(1,usuario.getFoto_perfil());
            stmt.setString(2,usuario.getNombre_usuario());
            stmt.setString(3,usuario.getContrasenna());
            stmt.setString(4,usuario.getNombre());        
            stmt.setString(5,usuario.getApellidos());
            stmt.setString(6,usuario.getCorreo());
            stmt.setInt(7,usuario.getTelefono());
            stmt.setDate(8, usuario.getFecha_registro());
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
        public int actualizar(Usuario usuario){
        //Inicializo mis componentes/variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, usuario.getFoto_perfil());
            stmt.setString(2, usuario.getNombre_usuario());
            stmt.setString(3, usuario.getContrasenna());
            stmt.setString(4, usuario.getNombre());
            stmt.setString(5, usuario.getApellidos());
            stmt.setString(6, usuario.getCorreo());
            stmt.setInt(7, usuario.getTelefono());
            
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
