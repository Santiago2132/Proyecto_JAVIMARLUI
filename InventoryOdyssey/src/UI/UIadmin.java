package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIadmin extends JFrame implements ActionListener {
    private JButton btnCrearUsuario, btnDesactivarUsuario, btnEliminarUsuario, btnRegistrarVendedor, btnLogOut;

    public UIadmin() {
        // Configuración de la ventana
        setTitle("Panel de Administración");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear botones
        btnCrearUsuario = new JButton("Crear Usuario");
        btnDesactivarUsuario = new JButton("Desactivar Usuario");
        btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnRegistrarVendedor = new JButton("Registrar Vendedor");
        btnLogOut = new JButton("Log Out");

        // Agregar ActionListener a los botones
        btnCrearUsuario.addActionListener(this);
        btnDesactivarUsuario.addActionListener(this);
        btnEliminarUsuario.addActionListener(this);
        btnRegistrarVendedor.addActionListener(this);
        btnLogOut.addActionListener(this);

        // Organizar los componentes en un GridLayout
        setLayout(new GridLayout(5, 1));

        // Agregar botones a la interfaz
        add(btnCrearUsuario);
        add(btnDesactivarUsuario);
        add(btnEliminarUsuario);
        add(btnRegistrarVendedor);
        add(btnLogOut);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Manejar eventos de botón aquí
        if (e.getSource() == btnCrearUsuario) {
            // Lógica para crear usuario
        } else if (e.getSource() == btnDesactivarUsuario) {
            // Lógica para desactivar usuario
        } else if (e.getSource() == btnEliminarUsuario) {
            // Lógica para eliminar usuario
        } else if (e.getSource() == btnRegistrarVendedor) {
            // Lógica para registrar vendedor
        } else if (e.getSource() == btnLogOut) {
            dispose(); // Cierra la ventana actual (UIadmin)
            UIlogin loginUI = new UIlogin(); // Crea una nueva ventana de login
            loginUI.setVisible(true); // Muestra la ventana de login
        }
    }


}
