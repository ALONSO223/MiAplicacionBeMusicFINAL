/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Amigos;
import dominio.Cancion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alooo
 */
public interface InterfazAmigos {
        public List seleccionar() throws SQLException;
    public int insertar(Amigos relacion) throws SQLException;
    public int actualizar(Amigos relacion);
    public int eliminar(int id);
}
