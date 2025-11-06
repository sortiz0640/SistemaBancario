import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCliente;
import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCuenta;
import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorOperacion;
import cr.ac.ucenfotec.sortiz0640.tl.ControllerApp;
import cr.ac.ucenfotec.sortiz0640.tl.ControllerCliente;
import cr.ac.ucenfotec.sortiz0640.tl.ControllerCuenta;
import cr.ac.ucenfotec.sortiz0640.tl.ControllerOperacion;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        GestorCliente gestorCliente = new GestorCliente();
        GestorCuenta gestorCuenta = new GestorCuenta(gestorCliente);
        GestorOperacion gestorOperacion = new GestorOperacion(gestorCuenta);

        ControllerCliente controllerCliente = new ControllerCliente(gestorCliente);
        ControllerCuenta controllerCuenta = new ControllerCuenta(gestorCuenta, gestorCliente);
        ControllerOperacion controllerOperacion = new ControllerOperacion(gestorOperacion);

        ControllerApp controllerApp = new ControllerApp(controllerCliente, controllerCuenta, controllerOperacion);

        controllerApp.start();
    }
}