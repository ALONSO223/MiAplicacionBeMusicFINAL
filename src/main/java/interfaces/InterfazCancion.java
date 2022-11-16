/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dominio.Cancion;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alooo
 */
public interface InterfazCancion {
    public List seleccionar() throws SQLException;
    public int insertar(Cancion cancion) throws SQLException;
    public int actualizar(Cancion cancion);
    public int eliminar(int id);
    
}
