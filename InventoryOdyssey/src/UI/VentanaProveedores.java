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

public class VentanaProveedores extends JFrame{

    public static void main(String[]args){
        VentanaProveedores ventanaProveedores = new VentanaProveedores();
        ventanaProveedores.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelFondo = new JPanel();
    JPanel panelEncima = new JPanel();
    JPanel panelEncima2 = new JPanel();
    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();
    public ArrayList<Proveedor> listaProveedor = new ArrayList<>();

    public VentanaProveedores(){
        this.setTitle("INVENTORY ODYSSEY - PROVEEDORES");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        panelContenedor();
        panelFondo();
        panelEncima();
        panelEncima2();
        tablaProveedores();
    }

    public void panelFondo(){
        panelFondo.setLayout(null);
        panelFondo.setBounds(60, 60, 1400,680);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        panelFondo.setBackground(color);

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/proveedor.png"));
        Image icono = icon.getImage().getScaledInstance(68, 68, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(50,20,68,68);
        panelFondo.add(imagen);

        JLabel titulo = new JLabel("PROVEEDORES");
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

    public static void tablaProveedores() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>ID</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>NOMBRE</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>NOMBRE<br>EMPRESA</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>NIT<br>EMPRESA</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>TELEONO</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>EMAIL</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>TIPO</div></html>\"");

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
        attributes.put(TextAttribute.SIZE, 11); // Tamaño de fuente
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
        panelConScroll.setBounds(640, 112, 725, 520);
        panelConScroll.setBackground(Color.white);

        // Agrega el panel con la barra de desplazamiento al panelCentral
        panelFondo.add(panelConScroll, BorderLayout.CENTER);
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

    public void panelEncima2(){
        panelEncima2.setLayout(null);
        panelEncima2.setBounds(120, 190, 540,480);
        panelEncima2.setOpaque(true);
        Color color = Color.decode("#4D4988");
        panelEncima2.setBackground(color);

        JLabel nombreProveedor = new JLabel("Nombre:");
        nombreProveedor.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreProveedor.setBounds(55,30,150,20);
        nombreProveedor.setForeground(Color.WHITE);
        panelEncima2.add(nombreProveedor);

        JTextField cajaNombre = new JTextField();
        cajaNombre.setBounds(240,30,220,25);
        panelEncima2.add(cajaNombre);

        JLabel idProveedor = new JLabel("ID:");
        idProveedor.setFont(new Font("Rockwell",Font.BOLD,20));
        idProveedor.setBounds(55,60,150,20);
        idProveedor.setForeground(Color.WHITE);
        panelEncima2.add(idProveedor);

        JTextField cajaId = new JTextField();
        cajaId.setBounds(240,60,220,25);
        panelEncima2.add(cajaId);

        JLabel nombreEmpresa = new JLabel("Nombre Empresa:");
        nombreEmpresa.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreEmpresa.setBounds(55,90,180,20);
        nombreEmpresa.setForeground(Color.WHITE);
        panelEncima2.add(nombreEmpresa);

        JTextField cajaNEmpresa = new JTextField();
        cajaNEmpresa.setBounds(240,90,220,25);
        panelEncima2.add(cajaNEmpresa);

        JLabel nitEmpresa = new JLabel("NIT Empresa:");
        nitEmpresa.setFont(new Font("Rockwell",Font.BOLD,20));
        nitEmpresa.setBounds(55,120,150,20);
        nitEmpresa.setForeground(Color.WHITE);
        panelEncima2.add(nitEmpresa);

        JTextField cajaNit = new JTextField();
        cajaNit.setBounds(240,120,220,25);
        panelEncima2.add(cajaNit);

        JLabel telefonoProveedor = new JLabel("Teléfono:");
        telefonoProveedor.setFont(new Font("Rockwell",Font.BOLD,20));
        telefonoProveedor.setBounds(55,150,150,20);
        telefonoProveedor.setForeground(Color.WHITE);
        panelEncima2.add(telefonoProveedor);

        JTextField cajaTelefono = new JTextField();
        cajaTelefono.setBounds(240,150,220,25);
        panelEncima2.add(cajaTelefono);

        JLabel emailProveedor = new JLabel("Email:");
        emailProveedor.setFont(new Font("Rockwell",Font.BOLD,20));
        emailProveedor.setBounds(55,180,150,20);
        emailProveedor.setForeground(Color.WHITE);
        panelEncima2.add(emailProveedor);

        JTextField cajaEmail = new JTextField();
        cajaEmail.setBounds(240,180,220,25);
        panelEncima2.add(cajaEmail);

        JLabel tipoProv = new JLabel("Tipo:");
        tipoProv.setFont(new Font("Rockwell",Font.BOLD,20));
        tipoProv.setBounds(55,210,150,20);
        tipoProv.setForeground(Color.WHITE);
        panelEncima2.add(tipoProv);

        JTextField cajaTipo = new JTextField();
        cajaTipo.setBounds(240,210,220,25);
        panelEncima2.add(cajaTipo);

        JButton botonAgg = new JButton("AGREGAR PROVEEDOR");
        botonAgg.setBounds(55,250,404,40);
        botonAgg.setBackground(Color.WHITE);
        botonAgg.setBorderPainted(false);
        panelEncima2.add(botonAgg);

        botonAgg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaNombre.getText();
                String id = cajaId.getText();
                String nombreEmpresa = cajaNEmpresa.getText();
                String nitEmpresa = cajaNit.getText();
                String telefono = cajaTelefono.getText();
                String email = cajaEmail.getText();
                String tipo = cajaTipo.getText();

                // Crea un objeto Proveedor con los valores
                Proveedor proveedor = new Proveedor(id, nombre, nombreEmpresa, nitEmpresa, telefono, email, tipo);

                // Agrega el proveedor a la lista
                listaProveedor.add(proveedor);

                // Agrega el proveeodr a la tabla
                agregarFila(new Object[]{proveedor.getId(), proveedor.getNombre(), proveedor.getNombreEmpresa(),proveedor.getNitEmpresa(),proveedor.getTelefono(), proveedor.getEmail(), proveedor.getTipo()});

                // Limpia los JTextField
                cajaNombre.setText("");
                cajaId.setText("");
                cajaTelefono.setText("");
                cajaNEmpresa.setText("");
                cajaNit.setText("");
                cajaEmail.setText("");
                cajaTipo.setText("");

            }
        });

