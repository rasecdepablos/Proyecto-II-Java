package principal.productos;

import principal.Productos;

public class Enlatados extends Productos {

    private double iva = 0.12;
    
    private int cedula;
    private int cantidadVendida;

    public Enlatados(String codigo, String descripcion, double precio, char tipo) {
        super(codigo,descripcion,precio,tipo);
    }
    
    public void Mostrar(){
        System.out.println("Producto Enlatado");
        
        super.Mostrar();
    }
}
