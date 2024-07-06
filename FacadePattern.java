// Subsystem classes
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on");
    }

    public void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stop() {
        System.out.println("Stopping the DVD");
    }

    public void off() {
        System.out.println("DVD Player is off");
    }
}

class Amplifier {
    public void on() {
        System.out.println("Amplifier is on");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to: " + level);
    }

    public void off() {
        System.out.println("Amplifier is off");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void setInput(String input) {
        System.out.println("Setting projector input to: " + input);
    }

    public void off() {
        System.out.println("Projector is off");
    }
}

// Facade class
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        projector.on();
        projector.setInput("DVD");
        amplifier.on();
        amplifier.setVolume(10);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the home theater...");
        dvdPlayer.stop();
        dvdPlayer.off();
        amplifier.off();
        projector.off();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector);
        homeTheater.watchMovie("Inception");  // Simplified interface to start the movie
        homeTheater.endMovie();  // Simplified interface to stop the movie
    }
}
