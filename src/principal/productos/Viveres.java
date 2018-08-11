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
public class Viveres extends Productos{

    private double iva = 0.12;
    /*
    private String codigo;
    private String descripcion;*/
    
    public Viveres(String codigo, String descripcion, char tipo) {
        
        super(codigo, descripcion, tipo);
        //this.codigo = codigo;
        //this.descripcion = descripcion;
    }
    
    public void Mostrar(){
        System.out.println("Producto Vegetal");
       
        super.Mostrar();
    }
    
}
