package Model;

import Classes.Usuario;
import DataBase.InventarioDAO;

public class ModelLogin {
    InventarioDAO inventarioDAO = new InventarioDAO();
    public Usuario retornoUsuario(String nombreUsuario){
        return inventarioDAO.obtenerUsuarioPorNombreUsuario(nombreUsuario);
    }
}
