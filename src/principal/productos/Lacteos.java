/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.productos;

import principal.Productos;

/**
 *
 * @author Rasec Depablos
 */
public class Lacteos extends Productos{

    private double kilos;
    private double litros;
    private boolean solido;
    
    public Lacteos(String codigo, String descripcion, double kilos, double litros, double precio, char tipo) {
        super(codigo, descripcion, precio, tipo);

        this.kilos = kilos;
        this.litros = litros;
    }
    
    public void Mostrar(){
        System.out.println("Producto Lacteo");
        
        if(kilos == 0){
            System.out.println("Litros: " + litros);
        } else{
            System.out.println("Kilos: " + kilos);
        }
        
        super.Mostrar();
    }

    public double getKilos() {
        return kilos;
    }

    public double getLitros() {
        return litros;
    }
    
}
