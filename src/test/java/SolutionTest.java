import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void day1() {
        SolutionDay1 solution = new SolutionDay1();

        Assert.assertEquals(solution.getLevel("(())"), 0);
        Assert.assertEquals(solution.getLevel("(()(()("), 3);
        Assert.assertEquals(solution.getLevel(")())())"), -3);

        Assert.assertEquals(solution.getBasementStep(")"), 1);
        Assert.assertEquals(solution.getBasementStep("()())"), 5);
    }

    @Test
    public void day2() {
        SolutionDay2 solution = new SolutionDay2();

        Assert.assertEquals(solution.getBoxArea(2, 3, 4), 58);
        Assert.assertEquals(solution.getBoxArea(1, 1, 10), 43);

        Assert.assertEquals(solution.getRibbonArea(2, 3, 4), 34);
        Assert.assertEquals(solution.getRibbonArea(1, 1, 10), 14);
    }

    @Test
    public void day3() {
        SolutionDay3 solution = new SolutionDay3();

        Assert.assertEquals(solution.getVisited("^>v<"), 4);
        Assert.assertEquals(solution.getVisited("^v^v^v^v^v"), 2);

        Assert.assertEquals(solution.getVisitedWithRobo("^>v<"), 3);
        Assert.assertEquals(solution.getVisitedWithRobo("^v^v^v^v^v"), 11);
    }
}
