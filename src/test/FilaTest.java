package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import interfaces.Filme_IF;
import models.Fila;
import utils.FilmeAux;

public class FilaTest {
    private Fila fila;
    private FilmeAux filmeAux = new FilmeAux();

    @Before
    public void init() {
        fila = new Fila();
    }

    @Test
    public void testIsNotEmpty() {
        fila.enqueue(filmeAux.gerarFilme());
        assertFalse(fila.isEmpty());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(fila.isEmpty());
    }

    @Test
    public void testEnqueueAndHeadElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            fila.enqueue(f);
            assertNotNull(fila.head());
        } catch (Exception e) {
            assertEquals("Fila vazia", e.getMessage());
        }
    }

    @Test
    public void testHeadElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            fila.enqueue(f);

            assertNotNull(fila.head());
            assertEquals(f, fila.head());
        } catch (Exception e) {
            assertEquals("Fila vazia", e.getMessage());
        }
    }

    @Test
    public void testThrow() {
        try {
            fila.head();
        } catch (Exception e) {
            assertEquals("Fila vazia", e.getMessage());
        }
    }

    @Test
    public void testDequeueElement() {
        try {
            Filme_IF f = filmeAux.gerarFilme();
            fila.enqueue(f);
            fila.enqueue(filmeAux.gerarFilme());

            assertEquals(f, fila.head());
            assertNotNull(fila.dequeue());
        } catch (Exception e) {
            assertEquals("Fila vazia", e.getMessage());
        }
    }
}
