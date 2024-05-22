package co.com.Bancolombia;

public class CuentaDeAhorro extends Cuenta {

    private double tasaInteresMensual;

    public CuentaDeAhorro(int numero, double saldo, double tasaInteresMensual) {
        super(numero, saldo );
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
