/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import com.mycompany.miaplicacionbemusic.MiAplicacionBeMusic;
import static com.mycompany.miaplicacionbemusic.MiAplicacionBeMusic.usuList;
import datos.UsuarioDao;
import interfaces.InterfazUsuario;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class Usuario implements Serializable {

    static Scanner ent = new Scanner(System.in);

    public int id_usuario;
    public String foto_perfil;
    public String nombre_usuario;
    public String contrasenna;
    public String nombre;
    public String apellidos;
    public String correo;
    public int telefono;
    public Date fecha_registro;

    public Usuario(int id_usuario, String foto_perfil, String nombre_usuario, String contrasenna, String nombre, String apellidos, String correo, int telefono, Date fecha_registro) {
        this.id_usuario = id_usuario;
        this.foto_perfil = foto_perfil;
        this.nombre_usuario = nombre_usuario;
        this.contrasenna = contrasenna;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.foto_perfil = foto_perfil;
        this.fecha_registro = fecha_registro;

    }

    public Usuario(String foto_perfil, String nombre_usuario, String contrasenna, String nombre, String apellidos, String correo, int telefono) {
        this.foto_perfil = foto_perfil;
        this.nombre_usuario = nombre_usuario;
        this.contrasenna = contrasenna;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_registro = Date.valueOf(LocalDate.now());
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre_usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.nombre_usuario, other.nombre_usuario);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("id_usuario=").append(id_usuario);
        sb.append(", foto_perfil=").append(foto_perfil);
        sb.append(", nombre_usuario=").append(nombre_usuario);
        sb.append(", contrasenna=").append(contrasenna);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", correo=").append(correo);
        sb.append(", telefono=").append(telefono);
        sb.append(", fecha_registro=").append(fecha_registro);
        sb.append('}');
        return sb.toString();
    }

    //Función para insertar un Usuario a la base de datos desde la terminal (menu1)
    //Función que conecta con la clase UsuarioDao para hacer uso del metodo insertar(Usuario)
    public static void registrarUsuario() throws SQLException {
        InterfazUsuario usuarioDao = new UsuarioDao();
        String foto_perfil;
        String nombreUsuario;
        String contrasenna;
        String nombre;
        String apellidos;
        String email;
        int telefono;
        System.out.println("-----------------------------------------");
        System.out.println("--         REGISTRO USUARIO           ---");
        System.out.println("-----------------------------------------");
        System.out.println("--Introduce la url de la foto de perfil: ");
        foto_perfil = ent.nextLine();
        foto_perfil = ent.nextLine();
        System.out.println("--Nombre de usuario: ");
        nombreUsuario = ent.nextLine();
        System.out.println("--Contraseña: ");
        contrasenna = ent.nextLine();
        System.out.println("--Nombre: ");
        nombre = ent.nextLine();
        System.out.println("--Apellidos: ");
        apellidos = ent.nextLine();
        System.out.println("--Correo Electronico: ");
        email = ent.nextLine();
        System.out.println("--Telefono Movil: ");
        telefono = ent.nextInt();

        Usuario usuarioRegistro = new Usuario(foto_perfil, nombreUsuario, contrasenna, nombre, apellidos, email, telefono);
        //el usuario registro lo crea 
        if (nombreUsuario != null && contrasenna != null && nombre != null && apellidos != null && email != null && telefono != 0) {
            boolean esta = MiAplicacionBeMusic.usuList.contains(usuarioRegistro);
            if (esta == false) {
                usuarioDao.insertar(usuarioRegistro);
                MiAplicacionBeMusic.usuList.add(usuarioRegistro);
                System.out.println("Usuario registrado correctamente en la base de datos!");
            } else if (esta == true) {
                System.out.println("La dirección de correo o el nombre de usuairo o el telefono ya están en uso. Porfavor inserte datos no utilizados anteriormente");
                MiAplicacionBeMusic.menu();
            }
        } else {
            System.out.println("Los campos nombreUsuario, contrasenna, nombre, apellidos, email y telefono son obligatorios\n porfavor vuelve a registrar el usuario con los campos rellenados");
        }
    }



    public static List<Usuario> seleccionarUsuarios() {
        InterfazUsuario usuarioDao = new UsuarioDao();
        List<Usuario> usuarioLista = null;
        try {
            usuarioLista = usuarioDao.seleccionar();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return usuarioLista;
    }

    public static boolean esta(String nombre) {
        Usuario usuario = null;
        boolean esta = false;
        for (int i = 0; i < usuario.seleccionarUsuarios().size(); i++) {
            if (nombre.equals(usuario.seleccionarUsuarios().get(i).getNombre_usuario())) {
                esta = true;
            }
        }
        return esta;
        
    }
    
     public static int estaID(String nombre) {
        Usuario usuario = null;
        int id = 0;
        for (int i = 0; i < usuario.seleccionarUsuarios().size(); i++) {
            if (nombre.equals(usuario.seleccionarUsuarios().get(i).getNombre_usuario())) {
                id = usuario.seleccionarUsuarios().get(i).id_usuario;
            }
        }
        return id;
        
    }
     public static String estaContrasenna(String nombre) {
        Usuario usuario = null;
        String contra = "";
        for (int i = 0; i < usuario.seleccionarUsuarios().size(); i++) {
            if (nombre.equals(usuario.seleccionarUsuarios().get(i).getNombre_usuario())) {
                contra = usuario.seleccionarUsuarios().get(i).contrasenna;
            }
        }
        return contra;
        
    }
     
         public static boolean comparadorContrasennas(String orig, String compare){
    String md5 = null;
    try{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(compare.getBytes());
        byte[] digest = md.digest();
        md5 = new BigInteger(1, digest).toString(16);

        return md5.equals(orig);

    } catch (NoSuchAlgorithmException e) {
        return false;
    }

             
         }

}
