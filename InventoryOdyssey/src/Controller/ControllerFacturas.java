package Controller;

import Classes.Factura;

import java.util.ArrayList;

public class ControllerFacturas {
    private ArrayList<Factura> listaFacturas;//Esto cambiarpa al modelo cuando este listo

    public ControllerFacturas() {
        listaFacturas = new ArrayList<>();
    }

    public boolean crearFactura(Factura factura) {
        return listaFacturas.add(factura);
    }

    public boolean modificarFactura(int identificacion, Factura nuevaFactura) {
        for (Factura factura : listaFacturas) {
            if (factura.getIdentificacion() == identificacion) {
                listaFacturas.remove(factura);
                return listaFacturas.add(nuevaFactura);
            }
        }
        return false; // No se encontró la factura con la identificación dada
    }

    public boolean eliminarFactura(int identificacion) {
        Factura facturaAEliminar = null;
        for (Factura factura : listaFacturas) {
            if (factura.getIdentificacion() == identificacion) {
                facturaAEliminar = factura;
                break;
            }
        }
        if (facturaAEliminar != null) {
            return listaFacturas.remove(facturaAEliminar);
        }
        return false; // No se encontró la factura con la identificación dada
    }
    public Factura consultarFactura(int identificacion) {
        for (Factura factura : listaFacturas) {
            if (factura.getIdentificacion() == identificacion) {
                return factura;
            }
        }
        return null; // Si no se encontró ninguna factura con la identificación dada
    }


    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }
}
