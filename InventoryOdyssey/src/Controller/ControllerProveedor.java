package Controller;

import Model.ProveedorModel;

public class ControllerProveedor {
    ProveedorModel proveedorModel = new ProveedorModel();

        public boolean crearProveedor(String nombre, String nombreEmpresa, int nitEmpresa, String telefono, String email, int tipo) {
            // Llamar al método de la clase ClienteModel pasando los nuevos atributos
            proveedorModel.agregarProveedor(nombre, nombreEmpresa, nitEmpresa, telefono, email, tipo);

            return true;
        }
}
