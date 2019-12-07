import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String INPUT = "2019/1/input/input";

    public static void main(final String[] args) {
        final List<Long> input = InputReader.create(INPUT).read().stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        Solver solver = new Solver();
        System.out.println(String.format("Result part 1: %s", solver.solve1(input)));
        System.out.println(String.format("Result part 2: %s", solver.solve2(input)));
    }
}
