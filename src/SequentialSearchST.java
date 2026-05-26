import java.util.ArrayList;
public class SequentialSearchST
{
    private SequentialSearchST() {}
    public static ArrayList<Song> search(ArrayList<Song> songs, String artist)
    {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songs) {if (s.getArtist().equals(artist)) {result.add(s);}}
        return result;
    }
}