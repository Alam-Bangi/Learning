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
        return "runs = " + runs;
    }
}
