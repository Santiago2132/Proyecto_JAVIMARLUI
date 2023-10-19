package Security;
import java.nio.charset.StandardCharsets;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encriptador {

    // Clave por defecto
    private static final String CLAVE_POR_DEFECTO = "clavePorDefecto";

    // Método para encriptar utilizando AES
    public static String encriptar(String texto) throws Exception {
        return encriptar(texto, CLAVE_POR_DEFECTO);
    }

    // Método para encriptar utilizando AES
    public static String encriptar(String texto, String clave) throws Exception {
        SecretKeySpec claveSecreta = generarClaveSecreta(clave);

        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta);

        byte[] textoEncriptado = cifrador.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }

    // Método para desencriptar utilizando AES
    public static String desencriptar(String textoEncriptado) throws Exception {
        return desencriptar(textoEncriptado, CLAVE_POR_DEFECTO);
    }

    // Método para desencriptar utilizando AES
    public static String desencriptar(String textoEncriptado, String clave) throws Exception {
        SecretKeySpec claveSecreta = generarClaveSecreta(clave);

        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta);

        byte[] textoBytes = Base64.getDecoder().decode(textoEncriptado);
        byte[] textoDesencriptado = cifrador.doFinal(textoBytes);

        return new String(textoDesencriptado, StandardCharsets.UTF_8);
    }

    // Genera una clave secreta en base a una cadena
    private static SecretKeySpec generarClaveSecreta(String clave) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] bytesClave = clave.getBytes(StandardCharsets.UTF_8);
        byte[] hash = sha.digest(bytesClave);

        return new SecretKeySpec(hash, "AES");
    }

    public static void main(String[] args) {
        try {
            String textoOriginal = "¡Hola Mundo! 123";

            String textoEncriptado = encriptar(textoOriginal);
            System.out.println("Texto encriptado: " + textoEncriptado);

            String textoDesencriptado = desencriptar(textoEncriptado);
            System.out.println("Texto desencriptado: " + textoDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}