/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.time.*;
import java.util.Objects;


/**
 *
 * @author Alumno Mañana
 */
public class Usuario implements Serializable{
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
        int hash = 3;
        hash = 53 * hash + this.id_usuario;
        hash = 53 * hash + Objects.hashCode(this.correo);
        hash = 53 * hash + this.telefono;
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
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre_usuario, other.nombre_usuario)) {
            return false;
        }
        return Objects.equals(this.correo, other.correo);
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

    
    
    
    
}
