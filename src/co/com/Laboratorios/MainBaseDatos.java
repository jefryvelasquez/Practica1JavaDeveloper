package co.com.Laboratorios;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainBaseDatos {

    private static class ConexionBD {
        private static final String URL = "jdbc:mysql://localhost:3306/practica12";
        private static final String USER = "admin";
        private static final String PASSWORD = "admin1234";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

   private static class CuentaDAO {
    public static Map<Integer, List<Cuenta>> leerCuentas() {
        Map<Integer, List<Cuenta>> cuentasPorCliente = new HashMap<>();
        try (Connection connection = ConexionBD.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cuentas");
            while (resultSet.next()) {
                int numero = resultSet.getInt("numero");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate fecha = LocalDate.parse( resultSet.getString("fecha"), formatter);
                double saldo = resultSet.getDouble("saldo");
                double interes = resultSet.getDouble("interes");
                int cliente = resultSet.getInt("cliente");
                String tipoCuenta = resultSet.getString("tipoCuenta");
                Cuenta cuenta = tipoCuenta.equals("CA") ? new CuentaDeAhorro(numero, fecha,saldo, interes) : new CuentaDeCheque(numero,fecha ,saldo, interes);

                List<Cuenta> cuentasDelCliente = cuentasPorCliente.getOrDefault(cliente, new ArrayList<>());
                cuentasDelCliente.add(cuenta);
                cuentasPorCliente.put(cliente, cuentasDelCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuentasPorCliente;
    }
}

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

        Map<Integer, Cliente> mapaClientes = new HashMap<>();
        mapaClientes.put(1, cliente1);
        mapaClientes.put(2, cliente2);
        mapaClientes.put(3, cliente3);

        Map<Integer, List<Cuenta>> cuentasPorCliente = CuentaDAO.leerCuentas();
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
    }
}