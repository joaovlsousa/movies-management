package models;

import interfaces.Filme_IF;
import interfaces.Lista_IF;
import utils.FilmeAux;

public class Lista implements Lista_IF {
    private NoLista head;
    private NoLista tail;
    private int size;

    public Lista() {
        this.size = 0;
        this.head = new NoLista();
        this.tail = this.head;
    }

    @Override
    public void insert(Filme_IF elemento) {
        NoLista aux = new NoLista(elemento, new NoLista(), this.tail);
        
        if (this.tail.isNIL()) {
            this.head = aux;
        }

        this.tail.setProx(aux);
        this.tail = aux;
        this.size++;
    }

    @Override
    public Filme_IF search(long id) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista vazia");
        }

        NoLista auxHead = this.head, auxTail = this.tail;

        while (!auxHead.equals(auxTail) && !auxHead.getProx().equals(auxTail)) {
            if (auxHead.getFilme().getID() == id) {
                return auxHead.getFilme();
            }
    
            if (auxTail.getFilme().getID() == id) {
                return auxTail.getFilme();
            }

            auxHead = auxHead.getProx();
            auxTail = auxTail.getAnt();
        }

        if (auxHead.getFilme().getID() == id) {
            return auxHead.getFilme();
        }

        if (auxTail.getFilme().getID() == id) {
            return auxTail.getFilme();
        }

        return null;
    }

    @Override
    public Filme_IF remove(long id) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista vazia");
        }

        Filme_IF aux = null;
        
        if (this.size == 1 && this.head.getFilme().getID() == id) {
            aux = this.head.getFilme();
            
            this.head = new NoLista();
            this.tail = this.head;
            this.size = 0;

            return aux;
        }

        NoLista auxHead = this.head, auxTail = this.tail;

        while (!auxHead.equals(auxTail) && !auxHead.getProx().equals(auxTail)) {
            if (auxHead.getFilme().getID() == id) {
                aux = auxHead.getFilme();
    
                if (this.head.equals(auxHead)) {
                    this.head = auxHead.getProx();
                } else {
                    auxHead.getAnt().setProx(auxHead.getProx());
                }
                
                auxHead.getProx().setAnt(auxHead.getAnt());
    
                this.size--;

                return aux;
            }
    
            if (auxTail.getFilme().getID() == id) {
                aux = auxTail.getFilme();
    
                if (this.tail.equals(auxTail)) {
                    this.tail = auxTail.getAnt();
                } else {
                    auxTail.getProx().setAnt(auxTail.getAnt());
                }

                auxTail.getAnt().setProx(auxTail.getProx());

                this.size--;

                return aux;
            }

            auxHead = auxHead.getProx();
            auxTail = auxTail.getAnt();
        }

        if (auxHead.getFilme().getID() == id) {
            aux = auxHead.getFilme();

            if (this.head.equals(auxHead)) {
                this.head = auxHead.getProx();
            } else {
                auxHead.getAnt().setProx(auxHead.getProx());
            }
            
            auxHead.getProx().setAnt(auxHead.getAnt());

            this.size--;

            return aux;
        }

        if (auxTail.getFilme().getID() == id) {
            aux = auxTail.getFilme();

            if (this.tail.equals(auxTail)) {
                this.tail = auxTail.getAnt();
            } else {
                auxTail.getProx().setAnt(auxTail.getAnt());
            }

            auxTail.getAnt().setProx(auxTail.getProx());

            this.size--;

            return aux;
        }

        return aux;
    }

    public Filme_IF removeLast() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Lista vazia");
        }

        Filme_IF aux = null;
        
        if (this.head.equals(this.tail)) {
            aux = this.head.getFilme();
            
            this.head = new NoLista();
            this.tail = this.head;
            this.size--;

            return aux;
        }

        aux = this.tail();
        this.tail.getAnt().setProx(this.tail.getProx());
        this.tail = this.tail.getAnt();
        this.size--;

        return aux;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Filme_IF head() throws Exception {
        if (this.head.isNIL()) {
            throw new Exception("A lista está vazia");
        }

        return this.head.getFilme();
    }

    @Override
    public Filme_IF tail() throws Exception {
        if (this.tail.isNIL()) {
            throw new Exception("A lista está vazia");
        }

        return this.tail.getFilme();
    }

    @Override
    public int size() {
        return this.size;
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[\n");

        Filme_IF[] filmes = this.sort();

        for (Filme_IF filme : filmes) {
            result.append(" ");
            result.append(filme.toString());
            result.append(",\n");
        }

        result.append("]");

        return result.toString();
    }

    public Filme_IF[] toArray() {
        if (this.isEmpty()) {
            return new Filme[0];
        }

        Filme_IF[] filmes = new Filme[this.size];
        NoLista auxHead = this.head, auxTail = this.tail;
        int i = 0, j = this.size - 1;

        while (!auxHead.equals(auxTail) && !auxHead.getProx().equals(auxTail)) {
            filmes[i] = auxHead.getFilme();
            filmes[j] = auxTail.getFilme();

            i++;
            j--;
            auxHead = auxHead.getProx();
            auxTail = auxTail.getAnt();
        }

        if (i == j) {
            filmes[i] = auxHead.getFilme();
        } else {
            filmes[i] = auxHead.getFilme();
            filmes[j] = auxTail.getFilme();
        }

        return filmes;
    }

    private Filme_IF[] sort() {
        Filme_IF[] filmes = this.toArray();
        FilmeAux.mergeSort(filmes);

        return filmes;
    }
}
