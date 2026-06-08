package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JudetTest {

    private Judet judet;

    @BeforeEach
    void setUp() {
        judet = new Judet("SB", "Sibiu", "Centru", 400000, 5400);
    }

    @Test
    void getISO() {
        assertEquals("SB", judet.getIso());
    }

    @Test
    void getNume() {
        assertEquals("Sibiu", judet.getNume());
    }

    @Test
    void getRegiune() {
        assertEquals("Centru", judet.getRegiunea());
    }

    @Test
    void getLocuitori() {
        assertEquals(400000, judet.getLocuitori());
    }

    @Test
    void getSuprafata() {
        assertEquals(5400, judet.getSuprafata());
    }

    @Test
    void testToString() {
        String rezultatStr = judet.toString();
        assertTrue(rezultatStr.contains("SB"));
        assertTrue(rezultatStr.contains("Sibiu"));
        assertTrue(rezultatStr.contains("Centru"));
        assertTrue(rezultatStr.contains("400000"));
        assertTrue(rezultatStr.contains("5400"));
    }
}