import java.util.List;

public class Solver {

    public List<Integer> solve1(final List<Integer> input) {
        final IntcodeExecutor executor = new IntcodeExecutor(input);

        // Fix alarm code 1202
        executor.put(1, 12);
        executor.put(2, 2);

        return executor.execute();
    }

    public int solve2(final List<Integer> input) {
        for (int noun = 1; noun < 100; noun++) {
            for (int verb = 1; verb < 100; verb++) {
                final IntcodeExecutor executor = new IntcodeExecutor(input);
                executor.put(1, noun);
                executor.put(2, verb);

                if (executor.execute().get(0) == 19690720) {
                    return noun * 100 + verb;
                }
            }
        }

        return -1;
    }
}
