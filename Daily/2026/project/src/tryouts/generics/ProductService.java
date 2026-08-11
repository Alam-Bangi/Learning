package tryouts.generics;

import java.util.List;

class ProductService {

    public <T> void print(T value) {
        System.out.println(value);
    }

    public <T> void printAll(List<T> values) {
        for (T value : values) {
            System.out.println(value);
        }
    }

    public <T> T getFirst(List<T> values) {
        return values.get(0);
    }
}