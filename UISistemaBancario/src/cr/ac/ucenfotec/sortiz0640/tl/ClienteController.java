package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.UICliente;

import java.io.IOException;

public class ClienteController {

    // Controlador de Clientes

    private UI ui = new UI(); // Clase de métodos para lectura y escritura en consola
    private UICliente interfaz = new UICliente(); //

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
            case 1: registrar(); break;
            case 2: listar(); break;
            case 0: break;
            default: ui.imprimirMensaje("Opción no válida. Intente nuevamente! \n");
        }
    }

    public void registrar() throws IOException {
        //todo: registro de clintes

    }

    public void listar() throws IOException {
        //todo: listar todos los clientes registrados

    }
}
