<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Consulta de Movimientos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('monster.jpg');
            background-size: cover;
            background-position: center;
            margin: 0;
        }
        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent background */
            padding: 60px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .input-group {
            margin: 15px 0;
        }
        .input-group label {
            display: block;
            margin-bottom: 5px;
            font-size: 18px;
        }
        .input-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .btn {
            width: 100%;
            padding: 15px;
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background-color: #800080;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        /* Ocultar los controles del spinner */
        input[type="number"]::-webkit-outer-spin-button,
        input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
        input[type="number"] {
            -moz-appearance: textfield;
        }
        .table-container {
            margin-top: 20px;
            text-align: left;
            overflow-x: auto; /* Para desplazamiento horizontal si la tabla es demasiado ancha */
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
            var resultadosDiv = document.getElementById("resultados");
            if (!resultadosDiv) {
                console.error("Elemento con id 'resultados' no encontrado");
                return;
            }

            var data = JSON.parse(response);
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
    <div class="container">
        <div class="input-group">
            <label for="nCuenta">Cuenta:</label>
            <input type="text" id="nCuenta" placeholder="Ingrese la cuenta">
        </div>
        <button class="btn" onclick="consultarMovimientos()">Consultar</button>

        <div class="table-container" id="resultados">
            <!-- Aquí se mostrará la tabla de resultados -->
        </div>
    </div>
</body>
</html>
