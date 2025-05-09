abstract class Wirbeltiere {
    double alter;
    int anzahlWirbel;
    String name;
    int kalorien;

    public int essen() {
        System.out.println(kalorien);
        this.kalorien++;
        System.out.println(kalorien);
        return 0;
    }
}

abstract class Saeugetiere extends Wirbeltiere {
    Saeugetiere(String name) {
        this.name = name;
    }
}
abstract class Reptilien extends Wirbeltiere {}

class Okapi extends Saeugetiere {
    public Okapi(String name) {
        super(name);
    }
}

class Kegelrobbe extends Saeugetiere {
    String geraeusch;
    int Umfang;

    @Override
    public int essen() {
        System.out.println(Umfang);
        this.Umfang++;
        System.out.println(Umfang);
        return super.essen();
    }

    public Kegelrobbe(String name, int umfang, String geraeusch) {
        super(name);
        this.Umfang = umfang;
        this.geraeusch = geraeusch;
    }
}

public class Main {
    public static void main(String[] args) {
        Kegelrobbe Thorsten = new Kegelrobbe("Thorsten", 50, "Oempfh");
        Okapi Thorsten2 = new Okapi("Thorsten");

        Saeugetiere[] array = new Saeugetiere[10];
        array[0] = Thorsten;
        array[1] = Thorsten2;

        Thorsten.essen();
        Thorsten2.essen();
    }
}