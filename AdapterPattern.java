interface MediaPlayer {
    void play(String audioType, String fileName);
}

class VlcPlayer {
    void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    private VlcPlayer vlcPlayer = new VlcPlayer();

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter = new MediaAdapter();

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else {
            mediaAdapter.play(audioType, fileName);
        }
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "video.avi");
    }
}
