package week7;
class Playlist {
    private String[] songs;
    private int count;

    Playlist(int size) {
        songs = new String[size];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return count;
    }
}

public class q2 {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        String[] songs = p.getSongs();

        for (int i = 0; i < songs.length; i++) {
            System.out.println(songs[i]);
        }

        System.out.println("Song Count: " + p.getSongCount());
    }
}