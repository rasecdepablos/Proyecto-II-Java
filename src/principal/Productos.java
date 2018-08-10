package principal;

public abstract class Productos {
    private String codigo;
    private String descripcion;
    
    private char tipoProducto;
    
    private double kilos;
    private double litros;
    
    public Productos(String codigo, String descripcion, char tipo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipoProducto = tipo;
        
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
    
}
