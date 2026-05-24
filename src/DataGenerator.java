import java.util.ArrayList;
import java.util.Random;
public class DataGenerator
{
    public static ArrayList<Song> generateDataBase(int n, long seed)
    {
        Random random = new Random(seed); //ocupamos el random nativo de java ya que no se nos pide ocupar la clase stdrandom de princeton
        int numTopGlobales = n / 50;
        String[] artists = new String[numTopGlobales];
        for (int i = 0; i < numTopGlobales; i++) {artists[i] = "TopGlobal_" + i;}
        String[] genres = {"Pop", "Rock", "Jazz", "Electronic", "Classical", "Hip-Hop"};
        ArrayList<Song> db = new ArrayList<>(n);
        for (int i = 1; i <= n; i++)
        {
            int id = i;
            String title = "Cancionsita_" + id;
            String artist = artists[random.nextInt(numTopGlobales)];
            String genre = genres[random.nextInt(genres.length)];
            int year = random.nextInt(57) + 1970;
            long plays = (long) (random.nextDouble() * 10000001L);
            db.add(new Song(id, title, artist, genre, year, plays));
        }
        return db;
    }
}