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
import java.util.HashMap;
import java.util.Map;

public class VentanaDelEmpleado extends JFrame {
    public static void main (String []args){
        VentanaDelEmpleado ventanaDelEmpleado = new VentanaDelEmpleado();
        ventanaDelEmpleado.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelFondo = new JPanel();
    JPanel panelEncima = new JPanel();
    JPanel panelEncima2 = new JPanel();


    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();

    public VentanaDelEmpleado(){
        this.setTitle("INVENTORY ODYSSEY - ELIMIMAR EMPLEADO");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.WHITE);
        panelContenedor();
        panelFondo();
        panelEncima();
        panelEncima2();
        tablaEmpleados();
        agregarFila(new Object []{"000492466","SEBASTIAN","CAJERO"});
        agregarFila(new Object []{"000127874","ANTONIO","BODEGUERO"});
    }



    public void panelFondo(){
        panelFondo.setLayout(null);
        panelFondo.setBounds(60, 60, 1400,680);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        panelFondo.setBackground(color);

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/despedido.png"));
        Image icono = icon.getImage().getScaledInstance(68, 68, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(50,20,68,68);
        panelFondo.add(imagen);

        JLabel titulo = new JLabel("ELIMINAR EMPLEADO");
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
        model.addColumn("<html><div style='text-align: center;'>TRABAJO</div></html>\"");

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
        panelConScroll.setBounds(700, 112, 580, 520);
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

        JLabel titulo = new JLabel("ID EMPLEADO");
        titulo.setFont(new Font("Rockwell",Font.BOLD,30));
        titulo.setBounds(160,160,600,32);
        titulo.setForeground(Color.WHITE);
        panelEncima2.add(titulo);

        JTextField cajaIdEmpleado = new JTextField();
        cajaIdEmpleado.setBounds(157,230,220,30);
        panelEncima2.add(cajaIdEmpleado);

        JButton botonEliminar = new JButton("ELIMINAR");
        botonEliminar.setBounds(156,290,221,40);
        botonEliminar.setBackground(Color.WHITE);
        botonEliminar.setBorderPainted(false);
        panelEncima2.add(botonEliminar);
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