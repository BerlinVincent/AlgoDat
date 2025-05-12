public class Tut1 {
    public static void main(String[] args) {
        Kegelrobbe Thorsten = new Kegelrobbe("Thorsten", 50, "Oempfh");
        Okapi Thorsten2 = new Okapi("Thorsten");

        Saeugetiere[] array = new Saeugetiere[10];
        array[0] = Thorsten;
        array[1] = Thorsten2;

        array[0].essen();
        array[1].essen();
    }
}