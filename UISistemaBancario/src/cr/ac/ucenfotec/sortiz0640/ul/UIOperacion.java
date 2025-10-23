package cr.ac.ucenfotec.sortiz0640.ul;

public class UIOperacion {

    // CLASE PARA LA INTERFAZ DE OPERACIONES

    private UI ui = new UI();

    public void mostrarMenu() {
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("SISTEMA BANCARIO [OPERACIONES] ");
        ui.imprimirMensaje("===================================");
        ui.imprimirMensaje("[1] DÉPOSITO");
        ui.imprimirMensaje("[2] RETIRO");
        ui.imprimirMensaje("[0] REGRESAR");
        ui.imprimirMensaje("===================================");
    }

}
