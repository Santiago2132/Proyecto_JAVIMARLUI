package UI;

import Controller.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAggEmpleado extends JFrame {
    ControllerAdministrador admin = new ControllerAdministrador();

    public static void main(String[] args){
        VentanaAggEmpleado ventanaAggEmp = new VentanaAggEmpleado();
        ventanaAggEmp.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JPanel panelFondo = new JPanel();
    JPanel informacionEmpleado = new JPanel();
    JLabel fondo = new JLabel();
    public VentanaAggEmpleado(){
        this.setTitle("INVENTORY ODYSSEY - AGREGAR PROVEEDORES");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        panelContenedor();
        panelFondo();
        panelInformacionEmpleado();

    }



    public void panelFondo(){

        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 0, 1535,550);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#100932");
        panelFondo.setBackground(color);

        //LABEL

        JLabel titulo = new JLabel("AGREGAR EMPLEADO");
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

    public void panelInformacionEmpleado(){


        JLabel imagen = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/hombre (1).png"));
        Image icono = image.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(700,100,350,350);
        informacionEmpleado.add(imagen);

        informacionEmpleado.setLayout(null);
        informacionEmpleado.setBounds(165, 130, 1200,600);
        informacionEmpleado.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        informacionEmpleado.setBackground(color);

        JLabel nombreEmpleado = new JLabel("Nombre:");
        nombreEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreEmpleado.setBounds(120,130,150,20);
        nombreEmpleado.setForeground(Color.BLACK);
        informacionEmpleado.add(nombreEmpleado);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(350,130,220,30);
        informacionEmpleado.add(cajaNombre);

        JLabel idEmpleado = new JLabel("Nombre usuario:");
        idEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        idEmpleado.setBounds(120,210,150,20);
        idEmpleado.setForeground(Color.BLACK);
        informacionEmpleado.add(idEmpleado);

        JTextField cajaId = new JTextField();
        cajaId.setBounds(350,210,220,30);
        informacionEmpleado.add(cajaId);

        JLabel telefonoEmpleado = new JLabel("Contraseña:");
        telefonoEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        telefonoEmpleado.setBounds(120,290,150,20);
        telefonoEmpleado.setForeground(Color.BLACK);
        informacionEmpleado.add(telefonoEmpleado);

        JTextField cajaTelefono = new JTextField();
        cajaTelefono.setBounds(350,290,220,30);
        informacionEmpleado.add(cajaTelefono);

        JLabel direccionEmpleado = new JLabel("Correo");
        direccionEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        direccionEmpleado.setBounds(120,370,150,20);
        direccionEmpleado.setForeground(Color.BLACK);
        informacionEmpleado.add(direccionEmpleado);

        JTextField cajaDireccion = new JTextField();
        cajaDireccion.setBounds(350,370,220,30);
        informacionEmpleado.add(cajaDireccion);

        JLabel correoEmpleado = new JLabel("Rol:");
        correoEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        correoEmpleado.setBounds(120,450,150,20);
        correoEmpleado.setForeground(Color.BLACK);
        informacionEmpleado.add(correoEmpleado);
        /*
        JTextField cajaEmpleado = new JTextField();
        cajaEmpleado.setBounds(350,450,220,30);
        informacionEmpleado.add(cajaEmpleado);

         */
        String[] opciones = {"Administrador", "Vendedor", "Bodeguero"};
        JComboBox<String> comboRoles = new JComboBox<>(opciones);
        comboRoles.setBounds(350, 450, 220, 30);
        informacionEmpleado.add(comboRoles);

        int rol;
        String rolSeleccionado = (String) comboRoles.getSelectedItem();
        switch (rolSeleccionado) {
            case "Administrador":
                rol = 1;
                break;
            case "Vendedor":
                rol = 2;
                break;
            case "Bodeguero":
                rol = 3;
                break;
            default:
                rol = 0; // Manejar un valor por defecto si no coincide ninguna opción
        }


        JButton botonAgregar =  new JButton("Agregar Empleado");
        botonAgregar.setBounds(1015,520,150,50);
        botonAgregar.setBackground(Color.white);
        informacionEmpleado.add(botonAgregar);
        // Agrega un ActionListener al botónAgregar
        botonAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaNombre.getText();
                String id = cajaId.getText();
                String telefono = cajaTelefono.getText();
                String direccion = cajaDireccion.getText();
                admin.crearUsuario(nombre,id,telefono,direccion,rol);
                cajaNombre.setText("");
                cajaId.setText("");
                cajaTelefono.setText("");
                cajaDireccion.setText("");
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
        contenedor.add(informacionEmpleado,Integer.valueOf(3));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
