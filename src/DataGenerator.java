// Ariel Olea y Santiago González
import java.util.ArrayList;
public class DataGenerator
{
    public static ArrayList<Song> generateDataBase(int n, long seed)
    {
        // ocupamos el StdRandom de Princeton como exige la pauta
        StdRandom.setSeed(seed);
        int numArtistas = n / 50;
        String[] artists = new String[numArtistas];
        for (int i = 0; i < numArtistas; i++) {artists[i] = "Artista_" + i;}
        String[] genres = {"Pop", "Rock", "Jazz", "Electronic", "Classical", "Hip-Hop"};
        ArrayList<Song> db = new ArrayList<>(n);
        for (int i = 1; i <= n; i++)
        {
            int id = i;
            String title = "Cancionsita_" + id;
            String artist = artists[StdRandom.uniform(numArtistas)];
            String genre = genres[StdRandom.uniform(genres.length)];
            int year = StdRandom.uniform(57) + 1970;
            long plays = (long) (StdRandom.uniform() * 10000001L);
            db.add(new Song(id, title, artist, genre, year, plays));
        }
        return db;
    }
}
