package Controller;

import Classes.Factura;
import Classes.Producto;
import Model.FacturaModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class FacturaController {
    private FacturaModel facturaModel;

    public FacturaController() {
        facturaModel = new FacturaModel();
    }

    public void agregarFactura(Factura factura) {
        java.util.Date fechaActual = new java.util.Date(); //
        Date fechaEmision = new Date(fechaActual.getTime());
        Date fechaVence = facturaModel.calcularFechaVencimiento((java.sql.Date) fechaEmision);
        int clienteId = factura.getIdentificacion();
        int metodoPagoId = 1; //
        int detalleEmpresaNit = 1; //
        int inventarioId = 1; //
        int productoId = 1; //
        double impuestos = 0.19; //
        double descuento = factura.getPorcentajeDescuento() * factura.getValorTotal(); //
        double total = factura.getValorTotal();

        int resultado = facturaModel.agregarFactura(clienteId, metodoPagoId, detalleEmpresaNit, inventarioId, productoId,
                (java.sql.Date) fechaEmision, (java.sql.Date) fechaVence, impuestos, descuento, total);

        if (resultado != -1) {
            JOptionPane.showMessageDialog(null, "Factura agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar la factura.");
        }
    }

    public void eliminarFactura(int idFactura) {
        int resultado = facturaModel.eliminarFactura(idFactura);

        if (resultado != -1) {
            JOptionPane.showMessageDialog(null, "Factura eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la factura.");
        }
    }

    public static void main(String[] args) {
        FacturaController facturaController = new FacturaController();


        Factura facturaEjemplo = new Factura(new java.util.Date(), "Cliente Ejemplo", 1, 123456789, "cliente@example.com",
                "Vendedor Ejemplo", new ArrayList<>(), 150.00, 0.10);

        facturaController.agregarFactura(facturaEjemplo);
    }
}