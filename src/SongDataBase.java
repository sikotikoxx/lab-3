import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class SongDataBase
{
    private ArrayList<Song> songs;
    public SongDataBase(ArrayList<Song> songs) {this.songs = songs;}
    public ArrayList<Song> getSongs() {return songs;}
    public void ordenarPorAlgoritmo(String algoritmo, String atributo)
    {
        Comparator<Song> comparator;
        switch (atributo) // compara segun el atributo
        {
            case "artist": comparator = Comparator.comparing(Song::getArtist); break;
            case "genre": comparator = Comparator.comparing(Song::getGenre); break;
            case "year": comparator = Comparator.comparingInt(Song::getYear); break;
            case "plays": default: comparator = Comparator.comparingLong(Song::getPlays); break;
        }
        switch (algoritmo)
        { //llama a las clases princeton
            case "insertionSort": Insertion.sort(songs, comparator); break;
            case "selectionSort": Selection.sort(songs, comparator); break;
            case "mergeSort": Merge.sort(songs, comparator); break;
            case "quickSort": Quick.sort(songs, comparator); break;
            default: songs.sort(comparator); break;
        }
    }
    public ArrayList<Song> sequentialSearch(String artist)
    {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s:songs) {if (s.getArtist().equals(artist)) {result.add(s);}}
        return result;
    }
    public ArrayList<Song> binarySearch(String artist)
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
            else{
                firstIndex = mid;
                hi = mid - 1;
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