import java.util.*;

public class Solver {
    private static final Coordinate START_POSITION = new Coordinate(0, 0);
    private final Collection<Intersection> intersections;

    public Solver(final Collection<Collection<String>> input) {
        intersections = calculateIntersections(input);
    }

    private Collection<Intersection> calculateIntersections(final Collection<Collection<String>> input) {
        final Map<Coordinate, Map<Integer, Integer>> grid = new HashMap<>();
        final List<Intersection> intersections = new ArrayList<>();

        int wire = 1;
        for (final Collection<String> wirepaths : input) {
            Coordinate position = START_POSITION;
            int steps = 0;

            for (final String wirepath : wirepaths) {
                final String direction = wirepath.substring(0, 1);
                final int amount = Integer.parseInt(wirepath.substring(1));

                for (int i = 0; i < amount; i++) {
                    position = position.add(direction);
                    steps++;

                    if (!grid.containsKey(position)) {
                        grid.put(position, new HashMap<>());
                    }

                    // Add each wire only once to a position: at the moment it requires the least steps.
                    if (!grid.get(position).containsKey(wire)) {
                        grid.get(position).put(wire, steps);
                    }

                    // An intersection occurs when one position has more than one wire.
                    if (grid.get(position).size() > 1) {
                        final int requiredSteps = grid.get(position).values().stream()
                                .reduce(Integer::sum)
                                .orElse(-1);

                        intersections.add(new Intersection(position, requiredSteps));
                    }
                }
            }

            wire++;
        }

        return intersections;
    }

    public int solve1() {
        int result = Integer.MAX_VALUE;

        for (final Intersection intersection : intersections) {
            final int distance = intersection.getCoordinate().getManhattanDistance(START_POSITION);

            if (distance < result) {
                result = distance;
            }
        }

        return result;
    }

    public int solve2() {
        return intersections.stream()
                .map(Intersection::getSteps)
                .min(Integer::compareTo)
                .orElse(-1);
    }
}
