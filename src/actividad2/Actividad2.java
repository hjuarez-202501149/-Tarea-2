package actividad2;

import java.util.Scanner;


/**
 *
 * @author Hans Juárez 
 */

public class Actividad2 {

    // Scanner para leer lo que escribe el usuario
    static final Scanner entrada = new Scanner(System.in);

    // Cantidad de números que se van a pedir
    static int totalDatos = 5;

    // Aquí se guardará el promedio
    static double media = 0;

    // Variables declaradas para practicar tipos primitivos
    static char respuesta = 'S';
    static boolean programaActivo = true;

    public static void main(String[] args) {

        // Vector donde se almacenan los números
        int[] vector = new int[totalDatos];

        // Matriz de 3 filas por 3 columnas
        int[][] tabla = new int[3][3];

        // Llenar el vector
        capturarVector(vector);

        // Mostrar mayor, menor y promedio
        calcularEstadisticas(vector);

        // Llenar la matriz
        capturarMatriz(tabla);

        // Mostrar la matriz y la suma de sus datos
        imprimirMatriz(tabla);
    }

    // Pide los números para llenar el vector
    public static void capturarVector(int[] vector) {

        System.out.println("\n===== CAPTURA DE DATOS =====");

        // Recorre todas las posiciones del vector
        for (int indice = 0; indice < vector.length; indice++) {

            vector[indice] = solicitarNumero(
                    "Valor #" + (indice + 1) + " (entre 1 y 100): ");
        }

    }

    // Valida que el número sea entero y esté dentro del rango
    public static int solicitarNumero(String texto) {

        int datoIngresado;

        while (true) {

            System.out.print(texto);

            // Si no es un entero vuelve a pedir el dato
            if (!entrada.hasNextInt()) {

                System.out.println("Entrada inválida. Solo se aceptan números enteros.");
                entrada.next();
                continue;

            }

            datoIngresado = entrada.nextInt();

            // Solo acepta números entre 1 y 100
            if (datoIngresado >= 1 && datoIngresado <= 100) {
                return datoIngresado;
            }

            System.out.println("El valor debe estar comprendido entre 1 y 100.");

        }

    }

    // Obtiene el mayor, el menor y el promedio del vector
    public static void calcularEstadisticas(int[] vector) {

        int maximo = vector[0];
        int minimo = vector[0];
        int acumulador = 0;

        // Recorre todos los valores del vector
        for (int valor : vector) {

            acumulador += valor;

            if (valor > maximo) {
                maximo = valor;
            }

            if (valor < minimo) {
                minimo = valor;
            }

        }

        // Calcula el promedio
        media = (double) acumulador / vector.length;

        System.out.println("\n===== RESUMEN =====");
        System.out.println("Número mayor: " + maximo);
        System.out.println("Número menor: " + minimo);
        System.out.println("Media: " + media);

    }

    // Llena la matriz con los datos que ingresa el usuario
    public static void capturarMatriz(int[][] tabla) {

        System.out.println("\n===== INGRESO DE MATRIZ =====");

        for (int fila = 0; fila < tabla.length; fila++) {

            for (int columna = 0; columna < tabla[fila].length; columna++) {

                tabla[fila][columna] = solicitarNumero(
                        "Dato [" + fila + "][" + columna + "]: ");

            }

        }

    }

    // Imprime la matriz y suma todos sus elementos
    public static void imprimirMatriz(int[][] tabla) {

        int total = 0;

        System.out.println("\n===== MATRIZ REGISTRADA =====");

        for (int fila = 0; fila < tabla.length; fila++) {

            for (int columna = 0; columna < tabla[fila].length; columna++) {

                System.out.printf("%4d", tabla[fila][columna]);
                total += tabla[fila][columna];

            }

            System.out.println();

        }

        // Muestra la suma de todos los números de la matriz
        System.out.println("\nTotal acumulado de la matriz: " + total);

    }

}