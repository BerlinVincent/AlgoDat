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