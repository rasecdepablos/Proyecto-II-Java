package principal.productos;

import principal.Productos;

public class Enlatados extends Productos {

    private double iva = 0.12;
    
    //private String codigo;
    //private String descripcion;

    public Enlatados(String codigo, String descripcion, char tipo) {
        //this.codigo = codigo;
        //this.descripcion = descripcion;
        super(codigo,descripcion,tipo);
    }
    
    public void Mostrar(){
        System.out.println("Producto Enlatado");
        
        super.Mostrar();
    }
}
