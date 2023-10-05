import Classes.Usuario;
import Controller.ControlDeAcceso;

public class Main {

    public static void main(String[] args) {
        ControlDeAcceso control = new ControlDeAcceso();
        Usuario user= new Usuario("Santiago","Karen");
        System.out.println(control.login(user));

    }
}