import java.util.ArrayList;
import java.util.Comparator;
public class Selection
{
    private Selection() {}
    public static void sort(ArrayList<Song> a, Comparator<Song> comparator)
    {
        int n = a.size();
        for (int i = 0; i < n; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++)
            {
                if (less(comparator, a.get(j), a.get(min))) min = j;
            }
            exch(a, i, min);
        }
    }
    private static boolean less(Comparator<Song> c, Song v, Song w) {
        return c.compare(v, w) < 0;
    }
    private static void exch(ArrayList<Song> a, int i, int j)
    {
        Song swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
}