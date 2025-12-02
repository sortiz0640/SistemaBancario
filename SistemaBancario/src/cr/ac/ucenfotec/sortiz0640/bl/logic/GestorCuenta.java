package cr.ac.ucenfotec.sortiz0640.bl.logic;

import cr.ac.ucenfotec.sortiz0640.bl.entities.*;
import cr.ac.ucenfotec.sortiz0640.dl.DataCuenta;

import java.util.ArrayList;

public class GestorCuenta {

    private DataCuenta db;
    private GestorCliente gestorCliente;

    public GestorCuenta(GestorCliente gestorCliente) {
        db = new DataCuenta();
        this.gestorCliente = gestorCliente;
    }

    public String agregarCuenta(String cedula, String tipoCuenta) {
        Cliente dueno = gestorCliente.getClientePorCedula(cedula);

        if (dueno == null) {
            return "[ERR] Cliente no encontrado";
        }

        Cuenta tmpCuenta = null;

        if (tipoCuenta.equalsIgnoreCase("AHORRO")) {
            tmpCuenta = new CuentaAhorro(dueno);
        }

        if (tipoCuenta.equalsIgnoreCase("CORRIENTE")) {
            tmpCuenta = new CuentaCorriente(dueno);
        }

        db.agregarCuenta(tmpCuenta);
        return "[INFO] Cuenta " + tipoCuenta + " [" + tmpCuenta.getNumCuenta() + "] agregada correctamente!";
    }

    public Cuenta getCuentaPorNumCuenta(int numCuenta) {
        for (Cuenta cuenta : db.getCuentas()) {
            if (cuenta.getNumCuenta() == numCuenta) {
                return cuenta;
            }
        }

        return null;
    }

    public boolean existenCuentas() {
        return db.existenCuentas();
    }

    public String deposito(int numCuenta, Operacion operacion) {

        Cuenta cuenta = getCuentaPorNumCuenta(numCuenta);

        if (cuenta == null) {
            return "[ERR] La cuenta " + numCuenta + " no existe. Inténtelo nuevamente";
        }

        cuenta.agregarOperacion(operacion);
        cuenta.depositar(operacion.getMonto());
        return "[INFO] El deposito por el monto de [" + operacion.getMonto() + "] en la cuenta [" + cuenta.getNumCuenta() + "] se ha realizado correctamente!\n" + getSaldoCuentaPorNumCuenta(numCuenta);

    }

    public String retiro(int numCuenta, Operacion operacion) {

        Cuenta cuenta = getCuentaPorNumCuenta(numCuenta);

        if (cuenta == null) {
            return "[ERR] La cuenta " + numCuenta + " no existe. Inténtelo nuevamente";
        }

        if (cuenta.getSaldo() < operacion.getMonto()) {
            return "[ERR] Saldo insuficiente. Saldo actual: " + cuenta.getSaldo();
        }

        cuenta.agregarOperacion(operacion);
        cuenta.retirar(operacion.getMonto());

        return "[INFO] El retiro por el monto de [" + operacion.getMonto() + "] en la cuenta [" + cuenta.getNumCuenta() + "] se ha realizado correctamente!\n" + getSaldoCuentaPorNumCuenta(numCuenta);
    }

    public String getSaldoCuentaPorNumCuenta(int numCuenta) {

        Cuenta cuenta = getCuentaPorNumCuenta(numCuenta);

        if (cuenta == null) {
            return "[ERR] La cuenta " + numCuenta + " no existe. Inténtelo nuevamente";
        }

        return "[CUENTA: " + numCuenta + "]" + "[SALDO: " + cuenta.getSaldo() + "]";

    }

    public ArrayList<String> getCuentasToStringPorCedula(String cedula) {

        Cliente dueno = gestorCliente.getClientePorCedula(cedula);

        if (dueno == null || !existenCuentas()) {
            return null;
        }

        return db.getCuentasToStringPorCedula(cedula);
    }

    public ArrayList<String> getSaldoCuentas() {

        if (!existenCuentas()) {
            return null;
        }

        ArrayList<Cuenta> cuentas = db.getCuentas();
        ArrayList<String> saldoCuentas = new ArrayList<>();
        for (Cuenta cuenta : cuentas) {
            saldoCuentas.add("[CUENTA: " + cuenta.getNumCuenta() + "]" + "[SALDO: " + cuenta.getSaldo() + "]" + "[PROPIETARIO: " + cuenta.getDuenoCedula() + "]");
        }

        return saldoCuentas;

    }

    public String aplicarComisionesMensuales() {
        if (!existenCuentas()) {
            return "[ERR] No hay cuentas registradas";
        }

        StringBuilder resultado = new StringBuilder("[INFO] Aplicando comisiones mensuales:\n");
        for (Cuenta cuenta : db.getCuentas()) {
            if (cuenta instanceof CuentaAhorro) {
                resultado.append(((CuentaAhorro) cuenta).aplicarComisionMensual()).append("\n");
            } else if (cuenta instanceof CuentaCorriente) {
                resultado.append(((CuentaCorriente) cuenta).aplicarComisionMensual()).append("\n");
            }
        }
        return resultado.toString();
    }
}
