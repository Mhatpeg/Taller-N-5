package lectura;


import edu.princeton.cs.stdlib.In;
import model.Cliente;
import model.Transferencia;
import model.TransferenciaBuilder;
import service.BancoImpl;


public class Lectura {
    private static BancoImpl banco;
    public Lectura(){
        banco=BancoImpl.getInstance();
    }
    public void leerClientes(){
        In archivoEntrada = new In("clientes.csv");

        String linea = archivoEntrada.readLine(); // Leer encabezado
        while ((linea = archivoEntrada.readLine()) != null) {
            try {
                String[] partes = linea.split(";");
                if (partes.length < 4) {
                    System.out.println("");
                } else {
                    String rut = partes[0];
                    String nombre = partes[1];
                    int monto = Integer.parseInt(partes[2]);
                    String clave = partes[3];
                    Cliente cliente = new Cliente(rut, nombre, monto, clave);
                    banco.agregarCliente(cliente);
                }
            } catch (Exception e) {
                System.out.println("Error procesando la línea: " + linea);
                e.printStackTrace();
            }
        }
        banco.saveClientes();
    }
    public void leerTransferencias(){
        In archivoEntrada = new In("transferencias.csv");
        String linea = archivoEntrada.readLine(); // Leer encabezado
        while ((linea = archivoEntrada.readLine()) != null) {
            try {
                String[] partes = linea.split(";");
                if (partes.length < 4) {
                    System.out.println("");
                } else {
                    String rutPropio = partes[0];
                    String rutDestinatario = partes[1];
                    int monto = Integer.parseInt(partes[2]);
                    String mensaje = partes[3];
                    Transferencia transferencia = new TransferenciaBuilder(rutPropio)
                            .setRutDestinatario(rutDestinatario)
                            .setMonto(monto)
                            .setMensaje(mensaje)
                            .build();
                    banco.agregarTransferencia(transferencia);
                }
            } catch (Exception e) {
                System.out.println("Error procesando la línea: " + linea);
                e.printStackTrace();
            }
        }
        banco.saveTransferencias();
    }
}
