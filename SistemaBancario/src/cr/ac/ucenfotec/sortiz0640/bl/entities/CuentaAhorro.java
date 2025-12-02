package cr.ac.ucenfotec.sortiz0640.bl.entities;

public class CuentaAhorro extends Cuenta {

    private static int cantCuentas = 0;
    private int operacionesExentas;
    private double cuotaOperaciones;
    private double cuotaFijaMensual = 2500.0;

    public CuentaAhorro(Cliente dueno) {
        super(dueno);
        this.operacionesExentas = 15;
        this.cuotaOperaciones = 1000.0;
        cantCuentas++;
    }

    @Override
    public double cobrarComisiones() {
        return cuotaFijaMensual;
    }

    public String aplicarComisionMensual() {
        double comision = cobrarComisiones();
        if (getSaldo() >= comision) {
            retirar(comision);
            return "[INFO] Comisión mensual de " + comision + " aplicada correctamente. Nuevo saldo: " + getSaldo();
        } else {
            return "[ERR] Saldo insuficiente para aplicar comisión de " + comision + ". Saldo actual: " + getSaldo();
        }
    }

    // Getters y Setters
    public double getCuotaFijaMensual() {
        return cuotaFijaMensual;
    }

    public void setCuotaFijaMensual(double cuotaFijaMensual) {
        this.cuotaFijaMensual = cuotaFijaMensual;
    }

    public int getOperacionesExentas() {
        return operacionesExentas;
    }

    public void setOperacionesExentas(int operacionesExentas) {
        this.operacionesExentas = operacionesExentas;
    }

    public double getCuotaOperaciones() {
        return cuotaOperaciones;
    }

    public void setCuotaOperaciones(double cuotaOperaciones) {
        this.cuotaOperaciones = cuotaOperaciones;
    }
}