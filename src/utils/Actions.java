package utils;

import java.util.Scanner;

import interfaces.Func;
import models.AVL;
import models.BST;
import models.Fila;
import models.ID;
import models.Lista;
import models.Pilha;
import models.TabelaHash;

public class Actions {
    public static void listaActions(Lista lista, int op) {
        switch (op) {
            case 1:
                Func print = () -> {
                    System.out.println(lista.toString());
                };

                calculateTime(print);
                break;
        
            case 2:
                Func search = () -> {
                    try {
                        System.out.println(lista.search(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(search);
                break;

            case 3:
                Func remove = () -> {
                    try {
                        System.out.println(lista.remove(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(remove);
                break;
        }
    }

    public static void pilhaActions(Pilha pilha, int op) {
        switch (op) {
            case 1:
                Func print = () -> {
                    System.out.println(pilha.toString());
                };

                calculateTime(print);
                break;
        
            case 2:
                Func search = () -> {
                    try {
                        System.out.println(pilha.top());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(search);
                break;

            case 3:
                Func remove = () -> {
                    try {
                        System.out.println(pilha.pop());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(remove);
                break;
        }
    }

    public static void filaActions(Fila fila, int op) {
        switch (op) {
            case 1:
                Func print = () -> {
                    System.out.println(fila.toString());
                };

                calculateTime(print);
                break;
        
            case 2:
                Func search = () -> {
                    try {
                        System.out.println(fila.head());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(search);
                break;

            case 3:
                Func remove = () -> {
                    try {
                        System.out.println(fila.dequeue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(remove);
                break;
        }
    }

    public static void tabelaHashActions(TabelaHash tabelaHash, int op) {
        switch (op) {
            case 1:
                Func print = () -> {
                    System.out.println(tabelaHash.print());
                };

                calculateTime(print);
                break;

            case 2:
                Func search = () -> {
                    try {
                        System.out.println(tabelaHash.search(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(search);
                break;

            case 3:
                Func remove = () -> {
                    try {
                        System.out.println(tabelaHash.remove(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(remove);
                break;
        }
    }

    public static void bstActions(BST bst, int op) {
        switch (op) {
            case 1:
                Func print = () -> {
                    System.out.println(bst.toString());
                };

                calculateTime(print);
                break;
        
            case 2:
                Func search = () -> {
                    try {
                        System.out.println(bst.search(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(search);
                break;

            case 3:
                Func remove = () -> {
                    try {
                        System.out.println(bst.remove(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(remove);
                break;
        }
    }

    public static void avlActions(AVL avl, int op) {
        switch (op) {
            case 1:
                Func print = () -> {
                    System.out.println(avl.toString());
                };

                calculateTime(print);
                break;
        
            case 2:
                Func search = () -> {
                    try {
                        System.out.println(avl.search(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(search);
                break;

            case 3:
                Func remove = () -> {
                    try {
                        System.out.println(avl.remove(getFilmeID()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                };

                calculateTime(remove);
                break;
        }
    }

    private static int getFilmeID() {
        System.out.print("Você quer buscar/remover um filme válido? (s/n) ");

        @SuppressWarnings("resource")
        char op = new Scanner(System.in).nextLine().toLowerCase().charAt(0);

        int filmeID = op == 's' 
            ? ID.getRandomGeneratedID()
            : Globals.QUANT_IDS + 1;

        return filmeID;
    }

    private static void calculateTime(Func func) {
        long tempoInicial = System.nanoTime();

        func.execute();

        double tempoFinal = (System.nanoTime() - tempoInicial) / 1_000_000_000.0;

        System.out.println("Tempo de execução: " + tempoFinal);
    }
}
