class OnlinePlayer {
    public static void main(String[] args) {

        Video video = new Video();

        Thread downloadThread = new Thread(video::download);
        Thread playThread = new Thread(video::play);

        playThread.start();
        downloadThread.start();
    }
}

class Video {

    private boolean isDownloaded = false;

    public synchronized void download() {

        System.out.println("Downloading video...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Downloading...!!!");
        }

        isDownloaded = true;
        System.out.println("Download complete");

        notify();
    }

    public synchronized void play() {

        while (!isDownloaded) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Downloading...!!!");
            }
        }
        System.out.println("Playing video...");
    }
}
