package co.com.Laboratorios;

import java.time.LocalDate;

public class CuentaDeAhorro extends Cuenta {

    private double tasaInteresMensual;

    public CuentaDeAhorro(int numero, LocalDate fechaApertura, double saldo, double tasaInteresMensual) {
        super(numero, fechaApertura,saldo );
        this.tasaInteresMensual = tasaInteresMensual;
    }

    public double calcularInteres() {
        return this.getSaldo() * this.tasaInteresMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeAhorro{" +
                "numero=" + this.getNumero() + ", " +
                "fechaApertura=" + this.getFechaApertura() + ", " +
                "saldo=" + this.getSaldo() + ", " +
                "fechaCancelacion=" + this.getFechaCancelacion() + ", " +
                "tasaInteresMensual=" + this.tasaInteresMensual + "}";
    }
}
