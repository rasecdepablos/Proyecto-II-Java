package principal;

import java.util.*;
import principal.productos.*;

public class Supermercado{
    
    private byte opcion = 0;
    
    private final Scanner in = new Scanner(System.in);
    
    private Productos[] productos = new Productos[1200];
    private Factura f =  new Factura();
    //private ArrayList <Productos> productos;
    
    private int numero = 0;
    
    private String codigo;
    private String descripcion;
    
    private char tipoProducto;
    
    public void Menu(){
        System.out.println("--Supermercado La Popular--");
        System.out.println("1)Añadir Producto  2)Existencia del producto  3)Facturar Venta  4)Ingresos Brutos  5)Egresos  6)Reporte Mayores Ventas  7)Productos en Baja Existencia  8)Salir");
        
        opcion = in.nextByte();
        
        switch(opcion){
            case 1:
                AñadirProducto();
                break;
            case 2:
                ExistenciaProducto();
                break;
            case 3:
                FacturarVenta();
                break;
            case 4:
                IngresosBrutos();
                break;
            case 5:
                EgresosEmpresa();
                break;
            case 6:
                ReporteMayoresVentas();
                break;
            case 7:
                EnExistencia();
                break;
            case 8:
                break;
            default:
             System.err.println("Opcion invalida");
             Menu();
        }
        
    }
    
    public static void main(String[] args) {
        Supermercado s = new Supermercado();
        s.Menu();
    }

    public void AñadirProducto(){
        
        double kilos;
        double litros;
        
        System.out.println("1) ENLATADOS  2) LACTEOS  3) CARNES  4) VIVERES");
        
        opcion = in.nextByte();
        
        switch(opcion){
            case 1:
                System.out.println("--ENLATADOS--");
                
                IngresarCodigo();
                IngresarDescripcion();
                
                productos[numero] = new Enlatados(codigo,descripcion, 'E');
                //productos.add(new Enlatados(codigo, descripcion));
                
                numero += 1;
                System.out.println("Agregado exitosamente!");
                Menu();
                break;    
            case 2:
                System.out.println("--LACTEOS--");

                IngresarCodigo();
                IngresarDescripcion();
                
                System.out.println("Ingrese los Kg del producto (Si los posee): ");
                kilos = in.nextDouble();
                System.out.println("Ingrese los litros del producto (Si los posee): ");
                litros = in.nextDouble();
                
                productos[numero] = new Lacteos(codigo, descripcion, kilos, litros, 'L');
                //productos.add(new Lacteos(codigo, descripcion, kilos, litros));
                
                numero += 1;
                System.out.println("Agregado exitosamente!");
                Menu();
                break;                
            case 3:
                System.out.println("--CARNES--");
                
                IngresarCodigo();
                IngresarDescripcion();
                
                System.out.println("Ingrese los Kg del producto: ");
                kilos = in.nextDouble();
                
                productos[numero] = new Carnes(codigo, descripcion, kilos, 'C');
                //productos.add(new Carnes(codigo, descripcion, kilos));
                
                numero += 1;
                System.out.println("Agregado exitosamente!");
                Menu();
                break;                
            case 4:
                System.out.println("--VIVERES--");
                
                IngresarCodigo();
                IngresarDescripcion();
                
                productos[numero] = new Viveres(codigo, descripcion, 'V');
                //productos.add(new Viveres(codigo, descripcion));
                
                numero += 1;
                System.out.println("Agregado exitosamente!");
                Menu();
                break;                 
            default:
             System.err.println("Opcion invalida");
             Menu();
        }
        
    }
    
    private String IngresarCodigo(){
    
        System.out.println("Ingrese el codigo del Producto: ");
        codigo = in.next();
   
        return codigo;
    }
    
    private String IngresarDescripcion() {

        System.out.println("Ingrese la descripcion del Producto: ");
        descripcion = in.next();        
    
    return descripcion;
    }
    
    public void ExistenciaProducto() {
        
        String codigobus;
        String code;
        String descripcion2;
        
        double kg;
        double l;
        
        if(productos == null){
            System.err.println("No has ingresado Productos!");
            Menu();
        }
        
        System.out.println("Ingrese el codigo del Producto a buscar: ");
        codigobus = in.next();
 
        int i = 0;
        
        while(productos[i] != null){
            if(productos[i].getCodigo() == codigo){
                
                tipoProducto = productos[i].getTipoProducto();
                
                code = productos[i].getCodigo();
                descripcion2 = productos[i].getDescripcion();
                
                kg = productos[i].getKilos();
                l = productos[i].getLitros();
                
                System.out.println("Producto Encontrado");
                ModificarProducto(code, descripcion2, kg, l);
                break;
            }
            i++;
        }
        
        Menu();
    } 

    public void FacturarVenta() {
    
  
    }

    private void ModificarProducto(final String cod, final String des, final double k, final double l) {
        
        int cantidad = 0;
        System.out.println("Ingrese la Cantidad Que Desea Agregar: ");
        cantidad = in.nextInt();
        
        if(tipoProducto == 'E'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Enlatados(cod, des,'E');
                
                numero += 1;
            }
        }
        
        if(tipoProducto == 'L'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Lacteos(cod, des, k, l, 'L');
                
                numero += 1;
            }
        }

        if(tipoProducto == 'C'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Carnes(cod, des, k, 'C');
                
                numero += 1;
            }
        }
        
        if(tipoProducto == 'V'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Viveres(cod, des, 'V');
                
      
                numero += 1;
            }
        }          
        
        System.out.println(cantidad + " Registrados de " + cod );
    }
    /*
    private void mirar(){
        for(int y = 0; y < numero; y++ ){
            System.out.println(productos[y]);
        }
    }*/

    private void IngresosBrutos() {
    
    }

    private void EgresosEmpresa() {
    
    }

    private void ReporteMayoresVentas() {
    
    }

    private void EnExistencia() {
    
    }
    
}
