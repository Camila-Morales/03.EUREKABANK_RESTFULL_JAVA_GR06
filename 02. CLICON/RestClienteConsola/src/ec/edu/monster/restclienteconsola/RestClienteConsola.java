package ec.edu.monster.restclienteconsola;

import ec.edu.monster.vista.MovimientoView;
import ec.edu.monster.vista.RetiroView;
import ec.edu.monster.vista.TransferenciaView;
import ec.edu.monster.vista.DepositoView;
import java.util.Scanner;

public class RestClienteConsola {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MovimientoView consolaConsultas = new MovimientoView();
        RetiroView consolaRetiro = new RetiroView();
        TransferenciaView consolaTransferencia = new TransferenciaView();
        DepositoView consolaDeposito = new DepositoView();

        boolean autenticado = false;

        // Proceso de login
        while (!autenticado) {
            System.out.print("Ingrese el usuario: ");
            String usuario = scanner.nextLine();
            System.out.print("Ingrese la clave: ");
            String clave = scanner.nextLine();

            if (usuario.equals("Monster") && clave.equals("Monster9")) {
                autenticado = true;
                System.out.println("¡Login exitoso! Bienvenido al sistema.");
            } else {
                System.out.println("Credenciales incorrectas. Intente nuevamente.\n");
            }
        }

        boolean salir = false;

        // Menú principal para navegar entre las opciones
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    consolaConsultas.realizarConsulta();
                    break;
                case 2:
                    consolaDeposito.realizarDeposito();
                    break;
                case 3:
                    consolaRetiro.realizarRetiro();
                    break;
                case 4:
                    consolaTransferencia.realizarTransferencia();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        }

        System.out.println("¡Gracias por utilizar nuestro sistema!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Consultar movimientos");
        System.out.println("2. Realizar depósito");
        System.out.println("3. Realizar retiro");
        System.out.println("4. Realizar transferencia");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
