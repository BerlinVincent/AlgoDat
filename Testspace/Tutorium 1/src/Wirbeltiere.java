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