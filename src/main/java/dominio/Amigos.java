/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import dominio.Usuario;
/**
 *
 * @author alooo
 */
public class Amigos {
    Usuario Amigo1;
    Usuario Amigo2;
    int idAmigo1;
    int idAmigo2;
    
    public Amigos(Usuario Amigo1, Usuario Amigo2, int idAmigo1, int idAmigo2) {
    this.Amigo1 = Amigo1;
    this.Amigo2 = Amigo2;
    this.idAmigo1 = Amigo1.getId_usuario();
    this.idAmigo2 = Amigo2.getId_usuario();

    }

    public Usuario getAmigo1() {
        return Amigo1;
    }

    public void setAmigo1(Usuario Amigo1) {
        this.Amigo1 = Amigo1;
    }

    public Usuario getAmigo2() {
        return Amigo2;
    }

    public void setAmigo2(Usuario Amigo2) {
        this.Amigo2 = Amigo2;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Amigos{");
        sb.append(", idAmigo1=").append(idAmigo1);
        sb.append(", idAmigo2=").append(idAmigo2);
        sb.append('}');
        return sb.toString();
    }

    
    

    
    
    
    
}
