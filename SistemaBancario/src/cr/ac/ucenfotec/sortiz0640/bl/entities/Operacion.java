package cr.ac.ucenfotec.sortiz0640.bl.entities;

import java.time.LocalDate;

public class Operacion {

    private int numero;
    private String tipo;
    private double monto;
    private LocalDate fechaOperacion;

    public Operacion(int numero, String tipo, double monto) {
        this.numero = numero;
        this.tipo = tipo;
        this.monto = monto;
        this.fechaOperacion = LocalDate.now();
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                ", fechaOperacion=" + fechaOperacion +
                '}';
    }
}
