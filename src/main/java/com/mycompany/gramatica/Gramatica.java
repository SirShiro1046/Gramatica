package com.mycompany.gramatica;

import java.util.ArrayList;

/**
 * @author myand
 */
public class Gramatica {
    private boolean veriableigual=false;
    private String nombre="";
    private int contComilla;
    private boolean entroNumero = false;
    private boolean entroIgual = false;
    private boolean listaid = true;
    private boolean siguiente = true;
    private final String s = "              ";
    private String guardar = "";
    private final String gramatica;
    private final ArrayList<String> listaVariables = new ArrayList<>();
    private final ArrayList<Character> lista = new ArrayList<>();
    private int contador;

    public Gramatica(String gramatica) {
        this.contComilla = 0;

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
        System.out.println(s + "-> " + "int" + "<letra><valorI><lista_id>;");
        do {
            reducirEspacio();
            
            while (Letrass(lista.get(contador)) == true && siguiente == true && listaid == true) {
                nombre= nombre+lista.get(contador);
                id();
                System.out.println("<valorI><lista_id>;");

                contador++;

            }
            
            listaVariables.add(nombre);
            nombre="";
            siguiente=ComprobarIgualdad();
            listaid = false;
            //convierte en while
            reducirEspacio();

            if (lista.get(contador) == '=' && siguiente == true) {
                entroIgual = true;
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }
            reducirEspacio();

            while (verificarValorI(lista.get(contador)) == true && siguiente == true) {
                entroNumero = true;
                valorI();
                System.out.println("<lista_id>;");
                contador++;
                // error: si dejo espacio entre el numero y la coma me marcara error
                if (lista.get(contador) == ' ' || lista.get(contador) == '.') {
                    siguiente = false;
                    valorI();
                    System.out.println("<lista_id>;");
                }
            }
            reducirEspacio();
            if (entroIgual == false && entroNumero == true || entroIgual == true && entroNumero == false) {
                siguiente = false;
            }

            if (lista.get(contador) == ',' && siguiente == true) {
                entroIgual = false;
                entroNumero = false;
                listaid = true;
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
         
        } while (lista.get(contador) != ';' && siguiente == true && listaid == true);

        if (siguiente == true && lista.get(contador) == ';') {
            System.out.println(s + "-> " + guardar + "<lista_id>;");
            System.out.print(s + "-> " + guardar + ";");
        }
    }

    private void flotante(String tipo) {
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<flotante>;");
        System.out.println(s + "-> " + "float" + "<id><valorF><lista_id>;");

        do {
            reducirEspacio();
            while (Letrass(lista.get(contador)) == true && siguiente == true && listaid == true) {
                nombre= nombre+lista.get(contador);
                id();
                System.out.println("<valorF><lista_id>;");

                contador++;
            }
            listaVariables.add(nombre);
            nombre="";
            siguiente=ComprobarIgualdad();
            listaid = false;
            reducirEspacio();

            if (lista.get(contador) == '=' && siguiente == true) {
                entroIgual = true;
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }
            reducirEspacio();

            while (verificarValorF(lista.get(contador)) == true && siguiente == true) {
                entroNumero = true;
                valorF();
                System.out.println("<lista_id>;");
                contador++;

                // error: si dejo espacio entre el numero y la coma me marcara error
                if (lista.get(contador) == ' ') {
                    siguiente = false;
                    valorI();
                    System.out.println("<lista_id>;");
                }
            }
            reducirEspacio();
            if (entroIgual == false && entroNumero == true || entroIgual == true && entroNumero == false) {
                siguiente = false;
            }
            if (lista.get(contador) == ',' && siguiente == true) {
                entroIgual = false;
                entroNumero = false;
                listaid = true;
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
        } while (lista.get(contador) != ';' && siguiente == true && listaid == true);
        if (siguiente == true && lista.get(contador) == ';') {
            System.out.println(s + "-> " + guardar + "<lista_id>;");
            System.out.print(s + "-> " + guardar + ";");
        }
    }

    private void doble(String tipo) {
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<double>;");
        System.out.println(s + "-> " + "double" + "<id><valorF><lista_id>;");

        do {
            reducirEspacio();
            while (Letrass(lista.get(contador)) == true && siguiente == true && listaid == true) {
                nombre= nombre+lista.get(contador);
                id();
                System.out.println("<valorD><lista_id>;");

                contador++;
            }
            listaVariables.add(nombre);
            nombre="";
            siguiente=ComprobarIgualdad();
            listaid = false;
            reducirEspacio();

            if (lista.get(contador) == '=' && siguiente == true) {
                entroIgual = true;
                igual();
                System.out.println("<digito><lista_id>;");
                contador++;
            }
            reducirEspacio();

            while (verificarValorD(lista.get(contador)) == true && siguiente == true) {
                entroNumero = true;
                valorF();
                System.out.println("<lista_id>;");
                contador++;

                // error: si dejo espacio entre el numero y la coma me marcara error
                if (lista.get(contador) == ' ') {
                    siguiente = false;
                    valorI();
                    System.out.println("<lista_id>;");
                }
            }
            reducirEspacio();
            if (entroIgual == false && entroNumero == true || entroIgual == true && entroNumero == false) {
                siguiente = false;
            }
            if (lista.get(contador) == ',' && siguiente == true) {
                entroIgual = false;
                entroNumero = false;
                listaid = true;
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
            }
        } while (lista.get(contador) != ';' && siguiente == true && listaid == true);
        if (siguiente == true && lista.get(contador) == ';') {
            System.out.println(s + "-> " + guardar + "<lista_id>;");
            System.out.print(s + "-> " + guardar + ";");
        }
    }

    private void caracter(String tipo) {
        int contarChar = 0;
        guardar = guardar + tipo + " ";
        System.out.println(s + "-> " + "<entero>;");
        System.out.println(s + "-> " + "int" + "<id><valorC><lista_id>;");

        do {
            reducirEspacio();

            while (Letrass(lista.get(contador)) == true && siguiente == true && listaid == true) {
                nombre= nombre+lista.get(contador);
                id();
                System.out.println("<valorC><lista_id>;");

                contador++;

            }
            listaVariables.add(nombre);
            nombre="";
            siguiente=ComprobarIgualdad();
            listaid = false;
            //convierte en while
            reducirEspacio();

            if (lista.get(contador) == '=' && siguiente == true) {
                entroIgual = true;
                igual();
                System.out.println("<comilla><letra><comilla><lista_id>;");
                contador++;
            }
            reducirEspacio();
            if (lista.get(contador) == 39) {
                comilla();
                System.out.println("'<letra><comilla><lista_id>;");
                contador++;
                contComilla++;
            }
            while (Letrass(lista.get(contador)) == true && siguiente == true && contarChar == 0) {
                entroNumero = true;
                valorC();
                System.out.println("<comillxa><lista_id>;");
                contador++;

                // error: si dejo espacio entre el numero y la coma me marcara error
                if (lista.get(contador) == ' ' || lista.get(contador) == '.') {
                    siguiente = false;
                    valorI();
                    System.out.println("<lista_id>;");
                }
                contarChar++;
            }
            if (lista.get(contador) == 39) {
                comilla();
                System.out.println("'<lista_ids>;");
                contador++;

            }
            reducirEspacio();
            if (entroIgual == false && entroNumero == true || entroIgual == true && entroNumero == false) {
                siguiente = false;
            }
            if (lista.get(contador) == ',' && siguiente == true) {
                entroIgual = false;
                entroNumero = false;
                listaid = true;
                lista_id();
                System.out.println(",<id><lista_id>;");
                contador++;
                contarChar = 0;

            }
        } while (lista.get(contador) != ';' && siguiente == true && listaid == true);
        if (siguiente == true && lista.get(contador) == ';') {

            System.out.print(s + "-> " + guardar + ";");
        }
    }

    private void lista_id() {
        System.out.print(s + "-> " + guardar);
        guardar = guardar + lista.get(contador);
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
        System.out.print(s + "-> " + guardar);
        guardar = guardar + lista.get(contador);
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
    }

    private void valorI() {
        digito();
        System.out.print("<digito>");
    }

    private void valorF() {
        digito();
        System.out.print("<digito>");
    }

    private void valorD() {
        digitoD();
        System.out.print("<digito>");
    }

    private void valorC() {
        letra();
    }

    private boolean Letrass(char caracter) { // Hecho por laura uwu 
        String abc = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
        for (int i = 0; i < abc.length(); i++) {
            if (abc.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarValorI(char caracter) { // Hecho por laura uwu 
        String num = "-0123456789";
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarValorF(char caracter) { // Hecho por laura uwu 
        String num = "-0123456789.";
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarValorD(char caracter) { // Hecho por laura uwu 
        String num = "-0123456789.eE";
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == caracter) {
                return true;
            }
        }
        return false;
    }

    private void reducirEspacio() {
        while (lista.get(contador) == ' ' && siguiente == true) {    // por si hay un espacio que lo ignore para continuar a la siguiente posicion
            guardar = guardar + lista.get(contador);
            contador++;
        }
    }
    
    public boolean ComprobarIgualdad(){   
        int n=1;

        for (int i = 0; i <listaVariables.size(); i++) {
            for (int j = n; j < listaVariables.size(); j++) {
                if(listaVariables.get(i).equals(listaVariables.get(j))){
                    System.out.println(s+"-> "+"Syntax Error Variable");
                    return false;
                }
            }
            n++; 
        } 
        return true;
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
