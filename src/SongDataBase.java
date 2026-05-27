// Ariel Olea y Santiago González
import java.util.ArrayList;
import java.util.Comparator;
public class SongDataBase
{
    private ArrayList<Song> songs;
    public SongDataBase(ArrayList<Song> songs) {this.songs = songs;}
    public ArrayList<Song> getSongs() {return songs;}
    public void ordenarPorAlgoritmo(String algoritmo, String atributo)
    {
        Comparator<Song> comparator;
        switch (atributo)
        {
            case "artist": comparator = Comparator.comparing(Song::getArtist); break;
            case "genre": comparator = Comparator.comparing(Song::getGenre); break;
            case "year": comparator = Comparator.comparingInt(Song::getYear); break;
            case "plays":
            default: comparator = Comparator.comparingLong(Song::getPlays); break;
        }
        switch (algoritmo)
        {
            case "insertionSort": Insertion.sort(songs, comparator); break;
            case "selectionSort": Selection.sort(songs, comparator); break;
            case "mergeSort": Merge.sort(songs, comparator); break;
            case "quickSort": Quick.sort(songs, comparator); break;
            default: songs.sort(comparator); break;
        }
    }
    public ArrayList<Song> sequentialSearch(String artist)
    {
        return SequentialSearchST.search(songs, artist);
    }
    public ArrayList<Song> binarySearch(String artist)
    {
        return BinarySearch.search(songs, artist);
    }
}
