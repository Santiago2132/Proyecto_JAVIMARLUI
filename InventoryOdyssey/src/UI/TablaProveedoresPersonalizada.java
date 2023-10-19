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
import java.util.Vector;

public class TablaProveedoresPersonalizada extends JFrame {

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelFondo = new JPanel();
    JPanel panelInvisible = new JPanel();
    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();

    public static void main (String []args){
        TablaProveedoresPersonalizada tablaProveedoresPersonalizada = new TablaProveedoresPersonalizada();
        tablaProveedoresPersonalizada.setVisible(true);
    }
    public TablaProveedoresPersonalizada(){
        this.setTitle("INVENTORY ODYSSEY - INVENTARIO");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.WHITE);
        panelContenedor();
        panelFondo();
        panelInvisible();
        tablaProductos();
    }
    public void panelFondo(){
        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 85,1537,720);
        panelFondo.setOpaque(true);
        panelFondo.setBackground(Color.white);
    }
    public void panelInvisible(){
        panelInvisible.setLayout(null);
        panelInvisible.setBounds(0, 0,1537,85);
        panelInvisible.setOpaque(false);
        panelInvisible.setBackground(Color.blue);

        JButton botonVolver = new JButton("<-");// no funciona ponerle imagen al boton
        botonVolver.setBounds(1450,15,50,50);
        botonVolver.setFont(new Font("Rockwell",Font.BOLD,15));
        botonVolver.setBackground(Color.white);
        botonVolver.setBorderPainted(false);
        panelInvisible.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaInventario ventanaInventario =  new VentanaInventario();
                ventanaInventario.setVisible(true);
                dispose();
            }
        });
    }
    public static void tablaProductos() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>ID<br>NOMBRE</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>IDENTIFICACIÓN</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>TELÉFONO</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>NOMBRE DE<br>LA EMPRESA</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>NIT DE LA EMPRESA</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>CORREO</div></html>\"");
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
        panelConScroll.setBounds(0, 0,1537,720);
        panelConScroll.setBackground(Color.white);

        // Agrega el panel con la barra de desplazamiento al panelCentral
        panelFondo.add(panelConScroll, BorderLayout.CENTER);
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
        contenedor.add(panelInvisible,Integer.valueOf(2));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

