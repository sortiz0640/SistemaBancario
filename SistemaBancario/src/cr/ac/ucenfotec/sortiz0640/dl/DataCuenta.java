package cr.ac.ucenfotec.sortiz0640.dl;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Cuenta;

import java.util.ArrayList;

public class DataCuenta {

    private ArrayList<Cuenta> cuentas;

    public DataCuenta() {
        cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta Cuenta) {
        cuentas.add(Cuenta);
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
}
