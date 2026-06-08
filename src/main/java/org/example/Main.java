package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Functii functie = new Functii();
        List<Judet> listaJudete = functie.citesteJudete("judete.csv");

        if (listaJudete.isEmpty()) {
            System.out.println("ATENTIE: Lista este goala.");
        } else {
            boolean trimiteInFisier = false;
            functie.proceseazaOutput(listaJudete, trimiteInFisier, "output.txt");
        }
    }
}