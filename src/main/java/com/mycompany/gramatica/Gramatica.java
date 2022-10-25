package com.mycompany.gramatica;
import java.util.ArrayList;

/**
 * @author myand
 */
public class Gramatica {
    String s="              ";
    String guardar="";
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
 
        System.out.println("<declaracion> -> <tipo>;");
        tipo(gramatica);    
    } 
    public void tipo(String gramatica){
        
        String tipo []=gramatica.split(" ");
      
        if(tipo[0].equals("int")){
            contador=4;
            
            entero(tipo[0]);
        }
        if (tipo[0].equals("float")) {
            contador=6;
            
            flotante(tipo[0]);
        }
        if (tipo[0].equals("char")) {
            contador=5;
            
            caracter(tipo[0]);
        }
        if (tipo[0].equals("double")) {
            contador=7;
            
            doble(tipo[0]);
        }   
    }
    public void entero(String tipo){
        guardar=guardar+tipo+" ";
        System.out.println(s+"-> "+"<entero>;");
        System.out.println(s+"-> "+"int"+ " <id> <valorI> <lista_id>;");
        
        while (verificarId(lista.get(contador))==true) {
            id();
            System.out.println("<valorI> <lista_id>;");
            contador++;
        }
        if(lista.get(contador)=='='){
            igual();
            System.out.println("<digito> <lista_id>;");
            contador++;
        }
        
        while (verificarValorI(lista.get(contador))==true) {            
            
            valorI();
            contador++;
        }
      
        lista_id();
    }
    public void flotante(String tipo){
        guardar=guardar+tipo+" ";
        System.out.println(s+"-> "+"<entero>");
        System.out.println(s+"-> "+"float"+ " <id> <valorF> <lista_id>");
        
        while (verificarId(lista.get(contador))==true) {
            id();
            System.out.println("<valorD> <lista_id>");
            contador++;
        }
    }
    public void doble(String tipo){
        guardar=guardar+tipo+" ";
        System.out.println(s+"-> "+"<entero>");
        System.out.println(s+"-> "+"double"+ " <id> <valorD> <lista_id>");
        
        while (verificarId(lista.get(contador))==true) {
            id();
            System.out.println("<valorD> <lista_id>");
            contador++;
        }
    }
    public void caracter(String tipo){
        guardar=guardar+tipo+" ";
        System.out.println(s+"-> "+"<entero>");
        System.out.println(s+"-> "+"char"+ " <id> <valorC> <lista_id>");
        
        while (verificarId(lista.get(contador))==true) {
            id();
            System.out.println("<valorC> <lista_id>");
            contador++;
        }
        
    }
    public void lista_id(){
//        id();
//        lista_id();
    }
    public void id(){
        letra(); 
        if(lista.get(contador+1)=='='){ 
        }else{
            System.out.print("<letra><resto_id>"); 
        }
    }
    public void resto_id(){
//        letra();
//        resto_id();
//        digito();
        
        
    }
    public void comilla(){
        
    }
    public void igual(){
        
        System.out.print(s+"-> "+guardar);
        System.out.print("<igual>");
        guardar=guardar+lista.get(contador);
    }
    public void letra(){
        guardar=guardar+lista.get(contador);
        System.out.print(s+"-> "+guardar);
        
    }
    public void digito(){
//        digito();
    }
    public void digitoD(){
//        digito();
//        digitoD();
    }
    public void valorI(){
        guardar=guardar+lista.get(contador);
        System.out.print(s+"-> "+guardar);
//        igual();
//        digito();
    }
    public void valorF(){
//        igual();
//        digitoD();
        
    }
    public void valorD(){
//        igual();
//        digitoD();
//        
    }
    public void valorC(){
//        igual();
//        comilla();
//        letra();
//        comilla();
    }
    public boolean verificarId(char caracter){ // Hecho por laura uwu 
        String abc ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < abc.length(); i++) {
            if (abc.charAt(i)==caracter) {
                return true;
            }
        }
        return false;
    }
    public boolean verificarValorI(char caracter){ // Hecho por laura uwu 
        String num ="0123456789";
        
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i)==caracter) {
                return true;
            }
        }
        return false;
    }
}
//int x