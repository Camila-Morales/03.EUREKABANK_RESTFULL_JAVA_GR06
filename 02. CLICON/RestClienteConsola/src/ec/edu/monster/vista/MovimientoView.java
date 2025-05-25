package ec.edu.monster.vista;

import ec.edu.monster.controlador.EurekaController;
import ec.edu.monster.modelo.Movimiento;
import java.util.List;
import java.util.Scanner;

public class MovimientoView {
     public void realizarConsulta() {
         Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la consola de consultas bancarias");
        System.out.print("Por favor ingrese su número de cuenta: ");
        String cuenta = scanner.nextLine().trim();

         EurekaController controller = new EurekaController();
         List<Movimiento> movimientos = controller.traerMovimientos(cuenta);

        if (movimientos.isEmpty()) {
            System.out.println("No se encontraron movimientos para la cuenta " + cuenta);
        } else {
            System.out.println("Movimientos encontrados para la cuenta " + cuenta + ":");
            for (Movimiento movimiento : movimientos) {
                System.out.println("Fecha: " + movimiento.getFecha() +
                                   ", Tipo: " + movimiento.getTipo() +
                                   ", Acción: " + movimiento.getAccion() +
                                   ", Importe: " + movimiento.getImporte());
            }
        }
    }
}
