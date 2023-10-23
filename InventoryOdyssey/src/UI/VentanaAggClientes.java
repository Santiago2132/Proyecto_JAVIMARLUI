package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAggClientes extends JFrame {

    public static void main(String[] args){
        VentanaAggClientes ventanaAggClientes = new VentanaAggClientes();
        ventanaAggClientes.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JPanel panelFondo = new JPanel();
    JPanel informacionCliente = new JPanel();
    JLabel fondo = new JLabel();


    public VentanaAggClientes(){
        this.setTitle("INVENTORY ODYSSEY - AGREGAR CLIENTES");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        panelContenedor();
        panelFondo();
        panelInformacionCliente();

    }

    public void panelFondo(){

        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 0, 1535,550);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#100932");
        panelFondo.setBackground(color);

        //LABEL

        JLabel titulo = new JLabel("AGREGAR CLIENTE");
        titulo.setFont(new Font("Rockwell",Font.BOLD,40));
        titulo.setBounds(350,60,400,32);
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
                VentanaFactura ventanaFactura = new VentanaFactura();
                ventanaFactura.setVisible(true);
                dispose();
            }
        });
    }

    public void panelInformacionCliente(){


        informacionCliente.setLayout(null);
        informacionCliente.setBounds(165, 130, 1200,600);
        informacionCliente.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        informacionCliente.setBackground(color);

        JLabel imagen = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/mujer (1).png"));
        Image icono = image.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(700,100,350,350);
        informacionCliente.add(imagen);

        JLabel nombreCliente = new JLabel("Nombre:");
        nombreCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreCliente.setBounds(120,130,150,20);
        nombreCliente.setForeground(Color.BLACK);
        informacionCliente.add(nombreCliente);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(350,130,220,30);
        informacionCliente.add(cajaNombre);

        JLabel idCliente = new JLabel("Identificación:");
        idCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        idCliente.setBounds(120,210,150,20);
        idCliente.setForeground(Color.BLACK);
        informacionCliente.add(idCliente);

        JTextField cajaId = new JTextField();
        cajaId.setBounds(350,210,220,30);
        informacionCliente.add(cajaId);

        JLabel telefonoCliente = new JLabel("Teléfono:");
        telefonoCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        telefonoCliente.setBounds(120,290,150,20);
        telefonoCliente.setForeground(Color.BLACK);
        informacionCliente.add(telefonoCliente);

        JTextField cajaTelefono = new JTextField();
        cajaTelefono.setBounds(350,290,220,30);
        informacionCliente.add(cajaTelefono);

        JLabel direccionCliente = new JLabel("Dirección:");
        direccionCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        direccionCliente.setBounds(120,370,150,20);
        direccionCliente.setForeground(Color.BLACK);
        informacionCliente.add(direccionCliente);

        JTextField cajaDireccion = new JTextField();
        cajaDireccion.setBounds(350,370,220,30);
        informacionCliente.add(cajaDireccion);

        JLabel correoCliente = new JLabel("Correo:");
        correoCliente.setFont(new Font("Rockwell",Font.BOLD,20));
        correoCliente.setBounds(120,450,150,20);
        correoCliente.setForeground(Color.BLACK);
        informacionCliente.add(correoCliente);

        JTextField cajaCliente = new JTextField();
        cajaCliente.setBounds(350,450,220,30);
        informacionCliente.add(cajaCliente);

        JButton botonAgregar =  new JButton("Agregar Cliente");
        botonAgregar.setBounds(1015,520,150,50);
        botonAgregar.setBackground(Color.white);
        informacionCliente.add(botonAgregar);


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
        contenedor.add(informacionCliente,Integer.valueOf(3));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
