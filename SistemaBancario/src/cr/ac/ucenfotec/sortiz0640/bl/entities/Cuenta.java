package cr.ac.ucenfotec.sortiz0640.bl.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Cuenta {

    private int cantCuentas = 0;
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
        return "Operacion " + operacion.getNumero() + " agregada correctamente!";

    }

    public String depositar(double monto) {

        return "Deposito realizado correctamente";
    }

    public String retirar(double monto) {

        return "Retiro realizado correctamente";
    }

    private int generarNumeroCuenta() {
        int timestamp = Math.toIntExact(System.currentTimeMillis() % 100000); // últimos 5 dígitos del tiempo
        int randomPart = new Random().nextInt(90) + 10; // 2 dígitos aleatorios
        return timestamp + randomPart;
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
