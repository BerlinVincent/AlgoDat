/**
 * Created by Jannes on 09.04.20.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Drucker extends Elektrogeraete{
    String Netzwerkname;
    Queue<Druckauftrag> Druckauftraege;
    int Tinte;

    public int getTinte(){
        return Tinte;
    }

    public Drucker (String Netzwerkname) {
        // todo
        this.Netzwerkname = Netzwerkname;
        fill();
        pruefen();
        this.Druckauftraege = new LinkedList<>();
    }

    public void DruckauftragEinreihen(Druckauftrag d) {
        this.Druckauftraege.add(d);
    }

    public void fill() {
        // todo
        this.Tinte = 100;
    }

    private void warten(int Sekunden) {
        try {
            for (int i = 0; i < 20; i++){
                Thread.sleep(Sekunden * 50);
                System.out.print(".");
            }
            System.out.println();

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void getInfo(){
        System.out.println("Aktuelle infromationen zum Drucker: " + this.Netzwerkname);
        System.out.println("Füllstand:                       " + this.Tinte + "%");
        System.out.println("Anstehende Aufträge:             " + this.Druckauftraege.size() + "\n");
        System.out.println("Tage bis zum nächsten Prüfdatum: " + this.TageBisPruefdatum+ "\n");

    }

    public void drucken() {
        // todo
        if (Druckauftraege.isEmpty()) {
            System.out.println("Keine Druckauftraege gefunden.");
            this.TageBisPruefdatum--;
            return;
        }
        
        while (!Druckauftraege.isEmpty()) {
            if (getTinte() == 0) {
                System.out.println("Nicht genug Tinte vorhanden.");
                System.out.println("Tinte wird nachgefuellt...");
                warten(10);
                fill();
                System.out.println("Drucken wird fortgesetzt.");
            }
            if (TageBisPruefdatum == 0) {
                System.out.println("Pruefdatum erreicht! Geraet pruefen!");
                System.out.println("Geraet wird geprueft...");
                warten(20);
                pruefen();
                System.out.println("Geraet geprueft. Drucken wird fortgesetzt.");
            }
            if (Druckauftraege.peek().getSeitenzahl() > getTinte()) {
                System.out.println("Nicht genug Tinte vorhanden.");
                System.out.println("Tinte wird nachgefuellt...");
                warten(10);
                fill();
                System.out.println("Tinte nachgefuellt. Drucken wird fortgesetzt.");
            }

            this.Tinte -= Druckauftraege.peek().getSeitenzahl();
            this.TageBisPruefdatum--;
            warten(Druckauftraege.poll().getSeitenzahl());
        }
    }
}
