/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gramatica;

/**
 *
 * @author myand
 */
public class Principal {
    public static void main(String[] args) {
       
       
        String oracion="int PrAmiiDE=1;";        
        System.out.println("*************"+oracion+"***************");
        Gramatica gramatica = new Gramatica(oracion);
        gramatica.declaracion();
        
    }
}
