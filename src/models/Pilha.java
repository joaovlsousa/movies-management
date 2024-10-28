package models;

import interfaces.Filme_IF;
import interfaces.Pilha_IF;

public class Pilha implements Pilha_IF {
    private Lista lista;

    public Pilha() {
        this.lista = new Lista();
    }

    @Override
    public Filme_IF pop() throws Exception {
        try {
            return this.lista.removeLast();
        } catch (Exception e) {
            throw new Exception("Pilha vazia");
        }
    }

    @Override
    public void push(Filme_IF element) {
        this.lista.insert(element);
    }

    @Override
    public boolean isEmpty() {
        return this.lista.isEmpty();
    }

    @Override
    public Filme_IF top() throws Exception {
        try {
            return this.lista.tail();
        } catch (Exception e) {
            throw new Exception("Pilha vazia");
        }
    }

    public String toString() {
        return this.lista.toString();
    }
}
