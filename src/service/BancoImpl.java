package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Cliente;
import model.Transferencia;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class BancoImpl implements Banco {
    private static BancoImpl instance;
    private static final String FILENAME_CLIENTES = "clientes.json";
    private static final String FILENAME_TRANSFERENCIAS = "transferencias.json";
    private List<Cliente> clientes;
    private List<Transferencia> transferencias;

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private BancoImpl() {
        clientes = new ArrayList<>();
        transferencias = new ArrayList<>();
        this.loadClientes();
        this.loadTransferencias();
        this.sort();
    }

    private void sort() {
        this.clientes.sort(Comparator.comparing(Cliente::getNombre));
    }

    @Override
    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public List<Transferencia> getTransferencias() {
        return transferencias;
    }

    @Override
    public int size() {
        return this.clientes.size();
    }

    @Override
    public Cliente getCliente(int posicion) {
        return this.clientes.get(posicion);
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getRut().equals(cliente.getRut())) {
                System.out.println("Cliente ya existe, no fue agregado");
                return;
            }
        }
        clientes.add(cliente);
        this.sort();
        this.saveClientes();
    }



    @Override
    public void agregarTransferencia(Transferencia transferencia) {

        if (transferencia == null) {
            throw new IllegalArgumentException("Transferencia no puede ser null");
        }
        for (Transferencia t : transferencias) {
            if (t.getRutPropio().equals(transferencia.getRutPropio())) {
                System.out.println("Transferencia ya existe, no fue agregado");
                return;
            }
        }
        this.transferencias.add(transferencia);
        this.sort();
        this.saveTransferencias();
    }

    @Override
    public void loadClientes() {
        this.clientes.clear();
        try {
            Cliente[] arregloClientes = GSON.fromJson(new FileReader(FILENAME_CLIENTES), Cliente[].class);
            this.clientes.addAll(Arrays.asList(arregloClientes));
        } catch (IOException e) {
            // Se ignora si no se puede leer el archivo (posiblemente porque no existe aún)
        }
    }

    @Override
    public void saveClientes() {
        try (FileWriter writer = new FileWriter(FILENAME_CLIENTES)) {
            GSON.toJson(this.clientes, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error de escritura de clientes", e);
        }
    }

    public void loadTransferencias() {
        this.transferencias.clear();
        try {
            Transferencia[] arregloTransferencias = GSON.fromJson(new FileReader(FILENAME_TRANSFERENCIAS), Transferencia[].class);
            this.transferencias.addAll(Arrays.asList(arregloTransferencias));
        } catch (IOException e) {
            // Se ignora si no se puede leer el archivo (posiblemente porque no existe aún)
        }
    }

    public void saveTransferencias() {
        try (FileWriter writer = new FileWriter(FILENAME_TRANSFERENCIAS)) {
            GSON.toJson(this.transferencias, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error de escritura de transferencias", e);
        }
    }

    public void imprimirClientes() {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void imprimirTransferencias() {
        System.out.println("Transferencias:");
        for (Transferencia transferencia : transferencias) {
            System.out.println(transferencia);
        }
    }

    public static BancoImpl getInstance() {
        if (instance == null) {
            instance = new BancoImpl();
        }
        return instance;
    }
    public Cliente validarCredenciales(String rut, String clave) {
        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut) && cliente.getClave().equals(clave)) {
                return cliente;
            }
        }
        return null; // Si no se encuentra el cliente o las credenciales son incorrectas
    }
}
