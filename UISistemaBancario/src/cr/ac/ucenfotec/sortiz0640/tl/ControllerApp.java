package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.ViewApp;

import java.io.IOException;

public class ControllerApp {

    private UI interfaz = new UI();
    private ViewApp view = new ViewApp();
    private ControllerCliente clienteController;
    private ControllerCuenta cuentaController;
    private ControllerOperacion operacionController;

    public ControllerApp(ControllerCliente clienteController, ControllerCuenta cuentaController, ControllerOperacion operacionController) {
        this.clienteController = clienteController;
        this.cuentaController = cuentaController;
        this.operacionController = operacionController;
    }
    public void start() throws IOException {
        int opcion = -1;
        do {
            view.mostrarMenu();
            opcion = interfaz.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 0);
    }

    public void procesarOpcion(int opcion) throws IOException {
        switch (opcion) {
            case 1: clienteController.start(); break;
            case 2: cuentaController.start(); break;
            case 3: operacionController.start(); break;
            case 0: interfaz.imprimirMensaje("Cerrando el programa..."); break;
            default: interfaz.imprimirMensaje("Opción no válida. Intente nuevamente! \n"); break;
        }
    }
}
