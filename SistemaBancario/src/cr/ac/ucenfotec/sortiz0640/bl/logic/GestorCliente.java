package cr.ac.ucenfotec.sortiz0640.bl.logic;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Cliente;
import cr.ac.ucenfotec.sortiz0640.dl.DataCliente;

import java.util.ArrayList;

public class GestorCliente {

    private DataCliente db;

    public GestorCliente() {
        db = new DataCliente();
    }

    public String agregarCliente(String nombre, String apellido, String cedula) {

        if (db.getClientePorCedula(cedula) != null) {
            return "[ERR] Ya existe un cliente con la cédula " + cedula;
        }

        Cliente tmpCliente = new Cliente(nombre, apellido, cedula);
        db.agregarCliente(tmpCliente);
        return "[INFO] Cliente agregado correctamente!";
    }

    public boolean existenClientes() {
        return db.existenClientes();
    }

    public Cliente getClientePorCedula(String cedula) {
        if (!existenClientes()) {
            return null;
        }

        return db.getClientePorCedula(cedula);
    }

    public ArrayList<String> getClientesToString() {

        if (!existenClientes()) {
            return null;
        }

        ArrayList<Cliente> listaClientes = db.getClientes();

        ArrayList<String> clientesString = new ArrayList<>();
        for (Cliente c : listaClientes) {
            clientesString.add(c.toString());
        }

        return clientesString;

    }
}
