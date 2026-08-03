package actividad2;

import java.util.Scanner;


/**
 *
 * @author Hans Juárez 
 */

public class Actividad2 {

    static Scanner entrada = new Scanner(System.in);

    static int totalDatos = 5;
    static double media = 0;
    static char respuesta = 'S';
    static boolean programaActivo = true;

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" ANALIZADOR DE NUMEROS ");
        System.out.println("================================");

        int[] vector = new int[totalDatos];
        capturarVector(vector);
        calcularEstadisticas(vector);

    }
    public static void capturarVector(int[] vector) {

    System.out.println("\n===== CAPTURA DE DATOS =====");

    for (int indice = 0; indice < vector.length; indice++) {

        vector[indice] = solicitarNumero(
                "Valor #" + (indice + 1) + " (1-100): ");

    }

}

    public static int solicitarNumero(String texto) {

        int datoIngresado;

        while (true) {

            System.out.print(texto);

            if (!entrada.hasNextInt()) {

                System.out.println("Entrada inválida.");
                entrada.next();
                continue;

            }

            datoIngresado = entrada.nextInt();

            if (datoIngresado >= 1 && datoIngresado <= 100) {

                return datoIngresado;

            }

            System.out.println("Número fuera del rango.");

        }

}
    public static void calcularEstadisticas(int[] vector) {

    int maximo = vector[0];
    int minimo = vector[0];
    int acumulador = 0;

    for (int valor : vector) {

        acumulador += valor;

        if (valor > maximo) {
            maximo = valor;
        }

        if (valor < minimo) {
            minimo = valor;
        }

    }

    media = (double) acumulador / vector.length;

    System.out.println("\n===== RESULTADOS =====");

    System.out.println("Mayor: " + maximo);
    System.out.println("Menor: " + minimo);
    System.out.println("Promedio: " + media);

}

}