/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import static com.mycompany.miaplicacionbemusic.MiAplicacionBeMusic.visualizarUsuarios;
import datos.AmigosDao;
import dominio.Usuario;
import interfaces.InterfazAmigos;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author alooo
 */
public class Amigos {
    static Scanner ent = new Scanner(System.in);
    
    int id_amistad;
    int idAmigo1;
    int idAmigo2;
    Date fecha_amistad;
    
    public Amigos(int id_amistad, int idAmigo1, int idAmigo2, Date fecha_amistaD) {
    this.id_amistad = id_amistad;
    this.idAmigo1 = idAmigo1;
    this.idAmigo2 = idAmigo2;
    this.fecha_amistad = fecha_amistad;
    }

    public Amigos(int idAmigo1, int idAmigo2) {
        this.idAmigo1 = idAmigo1;
        this.idAmigo2 = idAmigo2;
        this.fecha_amistad = Date.valueOf(LocalDate.now());
    }

    public Amigos() {
    }

    
    
    public int getIdAmigo1() {
        return idAmigo1;
    }

    public void setIdAmigo1(int idAmigo1) {
        this.idAmigo1 = idAmigo1;
    }

    public int getIdAmigo2() {
        return idAmigo2;
    }

    public void setIdAmigo2(int idAmigo2) {
        this.idAmigo2 = idAmigo2;
    }

    public int getId_amistad() {
        return id_amistad;
    }

    public void setId_amistad(int id_amistad) {
        this.id_amistad = id_amistad;
    }

    public Date getFecha_amistad() {
        return fecha_amistad;
    }

    public void setFecha_amistad(Date fecha_amistad) {
        this.fecha_amistad = fecha_amistad;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amigos{");
        sb.append(", idAmigo1=").append(idAmigo1);
        sb.append(", idAmigo2=").append(idAmigo2);
        sb.append('}');
        return sb.toString();
    }
    
    public static void seguirUsuario(int id) throws SQLException {
        visualizarUsuarios();
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
       InterfazAmigos amigosDao = new AmigosDao();
        int id2;
        System.out.println("Introduce el nombre de usuario que quieres seguir: ");
        String nombre = ent.nextLine();
        if (Usuario.esta(nombre) == true) {
            id2 = Usuario.estaID(nombre);
            System.out.println("Quieres seguir a " + Usuario.devolverUsuario(id2).getNombre() + " " + Usuario.devolverUsuario(id2).getApellidos() + " ? (S/N):");
            String opcion = ent.nextLine();
            if (opcion.toUpperCase() == "S") {
                Amigos amistadRegistro = new Amigos(id, id2);
                amigosDao.insertar(amistadRegistro);
                System.out.println("Solicitud completada, ya sois amigos.");
            } else {
                System.out.println("Operación no realizada");
            }

        } else {
            System.out.println("Usuario introducido no se encuentra en el sistema, intentalo de nuevo.");
        }

    }

    
    

    
    
    
    
}
