package ec.edu.monster.ws;

import ec.edu.monster.modelo.Movimiento;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:CoreBancarioResource
 * [coreBancario]<br>
 * USAGE:
 * <pre>
 *        CoreBancario client = new CoreBancario();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author georg
 */
public class CoreBancario {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://192.168.100.48:8080/Rest_EurekaBank/webresources";

    public CoreBancario() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("coreBancario");
    }

    public List<Movimiento> getMovimientos(String cuenta) throws ClientErrorException {
        WebTarget resource = webTarget.path(java.text.MessageFormat.format("movimientos/{0}", new Object[]{cuenta}));
        Response response = resource.request(MediaType.APPLICATION_JSON).get();
        return response.readEntity(new GenericType<List<Movimiento>>() {});
    }

    public Response registrarDeposito(Object requestEntity) throws ClientErrorException {
        return webTarget.path("deposito")
                .request(MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response registrarRetiro(Object requestEntity) throws ClientErrorException {
        return webTarget.path("retiro")
                .request(MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response registrarTransferencia(Object requestEntity) throws ClientErrorException {
        return webTarget.path("transferencia")
                .request(MediaType.APPLICATION_JSON)
                .post(javax.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON), Response.class);
    }

    public void close() {
        client.close();
    }
}
