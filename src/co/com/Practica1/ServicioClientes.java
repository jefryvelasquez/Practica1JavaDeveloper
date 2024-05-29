package co.com.Practica1;

import java.util.TreeSet;

public interface ServicioClientes {

    boolean agregarCliente(Cliente cliente);
    boolean eliminarCliente(int numero);
    Cliente consultarCliente(int numero);
    TreeSet<Cliente> obtenerClientes();
    Cliente buscarClientePorRfc(String rfc);
}
