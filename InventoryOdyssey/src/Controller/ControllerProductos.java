package Controller;

import Classes.Producto;
import Model.ProductoModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerProductos {
    ProductoModel productoModel = new ProductoModel();

    public boolean crearProductoBasico(String nombre,int id,int cantidad,double precio, double iva)  throws SQLException, IOException {
        return productoModel.agregarProducto(id,nombre,precio,cantidad,iva);
        //productoModel.agregarProducto(precio,iva);
    }
    public List<Producto> listaProductos(){
        return productoModel.obtenerProductos();
    }



    public boolean eliminarProducto(int idProducto) {

        return false;
    }

    public Producto consultarProducto(int idProducto) {

        return null;
    }
}
