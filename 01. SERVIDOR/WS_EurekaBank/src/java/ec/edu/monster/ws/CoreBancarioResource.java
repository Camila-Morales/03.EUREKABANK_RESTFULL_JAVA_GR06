package ec.edu.monster.ws;

import ec.edu.monster.modelo.Movimiento;
import ec.edu.monster.servicio.EurekaService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * REST Web Service
 */
@Path("coreBancario")
public class CoreBancarioResource {

    @Context
    private UriInfo context;
    private Gson gson = new Gson();

    public CoreBancarioResource() {
    }

    @GET
    @Path("/movimientos/{cuenta}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovimientos(@PathParam("cuenta") String cuenta) {
        List<Movimiento> lista;

        try {
            EurekaService service = new EurekaService();
            lista = service.leerMovimientos(cuenta);
        } catch (Exception e) {
            lista = new ArrayList<>();
        }

        String jsonLista = gson.toJson(lista);
        return Response.ok(jsonLista).build();
    }

    @POST
    @Path("/deposito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarDeposito(String jsonBody) {
        JsonObject responseJson = new JsonObject();

        JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);
        String cuenta = jsonObject.get("cuenta").getAsString();
        double importe = jsonObject.get("importe").getAsDouble();

        boolean exito;
        String codEmp = "0001";

        try {
            EurekaService service = new EurekaService();
            service.registrarDeposito(cuenta, importe, codEmp);
            exito = true;
        } catch (Exception e) {
            exito = false;
        }

        responseJson.addProperty("success", exito);
        return Response.ok(responseJson.toString()).build();
    }

    @POST
    @Path("/retiro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarRetiro(String jsonBody) {
        JsonObject responseJson = new JsonObject();

        JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);
        String cuenta = jsonObject.get("cuenta").getAsString();
        double importe = jsonObject.get("importe").getAsDouble();

        boolean exito;
        String codEmp = "0001";

        try {
            EurekaService service = new EurekaService();
            service.registrarRetiro(cuenta, importe, codEmp);
            exito = true;
        } catch (Exception e) {
            exito = false;
        }

        responseJson.addProperty("success", exito);
        return Response.ok(responseJson.toString()).build();
    }

    @POST
    @Path("/transferencia")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarTransferencia(String jsonBody) {
        JsonObject responseJson = new JsonObject();

        JsonObject jsonObject = gson.fromJson(jsonBody, JsonObject.class);
        String cuentaOrigen = jsonObject.get("cuentaOrigen").getAsString();
        String cuentaDestino = jsonObject.get("cuentaDestino").getAsString();
        double importe = jsonObject.get("importe").getAsDouble();

        boolean exito;
        String codEmp = "0001";

        try {
            EurekaService service = new EurekaService();
            service.registrarTransferencia(cuentaOrigen, cuentaDestino, importe, codEmp);
            exito = true;
        } catch (Exception e) {
            exito = false;
        }

        responseJson.addProperty("success", exito);
        return Response.ok(responseJson.toString()).build();
    }
}
