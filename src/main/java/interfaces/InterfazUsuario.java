/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;
import dominio.*;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author alooo
 */
public interface InterfazUsuario{    
    public List seleccionar() throws SQLException;
    public int insertar(Usuario usuario) throws SQLException;
    public int actualizar(Usuario usuario);
    public int eliminar(int id);
}
