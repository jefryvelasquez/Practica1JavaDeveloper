package co.com.Practica1;

public abstract class Cuenta implements Comparable<Cuenta> {

    private int numero;
    private String fechaApertura;
    private double saldo;
    private String fechaCancelacion;

    public Cuenta(int numero, double saldo) {
        this.numero = numero;
        this.fechaApertura = java.time.LocalDate.now().toString();
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
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
