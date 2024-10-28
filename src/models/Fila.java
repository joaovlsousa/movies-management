package models;

import interfaces.Fila_IF;
import interfaces.Filme_IF;

public class Fila implements Fila_IF {
    private Pilha p1;
    private Pilha p2;

    public Fila() {
        this.p1 = new Pilha();
        this.p2 = new Pilha();
    }

    @Override
    public Filme_IF dequeue() throws Exception {
        try {
            return this.p1.pop();
        } catch (Exception e) {
            throw new Exception("Fila vazia");
        }
    }

    @Override
    public void enqueue(Filme_IF element) {
        if (this.p1.isEmpty()) {
            this.p1.push(element);

            return;
        }

        try {
            while (!this.p1.isEmpty()) {
                this.p2.push(this.p1.pop());
            }

            this.p1.push(element);

            while (!this.p2.isEmpty()) {
                this.p1.push(this.p2.pop());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.p1.isEmpty();
    }

    @Override
    public Filme_IF head() throws Exception {
        try {
            return this.p1.top();
        } catch (Exception e) {
            throw new Exception("Fila vazia");
        }
    }

    public String toString() {
        return this.p1.toString();
    }
}
