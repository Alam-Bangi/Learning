import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class FileWriteRunner {
    public static void main(String[] args) throws IOException {
        Path fileToWrite = Paths.get("write.txt");

        List<String> linesToWrite = List.of("Apple", "Bat", "Cat", "Elephant");
        Files.write(fileToWrite, linesToWrite);
    }
}
