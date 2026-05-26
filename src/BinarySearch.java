import java.util.ArrayList;
public class BinarySearch
{
    private BinarySearch() {}
    public static ArrayList<Song> search(ArrayList<Song> songs, String artist)
    {
        ArrayList<Song> result = new ArrayList<>();
        int lo = 0;
        int hi = songs.size() - 1;
        int firstIndex = -1;
        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            int cmp = songs.get(mid).getArtist().compareTo(artist);
            if (cmp < 0) {lo = mid + 1;}
            else if (cmp > 0) {hi = mid - 1;}
            else
            {
                firstIndex = mid;
                hi = mid - 1; // sigue buscando hacia la izquierda
            }
        }
        if (firstIndex != -1)
        {
            for (int i = firstIndex; i < songs.size(); i++)
            {
                if (songs.get(i).getArtist().equals(artist)) {result.add(songs.get(i));}
                else {break;}
            }
        }
        return result;
    }
}