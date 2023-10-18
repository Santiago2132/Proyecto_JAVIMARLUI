package UI;

import Model.InventarioModel;

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

public class VentanaInventario extends JFrame {
    InventarioModel inventarioModel = new InventarioModel();

   public static void main (String []args){
        VentanaInventario ventanaInventario = new VentanaInventario();
        ventanaInventario.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelInventario = new JPanel();
    JPanel panelInvisble = new JPanel();
    JLabel fondo = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();


    public VentanaInventario(){
        this.setTitle("INVENTORY ODYSSEY - INVENTARIO");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.WHITE);
        panelContenedor();
        panelInventario();
        panelInvisible();
        tablaProductos();
    }

    public void panelInventario(){

        panelInventario.setLayout(null);
        panelInventario.setBounds(0, 85,1537,720);
        panelInventario.setOpaque(true);
        panelInventario.setBackground(Color.white);
    }

    public void panelInvisible(){

        panelInvisble.setLayout(null);
        panelInvisble.setBounds(0, 0,1537,85);
        panelInvisble.setOpaque(false);
        //panelInvisble.setBackground(Color.blue);

        // Crear un JMenuBar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(1300, 24, 110, 40); // Ajusta la posición y el tamaño según tus necesidades

        // Configurar la fuente personalizada para la barra de menú
        Font menuFont = new Font("Rockwell", Font.BOLD, 40); // Puedes ajustar la fuente y el tamaño aquí
        menuBar.setFont(menuFont);

        // Crear un JMenu y configurarlo
        JMenu opcionesMenu = new JMenu("ADMINISTRADOR");

        opcionesMenu.setForeground(Color.BLACK);

        JMenuItem cerrarSesionItem = new JMenuItem("Cerrar Sesión");
        opcionesMenu.add(cerrarSesionItem);

        cerrarSesionItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaLogin ventanaLogin = new VentanaLogin();
                ventanaLogin.setVisible(true);
                dispose();
            }
        });

        // Agregar el JMenu al JMenuBar
        menuBar.add(opcionesMenu);

        // Agregar el JMenuBar al panelInvisible
        panelInvisble.add(menuBar);

        JButton botonReportes = new JButton("REPORTES");
        botonReportes.setBounds(40,24,120,40);
        /*ImageIcon IReportes = new ImageIcon("src/Imagenes/BReportes.PNG");
        Icon icon = new ImageIcon(IReportes.getImage().getScaledInstance(botonReportes.getWidth(),botonReportes.getHeight(), Image.SCALE_SMOOTH));
        botonReportes.setIcon(icon);*/
        botonReportes.setBackground(Color.WHITE);
        botonReportes.setBorderPainted(false);
        /*ImageIcon imagen = new ImageIcon("src/Imagenes/BRreportes.PNG");
        Icon imagen1 = new ImageIcon(imagen.getImage().getScaledInstance(botonReportes.getWidth(), botonReportes.getHeight(), Image.SCALE_SMOOTH));
        botonReportes.setRolloverIcon(imagen1);*/
        panelInvisble.add(botonReportes);

        botonReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaReportes ventanaReportes = new VentanaReportes();
                ventanaReportes.setVisible(true);
                dispose();
            }
        });

        JButton botonProveedores = new JButton("PROVEEDORES");
        botonProveedores.setBounds(180,24,150,40);
        botonProveedores.setBackground(Color.WHITE);
        botonProveedores.setBorderPainted(false);
        panelInvisble.add(botonProveedores);

        JButton botonEmpleadoMes = new JButton("AGREGAR PRODUCTO");
        botonEmpleadoMes.setBounds(350,24,170,40);
        botonEmpleadoMes.setBackground(Color.WHITE);
        botonEmpleadoMes.setBorderPainted(false);
        panelInvisble.add(botonEmpleadoMes);

        JButton botonAggProv = new JButton("AGREGAR PROVEEDORES");
        botonAggProv.setBounds(540,24,190,40);
        botonAggProv.setBackground(Color.WHITE);
        botonAggProv.setBorderPainted(false);
        panelInvisble.add(botonAggProv);

        botonAggProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAggProveedores ventanaAggProv =  new VentanaAggProveedores();
                ventanaAggProv.setVisible(true);
                dispose();
            }
        });

        JButton botonAggEmpleado = new JButton("AGREGAR EMPLEADO");
        botonAggEmpleado.setBounds(750,24,180,40);
        botonAggEmpleado.setBackground(Color.WHITE);
        botonAggEmpleado.setBorderPainted(false);
        panelInvisble.add(botonAggEmpleado);

        botonAggEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAggEmpleado ventanaAggEmp = new VentanaAggEmpleado();
                ventanaAggEmp.setVisible(true);
                dispose();
            }
        });
    }

    public static void tablaProductos() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>ID<br>REFERENCIA</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>PRODUCTO</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>DESCRIPCION</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>PRECIO<br>UNIDAD</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>CANTIDAD</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>PROVEEDOR</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>FECH. REGISTRO</div></html>\"");
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
        panelInventario.add(panelConScroll, BorderLayout.CENTER);
    }
    public void agregarProducto(String id, String referencia, String producto, String descripcion, String precio, String cantidad, String proveedor) {
        // Añadir una nueva fila a la tabla
        Object[] fila = {id, referencia, producto, descripcion, precio, cantidad, proveedor};
        model.addRow(fila);
    }



    public void panelContenedor() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"));
        Image image = imagen.getImage().getScaledInstance(screenSize.width, screenSize.height, Image.SCALE_SMOOTH);
        imagen = new ImageIcon(image);
        JLabel fondo = new JLabel(imagen);
        fondo.setSize(screenSize.width, screenSize.height);

        contenedor.add(fondo, Integer.valueOf(1));
        contenedor.add(panelInventario,Integer.valueOf(2));
        contenedor.add(panelInvisble,Integer.valueOf(2));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
