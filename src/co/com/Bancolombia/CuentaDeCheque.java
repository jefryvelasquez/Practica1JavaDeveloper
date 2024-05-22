package co.com.Bancolombia;

public class CuentaDeCheque extends Cuenta {

    private double costoManejoMensual;

public CuentaDeCheque(int numero, double saldo, double costoManejoMensual) {
        super(numero, saldo);
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
