package Controller;

import Classes.Usuario;

public class ControlDeAcceso {

    public ControlDeAcceso() {
    }

    //Methods
    public boolean login(String name, String password){
        Usuario usuario = new Usuario(name, password);
        Usuario usuarioPrueba = new Usuario("Santiago","Karen");//Esta parte traera los usuarios de la base de datos.
        if((usuario.getNombre_usuario().equals(usuarioPrueba.getNombre_usuario())) && (usuario.getPassword().equals(usuarioPrueba.getPassword()))) {
            return true;
        }else {
            return false;
        }
    }
    public int rol(){
        Usuario usuarioPrueba = new Usuario("Santiago","Karen",1);//prueba sin modelo
        return usuarioPrueba.getTipoUsuario();
    }
    public boolean logout(){
        return true;
    }
    //aca tendrá la encriptación y desencriptación
}
