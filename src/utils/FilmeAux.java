package utils;

import java.util.Random;

import interfaces.Filme_IF;
import models.Filme;

public class FilmeAux {
    private static final char[] consoantes = {
        'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 
        'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
    };

    private static final char[] vogais = {'a', 'e', 'i', 'o', 'u'};

    private Random random = new Random();

    public Filme_IF gerarFilme() {
        String nome = this.gerarNome();
        int ano = this.gerarAno();
        int nota = this.gerarNota();

        return new Filme(nome, ano, nota);
    }

    private int gerarNota() {
        return this.random.nextInt(6);
    }

    private int gerarAno() {
        return 1990 + this.random.nextInt(2025 - 1990);
    }

    private String gerarNome() {
        String nome = "";

        nome += this.getConsoante();
        nome += this.getVogal();
        nome += this.getConsoante();
        nome += this.getVogal();

        return nome;
    }

    private char getConsoante() {
        int indexRandom = this.random.nextInt(consoantes.length);

        return consoantes[indexRandom];
    }

    private char getVogal() {
        int indexRandom = this.random.nextInt(vogais.length);

        return vogais[indexRandom];
    }

    public static void reverseArray(Filme_IF[] filmes) {
        Filme_IF temp = null;

        for (int i = 0, j = filmes.length - 1; i <= j; i++, j--) {
            temp = filmes[i];
            filmes[i] = filmes[j];
            filmes[j] = temp;
        }
    }

    public static void mergeSort(Filme_IF[] filmes) {
        mergeSortAux(filmes, 0, filmes.length - 1);
    }

    private static void mergeSortAux(Filme_IF[] filmes, int ini, int fim) {
        if (ini < fim) {
            int meio = ini + ((fim - ini) / 2);

            mergeSortAux(filmes, ini, meio);
            mergeSortAux(filmes, meio + 1, fim);
            merge(filmes, ini, meio, fim);

        }
    }

    private static void merge(Filme_IF[] filmes, int ini, int meio, int fim) {
        int tamEsq = meio - ini + 1;
        int tamDir = fim - meio;

        Filme_IF[] vetEsq = new Filme[tamEsq];
        Filme_IF[] vetDir = new Filme[tamDir];

        for (int i = 0; i < tamEsq; i++) {
            vetEsq[i] = filmes[ini + i];
        }
        
        for (int j = 0; j < tamDir; j++) {
            vetDir[j] = filmes[meio + 1 + j];
        }

        int e = 0, d = 0, k = ini;

        while (e < tamEsq && d < tamDir) {
            if (vetEsq[e].compareTo(vetDir[d]) > 0) {
                filmes[k] = vetEsq[e];
                e++;
            } else {
                filmes[k] = vetDir[d];
                d++;
            }

            k++;
        }

        while (e < tamEsq) {
            filmes[k] = vetEsq[e];
            e++;
            k++;
        }

        while (d < tamDir) {
            filmes[k] = vetDir[d];
            d++;
            k++;
        }
    }
}
