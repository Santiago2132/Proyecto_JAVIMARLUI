package UI;

import javax.swing.*;

public class Factura extends JFrame {

    public static void main(String[] args){
        Factura factura = new Factura();
        factura.setVisible(true);
    }

    public Factura(){
        this.setTitle("INVENTORY ODYSSEY - FACTURA");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
    }
}
