/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.duoc.Cliente;

import com.duoc.cuentas.CuentaAhorro;
import com.duoc.cuentas.CuentaCorriente;
import com.duoc.cuentas.CuentaCredito;
//import com.duoc.cuentas.Cuentas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jbarr
 */
public class Bank_Boston_2 {

    // Atributos encapsulados
    // Arreglo de constructor del objeto clientes tipo CuentaCorriente  
    private static final List<CuentaCorriente>  clienteCC      = new ArrayList<>();
    private static final List<CuentaAhorro>     clienteCA      = new ArrayList<>();
    private static final List<CuentaCredito>    clienteCCO     = new ArrayList<>();    
    
    private static final Scanner teclado = new Scanner(System.in);
    
    private static int contador = 0;
    
    // Atributos a solicitar al usuario
    private static final String[] caracteristicas = {"Rut",
            "Nombre","Apellido paterno","Apellido materno", 
            "Domicilio", "Comuna", "Telefono"
            };
    
    public static void main(String[] args) {
                
        int opcion;
        boolean salir1=false; 
        
        
        do{
        try{
                    
            System.out.println("\n========== BANK BOSTON ==========\n");
            System.out.println("[1] Registrar nuevo cliente");
            System.out.println("[2] Ingresar a sucursal virtual");
            System.out.println("[3] Salir");
            System.out.print("---> Ingrese opcion: ");
            
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1 -> registrarCliente();
                case 2 -> sucursalVirtual();
                case 3 -> {
                    System.out.println("\n<<< Bank Boston le agradece su preferencia >>>\n");    
                    salir1 = true;
                    break;
                }
                default -> System.out.println("[ERROR] Ingrese una opcion valida!\n"); 
            }        
            }catch(InputMismatchException ex) {
                System.out.println("[ERROR] Ingrese un numero entero...\n");
                teclado.next();
            }
        }while(salir1==false);
                        
    }
        
    public static void sucursalVirtual(){
        Scanner tecla3 = new Scanner(System.in);
        boolean salir2=false;
        int opcion;
        String rut="";
        
        try{
            if(!clienteCC.isEmpty()){
                System.out.print("Ingrese su rut: ");
                rut = tecla3.nextLine();
            }
        }catch(InputMismatchException ex) {
            System.out.println("[ERROR]");
            teclado.next();            
        }
            
           
        if(existeRUT(rut) == true){
        

        
        do{
        try{                 
            menuPrincipal();
            opcion = tecla3.nextInt();
        
            switch(opcion){
           
                case 1 -> datosCliente();
                case 2 -> depositar();
                case 3 -> girar();
                case 4 -> consultaSaldo();
                case 5 -> {
                    System.out.println("\n<<< Bank Boston le agradece su preferencia >>>\n");    
                    salir2 = true;
               
                    }
               default -> System.out.println("[ERROR] Ingrese una opcion valida!\n"); 

            }
            
        }catch(InputMismatchException io) {
            System.out.println("[ERROR] Ingrese un numero entero...\n");
            break;
           
            }
            }while(salir2==false);

            }else{
            System.out.println("[ERROR] Sin cuentas iniciadas aun.");
        }
    }
    
            
            
       
        
        
        
        
    
  
    
    
    public static void menuPrincipal(){
        System.out.println("\n=======   MENU   =======");

        System.out.println("[1] VER DATOS DE CLIENTE");
        System.out.println("[2] DEPOSITAR");
        System.out.println("[3] GIRAR");
        System.out.println("[4] CONSULTAR SALDO");
        System.out.println("[5] SALIR");
        System.out.print("---> Ingrese opcion: ");
    }
    
    public static void registrarCliente(){
        
        
        Scanner tecla2 = new Scanner(System.in);
        
        String[] result = {"","","","","","",""};
        int len = caracteristicas.length;
        boolean err=false;
        
        for(int i=0; i<len;i++){
            System.out.print("Ingrese " + caracteristicas[i] + ": ");
            result[i] = tecla2.nextLine();
            if(caracteristicas[i].equals("Rut")){
                if(comprobarRUT(result[0]) == false){
                    System.out.println("[ERROR] rut mal digitado...");
                    err=true;
                    break;
                }
                if(existeRUT(result[0]) == true){
                    System.out.println("[ERROR] Rut ya existe!...");
                    err=true;
                    break;
                }
            }
        }
        
        if(err==false){
        try{    
            clienteCC.add(new CuentaCorriente(
                result[0], // rut
                result[1], // nombre
                result[2], // apellido paterno
                result[3], // apellido materno
                result[4], // domicilio
                result[5], // comuna
                Integer.parseInt(result[6]), // telefono
                numeroCuenta(result[0]), // cuenta
                0 // saldo (ya seteado a $0 pesos))
            ));
            
            clienteCA.add(new CuentaAhorro(
                result[0], // rut
                result[1], // nombre
                result[2], // apellido paterno
                result[3], // apellido materno
                result[4], // domicilio
                result[5], // comuna
                Integer.parseInt(result[6]), // telefono
                numeroCuenta(result[0]), // cuenta
                0 // saldo (ya seteado a $0 pesos))
            ));
                        
            clienteCCO.add(new CuentaCredito(
                result[0], // rut
                result[1], // nombre
                result[2], // apellido paterno
                result[3], // apellido materno
                result[4], // domicilio
                result[5], // comuna
                Integer.parseInt(result[6]), // telefono
                numeroCuenta(result[0]), // cuenta
                0 // saldo (ya seteado a $0 pesos))
            ));            
            

            System.out.println("-> Cuenta Corriente: " + clienteCC.get(contador).getCuenta());
            contador++;
                  
        }catch(NumberFormatException io){
            System.out.println("[ERROR]");       
        }
        }
    
    }
    
    public static void datosCliente(){        
        if(clienteCC.isEmpty()){
            System.out.println("[ERROR] No hay clientes registrados aun...");
        }else{
        System.out.print("\nIngrese num Cuenta: ");
        int cuenta, cont = 0; 
        boolean existe = false;
        
        try{
        cuenta = teclado.nextInt();
        
        if(comprobarCuenta(cuenta) != -1){
            cont = comprobarCuenta(cuenta);
            existe = true;
        }else{
            System.out.println("[ERROR] No existe dicha cuenta...");
        }
        
        if(existe) clienteCC.get(cont).consultaDatos(); 
        
        }catch(NullPointerException ex){
            System.out.println("[ERROR] No se han iniciado datos\n");
        }catch(InputMismatchException ex) {
            System.out.println("[ERROR] Ingrese un numero entero...\n");
            teclado.next();
        }
        }
      
    }
    

    public static void depositar(){
        if(clienteCC.isEmpty()){
            System.out.println("[ERROR] No hay clientes registrados aun...");
        }else{
        System.out.print("\nIngrese num Cuenta: ");
        int cuenta, deposito, cont = 0; 
        boolean existe = false;
        
        try{
        cuenta = teclado.nextInt();
        
        if(comprobarCuenta(cuenta) != -1){
            cont = comprobarCuenta(cuenta);
            existe = true;
        }else{
            System.out.println("[ERROR] No existe dicha cuenta...");
        }
        
        if(existe){
            System.out.print("Ingrese un monto para depositar: ");
            deposito = teclado.nextInt();
            
            System.out.println("""
                               En que cuenta desea realizar la operacion?
                               [1] Cuenta Corriente
                               [2] Cuenta Ahorro
                               [3] Cuenta Credito                               
                               """);
            System.out.print("--Seleccione opcion: ");
            int opcion = teclado.nextInt();
            
            switch(opcion){
                case 1 -> clienteCC.get(cont).depositar(deposito);
                case 2 -> clienteCA.get(cont).depositar(deposito);
                case 3 -> clienteCCO.get(cont).depositar(deposito);
                default -> System.out.println("[ERROR] Ingrese una opcion valida.");
                    
            }
            }}catch(NullPointerException ex){
                System.out.println("[ERROR] No se han iniciado datos\n");
            }catch(InputMismatchException ex) {
                System.out.println("[ERROR] Ingrese un numero entero...\n");
                teclado.next();
            }
        
        }
    }
    
    public static void girar(){
        if(clienteCC.isEmpty()){
            System.out.println("[ERROR] No hay clientes registrados aun...");
        }else{           
        System.out.print("\nIngrese num Cuenta: ");
        int cuenta, giro, cont = 0; 
        boolean existe = false;
        
        try{
        cuenta = teclado.nextInt();
        
        if(comprobarCuenta(cuenta) != -1){
            cont = comprobarCuenta(cuenta);
            existe = true;
        }else{
            System.out.println("[ERROR] No existe dicha cuenta...");
        }
        
        if(existe){
            System.out.print("Ingrese un monto para girar: ");
            giro = teclado.nextInt();
            System.out.println("""
                               En que cuenta desea realizar la operacion?
                               [1] Cuenta Corriente
                               [2] Cuenta Ahorro
                               [3] Cuenta Credito                               
                               """);
            System.out.print("--Seleccione opcion: ");
            int opcion = teclado.nextInt();
            
            switch(opcion){
                case 1 -> clienteCC.get(cont).girar(giro);
                case 2 -> clienteCA.get(cont).girar(giro);
                case 3 -> clienteCCO.get(cont).girar(giro);
                default -> System.out.println("[ERROR] Ingrese una opcion valida.");
                    
            }           
        }}catch(NullPointerException ex){
            System.out.println("[ERROR] No se han iniciado datos\n");
        }catch(InputMismatchException ex) {
            System.out.println("[ERROR] Ingrese un numero entero...\n");
            teclado.next();
        }
        }
    }
    
    public static void consultaSaldo(){   
        if(clienteCC.isEmpty()){
            System.out.println("[ERROR] No hay clientes registrados aun...");
        }else{
        System.out.print("\nIngrese num Cuenta: ");
        int cuenta, cont = 0; 
        boolean existe = false;
        
        try{
        cuenta = teclado.nextInt();
        
        if(comprobarCuenta(cuenta) != -1){
            cont = comprobarCuenta(cuenta);
            existe = true;
        }else{
            System.out.println("[ERROR] No existe dicha cuenta...");
        }
        
        if(existe){
            clienteCC.get(cont).consultar();
            clienteCA.get(cont).consultar();
            clienteCCO.get(cont).consultar();
        } 
        
        }catch(NullPointerException ex){
            System.out.println("[ERROR] No se han iniciado datos\n");
        }catch(InputMismatchException ex) {
            System.out.println("[ERROR] Ingrese un numero entero...\n");
            teclado.next();
        }
        }
    }
    
    public static int numeroCuenta(String rut){
        int numeroCuenta;
        int numDigitos = rut.trim().length();
        
        char c_array[] = rut.toCharArray();
        
        char ult4[] = new char[4];
        ult4[3]= c_array[numDigitos-3]; // ultimos 4 digitos antes del gion
        ult4[2]= c_array[numDigitos-4]; // 
        ult4[1]= c_array[numDigitos-5];
        ult4[0]= c_array[numDigitos-7];
        
        String ultimos = "";
        for(int i=0; i<4; i++){
            ultimos = ultimos + ult4[i];
        }
        // linea que devuelve un numero entero al azar del 0 al 9           
        int random = (int)Math.floor(Math.random()*10);
        // String que agrupa el prefijo del banco + 4 ultimos digitos del rut + random
        // Generando los 9 digitos requeridos para la cuenta corriente
        String num = "3343" + ultimos + random;
        // linea que convierte el tipo String a int
        numeroCuenta = Integer.parseInt(num);
        
        return numeroCuenta;
    }
    
    // Metodo que comprueba la longitud de caracteres del rut ingresado
    public static boolean comprobarRUT(String rut){
        int numDigitos = rut.trim().length();
      
        return !(numDigitos <11 || numDigitos >12);
        
    }
    
    // Metodo que comprueba si existe el rut ingresado. Si ya esta ingresado, retorna true
    public static boolean existeRUT(String rut){
        boolean existe = false;
        
        if(!clienteCC.isEmpty()){
        int cont = clienteCC.size();
        
        for(int i=0; i<cont; i++){
            if(clienteCC.get(i).getRut().equals(rut)){
                existe = true;
                break;
            }
        }
        }
        
        return existe;
    }
    
    // Metodo que comprueba la existencia de una cuenta en particular
    // Si no existe, retorna -1. 
    // De lo contrario, retorna el indice del arreglo donde encontro el num de cuenta
    public static int comprobarCuenta(int cuenta){
        boolean existe = false;
        int cont=0;
        int indice=clienteCC.size();
                
        for(int i=0; i<indice; i++){
            if(clienteCC.get(i).getCuenta() == cuenta){
                existe = true;
                break;
            }
            cont++;
        }
        
        if(existe == false){
            return -1;
        }else{
        return cont;
    }
    }
}
