package model;

public class TransferenciaBuilder {
    /**
     * Constructor para la clase Transferencia.
     */
    private String rutPropio;
    private String rutDestinatario;
    private String apodo;
    private int monto;
    private String mensaje;

    public TransferenciaBuilder(String rutPropio){
        this.rutPropio= rutPropio;

    }
    public TransferenciaBuilder setApodo(String apodo){
        this.apodo = apodo;
        return this;
    }
    public TransferenciaBuilder setRutDestinatario(String rutDestinatario){
        this.rutDestinatario = rutDestinatario;
        return this;
    }
    public TransferenciaBuilder setMonto(int monto){
        this.monto = monto;
        return this;
    }
    public TransferenciaBuilder setMensaje(String mensaje){
        this.mensaje = mensaje;
        return this;
    }

    public Transferencia build(){
        return new Transferencia(rutPropio, rutDestinatario,monto,mensaje,apodo);
    }
}
