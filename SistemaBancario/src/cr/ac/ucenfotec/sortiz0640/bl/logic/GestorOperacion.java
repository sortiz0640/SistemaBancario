package cr.ac.ucenfotec.sortiz0640.bl.logic;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Operacion;

public class GestorOperacion {

    private GestorCuenta gestorCuenta;

    public GestorOperacion(GestorCuenta gestorCuenta) {
        this.gestorCuenta = gestorCuenta;
    }

    public String deposito(double monto, int numCuenta) {

        Operacion tmpOperacion = new Operacion("DEPOSITO", monto);
        return gestorCuenta.deposito(numCuenta, tmpOperacion);

    }

    public String retiro(double monto, int numCuenta) {

        Operacion tmpOperacion = new Operacion("RETIRO", monto);
        return gestorCuenta.retiro(numCuenta, tmpOperacion);

    }


}
