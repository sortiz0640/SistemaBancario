package cr.ac.ucenfotec.sortiz0640.ul;

public class UICliente {

    // Clase para la interfaz de CLIENTES

    private UI ui = new UI();

    public void mostrarMenu() {
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("SISTEMA BANCARIO [CLIENTES] ");
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("[1] Registrar Cliente");
        ui.imprimirMensaje("[2] Listar Clientes");
        ui.imprimirMensaje("[0] Regresar");
        ui.imprimirMensaje("===================================");
    }
}
