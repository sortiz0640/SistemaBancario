package cr.ac.ucenfotec.sortiz0640.bl.logic;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Cliente;
import cr.ac.ucenfotec.sortiz0640.dl.DataCliente;

public class GestorCliente {

    // test change
    private DataCliente bd;

    public GestorCliente() {
        bd = new DataCliente();
    }

    public String agregarCliente(String nombre, String apellido, String cedula) {
        Cliente tmpCliente = new Cliente(nombre, apellido, cedula);
        bd.agregarCliente(tmpCliente);
        return "Cliente agregado correctamente!";
    }
}
