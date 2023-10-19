package Controller;

import Classes.Usuario;
import Model.ModelLogin;
import Model.UsuarioModel;
import Security.Encriptador;

public class ControlDeAcceso {
    public UsuarioModel usuariomodelo = new UsuarioModel();
    public ModelLogin modelLogin = new ModelLogin();
    Encriptador encriptador = new Encriptador();

    public ControlDeAcceso() {
    }

    //Methods
    public boolean login(String name, String password) throws Exception {
        String passwordE = encriptador.encriptar(password);
        if(usuariomodelo.validarUsuario(name, passwordE)) {
            return true;
        }else {
            return false;
        }
    }
    public int rol(String name){
        return usuariomodelo.obtenerRolPorNombreUsuario(name);
    }
    public boolean logout(){
        return true;
    }
    //aca tendrá la encriptación y desencriptación
}
