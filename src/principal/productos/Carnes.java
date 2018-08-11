package principal.productos;

import principal.Productos;

/**
 *
 * @author Rasec Depablos
 */
public class Carnes extends Productos{

    private double kilos;
     
    public Carnes(String codigo, String descripcion, double kilos, char tipo) {
        super(codigo,descripcion,tipo);
        
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
