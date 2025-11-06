package cr.ac.ucenfotec.sortiz0640.bl.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Cuenta {

    private int cantCuentas;
    private int numCuenta;
    private double saldo;
    private Date fechaCreacion;
    private int numOperaciones;
    private Cliente dueno;
    private ArrayList<Operacion> listaOperaciones = new ArrayList<>();

    public Cuenta (Cliente dueno) {
        this.dueno = dueno;
        this.saldo = 0;
        this.fechaCreacion = new Date();
        this.cantCuentas = cantCuentas++;
        this.numCuenta = generarNumeroCuenta();
    }

    public String agregarOperacion(Operacion operacion) {
        listaOperaciones.add(operacion);
        this.numOperaciones++;
        return "Operacion " + operacion.getNumero() + " agregada correctamente!";

    }

    public void depositar(double monto) {
        this.saldo += monto;
    }

    public void retirar(double monto) {
        this.saldo -= monto;
    }

    private int generarNumeroCuenta() {
        long timestamp = System.currentTimeMillis() % 10000000L;
        int randomPart = new Random().nextInt(9) + 1;
        return (int)(timestamp + randomPart * 10000000L);
    }

    public int getCantCuentas() {
        return cantCuentas;
    }

    public void setCantCuentas(int cantCuentas) {
        this.cantCuentas = cantCuentas;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getNumOperaciones() {
        return numOperaciones;
    }

    public void setNumOperaciones(int numOperaciones) {
        this.numOperaciones = numOperaciones;
    }

    public Cliente getDueno() {
        return dueno;
    }

    public String getDuenoCedula() {
        return dueno.getCedula();
    }

    public void setDueno(Cliente dueno) {
        this.dueno = dueno;
    }

    public ArrayList<Operacion> getListaOperaciones() {
        return listaOperaciones;
    }

    public void setListaOperaciones(ArrayList<Operacion> listaOperaciones) {
        this.listaOperaciones = listaOperaciones;
    }

    @Override
    public String toString() {
        return "[NÚMERO CUENTA: " + numCuenta + "] " +
                "[SALDO: " + saldo + "] " +
                "[FECHA CREACIÓN: " + fechaCreacion + "] " +
                "[NÚMERO OPERACIONES: " + numOperaciones + "] " +
                "[DUEÑO: " + dueno.getNombre() + " " + dueno.getApellido() + "] " +
                "[CÉDULA DUEÑO: " + dueno.getCedula() + "]\n" +
                "[OPERACIONES: " + listaOperaciones + "]";
    }
}
