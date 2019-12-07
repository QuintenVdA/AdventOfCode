import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String INPUT = "2019/2/input/input";
    private static final String DELIMITER = ",";

    public static void main(final String[] args) {
        final List<Integer> input = InputReader.create(INPUT).read(DELIMITER).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final Solver solver = new Solver();
        System.out.println(String.format("Result part 1: %s", solver.solve1(input).get(0)));
        System.out.println(String.format("Result part 2: %s", solver.solve2(input)));
    }
}
