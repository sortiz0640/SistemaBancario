package cr.ac.ucenfotec.sortiz0640.dl;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Cliente;
import cr.ac.ucenfotec.sortiz0640.bl.entities.Operacion;

import java.util.ArrayList;

public class DataCliente {

    private ArrayList<Cliente> clientes;

    public DataCliente() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarOperacion(Operacion operacion, Cliente cliente) {

    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}


