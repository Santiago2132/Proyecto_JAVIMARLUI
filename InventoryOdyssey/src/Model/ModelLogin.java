package Model;

import Classes.Usuario;
import DataBase.InventarioDAO;
import Security.Encriptador;

public class ModelLogin {
    private Encriptador encriptador = new Encriptador();
    InventarioDAO inventarioDAO = new InventarioDAO();
    public Usuario retornoUsuario(String nombreUsuario) throws Exception {
        Usuario usuarioRetornar= inventarioDAO.obtenerUsuarioPorNombreUsuario(nombreUsuario);
        String password = encriptador.desencriptar(usuarioRetornar.getPassword());
        usuarioRetornar.setPassword(password);
        System.out.println(password);
        return usuarioRetornar;
    }
}
