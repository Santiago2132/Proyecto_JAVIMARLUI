package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
/*
Si alcanzamos a implementarlo para adjuntar la imagen del producto.
 */
public class AdjuntarImagenGUI extends JFrame {
    private JTextField textField;
    private JButton adjuntarButton;

    public AdjuntarImagenGUI() {
        // Configurar la ventana
        setTitle("Adjuntar Imagen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para organizar los elementos
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        // Añadir un campo de texto para mostrar el archivo seleccionado
        textField = new JTextField();
        textField.setEditable(false);
        panel.add(textField);

        // Añadir un botón de adjuntar
        adjuntarButton = new JButton("Adjuntar");
        adjuntarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    textField.setText(selectedFile.getName());
                    adjuntarButton.setEnabled(false); // Deshabilitar el botón después de adjuntar
                }
            }
        });
        panel.add(adjuntarButton);

        // Añadir el panel a la ventana
        add(panel);

        // Crear un botón para guardar
        JButton guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes agregar la lógica para guardar el archivo adjuntado
                // Puedes usar el valor de 'textField.getText()' para obtener el nombre del archivo
            }
        });
        add(guardarButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdjuntarImagenGUI().setVisible(true);
            }
        });
    }
}

