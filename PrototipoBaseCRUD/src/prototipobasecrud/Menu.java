/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prototipobasecrud;

import java.util.Scanner;

/**
 *
 * @author darav
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Conexion enlace = new Conexion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Insertar datos");
            System.out.println("2. Actualizar datos");
            System.out.println("3. Eliminar datos");
            System.out.println("4. Obtener datos");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    enlace.insertarDatos();
                    break;
                case 2:
                    enlace.actualizarDatos();
                    break;
                case 3:
                    enlace.eliminarDatos();
                    break;
                case 4:
                    mostrarDatos(enlace.obtenerDatos());
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void mostrarDatos(java.util.List<String> datos) {
        System.out.println("Datos obtenidos:");
        for (String dato : datos) {
            System.out.println(dato);
        }
    }
}
