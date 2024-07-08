package service;

import model.Cliente;
import model.Transferencia;

import java.util.List;

public interface Banco {
    /**
     * Obtener clientes de la lista clientes.
     * @return
     */
    List<Cliente> getClientes();

    /**
     * Obtener transferencias de la lista transferencias.
     * @return
     */
    List<Transferencia> getTransferencias();

    /**
     * Obtener tamaño de lista clientes.
     * @return
     */
    int size();

    Cliente getCliente(int posicion);

    /**
     * Agregar Cliente a la lista clientes, verificando que no se repita.
     * @param cliente
     */
    void agregarCliente(Cliente cliente);
    /**
     * Agregar Transferencia a la lista transferencias, verificando que no se repita.
     * @param transferencia
     */
    void agregarTransferencia(Transferencia transferencia);

    /**
     * Carga desde el backend los Contactos.
     */
    void loadClientes();

    /**
     * Guarda en el backend los Contactos.
     */
    void saveClientes();

}
