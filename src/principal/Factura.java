package principal;

/**
 *
 * @author Rasec Depablos
 */
class Factura {

    private int cedula;
    private int cantidad;
    private double precio;

    public Factura(int cantidad, int cedula, double precio) {
        this.cantidad = cantidad;
        this.cedula = cedula;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    
    public int getCantidad() {
        return cantidad;
    }
}
