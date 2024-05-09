import java.util.ArrayList;


enum Soort {
    VOORGERECHT,
    HOOFDGERECHT,
    BIJGERECHT,
    DESSERT
}


class Gerecht {
    private String naam;
    private ArrayList<String> ingredienten;
    private String afbeelding;
    private Soort soort;

    public Gerecht(String naam, ArrayList<String> ingredienten, String afbeelding, Soort soort) {
        this.naam = naam;
        this.ingredienten = ingredienten;
        this.afbeelding = afbeelding;
        this.soort = soort;
    }

    public String getNaam() {
        return naam;
    }

    public String getAfbeelding() {
        return afbeelding;
    }

    public Soort getSoort() {
        return soort;
    }

}


class Gebruiker {
    private String naam;
    private ArrayList<Gerecht> gerechten;

    public Gebruiker(String naam) {
        this.naam = naam;
        this.gerechten = new ArrayList<>();
    }

    public void voegGerechtToe(Gerecht gerecht) {
        gerechten.add(gerecht);
    }




}


class Filter {
    private String naam;

    public Filter(String naam) {
        this.naam = naam;
    }

    public ArrayList<Gerecht> filterGerechten(ArrayList<Gerecht> gerechten, Soort soort) {
        ArrayList<Gerecht> gefilterdeGerechten = new ArrayList<>();
        for (Gerecht gerecht : gerechten) {
            if (gerecht.getSoort() == soort) {
                gefilterdeGerechten.add(gerecht);
            }
        }
        return gefilterdeGerechten;
    }
}


class ZoekFilter {
    private String zoekterm;

    public ZoekFilter(String zoekterm) {
        this.zoekterm = zoekterm;
    }

    public ArrayList<Gerecht> zoekGerechten(ArrayList<Gerecht> gerechten, String zoekterm) {
        ArrayList<Gerecht> gevondenGerechten = new ArrayList<>();
        for (Gerecht gerecht : gerechten) {
            if (gerecht.getNaam().toLowerCase().contains(zoekterm.toLowerCase())) {
                gevondenGerechten.add(gerecht);
            }
        }
        return gevondenGerechten;
    }
}


class Galerij {
    private ArrayList<Gerecht> gerechten;

    public Galerij() {
        this.gerechten = new ArrayList<>();
    }

    public void toonGerechten() {
        if (gerechten.isEmpty()) {
            System.out.println("De galerij is leeg.");
        } else {
            System.out.println("Gerechten in de galerij:");
            for (Gerecht gerecht : gerechten) {
                System.out.println("Naam: " + gerecht.getNaam());
                System.out.println(gerecht.getAfbeelding());
                System.out.println("Soort: " + gerecht.getSoort());
                System.out.println("------------");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Voorbeeld:
        Gebruiker gebruiker = new Gebruiker("Kees");
        Gerecht gerecht = new Gerecht("Pasta Pesto", new ArrayList<>(), "pasta.jpg", Soort.HOOFDGERECHT);
        gebruiker.voegGerechtToe(gerecht);

    }
}
