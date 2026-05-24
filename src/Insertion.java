import java.util.ArrayList;
import java.util.Comparator;
public class Insertion
{
    private Insertion() {}
    public static void sort(ArrayList<Song> a, Comparator<Song> comparator)
    {
        int n = a.size();
        for (int i = 1; i < n; i++)
        {
            for (int j = i; j > 0 && less(comparator, a.get(j), a.get(j-1)); j--)
            {
                exch(a, j, j-1);
            }
        }
    }
    private static boolean less(Comparator<Song> c, Song v, Song w)
    {
        return c.compare(v, w) < 0;
    }
    private static void exch(ArrayList<Song> a, int i, int j)
    {
        Song swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
}
