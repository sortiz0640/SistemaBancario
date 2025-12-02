package cr.ac.ucenfotec.sortiz0640.bl.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public abstract class Cuenta {

    private int numCuenta;
    private double saldo;
    private Date fechaCreacion;
    private int numOperaciones;
    private int numOperacionesMes;
    private Cliente dueno;
    private ArrayList<Operacion> listaOperaciones = new ArrayList<>();

    public Cuenta() {

    }

    public Cuenta(Cliente dueno) {
        this.dueno = dueno;
        this.saldo = 0;
        this.fechaCreacion = new Date();
        this.numCuenta = generarNumeroCuenta();
    }

    public abstract double cobrarComisiones();

    public String agregarOperacion(Operacion operacion) {
        listaOperaciones.add(operacion);
        this.numOperaciones++;
        this.numOperacionesMes++;
        return "Operacion " + operacion.getNumero() + " agregada correctamente!";

    }

    public void depositar(double monto) {
        this.saldo += monto;
    }

    public void retirar(double monto) {
        this.saldo -= monto;
    }

    private int generarNumeroCuenta() {

        // Generado por IA para la generacion de numeros de cuenta aleatorios

        long timestamp = System.currentTimeMillis() % 10000000L;
        int randomPart = new Random().nextInt(9) + 1;
        return (int)(timestamp + randomPart * 10000000L);
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

    public int getNumOperacionesMes() {
        return numOperacionesMes;
    }

    public void setNumOperacionesMes(int numOperacionesMes) {
        this.numOperacionesMes = numOperacionesMes;
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
