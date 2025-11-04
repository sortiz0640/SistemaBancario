package cr.ac.ucenfotec.sortiz0640.bl.logic;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Cliente;
import cr.ac.ucenfotec.sortiz0640.bl.entities.Cuenta;
import cr.ac.ucenfotec.sortiz0640.bl.entities.Operacion;
import cr.ac.ucenfotec.sortiz0640.dl.DataCuenta;

import java.util.ArrayList;

public class GestorCuenta {

    private DataCuenta db;
    private GestorCliente gestorCliente = new GestorCliente();

    public GestorCuenta() {
        db = new DataCuenta();
    }

    public String agregarCuenta(String cedula) {

        Cliente dueno = gestorCliente.getClientePorCedula(cedula);
        Cuenta tmpCuenta = new Cuenta(dueno);
        db.agregarCuenta(tmpCuenta);
        return "[INFO] Cuenta [" + tmpCuenta.getNumCuenta() + "] agregada correctamente!";
    }

    public String agregarOperacion(Cuenta cuenta, Operacion operacion) {
        cuenta.agregarOperacion(operacion);
        return "[INFO] Operación agregada correctamente!";
    }

    public void eliminarOperacion() {

    }

    public boolean existenCuentas() {
        return db.existenCuentas();
    }

    public ArrayList<String> getCuentasToStringPorCedula(String cedula) {

        Cliente dueno = gestorCliente.getClientePorCedula(cedula);

        if (dueno == null || !existenCuentas()) {
            return null;
        }

        return db.getCuentasToStringPorCedula(cedula);
    }
}
