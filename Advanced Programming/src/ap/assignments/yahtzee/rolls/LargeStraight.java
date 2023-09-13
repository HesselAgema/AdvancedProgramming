package ap.assignments.yahtzee.rolls;

public class LargeStraight implements Combination {

    @Override
    public String getName() {
        return "Large Straight";
    }

    @Override
    public int getScore(int a, int b, int c, int d, int e) {
        if (a == b + 1 && b == c + 1 && c == d + 1 && d == e + 1) {
            return 40;
        }

        return 0;
    }
}
