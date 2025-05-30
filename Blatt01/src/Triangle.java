import java.util.Arrays;

public class Triangle extends ConvexPolygon {

    public Triangle(Vector2D a, Vector2D b, Vector2D c) {
        // TODO
        super(new Vector2D[]{a, b, c});
    }

    public Triangle(Triangle triangle) {
        // TODO
        super(triangle.vertices);
    }

    @Override
    public double area() {
        // TODO
        Vector2D a = new Vector2D(vertices[1].getX() - vertices[0].getX(),vertices[1].getY() - vertices[0].getY());
        Vector2D b = new Vector2D(vertices[2].getX() - vertices[1].getX(),vertices[2].getY() - vertices[1].getY());
        Vector2D c = new Vector2D(vertices[0].getX() - vertices[2].getX(),vertices[0].getY() - vertices[2].getY());
        double s1 = a.length();
        double s2 = b.length();
        double s3 = c.length();
        double s = (s1 + s2 + s3)/2;
        return Math.sqrt(s * (s-s1) * (s-s2) * (s-s3));
    }

    @Override
    public String toString() {
        // TODO
        return "Triangle{" + Arrays.toString(vertices) + "}";
    }

    public static void main(String[] args) {
        Vector2D a = new Vector2D(0, 0);
        Vector2D b = new Vector2D(10, 0);
        Vector2D c = new Vector2D(5, 5);
        Triangle triangle = new Triangle(a, b, c);
        double area = triangle.area();
        System.out.printf("Die Fläche des Dreiecks 'triangle' {%s, %s, %s} beträgt %.1f LE^2.\n", a, b, c, area);

        Triangle triangle2 = new Triangle(triangle);
        System.out.println("triangle2 ist eine Kopie per Copy-Konstruktor von 'triangle': " + triangle2);
        a.setX(-5);
        System.out.println("Eckpunkt 'a', der zur Definition von 'triangle' verwendet wurde, wird geändert.");
        System.out.println("Nun ist der Wert von 'triangle2': " + triangle2);
        /*
         * HINWEIS: Machen Sie sich keine Sorgen um etwaige Abweichungen in den letzten
         * Nachkommastellen bei der Berechnung des Flächeninhalts.
         * Diese werden in den automatisierten Tests herausgerechnet.
         * Die erwartete Ausgabe ist:
         * Die Fläche des Dreiecks 'triangle' {(0.0, 0.0), (10.0, 0.0), (5.0, 5.0)}
         * beträgt 25,0 LE^2.
         * triangle2 ist eine Kopie per Copy-Konstruktor von 'triangle': Triangle{[(0.0,
         * 0.0), (10.0, 0.0), (5.0, 5.0)]}
         * Eckpunkt 'a', der zur Definition von 'triangle' verwendet wurde, wird
         * geändert.
         * Nun ist der Wert von 'triangle2': Triangle{[(-5.0, 0.0), (10.0, 0.0), (5.0,
         * 5.0)]}
         */
    }
}

