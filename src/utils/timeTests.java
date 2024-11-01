package utils;

import interfaces.Filme_IF;
import models.AVL;

public class TimeTests {
    
    public void startTests(int amount) throws Exception {
        Filme_IF[] filmes = new FilmeAux().gerarFilmes(amount);
        long time;
        AVL tree = new AVL();

        System.out.println("----- TEMPOS DAS OPERAÇÕES - AVL -----");
        
        System.out.println();
        System.out.println();
        System.out.println(amount + " Elementos");
        System.out.println();
        
        time = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < amount; j++) {
                tree.insert(filmes[j]);
            }
            tree = new AVL();
        }
        System.out.println();
        System.out.println("Tempo de inserção: " + calculateTime(time)/10);
        System.out.println();
        
        for (int i = 0; i < amount; i++) {
            tree.insert(filmes[i]);
        }
        

        time = System.nanoTime();
        System.out.println();
        System.out.println(tree.searchNode(1));
        System.out.println();
        System.out.println("Tempo de BUSCA elemento INEXISTENTE: " + calculateTime(time));
        System.out.println();
        
        
        time = System.nanoTime();
        System.out.println();
        System.out.println(tree.searchNode(filmes[amount/2].getID()));
        System.out.println();
        System.out.println("Tempo de BUSCA elemento EXISTENTE: " + calculateTime(time));
        System.out.println();
        
        time = System.nanoTime();
        System.out.println();
        System.out.println(tree.remove(1));
        System.out.println();
        System.out.println("Tempo de REMOCAO elemento INEXISTENTE: " + calculateTime(time));
        System.out.println();
        
        
        time = System.nanoTime();
        System.out.println();
        System.out.println(tree.remove(filmes[amount/2].getID()));
        System.out.println();
        System.out.println("Tempo de busca elemento EXISTENTE: " + calculateTime(time));
        System.out.println();

        
        
        
    }
    
    
    private long calculateTime(long time) {
        return (long) (((System.nanoTime() - time) / 1000000000.0) / 10);
    }
}

// time = System.nanoTime();
// System.out.println("Tempo de inserção: " + ((System.nanoTime() - time) / 1000000000.0)/10);