public abstract class Elektrogeraete {
    int Kaufpreis;
    int TageBisPruefdatum;

    int getPruefDatum() {
        return TageBisPruefdatum;
    }

    public void pruefen(){
        TageBisPruefdatum = 365;
    }
}