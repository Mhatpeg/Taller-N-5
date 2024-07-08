package model;

/**
 * Creación de clase cliente y se agregan atributos de cliente.
 */
public class Cliente {
    private String rut;
    private String nombre;
    private int monto;
    private String clave;

    /**
     * Agregados Constructor de clase y atributos.
     * @param rut
     * @param nombre
     * @param monto
     * @param clave
     */
    public Cliente(String rut, String nombre, int monto, String clave) {
        this.rut = rut;
        this.nombre = nombre;
        this.monto = monto;
        this.clave = clave;
    }
    /**
     * Gets de los atributos
     * @return
     */

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMonto() {
        return monto;
    }

    public String getClave() {
        return clave;
    }
    /**
     * Se hacen String para poder imprimirlos, se ocupó para verificar que la lectura estaba correcta.
     * @return
     */
    @Override
    public String toString() {
        return "Cliente{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", monto=" + monto +
                ", clave='" + clave + '\'' +
                '}';
    }
}
