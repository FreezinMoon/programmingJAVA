package example.objects;
/**
 * The Coordinates class represents a pair of coordinates.
 */
public class Coordinates {
    private final double x;
    private final Float y;

    /**
     * Constructor for the Coordinates class.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     */
    public Coordinates(double x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor for the Coordinates class.
     *
     * @param x The x-coordinate as a string.
     * @param y The y-coordinate as a string.
     */
    public Coordinates(String x, String y) {
        this(Double.parseDouble(x), Float.parseFloat(y));
    }

    /**
     * Returns a string representation of the coordinates.
     *
     * @return A string representation of the coordinates.
     */
    @Override
    public String toString() {
        return "Coordinates{" + "x=" + x + ", y=" + y + '}';
    }

    /**
     * Returns the x-coordinate.
     *
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return The y-coordinate.
     */
    public Float getY() {
        return y;
    }
}