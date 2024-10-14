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
        return this.lista.removeLast();
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
        return this.lista.tail();
    }
}
