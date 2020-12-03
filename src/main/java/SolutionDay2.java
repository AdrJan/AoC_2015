import utils.DataGetter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionDay2 {

    public int getBoxArea(int l, int w, int h) {
        int area1 = l*w;
        int area2 = w*h;
        int area3 = l*h;
        return 2*area1 + 2*area2 + 2*area3 + Math.min(area1, Math.min(area2, area3));
    }

    public int getRibbonArea(int l, int w, int h) {
        List<Integer> sortedSizes = Arrays.asList(l, w, h);
        Collections.sort(sortedSizes);
        return l*w*h + sortedSizes.get(0)*2 + sortedSizes.get(1)*2;
    }

    public static void main(String... args) {
        SolutionDay2 solution = new SolutionDay2();
        List<String> input = new DataGetter().getLinesFromFile("day2.txt");
        String[] lineEls;

        int totalPaperArea = 0;
        int totalRibbonLength = 0;
        int l, w, h;
        for(String line : input) {
            lineEls = line.split("x");
            l = Integer.parseInt(lineEls[0]);
            w = Integer.parseInt(lineEls[1]);
            h = Integer.parseInt(lineEls[2]);

            totalPaperArea += solution.getBoxArea(l, w, h);
            totalRibbonLength += solution.getRibbonArea(l, w, h);
        }

        Solution.printAnswer(Solution.Answer.Answer_1, totalPaperArea);
        Solution.printAnswer(Solution.Answer.Answer_2, totalRibbonLength);
    }
}
