package cr.ac.ucenfotec.sortiz0640.bl.logic;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Cliente;
import cr.ac.ucenfotec.sortiz0640.bl.entities.Cuenta;
import cr.ac.ucenfotec.sortiz0640.bl.entities.Operacion;
import cr.ac.ucenfotec.sortiz0640.dl.DataCuenta;

public class GestorCuenta {

    private DataCuenta db;

    public GestorCuenta() {
        db = new DataCuenta();
    }

    public String agregarCuenta(Cliente dueno, double monto) {
        Cuenta tmpCuenta = new Cuenta(dueno, monto);
        db.agregarCuenta(tmpCuenta);
        return "Cuenta agregada correctamente!";
    }

    public String agregarOperacion(Cuenta cuenta, Operacion operacion) {
        cuenta.agregarOperacion(operacion);
        return "Operación agregada correctamente!";
    }

    public void eliminarOperacion() {

    }

}
