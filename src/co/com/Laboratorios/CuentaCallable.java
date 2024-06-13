package co.com.Laboratorios;

import java.util.AbstractMap;
import java.util.concurrent.Callable;

class CuentaCallable implements Callable<AbstractMap.SimpleEntry<Cuenta, Integer>> {
    private final String linea;

    CuentaCallable(String linea) {
        this.linea = linea;
    }

    @Override
    public AbstractMap.SimpleEntry<Cuenta, Integer> call() throws Exception {
        return Cuenta.parseCuenta(linea);
    }

}