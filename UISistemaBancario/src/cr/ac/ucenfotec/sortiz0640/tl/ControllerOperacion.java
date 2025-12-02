package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorOperacion;
import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.Validations;
import cr.ac.ucenfotec.sortiz0640.ul.ViewOperacion;

import java.io.IOException;

public class ControllerOperacion {


    private UI interfaz = new UI();
    private ViewOperacion view = new ViewOperacion(); //
    private Validations validator = new Validations();
    private GestorOperacion g;

    public ControllerOperacion(GestorOperacion gestor) {
        this.g = gestor;
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
            case 1: deposito(); break;
            case 2: retiro(); break;
            case 0: break;
            default: interfaz.imprimirMensaje("[INFO] Opción no válida. Intente nuevamente! \n"); break;
        }
    }

    public void deposito() throws IOException {

        int numCuenta = validator.numeroCuenta();

        interfaz.imprimirMensaje("[INFO] Transaccion tipo DEPOSITO");
        double monto = validator.monto();

        interfaz.imprimirMensaje(g.deposito(monto, numCuenta));

    }

    public void retiro() throws IOException {

        int numCuenta = validator.numeroCuenta();

        interfaz.imprimirMensaje("[INFO] Transaccion tipo RETIRO");
        double monto = validator.monto();

        interfaz.imprimirMensaje(g.retiro(monto, numCuenta));

    }
}
