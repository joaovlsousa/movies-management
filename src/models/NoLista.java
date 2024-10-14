package models;

import interfaces.Filme_IF;

public class NoLista {
    private Filme_IF filme;
    private NoLista prox;
    private NoLista ant;

    public NoLista(Filme_IF filme, NoLista prox, NoLista ant) {
        this.filme = filme;
        this.prox = prox;
        this.ant = ant;
    }

    public NoLista() {
        this.filme = null;
        this.prox = null;
        this.ant = null;
    }

    public boolean isNIL() {
        return this.filme == null && this.prox == null && this.ant == null;
    }

    public void setAnt(NoLista ant) {
        this.ant = ant;
    }

    public NoLista getAnt() {
        return this.ant;
    }

    public void setFilme(Filme_IF filme) {
        this.filme = filme;
    }
    
    public Filme_IF getFilme() {
        return this.filme;
    }

    public void setProx(NoLista prox) {
        this.prox = prox;
    }

    public NoLista getProx() {
        return this.prox;
    }
}
