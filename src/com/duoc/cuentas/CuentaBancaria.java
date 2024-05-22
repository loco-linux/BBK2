/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duoc.cuentas;

/**
 *
 * @author jbarr
 */
public abstract class CuentaBancaria extends Cuentas implements Cuenta {
        // 1° se crean los atributos asociados por tipo de dato
    // para encapsular los datos, se utiliza la palabra PRIVATE
    
    private String nombre, apellidoP, apellidoM, rut, domicilio, comuna;
    protected int telefono, cuenta, saldo;
    
    
    
    /* 2° se debe crear los constructores. Para poder crear los objetos
    de la clase main().
    Deben ser 2: uno SIN atributos y otro CON atributos 
    */
    
    // sin atributos
    public CuentaBancaria(){
        this.rut = "No definido";
        this.nombre = "No definido";
        this.apellidoP = "No definido";
        this.apellidoM = "No definido";
        this.domicilio = "No definido";
        this.comuna = "No definido";
        this.telefono = 0;
        this.cuenta = 0;
        this.saldo = SALDO_INICIO;
        
    }
    
    // con atributos
    public CuentaBancaria(
            String rut, 
            String nombre, 
            String apellidoP, 
            String apellidoM,
            String domicilio,
            String comuna,
            int telefono,
            int cuenta,
            int saldo
            ){
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = cuenta;
        this.saldo = saldo;
    }


    // 3° se deben crear los accesadores (GET) y mutadores (SET) para cada atributo
    public String getRut(){
        return rut;
    }
    
    public void setRut(String rut){
        this.rut = rut;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellidoP(){
        return apellidoP;
    }
    
    public void setApellidoP(String apellidoP){
        this.apellidoP = apellidoP;
    }
      
    public String getApellidoM(){
        return apellidoM;
    }
    
    public void setApellidoM(String apellidoM){
        this.apellidoM = apellidoM;
    }
    
      
    public String getDomicilio(){
        return domicilio;
    }
    
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
    
     
    public String getComuna(){
        return comuna;
    }
    
    public void setComuna(String comuna){
        this.comuna = comuna;
    }
    
    public int getTelefono(){
        return telefono;
    }
    
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    
    public int getCuenta(){
        return cuenta;
    }
    
    public void setCuenta(int cuenta){
        this.cuenta = cuenta;
    }
    

    public int getSaldo(){
        return saldo;
    }
    
    public void setSaldo(int saldo){
        this.saldo = saldo;
    }

    // 4° se deben crear los metodos necesarios segun el caso
    @Override
    public void girar(int giro){
    }
    
    @Override
    public void depositar(int deposito){        
    }
    
    @Override
    public void consultar(){
    }
    
    @Override
    public void consultaDatos(){
    }
    
}
