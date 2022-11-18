/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.miaplicacionbemusic;

import java.sql.SQLException;
import java.util.List;
import dominio.Usuario;
import datos.*;
import datosFichero.implementacion;
import interfaces.*;
import dominio.Cancion;
import dominio.PlayList;
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
    static List<Cancion> canList = new LinkedList<>();
    //Creo el objeto desde la clase Interfaz
    static InterfazUsuario usuarioDao = new UsuarioDao();
    static InterfazCancion cancionDao = new CancionDao();

    public static void main(String[] args) throws SQLException, ParseException {

        
        menu();
        
        
        /*
        try {
            List<Cancion> canciones = cancionDao.seleccionar();
            canciones.forEach(cancion -> {
                System.out.println("Cancion " + cancion.id_cancion + "= " + cancion);
                canList.add(cancion);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        System.out.println(canList);

        PlayList playlist1 = new PlayList();

        for (Cancion can : canList) {
            playlist1.agregarCancion(can);
        }

        String nombreArchivo = "PlayLists.txt";
        String contenido = playlist1.toString();
        implementacion imp = new implementacion();
        imp.crearArchivo(nombreArchivo);
        imp.escribirArchivoCancion(nombreArchivo, contenido);
        imp.leerArchivoCancion(nombreArchivo);
        */
        
        
        
        
        
        
        
        

        /*
        Date fCancion = Date.valueOf("2002-09-21");
        Time duracion =Time.valueOf("00:03:22");
        System.out.println((duracion.getMinutes()*60)+duracion.getSeconds());
        long segundo = System.currentTimeMillis();
        System.out.println(segundo);
        Cancion can = new Cancion("Joven Jugador","Last 2 People on Earth","url:portada",duracion,2020);
        Cancion can2 = new Cancion("More M's","Her Loss","url:portada",duracion,2022);
        Cancion can3 = new Cancion("Kurt Cobain","D.Valentino","url:portada",duracion,2022);
        
        //System.out.println(can);
        
        //menu();
        
        //cancionDao.insertar(can3);
        //cancionDao.eliminar(3);
        
        //Creamos el usuario, el id y la fecha de creacion del usuario se rellenan directamente
        Usuario usu1 = new Usuario ("url:foto_perfil","AlonsoCas","12345","Alonso","Pérez","alonso@gmail.com",678384810);
        
        //Insertamos el usuario creado en la base de datos
        //InterfazUsuario.insertar(usu1);
        usuarioDao.insertar(usu1);
        
        
        
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
                    registrarCancion();
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
            System.out.println("--         INTERFAZ USUARIO           ---");
            System.out.println("-----------------------------------------");
            System.out.println("--  1- PUBLICAR POST CANCION           --");
            System.out.println("--  2- COMENTAR                        --");
            System.out.println("--  3- CAMBIAR CORREO ELECTRONICO      --");
            System.out.println("--  4- BUSCAR USUARIO                  --");
            System.out.println("--  5- CREAR PLAYLIST (FORMATO .TXT)   --");
            System.out.println("--  0- SALIR                           --");
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
                case 4:

                    break;
                case 5:

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

    //Función para insertar un Usuario a la base de datos desde la terminal (menu1)
    //Función que conecta con la clase UsuarioDao para hacer uso del metodo insertar(Usuario)
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
        if (foto_perfil != null && nombreUsuario != null && contrasenna != null && nombre != null && apellidos != null && email != null && telefono != 0) {
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
    }

    public static void registrarCancion() throws SQLException {
        boolean control = true;
        //Usuario usu1 = new Usuario ("url:foto_perfil","AlonsoCas","12345","Alonso","Pérez","alonso@gmail.com",678384810);
        String nombre_cancion;
        String nombre_album;
        String portada;
        int fecha_cancion;
        String duracion_cancion;
        System.out.println("-----------------------------------------");
        System.out.println("--         REGISTRO CANCION           ---");
        System.out.println("-----------------------------------------");
        System.out.println("--Introduce nombre de la canción: ");
        nombre_cancion = ent.nextLine();
        nombre_cancion = ent.nextLine();
        System.out.println("--Nombre del album: ");
        nombre_album = ent.nextLine();
        System.out.println("--Portada del album/canción: ");
        portada = ent.nextLine();
        System.out.println("--Año de la canción: ");
        fecha_cancion = ent.nextInt();
        System.out.println("--Duración de la cancion(con el siguiente formato[HH:MM:SS]): ");
        duracion_cancion = ent.nextLine();
        duracion_cancion = ent.nextLine();
        Time duracion = Time.valueOf(duracion_cancion);

        Cancion cancionRegistro = new Cancion(nombre_cancion, nombre_album, portada, duracion, fecha_cancion);

        if (nombre_cancion != null && fecha_cancion != 0 && duracion_cancion != null) {
            for (Cancion can : canList) {
                if (cancionRegistro.equals(can) == true) {
                    control = true;
                } else {
                    control = false;
                }
            }
            if (control == false) {
                cancionDao.insertar(cancionRegistro);
                System.out.println("Canción registrada y almacenada correctamente en la aplicación!");
                System.out.println("En cuanto la canción este verificada se podrá insertar en los posts.");
            } else if (control == true) {
                System.out.println("La canción insertada ya se encuentra en la aplicación, \nporfavor introduzca una que todavia no esté registrada.");
                menu();
            }
        } else {
            System.out.println("El nombre de la canción, el año y la duración son campos obligatorios,\n porfavor rellenelos para poder registrar la cancion correctament");
        }
    }

    public static void iniciarUsuario() {
        String nombre;
        String contrasenna;
        System.out.println("-----------------------------------------");
        System.out.println("--         REGISTRO USUARIO           ---");
        System.out.println("-----------------------------------------");
        System.out.println("--Introduce Nombre de Usuario: ");
        nombre = ent.nextLine();
        nombre = ent.nextLine();
        for (Usuario usu : usuList) {
            if (nombre == usu.getNombre_usuario()) {
                System.out.println("--Introduce la contraseña de usuario con correo " + usu.getCorreo() + ":  ");
                contrasenna = ent.nextLine();
                if (contrasenna == usu.getContrasenna()) {
                    System.out.println("Contraseña introducida correctamente. Cuenta registrada correctamente.");
                    menuUsuario();
                } else {
                    System.out.println("Contraseña introducida incorrecta, intentalo de nuevo: ");
                    contrasenna = ent.nextLine();
                    break;
                }
            }
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
}
