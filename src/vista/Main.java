package vista;

import java.util.Scanner;
import controlador.ControladorTorneo;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorTorneo controlador = new ControladorTorneo();
        int opcion = 0;

        do {
            System.out.println("\n========================================");
            System.out.println("    SISTEMA DE SORTEO - LIGA PROFESIONAL");
            System.out.println("========================================");
            System.out.println("1. Sortear Octavos de Final (16 equipos)");
            System.out.println("2. Ver partidos de la ronda actual");
            System.out.println("3. Guardar Torneo (Serializar)");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        controlador.ejecutarSorteoOctavos();
                        break;
                    case 2:
                        controlador.mostrarPartidosActuales();
                        break;
                    case 3:
                        controlador.guardarProgreso();
                        break;
                    case 4:
                        System.out.println("¡Saliendo de la aplicación. Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); // Limpiar buffer
            }
        } while (opcion != 4);

        scanner.close();
    }
}