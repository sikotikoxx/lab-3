import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Merge
{
    private Merge() {}
    public static void sort(ArrayList<Song> a, Comparator<Song> comparator)
    {
        ArrayList<Song> aux = new ArrayList<>(Collections.nCopies(a.size(), null));
        sort(a, aux, 0, a.size() - 1, comparator);
    }
    private static void sort(ArrayList<Song> a, ArrayList<Song> aux, int lo, int hi, Comparator<Song> comparator)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, comparator);
        sort(a, aux, mid + 1, hi, comparator);
        merge(a, aux, lo, mid, hi, comparator);
    }
    private static void merge(ArrayList<Song> a, ArrayList<Song> aux, int lo, int mid, int hi, Comparator<Song> comparator)
    {
        for (int k = lo; k <= hi; k++)
        {
            aux.set(k, a.get(k));
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a.set(k, aux.get(j++));
            else if (j > hi) a.set(k, aux.get(i++));
            else if (less(comparator, aux.get(j), aux.get(i))) a.set(k, aux.get(j++));
            else a.set(k, aux.get(i++));
        }
    }
    private static boolean less(Comparator<Song> c, Song v, Song w) {
        return c.compare(v, w) < 0;
    }
}