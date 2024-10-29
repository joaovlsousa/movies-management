package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Fila;
import models.Filme;
import models.Lista;
import models.Pilha;
import models.TabelaHash;
import utils.FilmeAux;

public class OrdenacaoTest {
    private final Filme[] filmes = {
        new Filme(0, "A", 2020, 5),
        new Filme(1, "B", 2021, 4),
        new Filme(2, "C", 2019, 5),
        new Filme(3, "D", 2020, 5),
    };

    @Test
    public void testQueueSortedPrint() {
        Fila fila = new Fila();

        assertEquals("[]", fila.toString());

        for (Filme filme : filmes) {
            fila.enqueue(filme);
        }

        assertEquals(FilmeAux.toString(filmes), fila.toString());        
    }

    @Test
    public void testStackSortedPrint() {
        Pilha pilha = new Pilha();

        assertEquals("[]", pilha.toString());

        for (Filme filme : filmes) {
            pilha.push(filme);
        }

        assertEquals(FilmeAux.toString(filmes), pilha.toString());        
    }

    @Test
    public void testListSortedPrint() {
        Lista lista = new Lista();

        assertEquals("[]", lista.toString());

        for (Filme filme : filmes) {
            lista.insert(filme);
        }

        assertEquals(FilmeAux.toString(filmes), lista.toString());        
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

        result.append(FilmeAux.toString(f1));
        result.append(",\n");
        result.append(FilmeAux.toString(f2));
        result.append("\n");

        assertEquals(result.toString(), tabelaHash.print());        
    }
}
