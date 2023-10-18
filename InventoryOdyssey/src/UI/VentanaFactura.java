package UI;

import UI.VentanaAggProducto;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.Map;

public class VentanaFactura extends JFrame {

    public static void main(String[]args){
        VentanaFactura ventanaFactura = new VentanaFactura();
        ventanaFactura.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JLabel fondo = new JLabel();
    JPanel panelTitulo = new JPanel();
    static JPanel panelInfo = new JPanel();
    JPanel panelFondo = new JPanel();
    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();



    public VentanaFactura(){
        this.setTitle("INVENTORY ODYSSEY - FACTURA");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        panelContenedor();
        panelFondo();
        panelTitulo();
        panelInfo();
        tablaProductos();
        agregarFila(new Object []{});
    }

    public void panelFondo(){
        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 0, 1535,800);
        panelFondo.setOpaque(true);
        Color color =  Color.decode("#514D88");
        panelFondo.setBackground(color);
    }

    public void panelTitulo(){
        panelTitulo.setLayout(null);
        panelTitulo.setBounds(170, 90, 1200,100);
        panelTitulo.setOpaque(true);
        Color color =  Color.decode("#211F3A");
        panelTitulo.setBackground(color);

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/cuenta.png"));
        Image icono = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(50,18,64,64);
        panelTitulo.add(imagen);

        JLabel titulo = new JLabel("FACTURA");
        titulo.setBounds(140,18,250,64);
        titulo.setFont(new Font("Rockwell",Font.BOLD,45));
        titulo.setForeground(Color.white);
        panelTitulo.add(titulo);

        JLabel m = new JLabel("INVENTORY");
        m.setBounds(900,25,200,25);
        m.setFont(new Font("Rockwell",Font.BOLD,25));
        m.setForeground(Color.white);
        panelTitulo.add(m);

        JLabel n = new JLabel("ODISSEY");
        n.setBounds(900,49,150,25);
        n.setFont(new Font("Rockwell",Font.BOLD,25));
        n.setForeground(Color.white);
        panelTitulo.add(n);
    }

    public void panelInfo(){
        panelInfo.setLayout(null);
        panelInfo.setBounds(170, 190, 1200,530);
        panelInfo.setOpaque(true);
        Color color =  Color.decode("#F3F3F3");
        panelInfo.setBackground(color);

        JButton AggCliente = new JButton("AGREGAR CLIENTE");
        AggCliente.setBounds(40,100,160,40);
        AggCliente.setBackground(Color.WHITE);
        AggCliente.setBorderPainted(true);
        panelInfo.add(AggCliente);

        AggCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAggClientes ventanaAggClientes = new VentanaAggClientes();
                ventanaAggClientes.setVisible(true);
                dispose();
            }
        });

        JButton generarFactura = new JButton("GENERAR FACTURA");
        generarFactura.setBounds(950,30,170,40);
        /*ImageIcon imgR = new ImageIcon("src/Imagenes/GenrarFactura.PNG");// se le pone icono a boton
        Icon i = new ImageIcon(imgR.getImage().getScaledInstance(generarFactura.getWidth(), generarFactura.getHeight(), Image.SCALE_SMOOTH));
        generarFactura.setIcon(i);*/
        generarFactura.setBackground(Color.white);
        generarFactura.setBorderPainted(true);
        /*ImageIcon imgadmin = new ImageIcon("src/Imagenes/GenrarFactura.PNG");// se le pone icono a boton
        Icon iconAdmin = new ImageIcon(imgadmin.getImage().getScaledInstance(generarFactura.getWidth(), generarFactura.getHeight(), Image.SCALE_SMOOTH));
        generarFactura.setRolloverIcon(iconAdmin);*/
        panelInfo.add(generarFactura);

        generarFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Factura factura = new Factura();
                factura.setVisible(true);
                //dispose();
            }
        });

        JButton aggProducto = new JButton("AGREGAR PRODUCTO");
        aggProducto.setBounds(950,80,170,40);
        aggProducto.setBackground(Color.WHITE);
        aggProducto.setBorderPainted(true);
        panelInfo.add(aggProducto);

        aggProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAggProducto ventanaAggProducto = new VentanaAggProducto();
                ventanaAggProducto.setVisible(true);
                dispose();
            }
        });

        JTextField idCliente = new JTextField();
        idCliente.setBounds(40,42,160,30);
        idCliente.setFont(new Font("Rockwell",Font.BOLD,12));
        panelInfo.add(idCliente);


        JTextField nombre = new JTextField();
        nombre.setBounds(400,42,160,30);
        nombre.setFont(new Font("Rockwell",Font.BOLD,12));
        panelInfo.add(nombre);

        JTextField telefono = new JTextField();
        telefono.setBounds(690,42,160,30);
        telefono.setFont(new Font("Rockwell",Font.BOLD,12));
        panelInfo.add(telefono);

        JTextField correo = new JTextField();
        correo.setBounds(400,90,180,30);
        correo.setFont(new Font("Rockwell",Font.BOLD,12));
        panelInfo.add(correo);

        JTextField direccion = new JTextField();
        direccion.setBounds(700,90,180,30);
        direccion.setFont(new Font("Rockwell",Font.BOLD,12));
        panelInfo.add(direccion);

        //LABELS
        JLabel nombre1 = new JLabel("Nombre: ");
        nombre1.setBounds(320,45,100,20);
        nombre1.setFont(new Font("Rockwell",Font.BOLD,15));
        panelInfo.add(nombre1);

        JLabel coreo1 = new JLabel("Correo: ");
        coreo1.setBounds(325,91,100,20);
        coreo1.setFont(new Font("Rockwell",Font.BOLD,15));
        panelInfo.add(coreo1);

        JLabel telefono1 = new JLabel("Telefono: ");
        telefono1.setBounds(610,45,100,20);
        telefono1.setFont(new Font("Rockwell",Font.BOLD,15));
        panelInfo.add(telefono1);

        JLabel direccion1 = new JLabel("Dirección: ");
        direccion1.setBounds(610,91,100,20);
        direccion1.setFont(new Font("Rockwell",Font.BOLD,15));
        panelInfo.add(direccion1);


    }

    //tabla deslizable
    public static void tablaProductos() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>ID<br>Producto</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>Producto</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>Cantidad</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>Precio<br>Unidad</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>IVA % </div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>Precio<br>Total</div></html>\"");
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
        panelConScroll.setBounds(95, 180, 1000, 290);
        panelConScroll.setBackground(Color.white);

        // Agrega el panel con la barra de desplazamiento al panelCentral
        panelInfo.add(panelConScroll, BorderLayout.CENTER);
    }

    // Método para agregar una fila de objetos a la tabla
    public void agregarFila(Object[] objetos) {
        // Agrega una fila con los objetos al modelo de la tabla
        model.addRow(objetos);
        // Llenar la tabla con datos de la lista
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
        contenedor.add(panelTitulo,Integer.valueOf(3));
        contenedor.add(panelInfo,Integer.valueOf(3));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
