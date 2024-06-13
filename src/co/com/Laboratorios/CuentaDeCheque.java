package co.com.Laboratorios;

import java.time.LocalDate;

public class CuentaDeCheque extends Cuenta {

    private double costoManejoMensual;

public CuentaDeCheque(int numero, LocalDate fechaApertura, double saldo, double costoManejoMensual) {
        super(numero, fechaApertura, saldo);
        this.costoManejoMensual = costoManejoMensual;
    }

    @Override
    public String toString() {
        return "CuentaDeCheque{" +
                "numero=" + this.getNumero() + ", " +
                "fechaApertura=" + this.getFechaApertura() + ", " +
                "saldo=" + this.getSaldo() + ", " +
                "fechaCancelacion=" + this.getFechaCancelacion() + ", " +
                "costoManejoMensual=" + this.costoManejoMensual + "}";
    }
}
