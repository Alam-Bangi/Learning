package tryouts.sub_arrays;

public class Ball {
    int runs;
    boolean nb;
    boolean wide;
    boolean lb;
    boolean out;

    public Ball(int runs, boolean nb, boolean wide, boolean lb, boolean out) {
        this.runs = runs;
        this.nb = nb;
        this.wide = wide;
        this.lb = lb;
        this.out = out;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Runs = ").append(runs);

        if (nb) {
            result.append(", No-ball");
        }
        if (wide) {
            result.append(", Wide");
        }
        if (lb) {
            result.append(", Leg-bye");
        }
        if (out) {
            result.append(", Wicket");
        }
        return result.toString();
    }
}
