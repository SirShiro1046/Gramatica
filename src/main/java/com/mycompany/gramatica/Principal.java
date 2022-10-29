/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gramatica;

import java.util.Scanner;

/**
 *
 * @author myand
 */
public class Principal {
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);

        
        String oracion; 
        System.out.println("Ingresar Oracion xdddxddd");
        oracion= s.nextLine();
        

        System.out.println("*************"+oracion+"***************");
        Gramatica gramatica = new Gramatica(oracion);
        gramatica.declaracion();
        
        
    }
}
