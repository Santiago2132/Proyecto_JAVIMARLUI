package UI;

import javax.swing.*;
import java.awt.*;

public class VentanaReportes extends JFrame{

    public static void main(String[] args){
        VentanaReportes ventanaReportes = new VentanaReportes();
        ventanaReportes.setVisible(true);
    }

    JLayeredPane contenedor = new JLayeredPane();
    JPanel panelFondo = new JPanel();
    JPanel panelProMVendidos = new JPanel();
    JPanel panelProMnVendidos = new JPanel();
    JPanel calEnero = new JPanel();
    JPanel calFebrero = new JPanel();
    JPanel calMarzo = new JPanel();
    JPanel calAbril = new JPanel();
    JPanel calMayo = new JPanel();
    JPanel calJunio = new JPanel();
    JPanel calJulio = new JPanel();
    JPanel calAgos = new JPanel();
    JPanel calSep = new JPanel();
    JPanel calOct = new JPanel();
    JPanel calNov = new JPanel();
    JPanel calDecem = new JPanel();
    JPanel panelFondo1 = new JPanel();
    JPanel vendedorDelMes = new JPanel();
    JPanel titulo = new JPanel();
    JPanel titulo2 = new JPanel();

    public VentanaReportes(){
        this.setTitle("INVENTORY ODYSSEY - REPORTES");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setBackground(Color.white);
        panelContenedor();
        panelFondo();
        panelProMVendidos();
        panelProMnVendidos();
        titulo();
        titulo2();
        vendedorDelMes();
        panelFondo1();
        calEnero();
        calFebrero();
        calMarzo();
        calAbril();
        calMayo();
        calJunio();
        calJulio();
        calAgos();
        calSep();
        calOct();
        calNov();
        calDecem();
    }


    public void panelFondo(){
        panelFondo.setLayout(null);
        panelFondo.setBounds(0, 0, 1535,800);
        panelFondo.setOpaque(true);
        Color color = Color.decode("#6E80A1");
        panelFondo.setBackground(color);
    }

    public void titulo(){
        titulo.setLayout(null);
        titulo.setBounds(30, 30, 250,60);
        titulo.setOpaque(true);
        Color color = Color.decode("#211F3A");
        titulo.setBackground(color);

        JLabel subT = new JLabel("PRODUCTOS MÁS VENDIDOS");
        subT.setFont(new Font("Rockwell",Font.BOLD,15));
        subT.setBounds(15,20,250,20);
        subT.setForeground(Color.WHITE);
        titulo.add(subT);
    }
    public void panelProMVendidos(){
        panelProMVendidos.setLayout(null);
        panelProMVendidos.setBounds(30, 30, 250,350);
        panelProMVendidos.setOpaque(true);
        Color color = Color.decode("#FFFFFF");
        panelProMVendidos.setBackground(color);
    }

    public void titulo2(){
        titulo2.setLayout(null);
        titulo2.setBounds(30, 410, 250,60);
        titulo2.setOpaque(true);
        Color color = Color.decode("#211F3A");
        titulo2.setBackground(color);

        JLabel subT2 = new JLabel("PRODUCTOS MENOS VENDIDOS");
        subT2.setFont(new Font("Rockwell",Font.BOLD,14));
        subT2.setBounds(11,20,250,20);
        subT2.setForeground(Color.WHITE);
        titulo2.add(subT2);
    }
    public void panelProMnVendidos(){
        panelProMnVendidos.setLayout(null);
        panelProMnVendidos.setBounds(30, 410, 250,350);
        panelProMnVendidos.setOpaque(true);
        Color color = Color.decode("#FFFFFF");
        panelProMnVendidos.setBackground(color);
    }

