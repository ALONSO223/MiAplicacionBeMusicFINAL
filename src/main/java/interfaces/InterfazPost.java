/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Post;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alooo
 */
public interface InterfazPost {

    public List seleccionar() throws SQLException;

    public int insertar(Post post) throws SQLException;

    public int actualizar(Post post);

    public int eliminar(int id);

}
