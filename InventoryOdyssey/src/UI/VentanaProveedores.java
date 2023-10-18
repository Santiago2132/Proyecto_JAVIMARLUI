package UI;

import javax.swing.*;
import java.awt.*;

public class VentanaProveedores extends JFrame{

    public void main(String[]args){
        VentanaProveedores ventanaProveedores = new VentanaProveedores();
        ventanaProveedores.setVisible(true);
    }


    public VentanaProveedores(){
        this.setTitle("INVENTORY ODYSSEY - PROVEEDORES");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);

    }
}
