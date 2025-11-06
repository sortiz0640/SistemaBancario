package cr.ac.ucenfotec.sortiz0640.tl;

import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCliente;
import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.Validations;
import cr.ac.ucenfotec.sortiz0640.ul.ViewCliente;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerCliente {

    // Controlador de Clientes

    private UI interfaz = new UI();
    private ViewCliente view = new ViewCliente();
    private Validations validator = new Validations();
    private GestorCliente g;

    public ControllerCliente(GestorCliente gestorCliente) {
        this.g = gestorCliente;
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
            case 1: registrar(); break;
            case 2: listar(); break;
            case 0: break;
            default: interfaz.imprimirMensaje("[INFO] Opción no válida. Intente nuevamente! \n");
        }
    }

    public void registrar() throws IOException {

        String nombre = validator.nombre();
        String apellido = validator.apellido();
        String cedula = validator.cedula();

        interfaz.imprimirMensaje(g.agregarCliente(nombre, apellido, cedula));

    }

    public void listar() throws IOException {

        if (!g.existenClientes()) {
            interfaz.imprimirMensaje("[INFO] No existen clientes registrados");
            return;
        }

        ArrayList<String> lista = g.getClientesToString();
        for  (String c : lista) {
            interfaz.imprimirMensaje(c);
        }
    }
}
