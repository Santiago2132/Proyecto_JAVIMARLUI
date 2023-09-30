package Classes;

public class Producto {
    String referencia = "";
    String nombre = "";
     String categoria = "";
     String descripcion = "";
     String unidad = "";
     float precioVecta = 0;
    float precioCosto = 0;
    int terminoGarantia = 0;

    //Constructores

    public Producto() {
    }

    public Producto(String referencia, String nombre, String categoria, String descripcion, String unidad, float precioVecta, float precioCosto, int terminoGarantia) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.precioVecta = precioVecta;
        this.precioCosto = precioCosto;
        this.terminoGarantia = terminoGarantia;
    }
}
