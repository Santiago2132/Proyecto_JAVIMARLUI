package UI;

import Controller.ControlDeAcceso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class VentanaLogin extends JFrame {
    ControlDeAcceso controlDeAcceso = new ControlDeAcceso();
    public static void main(String[] args) {
        VentanaLogin ventanaLogin=new VentanaLogin();
        ventanaLogin.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JPanel panelLogin = new JPanel();
    JPanel panelTitulos = new JPanel();
    JPanel panelFondoInfo = new JPanel();
    JPanel panelFondoFondo = new JPanel();

    JLabel fondo = new JLabel();
    public VentanaLogin(){
        this.setTitle("INVENTORY ODYSSEY");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        //panelInicio();
        panelContenedor();
        panelTitulos();
        panelFondoInfo();
        PanelFondoFondo();
    }

    public void PanelFondoFondo(){

        panelFondoFondo.setLayout(null);
        panelFondoFondo.setBounds(1000, 100,380,620);
        panelFondoFondo.setOpaque(true);
        Color color =  new Color(255, 255, 255, 158);
        panelFondoFondo.setBackground(color);

    }

    public void panelFondoInfo(){

        panelFondoInfo.setLayout(null);
        panelFondoInfo.setBounds(1010, 110,360,600);
        panelFondoInfo.setOpaque(true);
        Color color =  Color.decode("#01010B");
        panelFondoInfo.setBackground(color);


        //LABELS


        JLabel tituloIncioSesion = new JLabel("INICIAR DE SESIÓN");
        tituloIncioSesion.setFont(new Font("Rockwell", Font.BOLD, 25));
        tituloIncioSesion.setBounds(65, 40, 300, 60 );
        tituloIncioSesion.setForeground(Color.white);
        panelFondoInfo.add(tituloIncioSesion);

        JLabel usuario = new JLabel("USUARIO");
        usuario.setFont(new Font("Rockwell", Font.BOLD, 18));
        usuario.setBounds(137, 150, 200, 30);
        usuario.setForeground(Color.white);
        panelFondoInfo.add(usuario);

        JLabel password = new JLabel("CONTRASEÑA");
        password.setFont(new Font("Rockwell", Font.BOLD, 18));
        password.setBounds(115, 250, 250, 30);
        password.setForeground(Color.white);
        panelFondoInfo.add(password);

        //CAJAS DE TEXTO
        JTextField cajaUsuario = new JTextField();
        cajaUsuario.setBounds(57,185, 250, 30);
        panelFondoInfo.add(cajaUsuario);

        //JTextField cajaPassword = new JTextField();
        //cajaPassword.setBounds(57, 290, 250, 30);
        //panelFondoInfo.add(cajaPassword);
        JPasswordField passwordField = new JPasswordField(20); // El número 20 es la longitud máxima de la contraseña
        panelLogin.add(new JLabel("Contraseña: "));
        passwordField.setBounds(57, 290, 250, 30);
        panelFondoInfo.add(passwordField);

        //TERMINOS Y CONDICIONES
        JLabel textoTerminos=new JLabel("Terminoss y Condiciones");
        textoTerminos.setBounds(111, 360, 310, 40);
        textoTerminos.setForeground(Color.blue);

        // SUBRAYADO
        Font font = textoTerminos.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        Font fontSubrayado = new Font(attributes);
        textoTerminos.setFont(fontSubrayado);


        panelFondoInfo.add(textoTerminos);

        JCheckBox check = new JCheckBox("He leído los terminos y condiciones");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(67,420,230,25);
        panelFondoInfo.add(check);

        //BOTON
        JButton botonLogin = new JButton("INGRESAR");
        botonLogin.setBounds(108,480,150,50);
        ImageIcon imgR = new ImageIcon("src/Imagenes/Captura.png");// se le pone icono a boton
        Icon i = new ImageIcon(imgR.getImage().getScaledInstance(botonLogin.getWidth(), botonLogin.getHeight(), Image.SCALE_SMOOTH));
        botonLogin.setIcon(i);
        botonLogin.setBackground(Color.white);
        botonLogin.setBorderPainted(false);
        ImageIcon imgadmin = new ImageIcon("src/Imagenes/Captura.png");// se le pone icono a boton
        Icon iconAdmin = new ImageIcon(imgadmin.getImage().getScaledInstance(botonLogin.getWidth(), botonLogin.getHeight(), Image.SCALE_SMOOTH));
        botonLogin.setRolloverIcon(iconAdmin);
        panelFondoInfo.add(botonLogin);

        botonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaUsuario.getText();
                String contraseña = new String(passwordField.getPassword());
                if(controlDeAcceso.login(nombre,contraseña)==true){
                    int rol = controlDeAcceso.rol(nombre);
                    if(rol ==  1){
                        VentanaInventario ventanaInventario =  new VentanaInventario();
                        ventanaInventario.setVisible(true);
                        dispose();
                    }else if(rol == 2){

                    }else if(rol ==3 ){

                    }else {

                    }
                }else {
                    cajaUsuario.setText(""); // Esto limpia el campo de texto
                    passwordField.setText(""); // Esto limpia el campo de contraseña
                }

            }
        });
    }


    public void panelTitulos(){

        panelTitulos.setLayout(null);
        panelTitulos.setBounds(0, 0, 900,800);
        panelTitulos.setOpaque(false);
        //panelTitulos.setBackground(Color.blue);

        JLabel tituloP = new JLabel("BIENVENIDO A...");
        tituloP.setFont(new Font("Rockwell", Font.BOLD, 25));
        tituloP.setBounds(105, 268, 250,38);
        tituloP.setForeground(Color.white);
        panelTitulos.add(tituloP);

        JLabel titulo = new JLabel("INVENTORY ODISSEY");
        titulo.setFont(new Font("Rockwell", Font.BOLD, 70));
        titulo.setBounds(100, 300, 800, 100 );
        titulo.setForeground(Color.white);
        panelTitulos.add(titulo);

        Font font = titulo.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        Font fontSubrayado = new Font(attributes);
        titulo.setFont(fontSubrayado);

    }

    public void panelContenedor(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
        Image image = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(image);
        JLabel fondo = new JLabel(imagen);
        fondo.setSize(screenSize.width, screenSize.height);


        contenedor.add(fondo,Integer.valueOf(1));
        contenedor.add(panelTitulos,Integer.valueOf(2));
        contenedor.add(panelFondoInfo,Integer.valueOf(3));
        contenedor.add(panelFondoFondo,Integer.valueOf(2));


        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
