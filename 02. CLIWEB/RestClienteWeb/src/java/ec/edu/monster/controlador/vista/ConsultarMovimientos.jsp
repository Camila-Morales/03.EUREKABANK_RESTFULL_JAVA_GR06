<%-- 
    Document   : ConsultarMovimientos
    Created on : Jun 16, 2024, 5:18:29 PM
    Author     : georg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Consulta de Movimientos</title>
    <style>
        table {
            width: 50%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
    <script>
        function consultarMovimientos() {
            var numeroCuenta = document.getElementById("nCuenta").value;
            var xmlhttp = new XMLHttpRequest();
            var url = "EurekaController?nCuenta=" + encodeURIComponent(numeroCuenta);

            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    mostrarResultados(this.responseText);
                }
            };

            xmlhttp.open("GET", url, true);
            xmlhttp.send();
        }

        function mostrarResultados(response) {
            var data = JSON.parse(response);
            var resultadosDiv = document.getElementById("resultados");
            var html = "<table>";
            html += "<tr><th>Cuenta</th><th>Nro Movimiento</th><th>Fecha</th><th>Tipo</th><th>Accion</th><th>Importe</th></tr>";

            // Recorrer cada objeto en el arreglo JSON
            for (var i = 0; i < data.length; i++) {
                html += "<tr>";
                html += "<td>" + data[i].cuenta + "</td>";
                html += "<td>" + data[i].nromov + "</td>";
                html += "<td>" + data[i].fecha + "</td>";
                html += "<td>" + data[i].tipo + "</td>";
                html += "<td>" + data[i].accion + "</td>";
                html += "<td>" + data[i].importe + "</td>";
                html += "</tr>";
            }

            html += "</table>";
            resultadosDiv.innerHTML = html;
        }
    </script>
</head>
<body>
    <h2>Consulta de Movimientos Bancarios</h2>

    <p><label>Número de cuenta: </label> <input type="text" id="nCuenta"></p>
    <p><button type="button" onclick="consultarMovimientos()">Consultar Movimientos</button></p>

    <h3>Resultados:</h3>

    <div id="resultados">
        <%-- Aquí se mostrará la tabla de resultados --%>
    </div>
</body>
</html>