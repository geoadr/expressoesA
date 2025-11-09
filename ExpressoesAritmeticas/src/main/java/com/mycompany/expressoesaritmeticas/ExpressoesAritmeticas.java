package com.mycompany.expressoesaritmeticas;

import java.util.Scanner;

class Nodo {
    char dado;
    Nodo proximo;

    Nodo(char dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class Pilha {
    private Nodo topo;

    public Pilha() {
        topo = null;
    }

    public void push(char dado) {
        Nodo novo = new Nodo(dado);
        novo.proximo = topo;
        topo = novo;
    }

    public char pop() {
        if (estaVazia()) {
            return '\0'; 
        }
        char dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}

public class ExpressoesAritmeticas {

    public static boolean verificaExpressao(String expressao) {
        Pilha pilha = new Pilha();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);


            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            }

     
            else if (c == ')' || c == ']' || c == '}') {
                if (pilha.estaVazia()) {
                    return false; 
                }

                char topo = pilha.pop();

                if ((c == ')' && topo != '(') ||
                    (c == ']' && topo != '[') ||
                    (c == '}' && topo != '{')) {
                    return false; // tipo de símbolo incorreto
                }
            }
        }


        return pilha.estaVazia();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("digitar  aq uma expressão aritmética:");
        String expressao = entrada.nextLine();

        if (verificaExpressao(expressao)) {
            System.out.println("ESTÁ CORRETA!");
        } else {
            System.out.println("ESTÁ INCORRETA!");
        }
    }
}
