package UI;

import Controller.ControllerCliente;
import Controller.ControllerProveedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAggProveedores extends JFrame{

    public static void main(String[]args){
        VentanaAggProveedores ventanaAggProveedores = new VentanaAggProveedores();
        ventanaAggProveedores.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JPanel panelFondo = new JPanel();
    JPanel informacionProveedor = new JPanel();
    JLabel fondo = new JLabel();


    public VentanaAggProveedores(){
        this.setTitle("INVENTORY ODYSSEY - AGREGAR PROVEEDORES");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        panelContenedor();
        panelFondo();
        panelInformacionProveedor();

    }

    public void panelFondo(){

        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 0, 1535,550);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#100932");
        panelFondo.setBackground(color);

        //LABEL

        JLabel titulo = new JLabel("AGREGAR PROVEEDOR");
        titulo.setFont(new Font("Rockwell",Font.BOLD,40));
        titulo.setBounds(350,60,600,32);
        titulo.setForeground(Color.WHITE);
        panelFondo.add(titulo);

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/agregar-usuario.png"));
        Image icono = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(260,44,64,64);
        panelFondo.add(imagen);

        JButton botonVolver = new JButton("<-");// no funciona ponerle imagen al boton
        botonVolver.setBounds(1308,40,50,50);
        botonVolver.setFont(new Font("Rockwell",Font.BOLD,15));
        /*ImageIcon volver = new ImageIcon("src/Imagenes/volver.png"); // se le pone icono a boton
        Icon i = new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH));
        botonVolver.setIcon(i);
        botonVolver.setBackground(Color.white);
        botonVolver.setBorderPainted(false);
        ImageIcon imgadmin = new ImageIcon("src/Imagenes/voler.png"); // se le pone icono a boton
        Icon iconAdmin = new ImageIcon(imgadmin.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH));
        botonVolver.setRolloverIcon(iconAdmin);*/
        panelFondo.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaInventario ventanaInventario =  new VentanaInventario();
                ventanaInventario.setVisible(true);
                dispose();
            }
        });
    }

    public void panelInformacionProveedor(){

        ControllerProveedor controllerProveedor = new ControllerProveedor();


        JLabel imagen = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/mujer.png"));
        Image icono = image.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(750,110,350,350);
        informacionProveedor.add(imagen);

        informacionProveedor.setLayout(null);
        informacionProveedor.setBounds(165, 140, 1200,600);
        informacionProveedor.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        informacionProveedor.setBackground(color);

        JLabel nombreCliente = new JLabel("Nombre:");
        nombreCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreCliente.setBounds(120,130,150,20);
        nombreCliente.setForeground(Color.BLACK);
        informacionProveedor.add(nombreCliente);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(375,130,220,30);
        informacionProveedor.add(cajaNombre);

        JLabel idCliente = new JLabel("Identificación:");
        idCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        idCliente.setBounds(120,190,150,20);
        idCliente.setForeground(Color.BLACK);
        informacionProveedor.add(idCliente);

        JTextField cajaId = new JTextField();
        cajaId.setBounds(375,190,220,30);
        informacionProveedor.add(cajaId);

        JLabel telefonoCliente = new JLabel("Teléfono:");
        telefonoCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        telefonoCliente.setBounds(120,250,150,20);
        telefonoCliente.setForeground(Color.BLACK);
        informacionProveedor.add(telefonoCliente);

        JTextField cajaTelefono = new JTextField();
        cajaTelefono.setBounds(375,250,220,30);
        informacionProveedor.add(cajaTelefono);

        JLabel nombreEmpresa = new JLabel("Nombre dela Empresa:");
        nombreEmpresa.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreEmpresa.setBounds(120,310,240,20);
        nombreEmpresa.setForeground(Color.BLACK);
        informacionProveedor.add(nombreEmpresa);

        JTextField cajaTelefonoEmpresa = new JTextField();
        cajaTelefonoEmpresa.setBounds(375,310,220,30);
        informacionProveedor.add(cajaTelefonoEmpresa);

        JLabel nitEmpresa = new JLabel("NIT de la empresa:");
        nitEmpresa.setFont(new Font("Rockwell",Font.BOLD,20));
        nitEmpresa.setBounds(120,370,180,20);
        nitEmpresa.setForeground(Color.BLACK);
        informacionProveedor.add(nitEmpresa);

        JTextField cajaDireccion = new JTextField();
        cajaDireccion.setBounds(375,370,220,30);
        informacionProveedor.add(cajaDireccion);

        JLabel tipoProv = new JLabel("Tipo:");
        tipoProv.setFont(new Font("Rockwell",Font.BOLD,20));
        tipoProv.setBounds(120,430,150,20);
        tipoProv.setForeground(Color.BLACK);
        informacionProveedor.add(tipoProv);

        JTextField cajaTipo = new JTextField();
        cajaTipo.setBounds(375,430,220,30);
        informacionProveedor.add(cajaTipo);



        JLabel correoCliente = new JLabel("Correo:");
        correoCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        correoCliente.setBounds(120,490,150,20);
        correoCliente.setForeground(Color.BLACK);
        informacionProveedor.add(correoCliente);

        JTextField cajaCliente = new JTextField();
        cajaCliente.setBounds(375,490,220,30);
        informacionProveedor.add(cajaCliente);

        JButton botonAgregar = new JButton("Agregar Proveedor");
        botonAgregar.setBounds(995, 525, 180, 50);
        botonAgregar.setBackground(Color.white);
        informacionProveedor.add(botonAgregar);

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaNombre.getText();
                String id = cajaId.getText();
                String telefono = cajaTelefono.getText();
                String nombreEmpresa = cajaTelefonoEmpresa.getText();
                int nitEmpresa = Integer.parseInt(cajaDireccion.getText()); // Asumiendo que nitEmpresa es un número
                int tipo = Integer.parseInt(cajaTipo.getText()); // Asumiendo que tipo es un número
                String email = cajaCliente.getText();
                
                // Limpiar los campos de entrada
                cajaNombre.setText("");
                cajaId.setText("");
                cajaTelefono.setText("");
                cajaTelefonoEmpresa.setText("");
                cajaDireccion.setText("");
                cajaTipo.setText("");
                cajaCliente.setText("");
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
        contenedor.add(panelFondo,Integer.valueOf(2));
        contenedor.add(informacionProveedor,Integer.valueOf(3));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
