public class CalculatorRunner {
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
        System.out.println("Subtract: " + doubleCalculator.subtract(10.9, 5.2));
        System.out.println("Multiply: " + doubleCalculator.multiply(10.5, 5.0));
        System.out.println("Divide: " + doubleCalculator.divide(100.0, 12.5));
        System.out.println("Mod: " + doubleCalculator.mod(170.25, 12.0));
        System.out.println("Sin: " + doubleCalculator.sin(30.25));
        System.out.println("Cos: " + doubleCalculator.cos(30.50));
        System.out.println("Tan: " + doubleCalculator.tan(30.75));
        System.out.println("Power: " + doubleCalculator.raisedTo(10.4, 5.0));

        System.out.println();

        Calculator<Long> longCalculator = new Calculator<>();

        System.out.println("Long Operations:");
        System.out.println("Add: " + longCalculator.add(190L, 110L));
        System.out.println("Subtract: " + longCalculator.subtract(20L, 11L));
        System.out.println("Multiply: " + longCalculator.multiply(105L, 50L));
        System.out.println("Divide: " + longCalculator.divide(1000L, 125L));
        System.out.println("Mod: " + longCalculator.mod(17025L, 120L));
        System.out.println("Sin: " + longCalculator.sin(30L));
        System.out.println("Cos: " + longCalculator.cos(305L));
        System.out.println("Tan: " + longCalculator.tan(307L));
        System.out.println("Power: " + longCalculator.raisedTo(104L, 50L));

        System.out.println();

        Calculator<String> stringCalculator = new Calculator<>();

        System.out.println("String Operations:");
        System.out.println("Add: " + stringCalculator.add("A", "B"));
    }
}

class Calculator<T> {

    private T convertResult(double result, T reference) {
        if (reference instanceof Integer) {
            return (T) (Integer) Double.valueOf(result).intValue();
        } else if (reference instanceof Double) {
            return (T) (Double) Double.valueOf(result).doubleValue();
        } else if (reference instanceof Long) {
            return (T) (Long) Double.valueOf(result).longValue();
        } else if (reference instanceof Float) {
            return (T) (Float) Double.valueOf(result).floatValue();
        } else if (reference instanceof Short) {
            return (T) (Short) Double.valueOf(result).shortValue();
        } else if (reference instanceof Integer) {
            return (T) (Byte) Double.valueOf(result).byteValue();
        }
        return null;
    }

    public T add(T a, T b) {
        if (!(a instanceof Number) || !(b instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        double addition = ((Number) a).doubleValue() + ((Number) b).doubleValue();
        return convertResult(addition, a);
    }

    public T subtract(T a, T b) {
        if (!(a instanceof Number) || !(b instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        double subtraction = ((Number) a).doubleValue() - ((Number) b).doubleValue();
        return convertResult(subtraction, b);
    }

    public T multiply(T a, T b) {
        if (!(a instanceof Number) || !(b instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        double multiplication = ((Number) a).doubleValue() * ((Number) b).doubleValue();
        return convertResult(multiplication, b);
    }

    public double divide(T a, T b) {
        if (!(a instanceof Number) || !(b instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");

        }
        if (((Number) b).doubleValue() == 0) {
            System.out.println("Cannot divide by 0");
            return 0;
        }
        return ((Number) a).doubleValue() / ((Number) b).doubleValue();
    }

    public double mod(T a, T b) {
        if (!(a instanceof Number) || !(b instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        if (((Number) b).doubleValue() == 0) {
            System.out.println("Cannot mod by 0");
            return 0;
        }
        return ((Number) a).doubleValue() % ((Number) b).doubleValue();
    }

    public double sin(T degrees) {
        if (!(degrees instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        double radians = Math.toRadians(((Number) degrees).doubleValue());
        double sin = Math.sin(radians);
        return sin;
    }

    public double cos(T degrees) {
        if (!(degrees instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        double radians = Math.toRadians(((Number) degrees).doubleValue());
        double cos = Math.cos(radians);
        return cos;
    }

    public double tan(T degrees) {
        if (!(degrees instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        double radians = Math.toRadians(((Number) degrees).doubleValue());
        double tan = Math.tan(radians);
        return tan;
    }

    public double raisedTo(T a, T b) {
        if (!(a instanceof Number) || !(b instanceof Number)) {
            throw new RuntimeException("Only Numbers Allowed");
        }
        if (((Number) b).intValue() == 0) {
            return Integer.valueOf(1);
        }
        double result = Math.pow(((Number) a).doubleValue(), ((Number) b).doubleValue());
        return result;
    }
}