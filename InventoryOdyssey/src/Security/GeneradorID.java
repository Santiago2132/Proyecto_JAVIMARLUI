package Security;

public class GeneradorID {
    private int ultimoID;

    public GeneradorID() {
        this.ultimoID = 0;
    }

    public int consultarUltimoID() {
        return ultimoID;
    }

    public int generarNuevoID() {
        ultimoID++;
        return ultimoID;
    }

    public static void main(String[] args) {
        GeneradorID generador = new GeneradorID();

        int ultimoID = generador.consultarUltimoID();
        System.out.println("El último ID es: " + ultimoID);

        int nuevoID = generador.generarNuevoID();
        System.out.println("El nuevo ID es: " + nuevoID);
    }
}

