package principal;

import java.util.*;
import principal.productos.*;

public class Supermercado{
    
    private byte opcion = 0;
    
    private final Scanner in = new Scanner(System.in);
    
    private Productos[] productos = new Productos[1200];
    private Factura[] factura =  new Factura[1200];
    
    private int numero = 0;
    private int posicionVenta = 0;
    
    private int cantidadE = 0;
    private int cantidadL = 0;
    private int cantidadC = 0;
    private int cantidadV = 0;
    
    private String codigo;
    private String descripcion;
    
    private double precio;
    
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
                IngresarPrecio();
                
                productos[numero] = new Enlatados(codigo, descripcion, precio, 'E');
                
                numero += 1;
                cantidadE += 1 ;
                System.out.println("Agregado exitosamente!");
                Menu();
                break;    
            case 2:
                System.out.println("--LACTEOS--");

                IngresarCodigo();
                IngresarDescripcion();
                IngresarPrecio();
                
                System.out.println("Ingrese los Kg del producto (Si los posee): ");
                kilos = in.nextDouble();
                System.out.println("Ingrese los litros del producto (Si los posee): ");
                litros = in.nextDouble();
                
                productos[numero] = new Lacteos(codigo, descripcion, kilos, litros, precio, 'L');
                
                numero += 1;
                cantidadL += 1;
                System.out.println("Agregado exitosamente!");
                Menu();
                break;                
            case 3:
                System.out.println("--CARNES--");
                
                IngresarCodigo();
                IngresarDescripcion();
                IngresarPrecio();
                
                System.out.println("Ingrese los Kg del producto: ");
                kilos = in.nextDouble();
                
                productos[numero] = new Carnes(codigo, descripcion, kilos, precio, 'C');
                
                numero += 1;
                cantidadC += 1;
                
                System.out.println("Agregado exitosamente!");
                Menu();
                break;                
            case 4:
                System.out.println("--VIVERES--");
                
                IngresarCodigo();
                IngresarDescripcion();
                IngresarPrecio();
                
                productos[numero] = new Viveres(codigo, descripcion, precio, 'V');
                
                numero += 1;
                cantidadV += 1;
                
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
    
    private double IngresarPrecio(){
        System.out.println("Ingrese el precio del Producto: ");
        precio = in.nextDouble();
        
        return precio;
    }
    
    public void ExistenciaProducto() {
        
        String codigobus;
        String code;
        String descripcion2;
        
        double kg;
        double l;
        double precioP;
        
        if(numero == 0){
            System.out.println("No hay Productos");
            Menu();
        }
        
        System.out.println("Ingrese el codigo del Producto a buscar: ");
        codigobus = in.next();
 
        int i = 0;
        
        while(productos[i] != null){
            if(productos[i].getCodigo().equalsIgnoreCase(codigobus)){
                
                tipoProducto = productos[i].getTipoProducto();
                
                code = productos[i].getCodigo();
                descripcion2 = productos[i].getDescripcion();
                
                kg = productos[i].getKilos();
                l = productos[i].getLitros();
                precioP = productos[i].getPrecio();
                
                
                System.out.println("Producto Encontrado!");
                ModificarProducto(code, descripcion2, kg, l, precioP);
                break;
            }
            
            i++;
        }
        Menu();
    } 

    public void FacturarVenta() {
        
        int cantidadVendida;
        int cedula;
        
        double precioVentasTotal = 0;
        
        String codigobus;
        
        System.out.println("Ingrese la cedula: ");
        cedula = in.nextInt();        
        
        System.out.println("Ingrese el codigo del producto: ");
        codigobus = in.next();
        
        System.out.println("Ingrese la cantidad vendida: ");
        cantidadVendida = in.nextInt();
        
        if(cantidadVendida > numero){
            System.out.println("Cantidad no valida porque supera la existencia");
            Menu();
        }else{
            
            for(int x = 0; x < cantidadVendida; x++){
                if(productos[x].getCodigo().equalsIgnoreCase(codigobus)){
                    
                    precioVentasTotal += productos[x].getPrecio();
                    
                    for(int y = x; y < productos.length - 1; y++){
                        productos[y] = productos[y + 1];
                    }
                    productos[productos.length - 1] = null;
                    numero -= 1;
                }    
            }
            
            factura[posicionVenta] = new Factura(cantidadVendida, cedula, precioVentasTotal);
            posicionVenta += 1;
        }
        
        System.out.println("TOTAL: " + precioVentasTotal);
        Menu();   
    }

    private void ModificarProducto(final String cod, final String des, final double k, final double l, double precio) {
        
        int cantidad = 0;
        System.out.println("Ingrese la Cantidad Que Desea Agregar: ");
        cantidad = in.nextInt();
        
        if(tipoProducto == 'E'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Enlatados(cod, des, precio,'E');
                
                numero += 1;
                cantidadE += 1;
            }
        }
        
        if(tipoProducto == 'L'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Lacteos(cod, des, k, l, precio, 'L');
                
                numero += 1;
                cantidadL += 1;
            }
        }

        if(tipoProducto == 'C'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Carnes(cod, des, k, precio, 'C');
                
                numero += 1;
                cantidadC += 1;
            }
        }
        
        if(tipoProducto == 'V'){
            
            for(int i = 0; i < cantidad; i++){
                productos[numero] = new Viveres(cod, des, precio, 'V');
               
                numero += 1;
                cantidadV += 1;
            }
        }          
        
        System.out.println(cantidad + " Registrados de " + cod );
    }
    
    private void mirar(){
        for(int y = 0; y < numero; y++ ){
            System.out.println(productos[y]);
        }
    }

    private void IngresosBrutos() {
        double total = 0;
       
        for(int x = 0; x < posicionVenta; x++){
            total += factura[x].getPrecio();
        }
        
        System.out.println("Ingresos Brutos: " + total);
       
        Menu();
    }

    private void EgresosEmpresa() {
        double egresos = 0;
        
        if(numero == 0){
           System.out.println("No has ingresado productos!"); 
        }else{
            
            for(int x = 0; x < numero; x++){
                egresos += productos[x].getPrecio();
            }
            
            System.out.println("Egresos en productos : " + egresos + " Cantidad de productos: " + numero);
        }
        Menu();           
    }

    private void ReporteMayoresVentas() {
    
    }

    private void EnExistencia() {
        if(cantidadE < 10){
            System.out.println("Hay menos de 10 productos de tipo Enlatados");
        }
        if(cantidadC < 10){
            System.out.println("Hay menos de 10 productos de tipo Carnicos");
        }
        if(cantidadL < 10){
            System.out.println("Hay menos de 10 productos de tipo Lacteos");
        }
        if(cantidadV < 10){
            System.out.println("Hay menos de 10 productos de tipo Viveres");
        }
        Menu();
    }    
}