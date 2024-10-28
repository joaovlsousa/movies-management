package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import interfaces.Filme_IF;
import models.Filme;

public class FilmeTest {
    @Test
    public void testCompareTo() {
        Filme_IF f1 = new Filme(0, "A", 2020, 5);
        Filme_IF f2 = new Filme(1, "B", 2021, 4);
        Filme_IF f3 = new Filme(2, "C", 2019, 5);
        Filme_IF f4 = new Filme(3, "D", 2020, 5);

        assertTrue(f1.compareTo(f2) > 0);
        assertTrue(f2.compareTo(f1) < 0);

        assertTrue(f1.compareTo(f3) > 0);
        assertTrue(f3.compareTo(f1) < 0);
        assertTrue(f1.compareTo(f4) > 0);
        assertTrue(f4.compareTo(f1) < 0);
    }

    @Test
    public void testToString() {
        Filme_IF f = new Filme(0, "Inception", 2010, 5);
        assertEquals("{#0 Inception (2010) [5]}", f.toString());
    }

    @Test
    public void testSettersAndGetters() {
        Filme_IF f = new Filme("Original", 3, 2018);
        f.setNome("Novo Nome");
        f.setNota(4);
        f.setAno(2020);
        f.setID(0);

        assertEquals("Novo Nome", f.getNome());
        assertEquals(4, f.getNota());
        assertEquals(2020, f.getAno());
        assertEquals(0, f.getID());
    }
}