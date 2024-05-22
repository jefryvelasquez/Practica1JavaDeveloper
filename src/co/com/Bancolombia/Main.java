package co.com.Bancolombia;

import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {

        Banco banco = new Banco("Bancolombia",
                new Domicilio("Calle 3", 789, "Medellin", "Antoquia", 050000),
                "COLOCOBM", "6045109000");

        Cliente cliente = new Cliente(1, "Juan Perez",
                new Domicilio("Calle 1", 123,"Centro", "Aguascalientes", 20000),
                "PEJL890123", "4491234567", "01/01/1990");
        Cliente cliente2 = new Cliente(2, "Maria Lopez",
                new Domicilio("Calle 2", 456, "Insurgentes", "Aguascalientes", 20010),
                "LOML890123", "4497654321", "02/02/1990");



        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(1, 1000, 0.05);
        CuentaDeCheque cuentaDeCheque = new CuentaDeCheque(2, 2000, 50);

        CuentaDeAhorro cuentaDeAhorro2 = new CuentaDeAhorro(3, 1000, 0.05);
        CuentaDeCheque cuentaDeCheque2 = new CuentaDeCheque(4, 2000, 50);

        cliente.agregarCuenta(cuentaDeAhorro);
        cliente.agregarCuenta(cuentaDeCheque);

        cliente2.agregarCuenta(cuentaDeAhorro2);
        cliente2.agregarCuenta(cuentaDeCheque2);

        banco.agregarCliente(cliente);
        banco.agregarCliente(cliente2);

        cliente.abonarCuenta(1, 500);

        System.out.println("Banco: " + banco.toString());

        System.out.println("Cuentas cliente 1:" + Arrays.toString(cliente.obtenerCuentas()));

        cliente.cancelarCuenta(2);

        cliente.retirar(2,150);

        System.out.println("Cuentas cliente 1:" + Arrays.toString(cliente.obtenerCuentas()));

        cliente.abonarCuenta(1, 500);

        banco.eliminarCliente(2);

        System.out.println( banco.consultarCliente(1).toString());

        System.out.println("Banco: " + banco.toString());

        System.out.println("CLientes del banco: " + Arrays.toString(banco.obtenerClientes()));

        System.out.println(banco.buscarClientePorRfc("PEJL890123").toString());




    }
}