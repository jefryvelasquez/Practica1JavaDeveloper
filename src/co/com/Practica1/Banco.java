package co.com.Practica1;

import java.util.TreeSet;

public class Banco implements ServicioClientes{

    private String nombre;
    private Domicilio domicilio;
    private String rfc;
    private String telefono;
    private TreeSet<Cliente> clientes;

    public Banco(String nombre, Domicilio domicilio, String rfc, String telefono) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.rfc = rfc;
        this.telefono = telefono;
        this.clientes = new TreeSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TreeSet<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(TreeSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean agregarCliente(Cliente cliente) {

        return clientes.add(cliente);
    }

    public boolean eliminarCliente(int numero) {

        return clientes.removeIf(cliente -> cliente.getNumero() == numero);
    }

    public Cliente consultarCliente(int numero){

        return clientes.stream().filter(cliente -> cliente.getNumero() == numero).findFirst().orElse(null);
    }
    public TreeSet<Cliente> obtenerClientes(){

            return clientes;

    }
    public Cliente buscarClientePorRfc(String rfc){

        return clientes.stream().filter(cliente -> cliente.getRfc().equals(rfc)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nombre=" + nombre + ", " +
                "domicilio=" + domicilio + ", " +
                "rfc=" + rfc + ", " +
                "telefono=" + telefono + ", " +
                "clientes=" + clientes +
                "}";
    }
}
