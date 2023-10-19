package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAggProducto extends JFrame {

    public static void main(String[] args){
        VentanaAggProducto ventanaAggProducto = new VentanaAggProducto();
        ventanaAggProducto.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JPanel panelLogin = new JPanel();
    JPanel panelInformacion = new JPanel();


    public VentanaAggProducto(){
        this.setTitle("INVENTORY ODYSSEY");
        this.setExtendedState(MAXIMIZED_BOTH);
        //this.setSize(800,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setBackground(Color.white);
        //panelInicio();
        panelContenedor();
        panelInformacion();
    }

    public void panelInformacion(){

        panelInformacion.setLayout(null);
        panelInformacion.setBounds(165, 100, 1200,600);
        panelInformacion.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        panelInformacion.setBackground(color);

        JLabel titulo = new JLabel("AGREGAR PRODUCTOS");
        titulo.setFont(new Font("Rockwell",Font.BOLD,40));
        titulo.setBounds(60,30,500,32);
        titulo.setForeground(Color.BLACK);
        panelInformacion.add(titulo);

        JLabel idProducto = new JLabel("CODIGO:");
        idProducto.setFont(new Font("Rockwell",Font.BOLD,20));
        idProducto.setBounds(120,150,150,20);
        idProducto.setForeground(Color.BLACK);
        panelInformacion.add(idProducto);

        JTextField cajaIdProd = new JTextField();
        cajaIdProd.setBounds(375,150,220,30);
        panelInformacion.add(cajaIdProd);

        JLabel nombre = new JLabel("NOMBRE:");
        nombre.setFont(new Font("Rockwell",Font.BOLD,20));
        nombre.setBounds(120,210,150,20);
        nombre.setForeground(Color.BLACK);
        panelInformacion.add(nombre);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(375,210,220,30);
        panelInformacion.add(cajaNombre);

        JLabel cantidad = new JLabel("CANTIDAD:");
        cantidad.setFont(new Font("Rockwell",Font.BOLD,20));
        cantidad.setBounds(120,270,150,20);
        cantidad.setForeground(Color.BLACK);
        panelInformacion.add(cantidad);

        JTextField cajaCantidad = new JTextField();
        cajaCantidad.setBounds(375,270,220,30);
        panelInformacion.add(cajaCantidad);

        JLabel precioUnitario = new JLabel("PRECIO UNITARIO:");
        precioUnitario.setFont(new Font("Rockwell",Font.BOLD,20));
        precioUnitario.setBounds(120,330,200,20);
        precioUnitario.setForeground(Color.BLACK);
        panelInformacion.add(precioUnitario);

        JTextField cajaPrecio = new JTextField();
        cajaPrecio.setBounds(375,330,220,30);
        panelInformacion.add(cajaPrecio);

        JLabel iva = new JLabel("IVA:");
        iva.setFont(new Font("Rockwell",Font.BOLD,20));
        iva.setBounds(120,390,150,20);
        iva.setForeground(Color.BLACK);
        panelInformacion.add(iva);

        JTextField cajaIva = new JTextField();
        cajaIva.setBounds(375,390,220,30);
        panelInformacion.add(cajaIva);

        JLabel fechaVenta = new JLabel("FECHA DE VENTA:");
        fechaVenta.setFont(new Font("Rockwell",Font.BOLD,20));
        fechaVenta.setBounds(120,450,190,20);
        fechaVenta.setForeground(Color.BLACK);
        panelInformacion.add(fechaVenta);

        JTextField cajaFecha = new JTextField();
        cajaFecha.setBounds(375,450,220,30);
        panelInformacion.add(cajaFecha);

        JLabel imagen = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/caja-del-paquete.png"));
        Image icono = image.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(750,110,350,350);
        panelInformacion.add(imagen);

        JButton botonAgregarProducto =  new JButton("Agregar Producto");
        botonAgregarProducto.setBounds(995,525,180,50);
        botonAgregarProducto.setBackground(Color.white);
        panelInformacion.add(botonAgregarProducto);

        botonAgregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = cajaIdProd.getText();
                String texto1 = cajaNombre.getText();
                String texto2 = cajaCantidad.getText();
                String texto3 = cajaPrecio.getText();
                String text4 = cajaIva.getText();
                String text5 = cajaFecha.getText();
            }
        });

        JButton botonVolver =  new JButton("<-");
        botonVolver.setBounds(1100,20,60,55);
        botonVolver.setBackground(Color.white);
        panelInformacion.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaInventario ventanaInventario =  new VentanaInventario();
                ventanaInventario.setVisible(true);
                dispose();
            }
        });



    }

    public void panelContenedor(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
        Image image = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(image);
        JLabel fondo = new JLabel(imagen);
        fondo.setSize(screenSize.width, screenSize.height);

        contenedor.add(fondo,Integer.valueOf(1));
        contenedor.add(panelInformacion,Integer.valueOf(2));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
