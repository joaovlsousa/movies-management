package models;

import interfaces.Filme_IF;

public class Filme implements Filme_IF {
    private long id;
    private String nome;
    private int ano;
    private int nota;

    public Filme() {}

    public Filme(String nome, int ano, int nota) {
        this.id = ID.gerarID();
        this.nome = nome;
        this.ano = ano;
        this.nota = nota;
    }

    public Filme(long id, String nome, int ano, int nota) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.nota = nota;
    }

    @Override
    public long getID() {
        return this.id;
    }

    @Override
    public void setID(long id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getNota() {
        return this.nota;
    }

    @Override
    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public int getAno() {
        return this.ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme_IF outro_filme) {
        return Long.compare(outro_filme.getID(), this.id);
    }

    @Override
    public String toString() {
        // {#id Nome (Ano) [Nota]}
        return "{#" + this.id + " " + this.nome + " (" + this.ano + ") [" + this.nota + "]}";
    }
}
