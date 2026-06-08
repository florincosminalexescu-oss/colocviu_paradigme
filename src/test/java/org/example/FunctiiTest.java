package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FunctiiTest {

    private Functii functie;
    private List<Judet> listaTest;
    private final String fisierTestCsv = "judete_test.csv";
    private final String fisierTestTxt = "output_test.txt";

    @BeforeEach
    void setUp() {
        functie = new Functii();
        listaTest = new ArrayList<>();
        listaTest.add(new Judet("SB", "Sibiu", "Centru", 400000, 5400));
        listaTest.add(new Judet("BV", "Brasov", "Centru", 550000, 5300));
        listaTest.add(new Judet("B", "Bucuresti", "Sud", 2000000, 228));
    }

    @Test
    void citesteJudete() {
        try (FileWriter writer = new FileWriter(fisierTestCsv)) {
            writer.write("SB,Sibiu,Centru,400000,5400\n");
            writer.write("BV,Brasov,Centru,550000,5300\n");
        } catch (IOException e) {
            fail("Nu s-a putut crea fisierul temporar de test");
        }

        List<Judet> rezultat = functie.citesteJudete(fisierTestCsv);

        assertEquals(2, rezultat.size());
        assertEquals("SB", rezultat.get(0).getIso());
        assertEquals("Brasov", rezultat.get(1).getNume());

        new File(fisierTestCsv).delete();
    }

    @Test
    void proceseazaOutput() {
        functie.proceseazaOutput(listaTest, true, fisierTestTxt);

        File fisierGenerat = new File(fisierTestTxt);
        assertTrue(fisierGenerat.exists());

        try {
            List<String> linii = Files.readAllLines(Paths.get(fisierTestTxt));

            assertTrue(linii.size() >= 4);
            assertTrue(linii.get(1).contains("Bucuresti"));
            assertTrue(linii.get(2).contains("Brasov"));
            assertTrue(linii.get(3).contains("Sibiu"));
        } catch (IOException e) {
            fail("Nu s-a putut citi fisierul de output generat");
        }

        fisierGenerat.delete();
    }
}