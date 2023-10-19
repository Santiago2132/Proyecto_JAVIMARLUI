package Controller;

import Classes.Usuario;
import Model.UsuarioModel;
import Security.Encriptador;

public class ControlDeAcceso {
    public UsuarioModel usuariomodelo = new UsuarioModel();
    Encriptador encriptador = new Encriptador();

    public ControlDeAcceso() {
    }

    //Methods
    public boolean login(String name, String password){

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
