package cr.ac.ucenfotec.sortiz0640.tl;
import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCliente;
import cr.ac.ucenfotec.sortiz0640.bl.logic.GestorCuenta;
import cr.ac.ucenfotec.sortiz0640.ul.UI;
import cr.ac.ucenfotec.sortiz0640.ul.Validations;
import cr.ac.ucenfotec.sortiz0640.ul.ViewCuenta;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControllerCuenta {

    private UI interfaz = new UI();
    private ViewCuenta view = new ViewCuenta();
    private GestorCuenta gestorCuenta;
    private GestorCliente gestorCliente;
    private Validations validator = new Validations();

    public ControllerCuenta(GestorCuenta gestorCuenta, GestorCliente gestorCliente) {
        this.gestorCuenta = gestorCuenta;
        this.gestorCliente = gestorCliente;
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
            case 2: listarCuenta(); break;
            case 3: listarCuentaSaldos(); break;
            case 4: aplicarComisiones(); break;
            case 0: break;
            default: interfaz.imprimirMensaje("[INFO] Opción no válida. Intente nuevamente! \n"); break;
        }
    }

    public void registrar() throws IOException {

        String cedulaCliente = validator.cedula();

        if (gestorCliente.getClientePorCedula(cedulaCliente) == null) {
            interfaz.imprimirMensaje("[INFO] El cliente especificado no existe. ");
            return;
        }

        String tipoCuenta = solicitarTipoCuenta();

        if (tipoCuenta != null) {
            interfaz.imprimirMensaje(gestorCuenta.agregarCuenta(cedulaCliente, tipoCuenta));
            return;
        }

        interfaz.imprimirMensaje("El tipo de cuenta especificado no es valido. Intente nuevamente");

    }

    public String solicitarTipoCuenta() throws IOException {

        int opcion = 0;
        interfaz.imprimirMensaje("[INFO]S Seleccione el tipo de cuenta: AHORRO [1] CORRIENTE [2]");
        opcion = Integer.parseInt(interfaz.leerTexto());

        if  (opcion == 1) {
            return "AHORRO";
        } else if (opcion == 2) {
            return "CORRIENTE";
        } else {
            return null;
        }

    }

    public void listarCuenta() throws IOException {

        if (!gestorCuenta.existenCuentas()) {
            interfaz.imprimirMensaje("[INFO] No existen cuentas registradas. Debe registrar al menos una cuenta para continuar.");
            return;
        }

        interfaz.imprimirMensaje("[INFO] Indique la cedula del ciente para listar sus cuentas\n");
        ArrayList<String> listaCuentas = gestorCuenta.getCuentasToStringPorCedula(validator.cedula());

        if (listaCuentas == null) {
            interfaz.imprimirMensaje("[ERR] El numero de cedula especificado no pertenece a ninguna cuenta registrada.");
            return;
        }

        interfaz.imprimirMensaje("[INFO] Lista de cuentas asociadas al cliente");
        for (String cuenta : listaCuentas) {
            interfaz.imprimirMensaje(cuenta + "\n");
        }

    }

    public void listarCuentaSaldos() {

        ArrayList<String> listaCuentras = gestorCuenta.getSaldoCuentas();

        if (listaCuentras == null) {
            interfaz.imprimirMensaje("[ERR] No existen cuentas registradas.");
            return;
        }

        for (String c : listaCuentras) {
            interfaz.imprimirMensaje(c + "\n");
        }
    }

    public void aplicarComisiones() throws IOException {
        if (!esPrimerDiaMes()) {
            interfaz.imprimirMensaje("[INFO] El día actual no es primero de mes. ¿Desea aplicar las comisiones de igual forma? [S][N]");
            String opcion = interfaz.leerTexto().toLowerCase();

            if (opcion.equals("n")) {
                return;
            } else if (!opcion.equals("s")) {
                interfaz.imprimirMensaje("[ERR] Ingrese una opción válida.");
                return;
            }
        }

        interfaz.imprimirMensaje(gestorCuenta.aplicarComisionesMensuales());
    }

    private boolean esPrimerDiaMes() {
        return LocalDate.now().getDayOfMonth() == 1;
    }
}
