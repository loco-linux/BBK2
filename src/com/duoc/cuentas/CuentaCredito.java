/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.cuentas;

/**
 *
 * @author jbarr
 */
public class CuentaCredito extends CuentaBancaria{

    public CuentaCredito() {
    }

    public CuentaCredito(
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
        } else {
            setSaldo(saldo - giro);
            System.out.println("Giro realizado de manera exitosa!");
            System.out.println("--> [CC][" +getCuenta()+"] Saldo actual de $" +getSaldo());
        }
 
        if(getSaldo()<0){
            System.out.println("Recuerde regularizar su situacion financiera a la brevedad.");
            System.out.println("Evite intereses por mora.");
        }
    }
    
    @Override
    public void depositar(int deposito){
        if(deposito < 0){
            System.out.println("[ERROR] Ingrese un monto mayor a cero...");
        } else {
            setSaldo(saldo+deposito);
            System.out.println("Deposito realizado de manera exitosa!");
            System.out.println("--> [CC][" +getCuenta()+"] Saldo actual de $" +getSaldo());
        }
        
    }
    
    @Override
    public void consultar(){
        System.out.println("--> [CC][" +getCuenta()+"] Saldo disponible: $" +getSaldo());
        
        if(getSaldo()<0){
            System.out.println("Recuerde regularizar su situacion financiera a la brevedad.");
            System.out.println("Evite intereses por mora.");
        }
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
