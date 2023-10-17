package Classes;

import Structures.LinkedList;

public class Proveedor {
    public String nombreEmpresa = "";
    public int nit = 0;
    public LinkedList historial;
    public LinkedList catalogo;

    public Proveedor() {
    }

    public Proveedor(String nombreEmpresa, int nit, LinkedList historial, LinkedList catalogo) {
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.historial = historial;
        this.catalogo = catalogo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public LinkedList getHistorial() {
        return historial;
    }

    public void setHistorial(LinkedList historial) {
        this.historial = historial;
    }

    public LinkedList getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(LinkedList catalogo) {
        this.catalogo = catalogo;
    }
}
