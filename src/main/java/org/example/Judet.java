package org.example;

public class Judet


{


    String ISO;
    String nume;
    String regiune;
    int locuitori;
    int suprafata;

    public Judet(String ISO, String nume, String regiune, int locuitori, int suprafata) {
        this.ISO = ISO;
        this.nume = nume;
        this.regiune = regiune;
        this.locuitori = locuitori;
        this.suprafata = suprafata;
    }


    public String getISO() {
        return ISO;
    }

    public String getNume() {
        return nume;
    }

    public String getRegiune() {
        return regiune;
    }

    public int getLocuitori() {
        return locuitori;
    }

    public int getSuprafata() {
        return suprafata;
    }

    @Override
    public String toString() {
        return "Judet{" +
                "ISO='" + ISO + '\'' +
                ", nume='" + nume + '\'' +
                ", regiune='" + regiune + '\'' +
                ", locuitori=" + locuitori +
                ", suprafata=" + suprafata +
                '}';
    }
}

