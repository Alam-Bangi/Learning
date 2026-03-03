import java.util.List;
import java.util.logging.Logger;

class MySortingUtilConsumer {
    private static Logger logger = Logger.getLogger(MySortingUtilConsumer.class.getName());

    public static void main(String[] args) {
        MySortingUtil util = new MySortingUtil();
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