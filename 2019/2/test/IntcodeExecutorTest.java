import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class IntcodeExecutorTest {

    @Test
    public void testExecute() {
        final List<Integer> input1 = Arrays.asList(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50);
        final List<Integer> expected1 = Arrays.asList(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50);
        Assert.assertEquals(expected1, new IntcodeExecutor(input1).execute());

        final List<Integer> input2 = Arrays.asList(1, 0, 0, 0, 99);
        final List<Integer> expected2 = Arrays.asList(2, 0, 0, 0, 99);
        Assert.assertEquals(expected2, new IntcodeExecutor(input2).execute());

        final List<Integer> input3 = Arrays.asList(2, 3, 0, 3, 99);
        final List<Integer> expected3 = Arrays.asList(2, 3, 0, 6, 99);
        Assert.assertEquals(expected3, new IntcodeExecutor(input3).execute());

        final List<Integer> input4 = Arrays.asList(2, 4, 4, 5, 99, 0);
        final List<Integer> expected4 = Arrays.asList(2, 4, 4, 5, 99, 9801);
        Assert.assertEquals(expected4, new IntcodeExecutor(input4).execute());

        final List<Integer> input5 = Arrays.asList(1, 1, 1, 4, 99, 5, 6, 0, 99);
        final List<Integer> expected5 = Arrays.asList(30, 1, 1, 4, 2, 5, 6, 0, 99);
        Assert.assertEquals(expected5, new IntcodeExecutor(input5).execute());
    }

    @Test
    public void testPut() {
        final List<Integer> input = Arrays.asList(1, 0, 0, 0, 99);
        final IntcodeExecutor executor = new IntcodeExecutor(input);

        final List<Integer> expected1 = Arrays.asList(1, 0, 0, 0, 99);
        Assert.assertEquals(expected1, executor.getInput());

        executor.put(0, 2);
        final List<Integer> expected2 = Arrays.asList(2, 0, 0, 0, 99);
        Assert.assertEquals(expected2, executor.getInput());

        executor.put(1, 2);
        final List<Integer> expected3 = Arrays.asList(2, 2, 0, 0, 99);
        Assert.assertEquals(expected3, executor.getInput());

        executor.put(2, 2);
        final List<Integer> expected4 = Arrays.asList(2, 2, 2, 0, 99);
        Assert.assertEquals(expected4, executor.getInput());
    }
}