    public void vendedorDelMes(){
        vendedorDelMes.setLayout(null);
        vendedorDelMes.setBounds(320, 30, 600,730);
        vendedorDelMes.setOpaque(true);
        Color color = Color.decode("#F3F3F3");
        vendedorDelMes.setBackground(color);

        JLabel tEmpleado = new JLabel("EMPLEADO DEL MES");
        tEmpleado.setFont(new Font("Rockwell",Font.BOLD,35));
        tEmpleado.setBounds(120,70,380,40);
        tEmpleado.setForeground(Color.BLACK);
        vendedorDelMes.add(tEmpleado);

        JLabel imagen = new JLabel();
        ImageIcon image = new ImageIcon(getClass().getResource("/Imagenes/empleado-del-mes.png"));
        Image icono = image.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        imagen.setIcon(new ImageIcon(icono));
        imagen.setBounds(140,260,350,350);
        vendedorDelMes.add(imagen);
    }

    public void panelFondo1(){
        panelFondo1.setLayout(null);
        panelFondo1.setBounds(960, 30, 540,730);
        panelFondo1.setOpaque(true);
        Color color = Color.decode("#FFFFFF");
        panelFondo1.setBackground(color);

        JLabel anio = new JLabel("2023");
        anio.setFont(new Font("Rockwell",Font.BOLD,40));
        anio.setBounds(223,20,250,40);
        anio.setForeground(Color.BLACK);
        panelFondo1.add(anio);
    }

    public void calEnero(){
        calEnero.setLayout(null);
        calEnero.setBounds(1010, 120, 200,80);
        calEnero.setOpaque(true);
        Color color = Color.decode("#100932");
        calEnero.setBackground(color);

        JLabel enero = new JLabel("ENERO");
        enero.setFont(new Font("Rockwell",Font.BOLD,20));
        enero.setBounds(65,10,100,20);
        enero.setForeground(Color.WHITE);
        calEnero.add(enero);
    }

    public void calFebrero(){
        calFebrero.setLayout(null);
        calFebrero.setBounds(1250, 120, 200,80);
        calFebrero.setOpaque(true);
        Color color = Color.decode("#100932");
        calFebrero.setBackground(color);

        JLabel febrero = new JLabel("FEBRERO");
        febrero.setFont(new Font("Rockwell",Font.BOLD,20));
        febrero.setBounds(52,10,100,20);
        febrero.setForeground(Color.WHITE);
        calFebrero.add(febrero);
    }

    public void calMarzo(){
        calMarzo.setLayout(null);
        calMarzo.setBounds(1010, 220, 200,80);
        calMarzo.setOpaque(true);
        Color color = Color.decode("#100932");
        calMarzo.setBackground(color);

        JLabel marzo = new JLabel("MARZO");
        marzo.setFont(new Font("Rockwell",Font.BOLD,20));
        marzo.setBounds(65,10,100,20);
        marzo.setForeground(Color.WHITE);
        calMarzo.add(marzo);
    }

    public void calAbril(){
        calAbril.setLayout(null);
        calAbril.setBounds(1250, 220, 200,80);
        calAbril.setOpaque(true);
        Color color = Color.decode("#100932");
        calAbril.setBackground(color);

        JLabel abril = new JLabel("ABRIL");
        abril.setFont(new Font("Rockwell",Font.BOLD,20));
        abril.setBounds(65,10,100,20);
        abril.setForeground(Color.WHITE);
        calAbril.add(abril);
    }

    public void calMayo(){
        calMayo.setLayout(null);
        calMayo.setBounds(1010, 320, 200,80);
        calMayo.setOpaque(true);
        Color color = Color.decode("#100932");
        calMayo.setBackground(color);

        JLabel mayo = new JLabel("MAYO");
        mayo.setFont(new Font("Rockwell",Font.BOLD,20));
        mayo.setBounds(65,10,100,20);
        mayo.setForeground(Color.WHITE);
        calMayo.add(mayo);
    }

    public void calJunio(){
        calJunio.setLayout(null);
        calJunio.setBounds(1250, 320, 200,80);
        calJunio.setOpaque(true);
        Color color = Color.decode("#100932");
        calJunio.setBackground(color);

        JLabel junio = new JLabel("JUNIO");
        junio.setFont(new Font("Rockwell",Font.BOLD,20));
        junio.setBounds(65,10,100,20);
        junio.setForeground(Color.WHITE);
        calJunio.add(junio);
    }

