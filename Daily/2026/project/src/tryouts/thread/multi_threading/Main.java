package tryouts.thread.multi_threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FileDownload implements Runnable {
    private final String fileName;
    private final int downloadTime;

    public FileDownload(String fileName, int downloadTime) {
        this.fileName = fileName;
        this.downloadTime = downloadTime;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started downloading " + fileName);

        try {
            for (int progress = 0; progress <= 100; progress += 25) {
                System.out.println(fileName + " - " + progress + "% completed");
                Thread.sleep(downloadTime / 4);
            }
            System.out.println(fileName + " downloaded successfully!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();

            System.out.println(fileName + " download interrupted.");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Download Manager Started ===");

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(new FileDownload("photo.jpg", 4000));
        executor.submit(new FileDownload("video.mp4", 6000));
        executor.submit(new FileDownload("document.pdf", 3000));

        executor.shutdown();

        System.out.println("All download tasks submitted.");
    }
}
