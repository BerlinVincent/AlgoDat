// Diese Klasse implementiert nur *zentrierte* reguläre Polygone, also mit midpoint = (0, 0).

public class RegularPolygon extends ConvexPolygon {

    // TODO
    double radius;

    public RegularPolygon(int N, double radius) {
        // TODO
        super(new Vector2D[N]);
        this.radius = radius;
        double n = (double) 360 / N;
        for(int i = 0; i < N; i++) {
            this.vertices[i] = new Vector2D(Math.sin(Math.toDegrees(n * i)), Math.cos(Math.toDegrees(n * i)));
        }
    }

    public RegularPolygon(RegularPolygon polygon) {
        // TODO
        super(polygon.vertices);
        this.radius = polygon.radius;
    }

    public void resize(double newradius) {
        // TODO
        for(Vector2D v : vertices) {
            v.setX(v.getX() / radius * newradius);
            v.setY(v.getY() / radius * newradius);
        }
        this.radius = newradius;
    }

    public static void main(String[] args) {
        RegularPolygon pentagon = new RegularPolygon(5, 1);
        System.out.println("Der Flächeninhalt des " + pentagon + " beträgt " + pentagon.area() + " LE^2.");
//        RegularPolygon otherpentagon = pentagon;      // Dies funktioniert nicht!
        RegularPolygon otherpentagon = new RegularPolygon(pentagon);
        pentagon.resize(10);
        System.out.println("Nach Vergrößerung: " + pentagon + " mit Fläche " + pentagon.area() + " LE^2.");
        System.out.println("Die Kopie: " + otherpentagon + " mit Fläche " + otherpentagon.area() + " LE^2.");
        /*
        Die erwartete Ausgabe ist:
Der Flächeninhalt des RegularPolygon{N=5, radius=1.0} beträgt 2.377641290737883 LE^2.
Nach Vergrößerung: RegularPolygon{N=5, radius=10.0} mit Fläche 237.7641290737884 LE^2.
Die Kopie: RegularPolygon{N=5, radius=1.0} mit Fläche 2.377641290737883 LE^2.
         */
    }
}

