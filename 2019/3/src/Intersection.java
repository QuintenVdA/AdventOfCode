import java.util.Objects;

public class Intersection {
    private final Coordinate coordinate;
    private final int steps;

    public Intersection(final Coordinate coordinate, final int steps) {
        this.coordinate = coordinate;
        this.steps = steps;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getSteps() {
        return steps;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Intersection that = (Intersection) o;

        return steps == that.steps && Objects.equals(coordinate, that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, steps);
    }
}
