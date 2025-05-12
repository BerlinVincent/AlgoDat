import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Druckauftrag {
    private String Auftraggeber;
    private int Seitenzahl;

    public int getSeitenzahl() {
        return Seitenzahl;
    }

    public void report() {
        System.out.println(Auftraggeber + " " + Seitenzahl);
    }

    Druckauftrag(String auftraggeber, int seitenzahl) {
        this.Auftraggeber = auftraggeber;
        this.Seitenzahl = seitenzahl;
    }

    public static void main(String[] args) {
        Stack<Druckauftrag> dStack = new Stack<Druckauftrag>();
        Queue<Druckauftrag> dQueue = new LinkedList<Druckauftrag>();
    }
}