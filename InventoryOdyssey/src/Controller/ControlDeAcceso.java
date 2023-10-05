package Controller;

import Classes.Usuario;

public class ControlDeAcceso {
    Boolean activo = false;

    public ControlDeAcceso() {
        this.activo = false;
    }

    //Methods
    public boolean login(Usuario user){
        //Aca ira el metodo de comprobación por ahora va un true por defecto
        boolean confirmacion = true;
        if(confirmacion==true){
            activo = true;
            return true;
        }else {
            return false;
        }
    }
    public boolean logout(){
        activo = false;
        return true;
    }
}
