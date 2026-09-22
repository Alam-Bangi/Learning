package random;

import java.util.Arrays;

class Numbers {
    private int[] data;
    public Numbers(int[] values) {
        this.data = values;
    }
    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
class ShallowCopy {
    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        Numbers e = new Numbers(vals);
        e.showData();

        vals[0] = 13;
        e.showData();
    }
}