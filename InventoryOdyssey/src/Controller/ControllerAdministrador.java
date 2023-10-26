package Controller;

import Classes.Usuario;
import Model.UsuarioModel;
import Security.Encriptador;
import Structures.LinkedList;

import java.util.Date;

public class ControllerAdministrador {
    //Crea los usuarios con esa cantidad de atributos, lo demás de la clase esta por agregado de persona.

    UsuarioModel usuarioModel = new UsuarioModel();
    /*
    public boolean crearUsuario(String nombre,String nombreUsuario,String password, String correo, int rol) throws Exception {//Funciones con usuario

        return usuarioModel.agregarUsuarioT(nombre,nombreUsuario,password,correo,rol);
    }

     */
    public boolean eliminarUsuario(Usuario usuarioAEliminar){
        boolean eliminado = false;//falta la consulta 3 condicionales que dependen del modelo
        eliminado = true;
        return false;
    }
    public Usuario consultaUsuario(String nombre){
        Usuario usuarioConsultado = new Usuario();//Falta la conulta
        return usuarioConsultado;
    }
    public boolean modificarUsuario(){
        return false;
    }
    public LinkedList estadoInventario(){//Inventario y Producto
        LinkedList inventarioProductos = new LinkedList();//Falta la consulta de todos los productos del inventario.
        return inventarioProductos;
    }
    public boolean crearFactura(){//Factura
         return false;//Solo estará listo cuando el controlador de facturas lo este.
    }
    public boolean eliminarFactura(){
        return false;
    }
    public boolean modificarFactura(){
        return false;
    }
    public boolean cambiarAtributos(){
        return false;
    }//Clientes
    public boolean agregarCliente(){//Metodos con clientes
        return false;
    }
    //Productos

    //Funciones de consulta
    public String balance(){
        return null;
    }
    public LinkedList empleados(){
        return null;
    }
}
