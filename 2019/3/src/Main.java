import java.util.Collection;

public class Main {
    private static final String INPUT = "2019/3/input/input";
    private static final String DELIMITER = ",";

    public static void main(final String[] args) {
        final Collection<Collection<String>> input = InputReader.create(INPUT).readSeparately(DELIMITER);

        final Solver solver = new Solver(input);
        System.out.println(String.format("Result part 1: %s", solver.solve1()));
        System.out.println(String.format("Result part 2: %s", solver.solve2()));
    }
}
