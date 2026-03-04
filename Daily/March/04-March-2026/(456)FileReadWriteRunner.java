import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileReadWriteRunner {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\User\\Downloads\\alam\\Learning\\Daily\\March\\04-March-2026\\sample.txt");
        String fileContent = Files.readString(path);
        System.out.println(fileContent);

        String newFileContent = fileContent.replace("Line", "This is Line");
        Path newPath = Paths
                .get("C:\\Users\\User\\Downloads\\alam\\Learning\\Daily\\March\\04-March-2026\\updated_sample.txt");
        Files.writeString(newPath, newFileContent);
        System.out.println(newFileContent);
    }

}
