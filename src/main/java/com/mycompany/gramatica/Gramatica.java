package com.mycompany.gramatica;

import java.util.ArrayList;

/**
 * @author myand
 */
public class Gramatica {
    private boolean siguiente= true;
    private final String s = "              ";
    private String guardar = "";
    private final String gramatica;
    private final ArrayList<Character> lista = new ArrayList<>();
    private int contador;

    public Gramatica(String gramatica) {
        this.contador = 0;
        this.gramatica = gramatica;
    }

    public void declaracion() {
        for (int i = 0; i < gramatica.length(); i++) {
            lista.add(gramatica.charAt(i));
        }

        System.out.println("<declaracion> -> <tipo>;");
        tipo(gramatica);
    }

    private void tipo(String gramatica) {

        String tipo[] = gramatica.split(" ");

        if (tipo[0].equals("int")) {
            contador = 4;

            entero(tipo[0]);
        }
        if (tipo[0].equals("float")) {
            contador = 6;

            flotante(tipo[0]);
        }
        if (tipo[0].equals("char")) {
            contador = 5;

            caracter(tipo[0]);
        }
        if (tipo[0].equals("double")) {
            contador = 7;

            doble(tipo[0]);
        }
    }

    private void entero(String tipo) {
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<entero>;");
        System.out.println(s + "-> " + "int" + "<id><valorI><lista_id>;");

        do {
            while (verificarId(lista.get(contador)) == true && siguiente==true) {
                id();
                System.out.println("<valorI><lista_id>;");
                contador++;
            }

            if (lista.get(contador) == ' '&& siguiente==true) {    // por si hay un espacio que lo ignore para continuar a la siguiente posicion
                guardar = guardar + lista.get(contador);
                contador++;
            }
            if (lista.get(contador) == '='&& siguiente==true) {
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }

            while (verificarValorI(lista.get(contador)) == true && siguiente==true ) {
                
                valorI();
                System.out.println("<lista_id>;");
                contador++;
            }
            if(verificarId(lista.get(contador))||lista.get(contador)=='.'){
                    siguiente =false;
                }
            if (lista.get(contador) == ','&& siguiente==true) {
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
        } while (lista.get(contador) != ';'&&siguiente==true);
        if (siguiente==true) {
               System.out.println(s + "-> " + guardar + "<lista_id>;");
        System.out.print(s + "-> " + guardar + ";");
        }
     
    }

    private void flotante(String tipo) {
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<entero>");
        System.out.println(s + "-> " + "float" + "<id><valorF><lista_id>");
        do {
            while (verificarId(lista.get(contador)) == true) {
                id();
                System.out.println("<valorF><lista_id>;");
                contador++;
            }

            if (lista.get(contador) == ' ') {    // por si hay un espacio que lo ignore para continiuar a la siguiente posicion
                guardar = guardar + lista.get(contador);
                contador++;
            }

            if (lista.get(contador) == '=') {
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }

            while (verificarValorI(lista.get(contador)) == true) {

                valorF();
                System.out.println("<lista_id>;");
                contador++;
            }

            if (lista.get(contador) == ',') {
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
        } while (lista.get(contador) != ';');
        System.out.println(s + "-> " + guardar + "<lista_id>;");
        System.out.print(s + "-> " + guardar + ";");

    }

    private void doble(String tipo) {
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<entero>");
        System.out.println(s + "-> " + "double" + "<id><valorD><lista_id>");

        do {
            while (verificarId(lista.get(contador)) == true) {
                id();
                System.out.println("<valorD><lista_id>;");
                contador++;
            }
            if (lista.get(contador) == ' ') {    // por si hay un espacio que lo ignore para continiuar a la siguiente posicion
                guardar = guardar + lista.get(contador);
                contador++;
            }
            if (lista.get(contador) == '=') {
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }

            while (verificarValorI(lista.get(contador)) == true) {

                valorD();
                System.out.println("<lista_id>;");
                contador++;
            }
            if (lista.get(contador) == ',') {
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
        } while (lista.get(contador) != ';');
        System.out.println(s + "-> " + guardar + "<lista_id>;");
        System.out.print(s + "-> " + guardar + ";");
    }

    private void caracter(String tipo) {
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<entero>");
        System.out.println(s + "-> " + "char" + "<id><valorC><lista_id>");

        do {
            while (verificarId(lista.get(contador)) == true) {
                id();
                System.out.println("<valorC><lista_id>;");
                contador++;
            }
            if (lista.get(contador) == ' ') {    // por si hay un espacio que lo ignore para continiuar a la siguiente posicion
                guardar = guardar + lista.get(contador);
                contador++;
            }
            if (lista.get(contador) == '=') {
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }

            while (verificarValorI(lista.get(contador)) == true) {

                valorC();
                System.out.println("<lista_id>;");
                contador++;
            }
            if (lista.get(contador) == ',') {
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
        } while (lista.get(contador) != ';');
        System.out.println(s + "-> " + guardar + "<lista_id>;");
        System.out.print(s + "-> " + guardar + ";");

    }

    private void lista_id() {

        System.out.print(s + "-> " + guardar);
        guardar = guardar + lista.get(contador);
//        id();
//        lista_id();
    }

    private void id() {
        letra();
        if (lista.get(contador + 1) == '=') {
        } else {
            System.out.print("<letra>");
            resto_id();
        }
    }

    private void resto_id() {
        System.out.print("<resto_id>");
    }

    private void comilla() {

    }

    private void igual() {

        System.out.print(s + "-> " + guardar);
        System.out.print("<igual>");
        guardar = guardar + lista.get(contador);
    }

    private void letra() {
        guardar = guardar + lista.get(contador);
        System.out.print(s + "-> " + guardar);

    }

    private void digito() {

        System.out.print(s + "-> " + guardar);
        guardar = guardar + lista.get(contador);

    }

    private void digitoD() {
        System.out.print(s + "-> " + guardar);
        guardar = guardar + lista.get(contador);
//        digito();
//        digitoD();
    }

    private void valorI() {

        digito();
        System.out.print("<digito>");
    }

    private void valorF() {
        digito();
        System.out.print("<digito>");
//        igual();
//        digitoD();

    }

    private void valorD() {
        digitoD();
        System.out.print("<digito>");
//        igual();
//        digitoD();
//        
    }

    private void valorC() {
     
//        igual();
//        comilla();
//        letra();
//        comilla();
    }

    private boolean verificarId(char caracter) { // Hecho por laura uwu 
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";

        for (int i = 0; i < abc.length(); i++) {
            if (abc.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarValorI(char caracter) { // Hecho por laura uwu 
        String num = "0123456789";

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }
}
/*Recordatorio para programar mañana
    en donde se lee el id poner una variable que guarde todo
lo que vaya aceptando el metodo de verificar id
despues todo eso guardarlo en una lista si si awebo 
seguido de esto al momento de salir reiniciar o borrar lo que esta en la 
variable string para la siguiente pasada
pero id anterior ya estara guardado en la lista

y ahora comprobar si en la lista hay valores similares
si los valores son similares entonces hacer que siguiente 
sea falso para asi detener todo el proceso

*/
