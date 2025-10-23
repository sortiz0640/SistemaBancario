package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.UICuenta;

import java.io.IOException;

public class CuentaController {

    // Controlador de Cuentas

    private UI ui = new UI(); // Clase de métodos para lectura y escritura en consola
    private UICuenta interfaz = new UICuenta(); //

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
            case 2: listarCuenta(); break;
            case 3: listarCuentaSaldos(); break;
            case 0: break;
            default: ui.imprimirMensaje("Opción no válida. Intente nuevamente! \n");
        }
    }

    public void registrar() throws IOException {
        //todo: registro de cuentas [requiere cliente previamente registrado]

    }

    public void listarCuenta() throws IOException {
        //todo: listar todas las cuentas registradas de un cliente [requiere cliente previamente registrado]

    }

    public void listarCuentaSaldos() {
        //todo: muestra todos los saldos actualizados
    }
}
