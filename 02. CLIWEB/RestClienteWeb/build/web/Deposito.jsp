<!DOCTYPE html>
<html>
<head>
    <title>Registrar Depósito</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
    </style>
</head>
<body>
    <div class="container">
        <div class="input-group">
            <label for="nCuenta">Cuenta:</label>
            <input type="text" id="nCuenta" placeholder="Ingrese la cuenta">
        </div>
        <div class="input-group">
            <label for="importe">Monto:</label>
            <input type="number" id="importe" placeholder="Ingrese el monto">
        </div>
        <button class="btn" onclick="realizarDeposito()">Registrar</button>
    </div>

    <script>
        function realizarDeposito() {
            var numeroCuenta = document.getElementById("nCuenta").value;
            var importe = document.getElementById("importe").value;

            var datos = {
                cuenta: numeroCuenta,
                importe: parseFloat(importe)
            };

            var xmlhttp = new XMLHttpRequest();
            var url = "EurekaController";

            xmlhttp.onreadystatechange = function() {
                if (this.readyState == 4) {
                    if (this.status == 200) {
                        alert("Depósito realizado con éxito");
                        // Puedes redirigir a otra página o mostrar un mensaje de éxito aquí
                    } else {
                        alert("Error al realizar el depósito");
                    }
                }
            };

            xmlhttp.open("POST", url, true);
            xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xmlhttp.send(JSON.stringify(datos));
        }
    </script>
</body>
</html>
