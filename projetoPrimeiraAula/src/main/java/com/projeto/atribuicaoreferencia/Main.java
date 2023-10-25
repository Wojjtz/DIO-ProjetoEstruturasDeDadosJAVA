package com.projeto.atribuicaoreferencia;

public class Main {
    public static void main(String[] args) {

        int A = 1;
        int B = A;

        System.out.println("Inteiro A: " + A
            + "\nInteiro B: " + B);
        A = 2;
        System.out.println("Inteiro A: " + A
                + "\nInteiro B: " + B);


        MeuObj a = new MeuObj(5);
        MeuObj b = a;

        System.out.println("Objeto A: " + a + "\nObjeto B: " + b);
        b.setNum(2);
        System.out.println("Objeto A: " + a + " \nObjeto B: " + b);
    }
}
