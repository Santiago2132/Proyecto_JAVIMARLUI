package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class TablaProveedoresPersonalizada extends JFrame {

    public TablaProveedoresPersonalizada() {
        setTitle("Tabla de Proveedores Personalizada");
        this.setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que las celdas no sean editables
            }
        };
        JTable tabla = new JTable(model);

        // Agregar columnas a la tabla
        model.addColumn("Nombre");
        model.addColumn("Identificación");
        model.addColumn("Teléfono");
        model.addColumn("Nombre de la Empresa");
        model.addColumn("NIT de la empresa");
        model.addColumn("Correo");

        // Agregar datos de ejemplo a la tabla
        Vector<String> proveedor1 = new Vector<>();
        proveedor1.add("Proveedor 1");
        proveedor1.add("12345");
        proveedor1.add("123-456-7890");
        proveedor1.add("Empresa A");
        proveedor1.add("NIT-12345");
        proveedor1.add("proveedor1@empresaA.com");
        model.addRow(proveedor1);

        Vector<String> proveedor2 = new Vector<>();
        proveedor2.add("Proveedor 2");
        proveedor2.add("54321");
        proveedor2.add("987-654-3210");
        proveedor2.add("Empresa B");
        proveedor2.add("NIT-54321");
        proveedor2.add("proveedor2@empresaB.com");
        model.addRow(proveedor2);

        // Centrar los textos en las celdas de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.setDefaultRenderer(Object.class, centerRenderer);

        // Crear un JScrollPane para hacer que la tabla sea deslizable
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Crear una etiqueta para la imagen de la persona
        JLabel imagenPersona = new JLabel(new ImageIcon("ruta/a/tu/imagen.png"));
        imagenPersona.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar la etiqueta de la imagen y el JScrollPane al panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imagenPersona, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TablaProveedoresPersonalizada ventana = new TablaProveedoresPersonalizada();
            ventana.setVisible(true);
        });
    }
}

