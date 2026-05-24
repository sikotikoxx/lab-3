import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Quick
{
    private Quick() {}
    public static void sort(ArrayList<Song> a, Comparator<Song> comparator)
    {
        Collections.shuffle(a); // Mezcla aleatoria nativa de Java
        sort(a, 0, a.size() - 1, comparator);
    }

    private static void sort(ArrayList<Song> a, int lo, int hi, Comparator<Song> comparator)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi, comparator);
        sort(a, lo, j - 1, comparator);
        sort(a, j + 1, hi, comparator);
    }

    private static int partition(ArrayList<Song> a, int lo, int hi, Comparator<Song> comparator)
    {
        int i = lo;
        int j = hi + 1;
        Song v = a.get(lo);
        while (true)
        {
            while (less(comparator, a.get(++i), v))
            {
                if (i == hi) break;
            }
            while (less(comparator, v, a.get(--j)))
            {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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