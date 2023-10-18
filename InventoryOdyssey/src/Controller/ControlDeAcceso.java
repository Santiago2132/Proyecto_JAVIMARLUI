package Controller;

import Classes.Usuario;
import Model.UsuarioModel;

public class ControlDeAcceso {
    public UsuarioModel usuariomodelo = new UsuarioModel();

    public ControlDeAcceso() {
    }

    //Methods
    public boolean login(String name, String password){
        Usuario usuario = new Usuario(name, password);
        if(usuariomodelo.validarUsuario(name, password)) {
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
