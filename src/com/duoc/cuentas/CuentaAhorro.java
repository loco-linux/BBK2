/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.cuentas;

/**
 *
 * @author jbarr
 */
public class CuentaAhorro extends CuentaBancaria {

    public static final int GIROS_TOTALES=6;
    private int girosRealizados = 0;
    
    public CuentaAhorro() {
    }

    public CuentaAhorro(
            String rut, 
            String nombre, 
            String apellidoP, 
            String apellidoM, 
            String domicilio, 
            String comuna, 
            int telefono, 
            int cuenta, 
            int saldo) {
        super(
                rut, 
                nombre, 
                apellidoP, 
                apellidoM, 
                domicilio, 
                comuna, 
                telefono, 
                cuenta, 
                saldo);
    }
 
    


    
    @Override
    public void girar(int giro){
        if(giro<0){
            System.out.println("[ERROR] Ingrese un monto mayor a 0...");          
        }else if(saldo - giro < 0){
            System.out.println("[ERROR] El giro no puede ser superior al saldo...");
        } else if(girosRealizados>=GIROS_TOTALES){
            System.out.println("[ERROR] Ha superado la cantidad de giros anuales que puede realizar en su cuenta de ahorro.");
            System.out.println("Contactese con su ejecutivo bancario.");
        
        } else if(girosRealizados<GIROS_TOTALES) {
            girosRealizados++;
            System.out.println("[Giros restantes]: " + (GIROS_TOTALES-girosRealizados));
            setSaldo(saldo - giro);            
            System.out.println("Giro realizado de manera exitosa!");
            System.out.println("--> [CA][" +getCuenta()+"] Saldo actual de $" +getSaldo());
        }
 
    }
    
    @Override
    public void depositar(int deposito){
        if(deposito < 0){
            System.out.println("[ERROR] Ingrese un monto mayor a cero...");
        } else {
            setSaldo(saldo+deposito);
            System.out.println("Deposito realizado de manera exitosa!");
            System.out.println("--> [CA][" +getCuenta()+"] Saldo actual de $" +getSaldo());
        }
        
    }
    
    @Override
    public void consultar(){
        System.out.println("--> [CA][" +getCuenta()+"] Saldo disponible: $" +getSaldo());
    }
    
    @Override
    public void consultaDatos(){
        System.out.println("[Cuenta][" +getCuenta()+"]");
        System.out.println("-> Rut: "               + getRut());
        System.out.println("-> Nombre: "            + getNombre());
        System.out.println("-> Apellido paterno: "  + getApellidoP());
        System.out.println("-> Apellido materno: "  + getApellidoM());
        System.out.println("-> Domicilio: "         + getDomicilio());
        System.out.println("-> Comuna: "            + getComuna());
        System.out.println("-> Telefono: "          + getTelefono());
    }
    
    
}
