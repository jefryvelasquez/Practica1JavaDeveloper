package co.com.Laboratorios;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
    {

        Banco banco = new Banco("Bancolombia",
                new Domicilio("Calle 3", 789, "Medellin", "Antoquia", 050000),
                "COLOCOBM", "6045109000");

        Cliente cliente = new Cliente(1, "Juan Perez",
                new Domicilio("Calle 1", 123,"Centro", "Aguascalientes", 20000),
                "PEJL890123", "4491234567", LocalDate.of(1987, 3, 23));
        Cliente cliente2 = new Cliente(2, "Maria Lopez",
                new Domicilio("Calle 2", 456, "Insurgentes", "Aguascalientes", 20010),
                "LOML890123", "4497654321", LocalDate.of(1997, 3, 13));



        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(1, LocalDate.of(2015, 5, 31),1000, 0.05);
        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2,LocalDate.of(1965, 1, 1) ,2000, 50);

        CuentaDeAhorro cuentaDeAhorro2 = new CuentaDeAhorro(3, LocalDate.of(1999, 11, 10),1000, 0.05);
        CuentaDeCheque cuentaDeCheque2 = new CuentaDeCheque(4, LocalDate.of(2000, 9, 11),2000, 50);

        cliente.agregarCuenta(cuentaDeAhorro);
        cliente.agregarCuenta(cuentaDeCheque);

        cliente2.agregarCuenta(cuentaDeAhorro2);
        cliente2.agregarCuenta(cuentaDeCheque2);

        banco.agregarCliente(cliente);
        banco.agregarCliente(cliente2);

        cliente.abonarCuenta(1, 500);

        System.out.println("Se imprime la información del banco con sus clientes: ");
        System.out.println("Banco: " + banco + "\n");

        System.out.println("Se imprimen las cuentas del cliente 1:");
        System.out.println("Cuentas cliente 1:" + cliente.obtenerCuentas() + "\n");


        cliente.cancelarCuenta(2);
        cliente.retirar(1,150);
        System.out.println("Se imprimen las cuentas del cliente 1, luego de cancelar cuenta 2 y hacer retiro en cuenta 1:");
        System.out.println("Cuentas cliente 1:" + cliente.obtenerCuentas() + "\n");


        cliente.abonarCuenta(1, 500);
        System.out.println("Se imprimen la cuentas del cliente 1, luego de abonar en cuenta 1:");
        System.out.println("Cuentas cliente 1:" + cliente.obtenerCuentas() + "\n");


        banco.eliminarCliente(2);
        System.out.println("Se imprime la información del banco con sus clientes luego de elimanr cliente 2 ");
        System.out.println("Banco: " + banco + "\n");

        System.out.println("Se imprime la información del cliente 1: ");
        System.out.println( banco.consultarCliente(1).toString() + "\n");


        System.out.println("Clientes del banco: " + banco.obtenerClientes() + "\n");

        System.out.println("Se consulta cliente por RFC:");
        System.out.println(banco.buscarClientePorRfc("PEJL890123").toString());
    }
}