package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import interfaces.Filme_IF;
import models.TabelaHash;
import utils.FilmeAux;
import utils.Globals;

public class TabelaHashTest {
    private TabelaHash tabelaHash;
    private FilmeAux filmeAux = new FilmeAux();

    @Before
    public void init() {
        tabelaHash = new TabelaHash(Globals.QUANT_FILMES);
    }

    @Test
    public void testIsNotEmpty() {
        tabelaHash.insert(filmeAux.gerarFilme());
        assertFalse(tabelaHash.isEmpty());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(tabelaHash.isEmpty());
    }

    @Test
    public void testInsertAndSearchElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            tabelaHash.insert(f);
            assertNotNull(tabelaHash.search(f.getID()));
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testSearchElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            tabelaHash.insert(f);

            assertNull(tabelaHash.search(Globals.QUANT_IDS + 1));
            assertNotNull(tabelaHash.search(f.getID()));
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testRemoveElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            tabelaHash.insert(f);
            tabelaHash.insert(filmeAux.gerarFilme());

            assertNull(tabelaHash.remove(Globals.QUANT_IDS + 1));
            assertNotNull(tabelaHash.remove(f.getID()));
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testThrow() {
        try {
            tabelaHash.search(0);
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }
}
