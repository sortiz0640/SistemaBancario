package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCliente;
import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCuenta;
import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.Validations;
import cr.ac.ucenfotec.sortiz0640.ul.ViewCuenta;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerCuenta {

    // Controlador de Cuentas

    private UI interfaz = new UI(); // Clase de métodos para lectura y escritura en consola
    private ViewCuenta view = new ViewCuenta(); //
    private GestorCuenta gestorCuenta = new GestorCuenta();
    private GestorCliente gestorCliente = new GestorCliente();
    private Validations validator = new Validations();

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
            case 1: registrar(); break;
            case 2: listarCuenta(); break;
            case 3: listarCuentaSaldos(); break;
            case 0: break;
            default: interfaz.imprimirMensaje("[INFO] Opción no válida. Intente nuevamente! \n");
        }
    }

    public void registrar() throws IOException {

        String cedulaCliente = validator.cedula();

        if (gestorCliente.getClientePorCedula(cedulaCliente) == null) {
            interfaz.imprimirMensaje("[INFO] El cliente especificado no existe. ");
            return;
        }

        interfaz.imprimirMensaje(gestorCuenta.agregarCuenta(cedulaCliente));

    }

    public void listarCuenta() throws IOException {

        if (!gestorCuenta.existenCuentas()) {
            interfaz.imprimirMensaje("[INFO] No existen cuentas registradas. Debe registrar al menos una cuenta para continuar.");
            return;
        }

        interfaz.imprimirMensaje("[INFO] Indique la cedula del ciente para listar sus cuentas\n");
        ArrayList<String> listaCuentas = gestorCuenta.getCuentasToStringPorCedula(validator.cedula());

        if (listaCuentas == null) {
            interfaz.imprimirMensaje("[INFO] El numero de cedula especificado no pertenece a ninguna cuenta registrada.");
            return;
        }

        interfaz.imprimirMensaje("[INFO] Lista de cuentas asociadas al cliente");
        for (String cuenta : listaCuentas) {
            interfaz.imprimirMensaje(cuenta);
        }

    }

    public void listarCuentaSaldos() {
        //todo: muestra todos los saldos actualizados
    }
}
