import java.util.Objects;

public class Pair<E> {
// TODO

    E first;
    E second;

    Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    Pair(Pair<E> other) {
        this.first = other.first;
        this.second = other.second;
    }

    public void swap() {
        E temp  = first;
        first = second;
        second = temp;
    }

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(getFirst(), pair.getFirst()) && Objects.equals(getSecond(), pair.getSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }

    @Override
    public String toString() {
        return "Pair<" + first + ", " + second + ">";
    }

    public static void main(String[] args) {
        Pair<Integer> pair1 = new Pair<>(1, 2);
        Pair<Integer> pair2 = new Pair<>(1, 2);
        System.out.println("Variable pair1 hat den Wert: " + pair1);
        System.out.println("Variable pair2 hat den Wert: " + pair2);
        System.out.println("Syntaktische Gleichheit von pair1 und pair2 ist: " + (pair1==pair2));
        System.out.println("Semantische Gleichheit von pair1 und pair2 ist: " + pair1.equals(pair2));
        Pair<Integer> pair1b = pair1;
        Pair<Integer> pair2b = new Pair<>(pair2);
        pair1.swap();
        pair2.setFirst(10);
        System.out.println("Nach swap() hat Variable pair1 den Wert: " + pair1);
        System.out.println("Nach setFirst(10) hat Variable pair2 den Wert: " + pair2);
        System.out.println("Die zuvor erstellte Kopie pair1b hat den Wert: " + pair1b);
        System.out.println("Die zuvor erstellte Kopie pair2b hat den Wert: " + pair2b);
        /*
        Die erwartete Ausgabe ist:
Variable pair1 hat den Wert: Pair<1, 2>
Variable pair2 hat den Wert: Pair<1, 2>
Syntaktische Gleichheit von pair1 und pair2 ist: false
Semantische Gleichheit von pair1 und pair2 ist: true
Nach swap() hat Variable pair1 den Wert: Pair<2, 1>
Nach setFirst(10) hat Variable pair2 den Wert: Pair<10, 2>
Die zuvor erstellte Kopie pair1b hat den Wert: Pair<2, 1>
Die zuvor erstellte Kopie pair2b hat den Wert: Pair<1, 2>
         */
    }
}

