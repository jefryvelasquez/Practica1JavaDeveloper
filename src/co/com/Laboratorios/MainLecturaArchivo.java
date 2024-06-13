package co.com.Laboratorios;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainLecturaArchivo {
    public static void main(String[] args) {

        // Crear tres clientes
        Cliente cliente1 = new Cliente(1, "Cliente 1",
                new Domicilio("Calle 3", 789, "Medellin", "Antoquia", 050000),
                "RFC1", "Telefono 1", LocalDate.of(2000, 1, 1));
        Cliente cliente2 = new Cliente(2, "Cliente 2",
                new Domicilio("Calle 1", 123,"Centro", "Aguascalientes", 20000),
                "RFC2", "Telefono 2", LocalDate.of(2020, 12, 27));
        Cliente cliente3 = new Cliente(3, "Cliente 3",
                new Domicilio("Calle 2", 456, "Insurgentes", "Aguascalientes", 20010),
                "RFC3", "Telefono 3", LocalDate.of(2009, 3, 19));


        try {

            Map<Integer, Cliente> mapaClientes = new HashMap<>();
            mapaClientes.put(1, cliente1);
            mapaClientes.put(2, cliente2);
            mapaClientes.put(3, cliente3);

            // Leer el archivo de cuentas
            Map<Integer, List<Cuenta>> cuentasPorCliente = Cuenta.leerCuentas("cuentas.txt");

            for (Map.Entry<Integer, List<Cuenta>> entry : cuentasPorCliente.entrySet()) {
                Integer numeroCliente = entry.getKey();
                List<Cuenta> cuentas = entry.getValue();
                Cliente cliente = mapaClientes.get(numeroCliente);
                if (cliente != null) {
                    for (Cuenta cuenta : cuentas) {
                        cliente.agregarCuenta(cuenta);
                    }
                }
            }

            // Validar que cada cliente tenga sus respectivas cuentas
            System.out.println("Cliente 1 tiene " + cliente1.obtenerCuentas().size() + " cuentas.");
            System.out.println("Cliente 2 tiene " + cliente2.obtenerCuentas().size() + " cuentas.");
            System.out.println("Cliente 3 tiene " + cliente3.obtenerCuentas().size() + " cuentas.");

            // Validar que los métodos del cliente sigan funcionando
            cliente1.abonarCuenta(1234, 100);
            cliente2.retirar(123456, 50);
            cliente3.cancelarCuenta(7894);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}