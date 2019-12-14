import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Tester {

    @Test
    public void testExamples() {
        final Solver solver1 = new Solver(Arrays.asList(
                Arrays.asList("R8", "U5", "L5", "D3"),
                Arrays.asList("U7", "R6", "D4", "L4")));
        Assert.assertEquals(6, solver1.solve1());
        Assert.assertEquals(30, solver1.solve2());

        final Solver solver2 = new Solver(Arrays.asList(
                Arrays.asList("U5", "L20"),
                Arrays.asList("D5", "L10", "U10")));
        Assert.assertEquals(15, solver2.solve1());
        Assert.assertEquals(40, solver2.solve2());

        final Solver solver3 = new Solver(Arrays.asList(
                Arrays.asList("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"),
                Arrays.asList("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83")));
        Assert.assertEquals(159, solver3.solve1());
        Assert.assertEquals(610, solver3.solve2());

        final Solver solver4 = new Solver(Arrays.asList(
                Arrays.asList("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"),
                Arrays.asList("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7")));
        Assert.assertEquals(135, solver4.solve1());
        Assert.assertEquals(410, solver4.solve2());

        final Solver solver5 = new Solver(Arrays.asList(
                Arrays.asList("R50", "L50"),
                Arrays.asList("D5", "R10", "D5", "L5", "U20")));
        Assert.assertEquals(5, solver5.solve1());
        Assert.assertEquals(40, solver5.solve2());
    }
}
