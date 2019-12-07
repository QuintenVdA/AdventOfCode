import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class Tester {

    @Test
    public void testExamples1() {
        Solver solver = new Solver();

        Assert.assertEquals(2L, solver.solve1(Collections.singletonList(12L)));
        Assert.assertEquals(2L, solver.solve1(Collections.singletonList(14L)));
        Assert.assertEquals(654L, solver.solve1(Collections.singletonList(1969L)));
        Assert.assertEquals(33583L, solver.solve1(Collections.singletonList(100756L)));
    }

    @Test
    public void testExamples2() {
        Solver solver = new Solver();

        Assert.assertEquals(2L, solver.solve2(Collections.singletonList(14L)));
        Assert.assertEquals(966L, solver.solve2(Collections.singletonList(1969L)));
        Assert.assertEquals(50346L, solver.solve2(Collections.singletonList(100756L)));
    }
}
