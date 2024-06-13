package co.com.Laboratorios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Cuenta implements Comparable<Cuenta> {

    private int numero;
    private LocalDate fechaApertura;
    private double saldo;
    private LocalDate fechaCancelacion;

    public Cuenta(int numero, LocalDate fechaApertura , double saldo) {
        this.numero = numero;
        this.fechaApertura =fechaApertura;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDate fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public static Map<Integer, List<Cuenta>> leerCuentas(String nombreArchivo) throws IOException {
        Map<Integer, List<Cuenta>> cuentasPorCliente = new HashMap<>();
        List<String> lineas = Files.readAllLines(Paths.get(nombreArchivo));
        for (String linea : lineas) {
            AbstractMap.SimpleEntry<Cuenta, Integer> cuentaYCliente = parseCuenta(linea);
            Cuenta cuenta = cuentaYCliente.getKey();
            Integer numeroCliente = cuentaYCliente.getValue();
            cuentasPorCliente.computeIfAbsent(numeroCliente, k -> new ArrayList<>()).add(cuenta);
        }
        return cuentasPorCliente;
    }

    public static AbstractMap.SimpleEntry<Cuenta, Integer> parseCuenta(String linea) {
        String tipo = linea.substring(0, 2);
        String[] partes = linea.substring(3, linea.length() - 1).split(",");
        int numero = Integer.parseInt(partes[0].trim());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaApertura = LocalDate.parse(partes[1].trim(), formatter);
        double saldo = Double.parseDouble(partes[2].trim());
        double interesMensual = Double.parseDouble(partes[3].trim());
        int numeroCliente = Integer.parseInt(partes[partes.length - 1].trim());
        Cuenta cuenta = tipo.equals("CA") ? new CuentaDeAhorro(numero, fechaApertura,saldo, interesMensual) : new CuentaDeCheque(numero,fechaApertura ,saldo, interesMensual);
        return new AbstractMap.SimpleEntry<>(cuenta, numeroCliente);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numero=" + numero + ", " +
                "fechaApertura=" + fechaApertura + ", " +
                "saldo=" + saldo + ", " +
                "fechaCancelacion=" + fechaCancelacion + "}";
    }

    @Override
    public int compareTo(Cuenta o){
        return Double.compare(this.saldo, o.saldo);

    }

}
