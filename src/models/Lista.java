package models;

import interfaces.Filme_IF;
import interfaces.Lista_IF;

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

        NoLista auxHead = this.head, auxTail = this.tail;
        Filme_IF aux = null;

        while (!auxHead.equals(auxTail) && !auxHead.getProx().equals(auxTail)) {
            if (auxHead.getFilme().getID() == id) {
                aux = auxHead.getFilme();
    
                if (this.head.equals(auxHead)) {
                    this.head = auxHead.getProx();
                }

                auxHead.getProx().setAnt(auxHead.getAnt());
    
                this.size--;

                return aux;
            }
    
            if (auxTail.getFilme().getID() == id) {
                aux = auxTail.getFilme();
    
                if (this.tail.equals(auxTail)) {
                    this.tail = auxTail.getAnt();
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

            auxHead.getProx().setAnt(auxHead.getAnt());

            this.size--;

            return aux;
        }

        if (auxTail.getFilme().getID() == id) {
            aux = auxTail.getFilme();

            auxTail.getAnt().setProx(auxTail.getProx());

            this.size--;

            return aux;
        }

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
}
