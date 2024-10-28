package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import interfaces.Filme_IF;
import models.Fila;
import models.Filme;
import models.Lista;
import models.Pilha;
import models.TabelaHash;

public class OrdenacaoTest {
    private final Filme[] filmes = {
        new Filme(0, "A", 2020, 5),
        new Filme(1, "B", 2021, 4),
        new Filme(2, "C", 2019, 5),
        new Filme(3, "D", 2020, 5),
    };

    private String toString(Filme[] filmes) {
        StringBuilder result = new StringBuilder("[\n");

        for (Filme_IF filme : filmes) {
            result.append(" ");
            result.append(filme.toString());
            result.append(",\n");
        }

        result.append("]");

        return result.toString();
    }

    @Test
    public void testQueueSortedPrint() {
        Fila fila = new Fila();

        assertEquals("[]", fila.toString());

        for (Filme filme : filmes) {
            fila.enqueue(filme);
        }

        assertEquals(this.toString(filmes), fila.toString());        
    }

    @Test
    public void testStackSortedPrint() {
        Pilha pilha = new Pilha();

        assertEquals("[]", pilha.toString());

        for (Filme filme : filmes) {
            pilha.push(filme);
        }

        assertEquals(this.toString(filmes), pilha.toString());        
    }

    @Test
    public void testListSortedPrint() {
        Lista lista = new Lista();

        assertEquals("[]", lista.toString());

        for (Filme filme : filmes) {
            lista.insert(filme);
        }

        assertEquals(this.toString(filmes), lista.toString());        
    }

    @Test
    public void testHashTableSortedPrint() {
        TabelaHash tabelaHash = new TabelaHash(filmes.length);

        assertEquals("[]", tabelaHash.print());

        for (Filme filme : filmes) {
            tabelaHash.insert(filme);
        }

        Filme[] f1 = {filmes[0], filmes[2]}, f2 = {filmes[1], filmes[3]};

        StringBuilder result = new StringBuilder();

        result.append(this.toString(f1));
        result.append(",\n");
        result.append(this.toString(f2));
        result.append("\n");

        assertEquals(result.toString(), tabelaHash.print());        
    }
}
