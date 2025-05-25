package ec.edu.monster.vista;

import ec.edu.monster.controlador.EurekaController;
import java.util.Scanner;
import javax.ws.rs.core.Response;

public class RetiroView {

    public void realizarRetiro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la consola de retiros bancarios");
        System.out.print("Por favor ingrese su número de cuenta: ");
        String cuenta = scanner.nextLine().trim();
        System.out.print("Por favor ingrese el importe para el retiro: ");
        double importe;

        try {
            importe = Double.parseDouble(scanner.nextLine().trim());
            EurekaController controller = new EurekaController();
            Response response = controller.realizarRetiro(cuenta, importe);

            if (response.getStatus() == 200) {
                System.out.println("Retiro realizado exitosamente.");
            } else {
                System.out.println("No se pudo realizar el retiro. Código de estado: " + response.getStatus());
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un importe válido.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al intentar realizar el retiro.");
            e.printStackTrace();
        }
    }
}