    public void calJulio(){
        calJulio.setLayout(null);
        calJulio.setBounds(1010, 420, 200,80);
        calJulio.setOpaque(true);
        Color color = Color.decode("#100932");
        calJulio.setBackground(color);

        JLabel julio = new JLabel("JULIO");
        julio.setFont(new Font("Rockwell",Font.BOLD,20));
        julio.setBounds(65,10,100,20);
        julio.setForeground(Color.WHITE);
        calJulio.add(julio);
    }

    public void calAgos(){
        calAgos.setLayout(null);
        calAgos.setBounds(1250, 420, 200,80);
        calAgos.setOpaque(true);
        Color color = Color.decode("#100932");
        calAgos.setBackground(color);

        JLabel agos = new JLabel("AGOSTO");
        agos.setFont(new Font("Rockwell",Font.BOLD,20));
        agos.setBounds(56,10,100,20);
        agos.setForeground(Color.WHITE);
        calAgos.add(agos);
    }
    public void calSep(){
        calSep.setLayout(null);
        calSep.setBounds(1010, 520, 200,80);
        calSep.setOpaque(true);
        Color color = Color.decode("#100932");
        calSep.setBackground(color);

        JLabel sep = new JLabel("SEPTIEMBRE");
        sep.setFont(new Font("Rockwell",Font.BOLD,20));
        sep.setBounds(37,10,150,20);
        sep.setForeground(Color.WHITE);
        calSep.add(sep);
    }

    public void calOct(){
        calOct.setLayout(null);
        calOct.setBounds(1250, 520, 200,80);
        calOct.setOpaque(true);
        Color color = Color.decode("#100932");
        calOct.setBackground(color);

        JLabel oct = new JLabel("OCTUBRE");
        oct.setFont(new Font("Rockwell",Font.BOLD,20));
        oct.setBounds(49,10,100,20);
        oct.setForeground(Color.WHITE);
        calOct.add(oct);
    }

    public void calNov(){
        calNov.setLayout(null);
        calNov.setBounds(1010, 620, 200,80);
        calNov.setOpaque(true);
        Color color = Color.decode("#100932");
        calNov.setBackground(color);

        JLabel nov = new JLabel("NOVIEMBRE");
        nov.setFont(new Font("Rockwell",Font.BOLD,20));
        nov.setBounds(36,10,150,20);
        nov.setForeground(Color.WHITE);
        calNov.add(nov);
    }

    public void calDecem(){
        calDecem.setLayout(null);
        calDecem.setBounds(1250, 620, 200,80);
        calDecem.setOpaque(true);
        Color color = Color.decode("#100932");
        calDecem.setBackground(color);

        JLabel dec = new JLabel("DICIEMBRE");
        dec.setFont(new Font("Rockwell",Font.BOLD,20));
        dec.setBounds(45,10,150,20);
        dec.setForeground(Color.WHITE);
        calDecem.add(dec);
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
        contenedor.add(panelProMVendidos,Integer.valueOf(3));
        contenedor.add(panelProMnVendidos,Integer.valueOf(3));
        contenedor.add(titulo,Integer.valueOf(4));
        contenedor.add(titulo2,Integer.valueOf(4));
        contenedor.add(vendedorDelMes,Integer.valueOf(4));
        contenedor.add(panelFondo1,Integer.valueOf(4));
        contenedor.add(calEnero,Integer.valueOf(5));
        contenedor.add(calFebrero,Integer.valueOf(5));
        contenedor.add(calMarzo,Integer.valueOf(5));
        contenedor.add(calAbril,Integer.valueOf(5));
        contenedor.add(calMayo,Integer.valueOf(5));
        contenedor.add(calJunio,Integer.valueOf(5));
        contenedor.add(calJulio,Integer.valueOf(5));
        contenedor.add(calAgos,Integer.valueOf(5));
        contenedor.add(calSep,Integer.valueOf(5));
        contenedor.add(calOct,Integer.valueOf(5));
        contenedor.add(calNov,Integer.valueOf(5));
        contenedor.add(calDecem,Integer.valueOf(5));


        this.getContentPane().add(contenedor);//se agrega el contenedor a la ventana
        contenedor.setSize(screenSize);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
