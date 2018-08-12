package principal.productos;

import principal.Productos;

/**
 *
 * @author Rasec Depablos
 */
public class Carnes extends Productos{

    private double kilos;
     
    public Carnes(String codigo, String descripcion, double kilos, double precio, char tipo) {
        super(codigo,descripcion,precio,tipo);
        
        this.kilos = kilos;
    }
    
    public void Mostrar(){
        System.out.println("Producto Carnico");
        
        super.Mostrar();
    }

    public double getKilos() {
        return kilos;
    }
}
