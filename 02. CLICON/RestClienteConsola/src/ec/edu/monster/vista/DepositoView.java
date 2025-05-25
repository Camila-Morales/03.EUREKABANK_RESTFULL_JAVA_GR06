package ec.edu.monster.vista;

import ec.edu.monster.controlador.EurekaController;
import ec.edu.monster.modelo.Movimiento;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.Response;

public class DepositoView {
      public void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la consola de depósitos bancarios");
        System.out.print("Por favor ingrese su número de cuenta: ");
        String cuenta = scanner.nextLine().trim();

        System.out.print("Ingrese el importe a depositar: ");
        double importe = scanner.nextDouble();

        EurekaController controller = new EurekaController();
          Response response = controller.realizarDeposito(cuenta, importe);

        if (response.getStatus() == 200) {
            System.out.println("Depósito realizado exitosamente para la cuenta " + cuenta);
        } else {
            System.out.println("Error al realizar el depósito para la cuenta " + cuenta);
        }
    }
}
