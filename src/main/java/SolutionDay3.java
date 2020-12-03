import utils.DataGetter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionDay3 {

    public int getVisited(String input) {
        Set<Position> positions = new HashSet<>();
        int x = 0;
        int y = 0;
        Position position;

        positions.add(new Position(x, y));
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '>') x++;
            else if (c == '<') x--;
            else if (c == '^') y++;
            else if (c == 'v') y--;

            position = new Position(x, y);
            positions.add(position);
        }

        return positions.size();
    }

    public int getVisitedWithRobo(String input) {
        Set<Position> positions = new HashSet<>();
        int sX = 0;
        int sY = 0;
        int rX = 0;
        int rY = 0;
        int x;
        int y;
        Position position;

        positions.add(new Position(sX, sY));
        for (int i = 0; i < input.length(); i++) {
            x = (i%2 == 0) ? sX : rX;
            y = (i%2 == 0) ? sY : rY;

            char c = input.charAt(i);
            if (c == '>') x++;
            else if (c == '<') x--;
            else if (c == '^') y++;
            else if (c == 'v') y--;

            position = new Position(x, y);
            positions.add(position);

            if(i%2 == 0) {
                sX = x;
                sY = y;
            } else {
                rX = x;
                rY = y;
            }
        }

        return positions.size();
    }

    public static void main(String... args) {
        SolutionDay3 solution = new SolutionDay3();
        String input = new DataGetter().getLinesFromFile("day3.txt").get(0);

        Solution.printAnswer(Solution.Answer.Answer_1, solution.getVisited(input));
        Solution.printAnswer(Solution.Answer.Answer_2, solution.getVisitedWithRobo(input));
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
