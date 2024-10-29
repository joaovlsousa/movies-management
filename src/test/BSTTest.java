package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import interfaces.Filme_IF;
import models.BST;
import utils.FilmeAux;
import utils.Globals;

public class BSTTest {
    private BST tree;
    private FilmeAux filmeAux = new FilmeAux();

    @Before
    public void init() {
        tree = new BST();
    }

    @Test
    public void testIsNotEmpty() {
        tree.insert(filmeAux.gerarFilme());
        assertFalse(tree.isEmpty());
        assertEquals(1, tree.size());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(tree.isEmpty());
        assertEquals(0, tree.size());
    }

    @Test
    public void testInsertAndSearchElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            tree.insert(f);
            assertNotNull(tree.search(f.getID()));
        } catch (Exception e) {
            assertEquals("A arvore está vazia", e.getMessage());
        }
    }

    @Test
    public void testSearchElement() {
        try {
            tree.insert(filmeAux.gerarFilme());
            tree.insert(filmeAux.gerarFilme());

            Filme_IF f = filmeAux.gerarFilme();
            tree.insert(f);

            tree.insert(filmeAux.gerarFilme());
            tree.insert(filmeAux.gerarFilme());

            assertNull(tree.search(Globals.QUANT_IDS + 1));
            assertNotNull(tree.search(f.getID()));
        } catch (Exception e) {
            assertEquals("A arvore está vazia", e.getMessage());
        }
    }

    @Test
    public void testRemoveElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            tree.insert(filmeAux.gerarFilme());
            tree.insert(f);
            tree.insert(filmeAux.gerarFilme());
            tree.insert(filmeAux.gerarFilme());

            assertNull(tree.remove(Globals.QUANT_IDS + 1));
            assertNotNull(tree.remove(f.getID()));
            // assertEquals(1, tree.size());
        } catch (Exception e) {
            assertEquals("A arvore está vazia", e.getMessage());
        }
    }

    @Test
    public void testThrow() {
        try {
            tree.search(0);
        } catch (Exception e) {
            assertEquals("A arvore está vazia", e.getMessage());
        }
    }
}
