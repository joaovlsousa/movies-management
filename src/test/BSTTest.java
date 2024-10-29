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
import models.Filme;
import utils.FilmeAux;
import utils.Globals;

public class BSTTest {
    private BST tree;
    private FilmeAux filmeAux = new FilmeAux();

    private final Filme[] filmes = {
        new Filme(2, "C", 2019, 5),
        new Filme(0, "A", 2020, 5),
        new Filme(3, "D", 2020, 5),
        new Filme(1, "B", 2021, 4),
    };

    private final Filme[] filmesOrdenados = {
        new Filme(0, "A", 2020, 5),
        new Filme(1, "B", 2021, 4),
        new Filme(2, "C", 2019, 5),
        new Filme(3, "D", 2020, 5),
    };

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
            tree.insert(f);

            assertNull(tree.remove(Globals.QUANT_IDS + 1));
            assertNotNull(tree.remove(f.getID()));
            assertEquals(0, tree.size());

            tree.insert(filmeAux.gerarFilme());
            tree.insert(f);
            tree.insert(filmeAux.gerarFilme());
            tree.insert(filmeAux.gerarFilme());

            assertNotNull(tree.remove(f.getID()));
            assertEquals(3, tree.size());
        } catch (Exception e) {
            assertEquals("A arvore está vazia", e.getMessage());
        }
    }

    @Test
    public void testInOrder() {
        for (Filme filme : filmes) {
            tree.insert(filme);
        }

        assertEquals(FilmeAux.toString(filmesOrdenados), tree.toString());
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
