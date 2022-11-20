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
import dominio.Comentario;
import dominio.PlayList;
import dominio.Post;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.System.exit;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public static List<Usuario> usuList = new LinkedList<>();
    public static List<Cancion> canList = new LinkedList<>();
    public static List<Post> postList = new LinkedList<>();
    public static List<Comentario> comList = new LinkedList<>();
    //Creo el objeto desde la clase Interfaz
    static InterfazUsuario usuarioDao = new UsuarioDao();
    static InterfazCancion cancionDao = new CancionDao();
    static InterfazPost postDao = new PostDao();
    static InterfazComentario comentarioDao = new ComentarioDao();

    public static void main(String[] args) throws SQLException, ParseException {
        Time duracion = Time.valueOf("00:03:22");
        Cancion can1 = new Cancion("ALL NIGHT LONG", "Lancey Fox", "LIFE IN HELL", "URL:", duracion, 2022);
        Cancion can2 = new Cancion("SPIRIT OF X2C", "Lancey Fox", "LIFE IN HELL", "URL:", duracion, 2022);
        Cancion can3 = new Cancion("DID IT AGAIN", "Lancey Fox", "LIFE IN HELL", "URL:", duracion, 2022);
        Cancion can4 = new Cancion("WORLD ON FIRE", "Lancey Fox", "LIFE IN HELL", "URL:", duracion, 2022);
        Cancion can5 = new Cancion("SUN MOON", "Lancey Fox", "LIFE IN HELL", "URL:", duracion, 2022);

        System.out.println(Usuario.devolverUsuario(32));

        System.out.println(Cancion.estaCancion("ALL NIGHT LONG"));
        System.out.println(Cancion.estaIDCancion("ALL NIHGT LONG"));
        System.out.println(Usuario.estaContrasenna("alex32"));

        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {

            System.out.println(usuario);
        }
        );
        List<Cancion> canciones = cancionDao.seleccionar();
        canciones.forEach(cancion -> {

            System.out.println(cancion);
        }
        );

        List<Comentario> comentarios = comentarioDao.seleccionar();
        comentarios.forEach(comentario -> {

            System.out.println(comentario);
        }
        );

        List<Post> posts = postDao.seleccionar();
        posts.forEach(post -> {

            System.out.println(post);
        }
        );

        //menu();
        /*
        
        
                String nombre = "alex32";
        Usuario usu = null;
        if (Usuario.esta(nombre) == true) {
            System.out.println(Usuario.estaID(nombre));
        }
        
        
        List<Cancion> canciones = cancionDao.seleccionar();
        canciones.forEach(cancion -> {
            System.out.println("cancion = " + cancion);
            canList.remove(cancion);
            cancionDao.eliminar(cancion.id_cancion);
        }
        );
        
        visualizarUsuarios();
         
        Usuario usu1 = new Usuario ("url:foto_perfil","alonso_2022","12345","Alonso","Pérez","alonso@gmail.com",678384810);
        Usuario usu2 = new Usuario ("url:foto_perfil","alex32","12345","Alejandro","Perez","alejandro@gmail.com",654321098);
        
        usuarioDao.insertar(usu2);
        
        
        
        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {

            usuList.remove(usuario);
            usuarioDao.eliminar(usuario.id_usuario);
        }
        );
        
        visualizarUsuarios();
        
        
        
        List<Cancion> canciones = cancionDao.seleccionar();
        canciones.forEach(cancion -> {

            canList.add(cancion);
        }
        );

        List<Comentario> comentarios = comentarioDao.seleccionar();
        comentarios.forEach(comentario -> {

            comList.add(comentario);
        }
        );

        List<Post> posts = postDao.seleccionar();
        posts.forEach(post -> {

            postList.add(post);
        }
        );
         */
 /*
        Post post1 = new Post(1, 3, "Cancion que he escuchado hoy y me ha recordado a verano");
        postDao.insertar(post1);

        Comentario comnen = new Comentario("url:reaccion", 8, "Me gusta mucho esta cancion!!", 1, 23);
        comentarioDao.insertar(comnen);

 Time duracion = Time.valueOf("00:03:22");
        Cancion cancion = new Cancion("Joven ", "D.Valentino", "Kendrick Lamar", "url:", duracion, 2022);

        visualizarCanciones();
        boolean esta = canList.contains(cancion);
        System.out.println(esta);
        //menu();
         */
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
                    Usuario.registrarUsuario();
                    break;
                case 2:
                    iniciarUsuario();
                    break;
                case 3:
                    Cancion.registrarCancion();
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

    public static void menuUsuario(int id) throws SQLException {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("--         INTERFAZ USUARIO           ---");
            System.out.println("-----------------------------------------");
            System.out.println("--  1- PUBLICAR POST CANCION           --"); //necesario id
            System.out.println("--  2- COMENTAR                        --"); //necesario id
            System.out.println("--  3- CAMBIAR CORREO ELECTRONICO      --"); //necesario id 
            System.out.println("--  4- BUSCAR USUARIO                  --"); //necesario id de otro usuario 
            System.out.println("--  5- CREAR PLAYLIST (FORMATO .TXT)   --"); //terminado
            System.out.println("--  6- ELIMINAR CUENTA                 --"); //terminado
            System.out.println("--  0- SALIR                           --");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  Introduce opción: ");
            opcion = ent.nextInt();
            switch (opcion) {
                case 1:
                    Post.publicarPost(id);
                    break;
                case 2:
                    System.out.println(id);
                    break;
                case 3:
                    actualizarCorreo(id);
                    break;
                case 4:

                    break;
                case 5:
                    crearPlaylist();
                    break;
                case 6:
                    System.out.println("Esta seguro de querer eliminar la cuenta?(S/N)");
                    String op = ent.nextLine();
                    if (op.toUpperCase() == "S") {
                        usuarioDao.eliminar(id);
                        System.out.println("Cuenta eliminada correctamente.");
                    } else if (op.toUpperCase() == "N") {
                        System.out.println("Cuenta no eliminada.");
                        return;
                    } else {
                        System.out.println("No introduciste correctamente las opciiones por lo que no se elimiará la cuenta, intentalo otra vez.");
                    }

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
        int id;
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("-----------------------------------------");
            System.out.println("--      INTERFAZ ADMINISTRADOR        ---");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  1-  VER USUARIOS REGISTRADOS       --");
            System.out.println("--  2-  VER CANCIONES PUBLICADAS       --");
            System.out.println("--  3-  VER POSTS PUBLICADOS           --");
            System.out.println("--  4-  VER COMENTARIOS PUBLICADOS     --");
            System.out.println("--  5-  ELIMINAR CANCIONES             --");
            System.out.println("--  6-  ELIMINAR USUARIO               --");
            System.out.println("--  0-  SALIR                          --");
            System.out.println("-----------------------------------------");
            System.out.println("-----------------------------------------");
            System.out.println("--  Introduce opción: ");
            opcion = ent.nextInt();
            switch (opcion) {
                case 1:
                    visualizarUsuarios();
                    break;
                case 2:
                    visualizarCanciones();
                    break;
                case 3:
                    visualizarPosts();
                    break;
                case 4:
                    visualizarComentarios();
                    break;
                case 5:
                    System.out.println("Introduce el id de la cancion que quiere eliminar: ");
                    id = ent.nextInt();
                    cancionDao.eliminar(id);
                    break;
                case 6:
                    System.out.println("Introduce el id de usuario que quiere eliminar: ");
                    id = ent.nextInt();
                    usuarioDao.eliminar(id);
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

    public static void crearPlaylist() throws SQLException {
        List<Cancion> canciones = cancionDao.seleccionar();
        canciones.forEach(cancion -> {
            canList.add(cancion);
            System.out.println(cancion);
        }
        );

        PlayList playlist1 = new PlayList();
        int id = -1;
        String nombre_playlist;
        System.out.println(canList);

        System.out.println("Introduce el nombre de la nueva playList: ");

        nombre_playlist = ent.nextLine();
        while (id != 0) {
            System.out.println("Introduce el id de la cancion que quieres añadir a la PlayList, introduce 0 para terminar el proceso: ");
            id = ent.nextInt();
            for (Cancion can : canList) {
                if (can.id_cancion == id) {
                    playlist1.agregarCancion(can);
                }

            }
        }

        String nombreArchivo = nombre_playlist;
        String contenido = playlist1.toString();
        implementacion imp = new implementacion();
        imp.crearArchivo(nombreArchivo);
        imp.escribirArchivoCancion(nombreArchivo, contenido);
        imp.leerArchivoCancion(nombreArchivo);
    }

    public static void iniciarUsuario() throws SQLException {
        Usuario usu = null;
        String nombre;
        int id;
        String contrasenna;
        String contrasennaCifrada;
        System.out.println("-----------------------------------------");
        System.out.println("--         REGISTRO USUARIO           ---");
        System.out.println("-----------------------------------------");
        ent.nextLine();
        System.out.println("--Introduce Nombre de Usuario: ");
        nombre = ent.nextLine();
        if (Usuario.esta(nombre) == true) {
            id = Usuario.estaID(nombre);
            contrasennaCifrada = Usuario.estaContrasenna(nombre);
            System.out.println("Introduce contraseña: ");
            contrasenna = ent.nextLine();
            if (Usuario.comparadorContrasennas(contrasennaCifrada, contrasenna) == true) {
                menuUsuario(id);
            } else {
                System.out.println("Usuario no encontrado en el sistema o Contraseña incorrecta.");
            }

        }

    }

    public static void actualizarCorreo(int id) {
        Usuario usuario = new Usuario();
        usuario = Usuario.devolverUsuario(id);
        boolean seguro;

        System.out.println("El correo actual es " + usuario.getCorreo() + ", esta seguro de que quiere cambiarlo?(S/N)");
        String seguridad = ent.nextLine();
        if (seguridad.toUpperCase() == "S") {

            System.out.println("Introduce el nuevo correo electronico: ");
            String correo = ent.nextLine();
            usuario.setCorreo(correo);

            usuarioDao.actualizar(usuario);
            System.out.println("Correo actualizado correctamente.");
            System.out.println("Usuario: " + usuario);
        } else {
            System.out.println("El correo no se actualizará, si quiere actualizrlo, vuelve a intentarlo.");
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

    } //TERMINADO

    public static void visualizarUsuarios() throws SQLException {
        try {
            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario -> {
                System.out.println("persona = " + usuario);
                usuList.add(usuario);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        System.out.println(usuList);

    }

    public static void visualizarCanciones() throws SQLException {
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

    }

    public static void visualizarComentarios() {
        try {
            List<Comentario> comentarios = comentarioDao.seleccionar();
            comentarios.forEach(comentario -> {
                System.out.println("Comentario " + comentario.id_comentario + " de Usuario con ID " + comentario.id_usuario + "en Post en el post con ID " + comentario.id_post + " = " + comentario);
                comList.add(comentario);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void visualizarPosts() {
        try {
            List<Post> posts = postDao.seleccionar();
            posts.forEach(post -> {
                System.out.println("Post " + post.id_post + " de Usuario con ID " + post.id_usuario + "= " + post);
                postList.add(post);
            }
            );
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
/*
    public static List<Usuario> listarUsuario() throws SQLException{
        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {
            usuList.add(usuario);
        }
        );
        return usuarios;
    }
    
        public boolean encontrarUsuario(String nombre) throws SQLException{
        boolean esta = false;
        List<Usuario> usuarios = usuarioDao.seleccionar();
        usuarios.forEach(usuario -> {
            if(nombre.equals(usuario.nombre_usuario)){
                esta = true;
            }else{
                System.out.println("El nombre introducido no pertenece a ningun Usuario registrado.");
                esta = false;
            }
        }
        );
        return esta;
        
        }
}

    
 */
 /*
   //Función para insertar un Usuario a la base de datos desde la terminal (menu1)
    //Función que conecta con la clase UsuarioDao para hacer uso del metodo insertar(Usuario)
    public static void registrarUsuario() throws SQLException {
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
            boolean esta = usuList.contains(usuarioRegistro);
            if (esta == false) {
                usuarioDao.insertar(usuarioRegistro);
                System.out.println("Usuario registrado correctamente en la base de datos!");
            } else if (esta == true) {
                System.out.println("La dirección de correo o el nombre de usuairo o el telefono ya están en uso. Porfavor inserte datos no utilizados anteriormente");
                menu();
            }
        }
    }
 */
