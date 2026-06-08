package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Functii {



    public List<Judet> citesteJudete(String path) {
        List<Judet> judete = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] bucati = linie.split(",");

                String iso = bucati[0].trim();
                String nume = bucati[1].trim();
                String regiunea = bucati[2].trim();
                int locuitori = Integer.parseInt(bucati[3].trim());
                int suprafata = Integer.parseInt(bucati[4].trim());

                judete.add(new Judet(iso, nume, regiunea, locuitori, suprafata));
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Eroare la formatarea numerelor: " + e.getMessage());
        }

        return judete;
    }


    public void proceseazaOutput(List<Judet> judete, boolean inFisier, String path) {
        if (inFisier) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                bw.write("Judete citite din fisier");
                bw.newLine();
                for (Judet judet : judete) {
                    bw.write(judet.toString());
                    bw.newLine();
                }
                System.out.println("Succes! Datele au fost salvate in: " + path);
            } catch (IOException e) {
                System.out.println("Eroare la scrierea in fisier: " + e.getMessage());
            }
        } else {
            System.out.println("Utilizatorul a ales sa afiseze pe ecran");
            judete.forEach(judet -> System.out.println(judet));
        }
    }



}




