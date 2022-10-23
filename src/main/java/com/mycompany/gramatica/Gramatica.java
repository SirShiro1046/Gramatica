/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gramatica;

import java.util.ArrayList;

/**
 *
 * @author myand
 */
public class Gramatica {
    String s="              ";
    String gramatica;
    ArrayList<Character> lista = new ArrayList<>();
    private int contador;
    public Gramatica(String gramatica) {
        this.contador = 0;
        this.gramatica = gramatica;
    }
    
    public void declaracion(){
        for (int i = 0; i < gramatica.length(); i++) {
            lista.add(gramatica.charAt(i));
        }
 
        System.out.println("<declaracion> -> <tipo>");
        tipo(gramatica);    
    }
    
    public void tipo(String gramatica){
        
        String tipo []=gramatica.split(" ");
       
        if(tipo[0].equals("int")){
            contador=2;
            
            entero(tipo[0]);
        }
        if (tipo[0].equals("float")) {
            contador=4;
            
            flotante(tipo[0]);
        }
        if (tipo[0].equals("char")) {
            contador=3;
            
            caracter(tipo[0]);
        }
        if (tipo[0].equals("double")) {
            contador=5;
            
            doble(tipo[0]);
        }   
    }
    public void entero(String tipo){
        System.out.println(s+"-> "+"<entero>");
        System.out.println(s+"-> "+"int"+ " <id> <valorI> <lista_id>");
        id();
        valorI();
        lista_id();
        //"<valorI> <lista_id>");
    }
    public void flotante(String tipo){
        System.out.println(s+"-> "+"<flotante>");
        System.out.println(s+"-> "+"float"+ " <id> <valorF> <lista_id>");
        id();
        valorF();
        lista_id();
    }
    public void doble(String tipo){
        System.out.println(s+"-> "+"<doble>");
        System.out.println(s+"-> "+"double"+ " <id> <valorD> <lista_id>");
        id();
        valorD();
        lista_id();
    }
    public void caracter(String tipo){
        System.out.println(s+"-> "+"<caracter>");
        System.out.println(s+"-> "+"char"+" <id> <valorC> <lista_id>");
        id();
        valorD();
        lista_id();
    }
    public void lista_id(){
        id();
        lista_id();
    }
    public void id(){
        letra();
        resto_id();
        
    }
    public void resto_id(){
        letra();
        resto_id();
        digito();
        
        
    }
    public void comilla(){
        
    }
    public void igual(){
        
    }
    public void letra(){
        
    }
    public void digito(){
        digito();
    }
    public void digitoD(){
        digito();
        digitoD();
    }
    public void valorI(){
        igual();
        digito();
    }
    public void valorF(){
        igual();
        digitoD();
        
    }
    public void valorD(){
        igual();
        digitoD();
        
    }
    public void valorC(){
        igual();
        comilla();
        letra();
        comilla();
    }  
}
