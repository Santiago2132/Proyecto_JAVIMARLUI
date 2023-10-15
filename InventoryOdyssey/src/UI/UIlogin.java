package UI;

import Classes.Usuario;
import Controller.ControlDeAcceso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIlogin extends JFrame implements ActionListener {
    private JTextField txtNombre;
    private JPasswordField txtContraseña;
    private JButton btnIngresar;
    ControlDeAcceso controlDeAcceso = new ControlDeAcceso();

    public UIlogin() {
        // Configuración de la ventana
        setTitle("Inicio de Sesión");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear componentes
        txtNombre = new JTextField();
        txtContraseña = new JPasswordField();
        btnIngresar = new JButton("Ingresar");

        // Agregar ActionListener al botón
        btnIngresar.addActionListener(this);

        // Organizar los componentes en un GridLayout
        setLayout(new GridLayout(3, 2));

        // Agregar componentes a la interfaz
        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Contraseña:"));
        add(txtContraseña);
        add(new JLabel(""));
        add(btnIngresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIngresar) {
            String nombre = txtNombre.getText();
            String contraseña = new String(txtContraseña.getPassword());
            if(controlDeAcceso.login(nombre,contraseña)==true){
                int rol = controlDeAcceso.rol();
                if(rol ==  1){
                    this.setVisible(false);
                    this.dispose();
                    UIadmin adminUI = new UIadmin();
                    adminUI.setVisible(true);
                }else if(rol == 2){

                }else if(rol ==3 ){

                }
            }else {
                System.out.println("Contraseña incorrecta");
            }
        }
    }
}

