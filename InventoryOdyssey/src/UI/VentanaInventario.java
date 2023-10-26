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

public class VentanaInventario extends JFrame {

   public static void main (String []args){
        VentanaInventario ventanaInventario = new VentanaInventario();
        ventanaInventario.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelInventario = new JPanel();
    JPanel panelInvisble = new JPanel();
    JLabel fondo = new JLabel();
    JMenuBar menuBar = new JMenuBar();
    public ArrayList<Producto> listaProductos = new ArrayList<>();
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
        Color color = Color.decode("#100932");
        panelInventario.setBackground(color);

        JLabel titulo = new JLabel("AGREGAR PRODUCTO");
        titulo.setFont(new Font("Rockwell",Font.BOLD,40));
        titulo.setBounds(45,90,500,40);
        titulo.setForeground(Color.WHITE);
        panelInventario.add(titulo);



        JLabel idProducto = new JLabel("ID:");
        idProducto.setFont(new Font("Rockwell",Font.BOLD,20));
        idProducto.setBounds(65,260,150,20);
        idProducto.setForeground(Color.WHITE);
        panelInventario.add(idProducto);

        JTextField cajaID = new JTextField();
        cajaID.setBounds(255,260,220,25);
        panelInventario.add(cajaID);

        JLabel nombreProducto = new JLabel("Producto:");
        nombreProducto.setFont(new Font("Rockwell",Font.BOLD,20));
        nombreProducto.setBounds(65,310,150,20);
        nombreProducto.setForeground(Color.WHITE);
        panelInventario.add(nombreProducto);



        JTextField cajaNomPro = new JTextField();
        cajaNomPro.setBounds(255,310,220,25);
        panelInventario.add(cajaNomPro);

        JLabel cantidadProducto = new JLabel("Cantidad:");
        cantidadProducto.setFont(new Font("Rockwell",Font.BOLD,20));
        cantidadProducto.setBounds(65,360,150,20);
        cantidadProducto.setForeground(Color.WHITE);
        panelInventario.add(cantidadProducto);

        JTextField cajaCantidad = new JTextField();
        cajaCantidad.setBounds(255,360,220,25);
        panelInventario.add(cajaCantidad);

        JLabel precioProducto = new JLabel("Precio Unidad:");
        precioProducto.setFont(new Font("Rockwell",Font.BOLD,20));
        precioProducto.setBounds(65,410,180,20);
        precioProducto.setForeground(Color.WHITE);
        panelInventario.add(precioProducto);

        JTextField cajaPrecio = new JTextField();
        cajaPrecio.setBounds(255,410,220,25);
        panelInventario.add(cajaPrecio);

        JLabel ivaProd = new JLabel("IVA %:");
        ivaProd.setFont(new Font("Rockwell",Font.BOLD,20));
        ivaProd.setBounds(65,460,180,20);
        ivaProd.setForeground(Color.WHITE);
        panelInventario.add(ivaProd);

        JTextField cajaIva = new JTextField();
        cajaIva.setBounds(255,460,220,25);
        panelInventario.add(cajaIva);

        JButton botonAgg = new JButton("AGREGAR PRODUCTO");
        botonAgg.setBounds(65,545,404,40);
        botonAgg.setBackground(Color.WHITE);
        botonAgg.setBorderPainted(false);
        panelInventario.add(botonAgg);

        botonAgg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaNomPro.getText();
                String id = cajaID.getText();
                String cantidad = cajaCantidad.getText();
                String precioUnitario = cajaPrecio.getText();
                String iva = cajaIva.getText();


                // Crea un objeto Proveedor con los valores
                Producto producto = new Producto(id, nombre, cantidad, precioUnitario, iva);

                // Agrega el proveedor a la lista
                listaProductos.add(producto);

                // Agrega el proveeodr a la tabla
                agregarFila(new Object[]{producto.getCodigo(), producto.getNombreProducto(), producto.getCantidad(),producto.getPrecioUnitario(),producto.getIva()});

                // Limpia los JTextField
                cajaNomPro.setText("");
                cajaID.setText("");
                cajaCantidad.setText("");
                cajaIva.setText("");
                cajaPrecio.setText("");
            }
        });
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



        JButton botonProveedores = new JButton("PROVEEDORES");
        botonProveedores.setBounds(250,24,150,40);
        botonProveedores.setBackground(Color.WHITE);
        botonProveedores.setBorderPainted(false);
        panelInvisble.add(botonProveedores);

        botonProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaProveedores ventanaProveedores = new VentanaProveedores();
                ventanaProveedores.setVisible(true);
                dispose();
            }
        });

        /*
        JButton botonAggPro = new JButton("AGREGAR PRODUCTO");
        botonAggPro.setBounds(50,24,170,40);
        botonAggPro.setBackground(Color.WHITE);
        botonAggPro.setBorderPainted(false);
        panelInvisble.add(botonAggPro);

        botonAggPro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAggProducto ventanaAggProducto = new VentanaAggProducto();
                ventanaAggProducto.setVisible(true);
                dispose();
            }
        });
        
         */


        JButton botonDelEmpleado = new JButton("EMPLEADOS");
        botonDelEmpleado.setBounds(450,24,180,40);
        botonDelEmpleado.setBackground(Color.WHITE);
        botonDelEmpleado.setBorderPainted(false);
        panelInvisble.add(botonDelEmpleado);

        botonDelEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaEmpleados ventanaDelEmpleado = new VentanaEmpleados();
                ventanaDelEmpleado.setVisible(true);
                dispose();
            }
        });
    }

    public static void tablaProductos() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>ID<br>REFERENCIA</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>PRODUCTO</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>CANTIDAD</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>PRECIO<br>UNIDAD</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>IVA%</div></html>\"");

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
        panelConScroll.setBounds(560, 0,1000,720);
        panelConScroll.setBackground(Color.white);

        // Agrega el panel con la barra de desplazamiento al panelCentral
        panelInventario.add(panelConScroll, BorderLayout.CENTER);
    }

    // Método para agregar una fila de objetos a la tabla
    public void agregarFila(Object[] objetos) {
        // Agrega una fila con los objetos al modelo de la tabla
        model.addRow(objetos);
        // Llenar la tabla con datos de la lista
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
