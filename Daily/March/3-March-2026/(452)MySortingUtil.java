import java.util.List;
import java.util.logging.Logger;

class DirectConsumer {
    private static Logger logger = Logger.getLogger(DirectConsumer.class.getName());

    public static void main(String[] args) {
        BubbleSort util = new BubbleSort();
        List<String> sorted = util.sort(List.of("Charlie", "Alice", "Bob"));
        logger.info(sorted.toString());
    }
}

class MySortingUtil {
    public List<String> sort(List<String> names) {
        BubbleSort bubbleSort = new BubbleSort();
        return bubbleSort.sort(names);

    }
}

class BubbleSort {
    public List<String> sort(List<String> names) {
        return names;
    }
}