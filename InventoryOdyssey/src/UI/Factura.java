package UI;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Factura extends JFrame {

    public static void main(String[] args){
        Factura factura = new Factura();
        factura.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    static JPanel panelFactura = new JPanel();

    static JTable table = new JTable();
    static DefaultTableModel model = new DefaultTableModel();


    public Factura(){
        this.setTitle("INVENTORY ODYSSEY - FACTURA");
        this.setSize(600,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.WHITE);
        panelContenedor();
        panelFactura();
        tablaFactura();
        agregarFila(new Object []{"2","Martillo HD","19%","15.000"});
        agregarFila(new Object []{"1","Cajo de clavos","19%","5.000"});
        agregarFila(new Object []{"2","Guantes anti-cortes","19%","30.000"});
        agregarFila(new Object []{"3","Tijeras","19%","10.000"});
    }

    public void panelFactura(){

        panelFactura.setLayout(null);
        panelFactura.setBounds(0, 0, 600,800);
        panelFactura.setOpaque(true);
        Color color = Color.decode("#FFFFFF");
        panelFactura.setBackground(color);

        JLabel imagen = new JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/herramientas (1).png"));
        Image icono = icon.getImage().getScaledInstance(67, 67, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(250,10,67,67);
        panelFactura.add(imagen);

        JLabel titulo = new JLabel("INVENTORY ODYSSEY");
        titulo.setFont(new Font("Rockwell",Font.BOLD,20));
        titulo.setBounds(180,90,400,20);
        titulo.setForeground(Color.black);
        panelFactura.add(titulo);

        JLabel InfoCarrera = new JLabel("Calle 33 # 24-30");
        InfoCarrera.setFont(new Font("Rockwell",Font.BOLD,14));
        InfoCarrera.setBounds(150,120,200,14);
        InfoCarrera.setForeground(Color.black);
        panelFactura.add(InfoCarrera);

        JLabel InfoTelefono = new JLabel("Tel: 3127531291");
        InfoTelefono.setFont(new Font("Rockwell",Font.BOLD,14));
        InfoTelefono.setBounds(300,120,200,14);
        InfoTelefono.setForeground(Color.black);
        panelFactura.add(InfoTelefono);

        JLabel InfoLocation = new JLabel("SANTANDER - BUCARAMANGA");
        InfoLocation.setFont(new Font("Rockwell",Font.BOLD,14));
        InfoLocation.setBounds(173,140,250,14);
        InfoLocation.setForeground(Color.black);
        panelFactura.add(InfoLocation);

        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Formatear la fecha y la hora en formatos deseados
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaFormateada = fechaHoraActual.format(formatoFecha);
        String horaFormateada = fechaHoraActual.format(formatoHora);

        // Crear JLabels para mostrar la fecha y la hora
        JLabel fechaLabel = new JLabel("Fecha: " + fechaFormateada);
        fechaLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
        fechaLabel.setBounds(153, 160, 150, 14);
        fechaLabel.setForeground(Color.black);
        panelFactura.add(fechaLabel);

        JLabel horaLabel = new JLabel("Hora: " + horaFormateada);
        horaLabel.setFont(new Font("Rockwell", Font.BOLD, 14));
        horaLabel.setBounds(308, 160, 150, 14);
        horaLabel.setForeground(Color.black);
        panelFactura.add(horaLabel);

        JLabel clienteNombre = new JLabel("Cliente:  ");
        clienteNombre.setFont(new Font("Rockwell",Font.PLAIN,12));
        clienteNombre.setBounds(20,210,600,12);
        clienteNombre.setForeground(Color.black);
        panelFactura.add(clienteNombre);

        JLabel clienteId = new JLabel("Identificación:  ");
        clienteId.setFont(new Font("Rockwell",Font.PLAIN,12));
        clienteId.setBounds(20,225,600,12);
        clienteId.setForeground(Color.black);
        panelFactura.add(clienteId);

        JLabel clienteDireccion = new JLabel("Dirección:  ");
        clienteDireccion.setFont(new Font("Rockwell",Font.PLAIN,12));
        clienteDireccion.setBounds(20,240,600,12);
        clienteDireccion.setForeground(Color.black);
        panelFactura.add(clienteDireccion);

        JLabel clienteTelefono = new JLabel("Teléfono:  ");
        clienteTelefono.setFont(new Font("Rockwell",Font.PLAIN,12));
        clienteTelefono.setBounds(20,255,600,12);
        clienteTelefono.setForeground(Color.black);
        panelFactura.add(clienteTelefono);

        JLabel subtotalLabel = new JLabel("SUBTOTAL: ");
        subtotalLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
        subtotalLabel.setBounds(358, 450, 200, 12);
        subtotalLabel.setForeground(Color.black);
        panelFactura.add(subtotalLabel);

        JLabel descuentoLabel = new JLabel("Descuento: ");
        descuentoLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
        descuentoLabel.setBounds(358, 470, 200, 12);
        descuentoLabel.setForeground(Color.black);
        panelFactura.add(descuentoLabel);

        JLabel ivaLabel = new JLabel("IVA: ");
        ivaLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
        ivaLabel.setBounds(358, 490, 200, 12);
        ivaLabel.setForeground(Color.black);
        panelFactura.add(ivaLabel);

        JLabel totalLabel = new JLabel("Total: ");
        totalLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
        totalLabel.setBounds(358, 510, 200, 12);
        totalLabel.setForeground(Color.black);
        panelFactura.add(totalLabel);

        JLabel recibidoLabel = new JLabel("Recibido: ");
        recibidoLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
        recibidoLabel.setBounds(358, 530, 200, 12);
        recibidoLabel.setForeground(Color.black);
        panelFactura.add(recibidoLabel);

        JLabel cambioLabel = new JLabel("Cambio: ");
        cambioLabel.setFont(new Font("Rockwell", Font.BOLD, 12));
        cambioLabel.setBounds(358, 550, 200, 12);
        cambioLabel.setForeground(Color.black);
        panelFactura.add(cambioLabel);

        JLabel cantArti = new JLabel("Cantidad de Articulos: : ");
        cantArti.setFont(new Font("Rockwell", Font.BOLD, 12));
        cantArti.setBounds(80, 600, 500, 12);
        cantArti.setForeground(Color.black);
        panelFactura.add(cantArti);

        JLabel formaDPago = new JLabel("Forma de Pago: : ");
        formaDPago.setFont(new Font("Rockwell", Font.BOLD, 12));
        formaDPago.setBounds(80, 620, 500, 12);
        formaDPago.setForeground(Color.black);
        panelFactura.add(formaDPago);

        JLabel atendido = new JLabel("Antendido Por: ");
        atendido.setFont(new Font("Rockwell", Font.BOLD, 12));
        atendido.setBounds(80, 650, 500, 12);
        atendido.setForeground(Color.black);
        panelFactura.add(atendido);

        JLabel imagen1 = new JLabel();
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/Imagenes/ditto.jpeg"));
        Image icono1 = icon1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        imagen1.setIcon(new ImageIcon(icono1));
        imagen1.setBounds(150,475,80,80);
        panelFactura.add(imagen1);

        JLabel agradecido = new JLabel("GRACIAS POR SU COMPRA");
        agradecido.setFont(new Font("Rockwell", Font.BOLD, 12));
        agradecido.setBounds(200, 690, 500, 12);
        agradecido.setForeground(Color.black);
        panelFactura.add(agradecido);

        JLabel INFO = new JLabel("GARANTÍA DE 15 DÍAS POR DEFECTO DE FABRICA PRESENTADO POR ESTA FACTURA");
        INFO.setFont(new Font("Rockwell", Font.BOLD, 12));
        INFO.setBounds(40, 720, 800, 12);
        INFO.setForeground(Color.black);
        panelFactura.add(INFO);
    }

    public static void tablaFactura() {
        // Crear un modelo de tabla
        model = new DefaultTableModel();
        model.addColumn("<html><div style='text-align: center;'>CANTIDAD</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>DESCRIPCIÓN</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>IVA%</div></html>\"");
        model.addColumn("<html><div style='text-align: center;'>PRECIO</div></html>\"");

        // Configurar filas de diferentes alturas
        table = new JTable(model);


        // Establecer el tamaño de todas las celdas de la tabla
        int cellHeight = 25; // Altura deseada de las celdas

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
        panelConScroll.setBounds(20, 280, 550, 150);
        panelConScroll.setBackground(Color.white);

        // Agrega el panel con la barra de desplazamiento al panelCentral
        panelFactura.add(panelConScroll, BorderLayout.CENTER);
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
        contenedor.add(panelFactura,Integer.valueOf(2));

        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
