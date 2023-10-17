package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String usuario="root";
    private static String contrasena ="patricia";
    private static String url = "jdbc:mysql://localhost:3306/inventoryodissey";

    static {
        try {
            Class.forName(driver);
            System.out.println("conexion con mysql" );
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error en el driver" );
        }
    }

    static Connection con=null;
    public static Connection getConnection() {
        try {
            con=DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("conectado a mysql" );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error de conexion");
        }
        return con;
    }

    public Connection close() {
        try {

            con.close();
            System.out.println("se cerro la conexion exitosamente" );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error de conexion");

        }
        return con;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        BaseDatos db=new BaseDatos();
        db.getConnection();
        db.close();
    }
}