        JLabel nombreEmpleado1 = new JLabel("ID:");
        nombreEmpleado1.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreEmpleado1.setBounds(55,330,150,20);
        nombreEmpleado1.setForeground(Color.WHITE);
        panelEncima2.add(nombreEmpleado1);

        JTextField cajaNombre1 = new JTextField();
        cajaNombre1.setBounds(240,330,220,25);
        panelEncima2.add(cajaNombre1);

        JButton botonEliminar = new JButton("ELIMINAR PROVEEDOR");
        botonEliminar.setBounds(55,390,404,40);
        botonEliminar.setBackground(Color.WHITE);
        botonEliminar.setBorderPainted(false);
        panelEncima2.add(botonEliminar);

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtén el ID del empleado a eliminar desde el JTextField cajaNombre1
                String idAEliminar = cajaNombre1.getText();

                // Llama a un método para eliminar el empleado de la lista y de la tabla
                eliminarProveedorPorId(idAEliminar);

                // Limpia el JTextField cajaNombre1
                cajaNombre1.setText("");
            }
        });
    }

    private void eliminarProveedorPorId(String id) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        boolean proveedorEncontrado = false;

        for (int i = 0; i < rowCount; i++) {
            String idEnFila = model.getValueAt(i, 0).toString(); // Suponiendo que la columna 0 contiene el ID
            if (idEnFila.equals(id)) {
                model.removeRow(i);
                proveedorEncontrado = true;
                break; // Termina después de eliminar la fila
            }
        }

        if (!proveedorEncontrado) {
            JOptionPane.showMessageDialog(this, "Proveedor no existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void panelEncima(){
        panelEncima.setLayout(null);
        panelEncima.setBounds(100, 170, 580,520);
        panelEncima.setOpaque(true);
        Color color = Color.decode("#211F3A");
        panelEncima.setBackground(color);

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
