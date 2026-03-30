
public class CalciWithExtends {
    public static void main(String[] args) {

        Calculator<Integer> intCalculator = new Calculator<>();

        System.out.println("Integer Operations: ");
        System.out.println("Add: " + intCalculator.add(10, 5));
        System.out.println("Subtract: " + intCalculator.subtract(10, 5));
        System.out.println("Multiply: " + intCalculator.multiply(10, 5));
        System.out.println("Divide: " + intCalculator.divide(10, 5));
        System.out.println("Mod: " + intCalculator.mod(10, 5));
        System.out.println("Sin: " + intCalculator.sin(30));
        System.out.println("Cos: " + intCalculator.cos(30));
        System.out.println("Tan: " + intCalculator.tan(30));
        System.out.println("Power: " + intCalculator.raisedTo(10, 5));

        System.out.println();

        Calculator<Double> doubleCalculator = new Calculator<>();

        System.out.println("Double Operations:");
        System.out.println("Add: " + doubleCalculator.add(5.5, 2.5));
        System.out.println("Multiply: " + doubleCalculator.multiply(2.5, 4.0));

        System.out.println();

        Calculator<String> stringCalculator = new Calculator<>();

        // System.out.println("String Operations:");
        // System.out.println("Add: " + stringCalculator.add("A", "B"));
    }
}

class Calculator<T extends Number> {

    public double add(T a, T b) {
        return ((Number) a).doubleValue() + ((Number) b).doubleValue();
    }

    public double subtract(T a, T b) {
        return ((Number) a).doubleValue() - ((Number) b).doubleValue();
    }

    public double multiply(T a, T b) {
        return ((Number) a).doubleValue() * ((Number) b).doubleValue();
    }

    public double divide(T a, T b) {
        if (((Number) b).doubleValue() == 0) {
            System.out.println("Cannot divide by 0");
            return 0;
        }
        return ((Number) a).doubleValue() / ((Number) b).doubleValue();
    }

    public double mod(T a, T b) {
        if (((Number) b).doubleValue() == 0) {
            System.out.println("Cannot mod by 0");
            return 0;
        }
        return ((Number) a).doubleValue() % ((Number) b).doubleValue();
    }

    public double sin(T degrees) {
        double radians = Math.toRadians(((Number) degrees).doubleValue());
        double sin = Math.sin(radians);
        return sin;
    }

    public double cos(double degrees) {
        double radians = Math.toRadians(((Number) degrees).doubleValue());
        double cos = Math.cos(radians);
        return cos;
    }

    public double tan(double degrees) {
        double radians = Math.toRadians(((Number) degrees).doubleValue());
        double tan = Math.tan(radians);
        return tan;
    }

    public double raisedTo(T a, T b) {
        if (((Number) b).intValue() == 0) {
            return Integer.valueOf(1);
        }
        double result = 0.0;
        for (int i = 0; i < ((Number) b).intValue(); i++) {
            result = ((Number) a).doubleValue() * ((Number) b).doubleValue();
        }
        return result;
    }
}