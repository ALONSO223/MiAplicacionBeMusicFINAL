/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dominio.Comentario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alooo
 */
public interface InterfazComentario {
    public List seleccionar() throws SQLException;

    public int insertar(Comentario comentario) throws SQLException;

    public int actualizar(Comentario comentario);

    public int eliminar(int id);
    
}
