package Security;
public class Encriptador {

    public static String encriptar(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Verifica si el caracter es una letra
            if (Character.isLetter(caracter)) {
                char nuevoCaracter = (char) (caracter + 1); // Cambia a la siguiente letra en el alfabeto
                resultado.append(nuevoCaracter);
            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    public static String desencriptar(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            // Verifica si el caracter es una letra
            if (Character.isLetter(caracter)) {
                char nuevoCaracter = (char) (caracter - 1); // Cambia a la letra anterior en el alfabeto
                resultado.append(nuevoCaracter);
            } else {
                resultado.append(caracter);
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {//Prueba
        String mensajeOriginal = "hola";
        String mensajeEncriptado = encriptar(mensajeOriginal);
        System.out.println("Mensaje encriptado: " + mensajeEncriptado);
        String mensajeDesencriptado = desencriptar(mensajeEncriptado);
        System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);
    }
}
