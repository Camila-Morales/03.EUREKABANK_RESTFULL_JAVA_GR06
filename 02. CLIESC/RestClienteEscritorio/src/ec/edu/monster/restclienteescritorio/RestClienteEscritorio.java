package ec.edu.monster.restclienteescritorio;

import ec.edu.monster.vista.LoginView;

public class RestClienteEscritorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear y mostrar la ventana de LoginVista
        java.awt.EventQueue.invokeLater(() -> {
            LoginView login = new LoginView();
            login.setVisible(true);
        });
    }
}