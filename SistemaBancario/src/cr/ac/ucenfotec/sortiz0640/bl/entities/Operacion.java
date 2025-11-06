package cr.ac.ucenfotec.sortiz0640.bl.entities;

import java.time.LocalDate;
import java.util.Random;

public class Operacion {

    private int numero;
    private String tipo;
    private double monto;
    private LocalDate fechaOperacion;

    public Operacion(String tipo, double monto) {
        this.numero = generarNumeroOperacion();
        this.tipo = tipo;
        this.monto = monto;
        this.fechaOperacion = LocalDate.now();
    }

    public int getNumero() {
        return numero;
    }

    private int generarNumeroOperacion() {

        // Generado por IA para la creacion de los numeros de operacion

        int timestamp = Math.toIntExact(System.currentTimeMillis() % 200000); // últimos 5 dígitos del tiempo
        int randomPart = new Random().nextInt(70) + 20; // 2 dígitos aleatorios
        return timestamp + randomPart;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    @Override
    public String toString() {
        return "[NÚMERO: " + numero + "] " +
                "[TIPO: " + tipo + "] " +
                "[MONTO: " + monto + "] " +
                "[FECHA OPERACIÓN: " + fechaOperacion + "]";
    }
}
