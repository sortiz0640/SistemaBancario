package cr.ac.ucenfotec.sortiz0640.ul;

public class UICuenta {

    // CLASE PARA LA INTERFAZ DE CUENTAS

    private UI ui = new UI();

    public void mostrarMenu() {
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("SISTEMA BANCARIO [CUENTAS] ");
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("[1] Registrar Cuenta");
        ui.imprimirMensaje("[2] Listar Cuentas de Cliente [Numero Cédula]");
        ui.imprimirMensaje("[3] Listar Saldos de Cuentas ");
        ui.imprimirMensaje("[0] Regresar");
        ui.imprimirMensaje("===================================");
    }
}
