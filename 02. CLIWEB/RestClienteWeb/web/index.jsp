<!DOCTYPE html>
<html>
<head>
    <title>Vista Principal</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-image: url('monster.jpg');
            background-size: cover;
            background-position: center;
        }
        .container {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .btn {
            display: none;
            width: 200px;
            margin: 20px auto;
            padding: 15px;
            font-size: 20px;
            font-weight: bold;
            color: #fff;
            background-color: #800080;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn.exit {
            background-color: #dc3545;
        }
        .input-group {
            margin: 15px 0;
            width: 95%;
        }
        .input-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .input-group button {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            margin-top: 10px;
            color: #fff;
            background-color: #800080;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container" id="login-container">
        <h2>Login</h2>
        <div class="input-group">
            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" placeholder="Ingrese su usuario">
        </div>
        <div class="input-group">
            <label for="clave">Clave:</label>
            <input type="password" id="clave" placeholder="Ingrese su clave">
        </div>
        <div class="input-group">
            <button onclick="login()">Ingresar</button>
        </div>
    </div>

    <div class="container" id="main-container" style="display: none;">
        <h3>EurekaBank</h3>
        <button class="btn" id="deposito-btn" onclick="goToDeposito()">Depósito</button>
        <button class="btn" id="retiro-btn" onclick="goToRetiro()">Retiro</button>
        <button class="btn" id="transferencia-btn" onclick="goToTransferencia()">Transferencia</button>
        <button class="btn" id="consulta-btn" onclick="goToConsulta()">Consulta</button>
        <button class="btn exit" onclick="salir()">Salir</button>
    </div>

    <script>
        function login() {
            const usuario = document.getElementById('usuario').value;
            const clave = document.getElementById('clave').value;

            if (usuario === 'Monster' && clave === 'Monster9') {
                document.getElementById('login-container').style.display = 'none';
                document.getElementById('main-container').style.display = 'block';
                document.querySelectorAll('.btn').forEach(btn => btn.style.display = 'block');
                alert('¡Login exitoso!');
            } else {
                alert('Credenciales incorrectas. Intente nuevamente.');
            }
        }

        function goToDeposito() {
            window.location.href = 'Deposito.jsp';
        }

        function goToRetiro() {
            window.location.href = 'Retiro.jsp';
        }

        function goToTransferencia() {
            window.location.href = 'Transferencia.jsp';
        }

        function goToConsulta() {
            window.location.href = 'ConsultarMovimientos.jsp';
        }

        function salir() {
            if (confirm('¿Estás seguro de que deseas salir?')) {
                document.getElementById('main-container').style.display = 'none';
                document.getElementById('login-container').style.display = 'block';
                document.getElementById('usuario').value = '';
                document.getElementById('clave').value = '';
                document.querySelectorAll('.btn').forEach(btn => btn.style.display = 'none');
            }
        }
    </script>
</body>
</html>
