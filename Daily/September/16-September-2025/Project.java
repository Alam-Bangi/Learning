class Project {
    public static void main(String[] args) {
        ComplexAlgorithm algorithm = new RealAlgorithm();
        System.out.println(algorithm.complexAlgorithm(10, 20));
    }
}

interface ComplexAlgorithm {
    int complexAlgorithm(int number1, int number2);
    
}

class DummyAlgorithm implements ComplexAlgorithm {
    public int complexAlgorithm(int number1, int number2) {
        return number1+number2;
    }
}
class RealAlgorithm implements ComplexAlgorithm {
    public int complexAlgorithm(int number1, int number2) {
        return number1*number2;
    }
}