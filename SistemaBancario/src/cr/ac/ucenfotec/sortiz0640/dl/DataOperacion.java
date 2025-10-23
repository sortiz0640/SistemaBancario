package cr.ac.ucenfotec.sortiz0640.dl;

import cr.ac.ucenfotec.sortiz0640.bl.entities.Operacion;

import java.util.ArrayList;

public class DataOperacion {

    private ArrayList<Operacion> operaciones;

    public DataOperacion() {
        operaciones = new ArrayList<>();
    }

    public void agregarOperacion(Operacion operacion) {
        operaciones.add(operacion);
    }

    public ArrayList<Operacion> getOperaciones() {
        return operaciones;
    }
    
}
