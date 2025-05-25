package ec.edu.monster.controlador;

import ec.edu.monster.modelo.Movimiento;
import ec.edu.monster.ws.CoreBancario;
import java.util.List;
import javax.ws.rs.core.Response;
import com.google.gson.JsonObject;

public class EurekaController {

    public List<Movimiento> traerMovimientos(String cuenta) {
        CoreBancario core = new CoreBancario();
        List<Movimiento> movimientos = core.getMovimientos(cuenta);
        core.close();
        return movimientos;
    }

    public Response realizarDeposito(String cuenta, double importe) {
        CoreBancario core = new CoreBancario();
        // Crear un objeto que contenga los datos del depósito
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("cuenta", cuenta);
        requestBody.addProperty("importe", importe);

        // Llamar al método de registro de depósito en el cliente REST
        Response response = core.registrarDeposito(requestBody.toString());

        // Cerrar la conexión con el cliente REST
        core.close();

        return response;
    }

    public Response realizarRetiro(String cuenta, double importe) {
        CoreBancario core = new CoreBancario();
        // Crear un objeto que contenga los datos del retiro
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("cuenta", cuenta);
        requestBody.addProperty("importe", importe);

        // Llamar al método de registro de retiro en el cliente REST
        Response response = core.registrarRetiro(requestBody.toString());

        // Cerrar la conexión con el cliente REST
        core.close();

        return response;
    }

    public Response realizarTransferencia(String cuentaOrigen, String cuentaDestino, double importe) {
        CoreBancario core = new CoreBancario();
        // Crear un objeto que contenga los datos de la transferencia
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("cuentaOrigen", cuentaOrigen);
        requestBody.addProperty("cuentaDestino", cuentaDestino);
        requestBody.addProperty("importe", importe);

        // Llamar al método de registro de transferencia en el cliente REST
        Response response = core.registrarTransferencia(requestBody.toString());

        // Cerrar la conexión con el cliente REST
        core.close();

        return response;
    }
}
