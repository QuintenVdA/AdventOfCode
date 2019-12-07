import java.util.Collection;

public class Solver {

    public long solve1(final Collection<Long> input) {
        return input.stream()
                .map(this::calculateFuel)
                .reduce(Long::sum)
                .orElse(0L);
    }

    public long solve2(final Collection<Long> input) {
        return input.stream()
                .map(this::calculateFuelRecursive)
                .reduce(Long::sum)
                .orElse(0L);
    }

    public long calculateFuel(final long mass) {
        return Math.round(Math.floor(mass / 3d)) - 2;
    }

    public long calculateFuelRecursive(final long mass) {
        final long fuel = calculateFuel(mass);

        if (fuel <= 0) {
            return 0L;
        }

        return fuel + calculateFuelRecursive(fuel);
    }
}
