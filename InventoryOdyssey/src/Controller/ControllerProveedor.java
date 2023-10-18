package Controller;

<<<<<<< HEAD
=======
import Model.ClienteModel;
>>>>>>> c7ac3e004a71ac9b270780fb95dff2c063f3fbc5
import Model.ProveedorModel;

public class ControllerProveedor {
    ProveedorModel proveedorModel = new ProveedorModel();

<<<<<<< HEAD
    public boolean crearProveedor(String nombre, String nombreEmpresa, int nitEmpresa, String telefono, String email, int tipo) {
=======
    public boolean crearCliente(String nombre, String nombreEmpresa, int nitEmpresa, String telefono, String email, int tipo) {
>>>>>>> c7ac3e004a71ac9b270780fb95dff2c063f3fbc5
        // Llamar al método de la clase ClienteModel pasando los nuevos atributos
        proveedorModel.agregarProveedor(nombre, nombreEmpresa, nitEmpresa, telefono, email, tipo);

        return true;
    }
}
