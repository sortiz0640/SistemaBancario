package cr.ac.ucenfotec.sortiz0640.ul;

public class ViewApp {

    // CLASE PARA MENÚ PRINCIPAL DEL PROGRAMA

    private UI ui = new UI();

    public void mostrarMenu() {
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("SISTEMA BANCARIO ");
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("[1] Clientes");
        ui.imprimirMensaje("[2] Cuentas");
        ui.imprimirMensaje("[0] Salir");
        ui.imprimirMensaje("===================================");
    }

}
