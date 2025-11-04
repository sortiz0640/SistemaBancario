package cr.ac.ucenfotec.sortiz0640.ul;

import org.apache.commons.validator.routines.EmailValidator;

import java.io.IOException;

public class Validations {

    private UI interfaz = new UI();
    EmailValidator validator = EmailValidator.getInstance();


    public String nombre() throws IOException {

        String nombre;

        do {

            interfaz.imprimirMensaje("Ingrese el nombre: ");
            nombre = interfaz.leerTexto();

            if (nombre == null ||  nombre.isBlank()) {
                interfaz.imprimirMensaje("[ERR] El nombre no puede estar vacio. ");
            }

        } while (nombre == null ||  nombre.isBlank());

        return nombre;
    }

    public String apellido() throws IOException {

        String apellido;

        do {

            interfaz.imprimirMensaje("Ingrese el apellido");
            apellido = interfaz.leerTexto();

            if (apellido == null ||  apellido.isBlank()) {
                interfaz.imprimirMensaje("[ERR] El apellido no puede estar vacio. ");
            }

        } while (apellido == null ||  apellido.isBlank());

        return apellido;
    }

    public String cedula() throws IOException {

        String cedula;
        String patronCedula = "\\d-\\d{4}-\\d{4}"; // formato: 1-0000-0000

        do {
            interfaz.imprimirMensaje("Ingrese la cédula [Formato 1-0000-0000]: ");
            cedula = interfaz.leerTexto();

            if (cedula == null || cedula.isBlank() || !cedula.matches(patronCedula)) {
                interfaz.imprimirMensaje("[ERR] Formato inválido. La cédula debe tener el formato 1-0000-0000.\n");
            }

        } while (cedula == null || cedula.isBlank() || !cedula.matches(patronCedula));

        return cedula;

    }
}
