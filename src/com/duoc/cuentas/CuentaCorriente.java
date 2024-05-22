
package com.duoc.cuentas;

/**
 *
 * @author Jaime Barraza & Sebastian Olave
 */


// se crea la clase con un nombre
public class CuentaCorriente extends CuentaBancaria{

    public CuentaCorriente() {
    }

    public CuentaCorriente(
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
        if(saldo - giro < 0){
            System.out.println("[ERROR] El giro no puede ser superior al saldo...");
        }else if(giro<0){
            System.out.println("[ERROR] Ingrese un monto mayor a 0...");
        } else {
            setSaldo(saldo - giro);
            System.out.println("Giro realizado de manera exitosa!");
            System.out.println("--> [CC][" +getCuenta()+"] Saldo actual de $" +getSaldo());
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


