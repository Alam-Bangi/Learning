class Player {
    public static void main(String[] args) {
        MusicPlayer mp3Player = new MP3Player();
        mp3Player.turnOn();
        mp3Player.playMusic();
        mp3Player.turnOff();

        System.out.println();

        MusicPlayer spotify = new Spotify();
        spotify.turnOn();
        spotify.playMusic();
        spotify.turnOff();
    }
}

abstract class MusicPlayer {
    abstract void turnOn();

    abstract void turnOff();

    abstract void playMusic();
}

class MP3Player extends MusicPlayer {
    public void turnOn() {
        System.out.println("Turning on...");
    }

    public void playMusic() {
        System.out.println("Playing music using MP3 file");
    }

    public void turnOff() {
        System.out.println("Powering Off...");
    }
}

class Spotify extends MusicPlayer {
    public void turnOn() {
        System.out.println("Opening the app..");
    }

    public void turnOff() {
        System.out.println("Closing the app...");
    }

    public void playMusic() {
        System.out.println("Playing music on Spotify online");
    }
}
