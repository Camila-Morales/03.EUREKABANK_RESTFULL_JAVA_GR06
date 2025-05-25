package ec.edu.monster.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EurekaController", urlPatterns = {"/EurekaController"})
public class EurekaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // No implementado (puede quedar vacío)
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numeroCuenta = request.getParameter("nCuenta");
        String tipoMovimiento = request.getParameter("tipoMovimiento"); // opcional: "deposito", "retiro", "transferencia"
        String tipoOperacion = request.getParameter("tipoOperacion");   // opcional: "entrada", "salida"

        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\":\"Falta parámetro nCuenta\"}");
            return;
        }

        String uriBase = "http://192.168.100.48:8080/Rest_EurekaBank/webresources/coreBancario/movimientos/";
        StringBuilder uriBuilder = new StringBuilder(uriBase).append(numeroCuenta);

        if (tipoMovimiento != null && !tipoMovimiento.isEmpty()) {
            uriBuilder.append("/").append(tipoMovimiento);
        }
        if (tipoOperacion != null && !tipoOperacion.isEmpty()) {
            uriBuilder.append("/").append(tipoOperacion);
        }

        String uri = uriBuilder.toString();

        String jsonResponse = sendGET(uri);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    // Método para enviar una solicitud GET y obtener la respuesta JSON como cadena
    private String sendGET(String uri) throws IOException {
        StringBuilder jsonResponse = new StringBuilder();

        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                jsonResponse.append(inputLine);
            }
            in.close();
        } else {
            jsonResponse.append("{ \"error\": \"Error al hacer la solicitud GET: " + responseCode + "\" }");
        }
        return jsonResponse.toString();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonInput = obtenerJsonEntrada(request);
        System.out.println("Datos recibidos para POST: " + jsonInput); // Registro de depuración

        String jsonResponse = enviarSolicitudPOST(jsonInput);
        System.out.println("Respuesta de la API: " + jsonResponse); // Registro de depuración

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    private String obtenerJsonEntrada(HttpServletRequest request) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private String enviarSolicitudPOST(String jsonInput) throws IOException {
        String uri = "http://localhost:8080/Rest_EurekaBank/webresources/coreBancario/deposito";
        System.out.println("Enviando solicitud POST a: " + uri); // Registro de depuración

        URL url = new URL(uri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setDoOutput(true);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        StringBuilder jsonResponse = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                jsonResponse.append(responseLine.trim());
            }
        } catch (IOException e) {
            System.err.println("Error al leer la respuesta de la API: " + e.getMessage());
            jsonResponse.append("{ \"error\": \"Error al leer la respuesta de la API\" }");
        }

        return jsonResponse.toString();
    }

    @Override
    public String getServletInfo() {
        return "Controlador Eureka para consultar y registrar movimientos bancarios";
    }// </editor-fold>

}
