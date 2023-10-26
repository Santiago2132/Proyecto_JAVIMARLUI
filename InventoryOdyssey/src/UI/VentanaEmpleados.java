package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VentanaEmpleados extends JFrame {
    public static void main (String []args){
        VentanaEmpleados ventanaDelEmpleado = new VentanaEmpleados();
        ventanaDelEmpleado.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelFondo = new JPanel();
    JPanel panelEncima = new JPanel();
    JPanel panelEncima2 = new JPanel();
    public ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();


    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();

    public VentanaEmpleados(){
        this.setTitle("INVENTORY ODYSSEY - EMPLEADOS");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.WHITE);
        panelContenedor();
        panelFondo();
        panelEncima();
        panelEncima2();
        tablaEmpleados();

    }



    public void panelFondo(){
        panelFondo.setLayout(null);
        panelFondo.setBounds(60, 60, 1400,680);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        panelFondo.setBackground(color);

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/empleado.png"));
        Image icono = icon.getImage().getScaledInstance(68, 68, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(50,20,68,68);
        panelFondo.add(imagen);

        JLabel titulo = new JLabel("EMPLEADOS");
        titulo.setFont(new Font("Rockwell",Font.BOLD,40));
        titulo.setBounds(150,40,600,32);
        titulo.setForeground(Color.BLACK);
        panelFondo.add(titulo);

        JButton botonVolver =  new JButton("<-");
        botonVolver.setBounds(1320,20,60,55);
        botonVolver.setBackground(Color.white);
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

    public static void tablaEmpleados() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>ID</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>NOMBRE<br>EMPLEADO</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>TELÉFONO</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>EMAIL</div></html>\"");


        // Configurar filas de diferentes alturas
        table = new JTable(model);

        // Establecer el tamaño de todas las celdas de la tabla
        int cellHeight = 30; // Altura deseada de las celdas

        table.setRowHeight(cellHeight);
        // Configurar el ancho de todas las columnas de la tabla
        int columnWidth = 100; // Ancho deseado de las columnas
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < table.getColumnCount(); i++) {
            columnModel.getColumn(i).setPreferredWidth(columnWidth);
        }

        // Cambiar la fuente del texto en la tabla
        Font font = table.getFont();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.SIZE, 14); // Tamaño de fuente
        font = font.deriveFont(attributes);
        table.setFont(font);

        // Crea un renderizador personalizado para centrar el contenido de las celdas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        // Aplica el renderizador personalizado a todas las columnas de la tabla
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Personalizar el renderizador de encabezado para establecer la altura
        JTableHeader header = table.getTableHeader();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        renderer.setPreferredSize(new Dimension(2, 50)); // Altura deseada del encabezado
        header.setFont(new Font("Rockewell", Font.BOLD, 14));
        header.setBackground(Color.white);
        // Establecer la política de redimensionamiento de las columnas
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        // Agregar la tabla a un panel con barra de desplazamiento
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.white);

        // Crea un nuevo panel para contener la tabla con la barra de desplazamiento
        JPanel panelConScroll = new JPanel(new BorderLayout());
        panelConScroll.add(scrollPane, BorderLayout.CENTER);
        panelConScroll.setBounds(700, 112, 620, 520);
        panelConScroll.setBackground(Color.white);

        // Agrega el panel con la barra de desplazamiento al panelCentral
        panelFondo.add(panelConScroll, BorderLayout.CENTER);
        table.setEnabled(false);
    }

    // Método para agregar una fila de objetos a la tabla
    public void agregarFila(Object[] objetos) {
        // Agrega una fila con los objetos al modelo de la tabla
        model.addRow(objetos);
        // Llenar la tabla con datos de la lista
    }

    private void eliminarFilaPorId(String id) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            String idEnFila = model.getValueAt(i, 0).toString(); // Suponiendo que la columna 0 contiene el ID
            if (idEnFila.equals(id)) {
                model.removeRow(i);
                break; // Termina después de eliminar la fila
            }
        }
    }

    public void panelEncima(){
        panelEncima.setLayout(null);
        panelEncima.setBounds(100, 170, 580,520);
        panelEncima.setOpaque(true);
        Color color = Color.decode("#211F3A");
        panelEncima.setBackground(color);

    }

    public void panelEncima2(){
        panelEncima2.setLayout(null);
        panelEncima2.setBounds(120, 190, 540,480);
        panelEncima2.setOpaque(true);
        Color color = Color.decode("#4D4988");
        panelEncima2.setBackground(color);

        JLabel nombreEmpleado = new JLabel("Nombre:");
        nombreEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreEmpleado.setBounds(55,80,150,20);
        nombreEmpleado.setForeground(Color.WHITE);
        panelEncima2.add(nombreEmpleado);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(220,80,220,25);
        panelEncima2.add(cajaNombre);

        JLabel idEmpleado = new JLabel("ID:");
        idEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        idEmpleado.setBounds(55,110,150,20);
        idEmpleado.setForeground(Color.WHITE);
        panelEncima2.add(idEmpleado);

        JTextField cajaId = new JTextField();
        cajaId.setBounds(220,110,220,25);
        panelEncima2.add(cajaId);

        JLabel telefonoEmpleado = new JLabel("Teléfono:");
        telefonoEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        telefonoEmpleado.setBounds(55,140,150,20);
        telefonoEmpleado.setForeground(Color.WHITE);
        panelEncima2.add(telefonoEmpleado);

        JTextField cajaTelefono = new JTextField();
        cajaTelefono.setBounds(220,140,220,25);
        panelEncima2.add(cajaTelefono);

        JLabel emailEmpleado = new JLabel("Email:");
        emailEmpleado.setFont(new Font("Rockwell",Font.BOLD,20));
        emailEmpleado.setBounds(55,170,150,20);
        emailEmpleado.setForeground(Color.WHITE);
        panelEncima2.add(emailEmpleado);

        JTextField cajaEmail = new JTextField();
        cajaEmail.setBounds(220,170,220,25);
        panelEncima2.add(cajaEmail);

        JButton botonAgg = new JButton("AGREGAR EMPLEADO");
        botonAgg.setBounds(55,220,383,40);
        botonAgg.setBackground(Color.WHITE);
        botonAgg.setBorderPainted(false);
        panelEncima2.add(botonAgg);

        botonAgg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaNombre.getText();
                String id = cajaId.getText();
                String telefono = cajaTelefono.getText();
                String email = cajaEmail.getText();

                // Crea un objeto Empleado con los valores
                Empleado empleado = new Empleado(id, nombre, telefono, email);

                // Agrega el empleado a la lista
                listaEmpleados.add(empleado);

                // Agrega el empleado a la tabla
                agregarFila(new Object[]{empleado.getId(), empleado.getNombre(), empleado.getTelefono(), empleado.getEmail()});

                // Limpia los JTextField
                cajaNombre.setText("");
                cajaId.setText("");
                cajaTelefono.setText("");
                cajaEmail.setText("");
            }
        });

        JLabel nombreEmpleado1 = new JLabel("ID:");
        nombreEmpleado1.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreEmpleado1.setBounds(55,330,150,20);
        nombreEmpleado1.setForeground(Color.WHITE);
        panelEncima2.add(nombreEmpleado1);

        JTextField cajaNombre1 = new JTextField();
        cajaNombre1.setBounds(220,330,220,25);
        panelEncima2.add(cajaNombre1);

        JButton botonEliminar = new JButton("ELIMINAR EMPLEADO");
        botonEliminar.setBounds(55,390,383,40);
        botonEliminar.setBackground(Color.WHITE);
        botonEliminar.setBorderPainted(false);
        panelEncima2.add(botonEliminar);

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén el ID del empleado a eliminar desde el JTextField cajaNombre1
                String idAEliminar = cajaNombre1.getText();

                // Llama a un método para eliminar el empleado de la lista y de la tabla
                eliminarEmpleadoPorId(idAEliminar);

                // Limpia el JTextField cajaNombre1
                cajaNombre1.setText("");
            }
        });
    }

    private void eliminarEmpleadoPorId(String id) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        boolean empleadoEncontrado = false;

        for (int i = 0; i < rowCount; i++) {
            String idEnFila = model.getValueAt(i, 0).toString(); // Suponiendo que la columna 0 contiene el ID
            if (idEnFila.equals(id)) {
                model.removeRow(i);
                empleadoEncontrado = true;
                break; // Termina después de eliminar la fila
            }
        }

        if (!empleadoEncontrado) {
            JOptionPane.showMessageDialog(this, "Empleado no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void panelContenedor() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
        Image image = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(image);
        JLabel fondo = new JLabel(imagen);
        fondo.setSize(screenSize.width, screenSize.height);

        contenedor.add(fondo, Integer.valueOf(1));
        contenedor.add(panelFondo,Integer.valueOf(2));
        contenedor.add(panelEncima,Integer.valueOf(3));
        contenedor.add(panelEncima2,Integer.valueOf(4));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
