package Controller;

import Classes.Producto;
import Model.ProductoModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerProductos {
    ProductoModel productoModel = new ProductoModel();

    public boolean crearProductoBasico(double precio, double iva) throws SQLException, IOException {
        return false;
        //productoModel.agregarProducto(precio,iva);
    }



    public boolean eliminarProducto(int idProducto) {

        return false;
    }

    public Producto consultarProducto(int idProducto) {

        return null;
    }
    public static void main(String[] args) throws SQLException, IOException {
        ControllerProductos controllerProductos = new ControllerProductos();
        controllerProductos.crearProductoBasico(1231231.21,12);
    }
}
