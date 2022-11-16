/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.miaplicacionbemusic;

import java.sql.SQLException;
import java.util.List;
import dominio.Usuario;
import datos.UsuarioDao;
import datos.*;
import dominio.Cancion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.System.exit;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alonso Pérez-Olleros Castillejo
 */
public class MiAplicacionBeMusic {

    static Scanner ent = new Scanner(System.in);

    static List<Usuario> usuList = new LinkedList<>();
    static UsuarioDao usuarioDao = new UsuarioDao();
    static CancionDao cancionDao = new CancionDao();

    public static void main(String[] args) throws SQLException, ParseException {

        Date fCancion = Date.valueOf(LocalDate.now());
        Time duracion =Time.valueOf("00:03:22");
        System.out.println((duracion.getMinutes()*60)+duracion.getSeconds());
        long segundo = System.currentTimeMillis();
        System.out.println(segundo);
        Cancion can = new Cancion("Joven Jugador","Last 2 People on Earth","url:portada",duracion,fCancion);
        
        System.out.println(can);
        
        
        
        /*
        //cancionDao.insertar(can);
        try {
            List<Cancion> canciones = cancionDao.seleccionar();
            canciones.forEach(cancion -> {
                System.out.println("Cancion " + cancion.id_cancion + "= " + cancion);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //Visualizo todos los usuarios de la lista de usuariosDao
        try {
            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario -> {
                System.out.println("Usuario " + usuario.id_usuario + "= " + usuario);
                usuList.add(usuario);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        //comprobamos porque no se ejecuta la comproboacion de usuario repetido, llego a la conclusion que por el equals, el equals necesita tener todos los campos introducidos iguales para que devuelva true.
        Usuario usuarioLola = new Usuario("url", "nombre_usu", "1234", "lola", "lolita", "correo", 23423);

        for (Usuario usu : usuList) {
            System.out.println(usu.equals(usuarioLola));
        }
        */
        //menu();
        //usuarioDao.eliminar();

        /*
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String fechaNac = "12/03/2002";
        java.util.Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
         */
 /*
        //Creamos el usuario, el id y la fecha de creacion del usuario se rellenan directamente
        Usuario usu1 = new Usuario ("url:foto_perfil","AlonsoCas","12345","Alonso","Pérez","alonso@gmail.com",678384810);
        
        //Insertamos el usuario creado en la base de datos
        usuarioDao.insertar(usu1);
        
        //Visualizo un usuario de la bsae de datos
        System.out.println(usuarioDao.seleccionar());

        
        //Visualizo todos los usuarios de la lista de usuariosDao
        try {
            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario -> {
                    System.out.println("persona = " + usuario);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
              
         */
    }

    public static void menu() throws SQLException {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("--    APLPICACION BEMUSIC    ---");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  1-  REGISTRAR USUARIO              --");
            System.out.println("--  2-  INICIAR SESION                 --");
            System.out.println("--  3-  REGISTRAR CANCION              --");
            System.out.println("--  4-  INICIAR SESION ADMIN           --");
            System.out.println("--  0-  SALIR                          --");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  Introduce opción: ");
            opcion = ent.nextInt();
            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarUsuario();
                    break;
                case 3:
                    //registrarCancion();
                    break;
                case 4:
                    inicioAdmin();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nIntroduzca un número entre 0 y 5");
                    break;
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("");
            }
        }
    }

    public static void menuUsuario() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("--    INTERFAZ USUARIO                ---");
            System.out.println("-----------------------------------------");
            System.out.println("--  1- PUBLICAR POST CANCION           --");
            System.out.println("--  2- COMENTAR                        --");
            System.out.println("--  0-  SALIR                          --");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  Introduce opción: ");
            opcion = ent.nextInt();
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nIntroduzca un número entre 0 y 5");
                    break;
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("");
            }
        }

    }

    public static void menuAdmin() throws SQLException {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("--    APLPICACION BEMUSIC             ---");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  1-  VER USUARIOS REGISTRADOS       --");
            System.out.println("--  2-  VER CANCIONES PUBLICADAS       --");
            System.out.println("--  3-  ELIMINAR CANCIONES             --");
            System.out.println("--  3-  ELIMINAR USUARIO               --");
            System.out.println("--  0-  SALIR                          --");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  Introduce opción: ");
            opcion = ent.nextInt();
            switch (opcion) {
                case 1:
                    List<Usuario> usuarios = usuarioDao.seleccionar();
                    usuarios.forEach(usuario -> {
                        System.out.println("persona = " + usuario);
                    }
                    );
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nIntroduzca un número entre 0 y 5");
                    break;
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("");
            }
        }

    }

    public static void registrarUsuario() throws SQLException {
        boolean control = true;
        //Usuario usu1 = new Usuario ("url:foto_perfil","AlonsoCas","12345","Alonso","Pérez","alonso@gmail.com",678384810);
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
        for (Usuario usu : usuList) {
            if (usuarioRegistro.equals(usu) == true) {
                control = true;
            } else {
                control = false;
            }
        }
        if (control == false) {
            usuarioDao.insertar(usuarioRegistro);
            System.out.println("Usuario registrado correctamente en la base de datos!");
        } else if (control == true) {
            System.out.println("La dirección de correo o el nombre de usuairo o el telefono ya están en uso. Porfavor inserte datos no utilizados anteriormente");
            menu();
        }
    }

    public static void inicioAdmin() throws SQLException {
        int contrasenna = 1234;
        int contra;
        System.out.println("");
        System.out.println("Introduce contraseña: ");
        contra = ent.nextInt();
        if (contrasenna == contra) {
            menuAdmin();
        } else {
            System.out.println("Contraseña introducida incorrecta");
            menu();
        }

    }

    public static void iniciarUsuario() {

        menuUsuario();

    }
}
