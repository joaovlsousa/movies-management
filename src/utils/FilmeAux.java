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
}
