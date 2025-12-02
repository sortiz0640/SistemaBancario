package cr.ac.ucenfotec.sortiz0640.bl.entities;

public class CuentaCorriente extends Cuenta {

    private static int cantCuentas = 0;
    private int operacionesEsteMes = 0;  // Nuevo contador mensual
    private double cuotaMantenimiento;
    private int operacionesExentas;
    private double costoPorOperacionExcedente;

    public CuentaCorriente(Cliente dueno) {
        super(dueno);
        this.operacionesExentas = 10;
        this.costoPorOperacionExcedente = 1500.0;
        this.cuotaMantenimiento = 5000;
        cantCuentas++;
    }

    @Override
    public double cobrarComisiones() {
        int totalOperaciones = getNumOperaciones();
        int operacionesExcedentes = Math.max(0, totalOperaciones - operacionesExentas);
        return cuotaMantenimiento + (operacionesExcedentes * costoPorOperacionExcedente);
    }

    public String aplicarComisionMensual() {
        double comision = cobrarComisiones();
        if (getSaldo() >= comision) {
            retirar(comision);
            setNumOperacionesMes(0);
            return "[INFO] Comisión mensual de " + comision + " aplicada correctamente. Nuevo saldo: " + getSaldo();
        } else {
            return "[ERR] Saldo insuficiente para aplicar comisión de " + comision + ". Saldo actual: " + getSaldo();
        }
    }

    public double getCuotaMantenimiento() {
        return cuotaMantenimiento;
    }

    public void setCuotaMantenimiento(double cuotaMantenimiento) {
        this.cuotaMantenimiento = cuotaMantenimiento;
    }

    public int getOperacionesExentas() {
        return operacionesExentas;
    }

    public void setOperacionesExentas(int operacionesExentas) {
        this.operacionesExentas = operacionesExentas;
    }

    public double getCostoPorOperacionExcedente() {
        return costoPorOperacionExcedente;
    }

    public void setCostoPorOperacionExcedente(double costoPorOperacionExcedente) {
        this.costoPorOperacionExcedente = costoPorOperacionExcedente;
    }

    public int getOperacionesEsteMes() {
        return operacionesEsteMes;
    }

    public void setOperacionesEsteMes(int operacionesEsteMes) {
        this.operacionesEsteMes = operacionesEsteMes;
    }
}