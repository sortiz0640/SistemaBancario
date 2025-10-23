package tl;

import ui.UI;
import ui.UICuenta;
import ui.UIOperacion;

import java.io.IOException;

public class OperacionController {

    // Controlador de Operaciones [Cuentas]

    private UI ui = new UI(); // Clase de métodos para lectura y escritura en consola
    private UIOperacion interfaz = new UIOperacion(); //

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
            case 1: deposito(); break;
            case 2: retiro(); break;
            case 0: break;
            default: ui.imprimirMensaje("Opción no válida. Intente nuevamente! \n");
        }
    }

    public void deposito() throws IOException {

        //todo: metodo para depositos en CUENTAS

    }

    public void retiro() throws IOException {

        //todo: metodo para retiros en CUENTAS

    }
}
