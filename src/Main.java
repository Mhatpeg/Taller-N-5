import lectura.Lectura;
import service.BancoImpl;

public class Main {
    public static void main(String[] args) {
        Lectura lectura= new Lectura();
        // Leer y guardar clientes
        lectura.leerClientes();
        // Leer y guardar transferencias
        lectura.leerTransferencias();
        BancoImpl banco = BancoImpl.getInstance();
        banco.imprimirClientes();
        banco.imprimirTransferencias();


    }

}