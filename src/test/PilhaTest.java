package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import interfaces.Filme_IF;
import models.Pilha;
import utils.FilmeAux;

public class PilhaTest {
    private Pilha pilha;
    private FilmeAux filmeAux = new FilmeAux();

    @Before
    public void init() {
        pilha = new Pilha();
    }

    @Test
    public void testIsNotEmpty() {
        pilha.push(filmeAux.gerarFilme());
        assertFalse(pilha.isEmpty());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(pilha.isEmpty());
    }

    @Test
    public void testPushAndTopElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            pilha.push(f);
            assertNotNull(pilha.top());
        } catch (Exception e) {
            assertEquals("Pilha vazia", e.getMessage());
        }
    }

    @Test
    public void testTopElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            pilha.push(f);

            assertNotNull(pilha.top());
            assertEquals(f, pilha.top());
        } catch (Exception e) {
            assertEquals("Pilha vazia", e.getMessage());
        }
    }

    @Test
    public void testPopElement() {
        try {
            pilha.push(filmeAux.gerarFilme());
            Filme_IF f = filmeAux.gerarFilme();
            pilha.push(f);

            assertEquals(f, pilha.top());
            assertNotNull(pilha.pop());
        } catch (Exception e) {
            assertEquals("Pilha vazia", e.getMessage());
        }
    }

    @Test
    public void testThrow() {
        try {
            pilha.top();
        } catch (Exception e) {
            assertEquals("Pilha vazia", e.getMessage());
        }
    }
}
