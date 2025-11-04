package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.ViewApp;

import java.io.IOException;

public class ControllerApp {

    // Controlador del Menú Principal del Programa

    private UI ui = new UI(); // Clase de métodos para lectura y escritura en consola
    private ViewApp interfaz = new ViewApp(); // Clase de métodos para el menu principal del programa
    private ControllerCliente clienteController = new ControllerCliente(); //
    private ControllerCuenta cuentaController = new ControllerCuenta();

    public void start() throws IOException {
        int opcion = -1;
        do {
            interfaz.mostrarMenu();
            opcion = ui.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1: clienteController.start(); break;
            case 2: cuentaController.start(); break;
            case 0: ui.imprimirMensaje("Cerrando el programa..."); break;
            default: ui.imprimirMensaje("Opción no válida. Intente nuevamente! \n");
        }
    }
}
