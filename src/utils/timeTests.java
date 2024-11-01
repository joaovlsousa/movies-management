package utils;

import interfaces.Filme_IF;
import models.AVL;

public class TimeTests {
    
    public void startTests(int amount, AVL tree) {
        Filme_IF[] filmes = new FilmeAux().gerarFilmes(amount);
        long time;


        
        System.out.println("----- TEMPOS DAS OPERAÇÕES - AVL -----");
        time = System.nanoTime();
        
        for (int i = 0; i < amount; i++) {
            tree.insert(filmes[i]);
        }

        System.out.println();
        System.out.println(amount + " Elementos");

        // time = System.nanoTime();
        System.out.println("Tempo de inserção: " + ((System.nanoTime() - time) / 1000000000.0)/10);


    }
}
