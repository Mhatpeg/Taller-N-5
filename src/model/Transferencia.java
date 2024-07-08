package model;

public class Transferencia {
    private String rutPropio;
    private String rutDestinatario;
    private int monto;
    private String mensaje;
    private String apodo;

    /**
     * Agregados Constructor de clase y atributos.
     * @param rutPropio
     * @param rutDestinatario
     * @param monto
     * @param mensaje
     * @param apodo
     */

    public Transferencia(String rutPropio, String rutDestinatario, int monto, String mensaje, String apodo) {
        this.rutPropio = rutPropio;
        this.rutDestinatario = rutDestinatario;
        this.monto = monto;
        this.mensaje = mensaje;
        this.apodo=apodo;
    }

    /**
     * Gets de los atributos
     * @return
     */

    public String getApodo(){
        return apodo;
    }

    public String getRutPropio() {
        return rutPropio;
    }

    public String getRutDestinatario() {
        return rutDestinatario;
    }

    public int getMonto() {
        return monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    /**
     * Se hacen String para poder imprimirlos, se ocupó para verificar que la lectura estaba correcta.
     * @return
     */
    @Override
    public String toString() {
        return "Transferencia{" +
                "rutPropio='" + rutPropio + '\'' +
                ", rutDestinatario='" + rutDestinatario + '\'' +
                ", monto=" + monto +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
