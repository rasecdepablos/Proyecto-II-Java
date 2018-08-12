package principal;

public abstract class Productos {
    private String codigo;
    private String descripcion;
    
    private char tipoProducto;
    
    private double kilos;
    private double litros;
    private double precio;
    
    private int cedula;
    private int cantidadVendidos;
    
    public Productos(String codigo, String descripcion, double precio, char tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoProducto = tipo;
        this.precio = precio;
        
        this.kilos = kilos;
        this.litros = litros;
    }
    
    public void Mostrar(){
        System.out.println("Codigo: " + codigo + " Descripcion: " + descripcion);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public char getTipoProducto() {
        return tipoProducto;
    }

    public double getKilos() {
        return kilos;
    }

    public double getLitros() {
        return litros;
    }

    public double getPrecio() {
        return precio;
    }
    
}
