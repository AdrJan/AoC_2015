import utils.DataGetter;

public class SolutionDay1 {

    public int getLevel(String input) {
        int level = 0;
        for (int i = 0; i < input.length(); i++)
            switch (input.charAt(i)) {
                case '(':
                    level++;
                    break;
                case ')':
                    level--;
                    break;
                default:
                    break;
            }
        return level;
    }

    public int getBasementStep(String input) {
        int basementStep = 0;
        int level = 0;
        for (int i = 0; i < input.length(); i++) {
            basementStep++;
            switch (input.charAt(i)) {
                case '(':
                    level++;
                    break;
                case ')':
                    level--;
                    break;
                default:
                    break;
            }
            if (level < 0)
                break;
        }

        return basementStep;
    }

    public static void main(String... args) {
        SolutionDay1 solution = new SolutionDay1();
        String input = new DataGetter().getLinesFromFile("day1.txt").get(0);

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getLevel(input));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getBasementStep(input));
    }
}
