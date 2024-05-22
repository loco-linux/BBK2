/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.duoc.cuentas;

/**
 *
 * @author jbarr
 */
public interface Cuenta {
    
    // Declaracion de metodos abstractos
    void girar(int giro);
    void depositar(int deposito);
    void consultar();
    void consultaDatos();
 
    
    //Declaracion de propiedades constantes
    public static final int SALDO_INICIO = 0;
    

}

