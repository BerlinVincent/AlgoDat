import java.util.Arrays;

public class ConvexPolygon extends Polygon {
    // TODO

    @Override
    public double perimeter() {
        double perimeter = 0;
        for (int i = 0; i < vertices.length; i++) {
            perimeter += vertices[i % vertices.length].length() - vertices[i % vertices.length + 1].length();
        }
        return perimeter;
    }

    @Override
    public double area() {
        return 0;
    }

    public static double totalArea(Polygon[] polygons) {
        double area = 0;
        for (Polygon p : polygons) {
            area += p.area();
        }
        return area;
    }

    public static Polygon[] somePolygons() {
        Vector2D[] vertices = new Vector2D[6];
        vertices[0] = new Vector2D(0, 0);
        vertices[1] = new Vector2D(10, 0);
        vertices[2] = new Vector2D(5, 5);
        vertices[3] = new Vector2D(10, -5);
        vertices[4] = new Vector2D(12, 2);
        vertices[5] = new Vector2D(3, 17);

        return new Polygon[] {
                new Triangle(vertices[0], vertices[1], vertices[2]),
                new ConvexPolygon(new Vector2D[] {vertices[0], vertices[3], vertices[4], vertices[5]}),
                new RegularPolygon(5, 1), new RegularPolygon(6, 1)
        };
    }

    @Override
    public String toString() {
        return "ConvexPolygon[" + Arrays.toString(vertices) + "]";
    }

    ConvexPolygon(Vector2D[] corners) {
        this.vertices = corners;
    }
}


