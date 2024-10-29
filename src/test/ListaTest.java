package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import interfaces.Filme_IF;
import models.Lista;
import utils.FilmeAux;
import utils.Globals;

public class ListaTest {
    private Lista lista;
    private FilmeAux filmeAux = new FilmeAux();

    @Before
    public void init() {
        lista = new Lista();
    }

    @Test
    public void testIsNotEmpty() {
        lista.insert(filmeAux.gerarFilme());
        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test
    public void testInsertAndSearchElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            lista.insert(f);
            assertNotNull(lista.search(f.getID()));
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testSearchElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            lista.insert(f);

            assertNull(lista.search(Globals.QUANT_IDS + 1));
            assertNotNull(lista.search(f.getID()));
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testRemoveElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            lista.insert(f);
            lista.insert(filmeAux.gerarFilme());

            assertNull(lista.remove(Globals.QUANT_IDS + 1));
            assertNotNull(lista.remove(f.getID()));
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testRemoveLastElement() {
        try {
            lista.insert(filmeAux.gerarFilme());
            lista.insert(filmeAux.gerarFilme());

            Filme_IF f = filmeAux.gerarFilme();
            lista.insert(f);

            assertEquals(f, lista.removeLast());
            assertNotEquals(f, lista.removeLast());
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }

    @Test
    public void testThrow() {
        try {
            lista.search(0);
        } catch (Exception e) {
            assertEquals("Lista vazia", e.getMessage());
        }
    }
}
