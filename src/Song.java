// Ariel Olea y Santiago González
public class Song{
    private int id;
    private String title;
    private String artist;
    private String genre;
    private int year;
    private long plays;

    public Song(int id, String title, String artist, String genre, int year, long plays)
    {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.plays = plays;
    }
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
    public long getPlays() { return plays; }
}
