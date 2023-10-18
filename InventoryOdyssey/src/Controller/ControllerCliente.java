package Controller;

import Model.ClienteModel;

public class ControllerCliente {
    ClienteModel clienteModel = new ClienteModel();
    public boolean crearCliente(String nombre, String identificación, String telefono,String dirección, String correo){
        clienteModel.agregarCliente(nombre,identificación,dirección,telefono,correo);
        return true;
    }
}
