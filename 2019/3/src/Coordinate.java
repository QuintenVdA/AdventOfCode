import java.util.Objects;

public class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getManhattanDistance(final Coordinate other) {
        return Math.abs(getX() - other.getX()) + Math.abs(getY() - other.getY());
    }

    public Coordinate add(final String direction) {
        switch (direction) {
            case "U":
                return new Coordinate(x, y + 1);
            case "D":
                return new Coordinate(x, y - 1);
            case "L":
                return new Coordinate(x - 1, y);
            case "R":
                return new Coordinate(x + 1, y);
        }

        return null;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Coordinate that = (Coordinate) o;

        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
