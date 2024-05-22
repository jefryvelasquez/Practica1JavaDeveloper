package co.com.Bancolombia;

public interface ServicioClientes {

    public boolean agregarCliente(Cliente cliente);
    public boolean eliminarCliente(int numero);
    public Cliente consultarCliente(int numero);
    public Cliente[] obtenerClientes();
    public Cliente buscarClientePorRfc(String rfc);
}
