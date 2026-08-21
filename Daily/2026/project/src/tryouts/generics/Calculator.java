package tryouts.generics;

// 3. <T extends Number> - Bounded type parameter
class Calculator<T extends Number> {

    public double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }
}