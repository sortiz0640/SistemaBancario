package cr.ac.ucenfotec.sortiz0640.bl.entities;

import java.util.ArrayList;
import java.util.Date;

public class Cuenta {

    private int cantCuentas = 0;
    private int numCuenta;
    private double saldo;
    private Date fechaCreacion;
    private int numOperaciones;
    private Cliente dueno;
    private ArrayList<Operacion> listaOperaciones = new ArrayList<>();


    public Cuenta (Cliente dueno, double monto) {
        this.dueno = dueno;
        this.saldo = monto;
        this.fechaCreacion = new Date();
        this.cantCuentas = cantCuentas++;
    }

    public String agregarOperacion(Operacion operacion) {
        listaOperaciones.add(operacion);
        return "Operacion " + operacion.getNumero() + " agregada correctamente!";

    }

    public String depositar(double monto) {

        return "Deposito realizado correctamente";
    }

    public String retirar(double monto) {

        return "Retiro realizado correctamente";
    }



    @Override
    public String toString() {
        return "Cuenta{" +
                "cantCuentas=" + cantCuentas +
                ", numCuenta=" + numCuenta +
                ", saldo=" + saldo +
                ", fechaCreacion=" + fechaCreacion +
                ", numOperaciones=" + numOperaciones +
                ", dueno=" + dueno +
                ", listaOperaciones=" + listaOperaciones +
                '}';
    }
}
