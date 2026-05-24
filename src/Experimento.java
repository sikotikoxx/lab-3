import java.util.ArrayList;
public class Experimento
{
    public static void main(String[] args)
    {
        System.out.println("Iniciando etapa 2: Experimento de ordenamiento");
        ejecutarExperimento1();
        System.out.println("Iniciando etapa 3: Experimento de búsqueda");
        ejecutarExperimento2();
        System.out.println("Todos los experimentos finalizaron y los CSV han sido creados compañero, revisa");
    }
    private static void ejecutarExperimento1()
    {
        int[] sizes = {1024, 2048, 4096, 8192, 16384, 32768};
        for (int n : sizes)
        {
            Out out = new Out("exp1_resultados_" + n + ".csv");
            out.println("instancia,insertionSort,selectionSort,mergeSort,quickSort");
            for (int i = 0; i < 100; i++)
            {
                long seed = n + i;
                ArrayList<Song> dbOriginal = DataGenerator.generateDataBase(n, seed);
                // INSERTION
                SongDataBase db1 = new SongDataBase(new ArrayList<>(dbOriginal));
                long start1 = System.nanoTime(); // inicia cronómetro nativo
                db1.ordenarPorAlgoritmo("insertionSort", "plays");
                double tInsertion = (System.nanoTime() - start1) / 1_000_000_000.0; // pasa a segundos (ahi vemos si lo pasamos a milisegundos)
                // SELECTION
                SongDataBase db2 = new SongDataBase(new ArrayList<>(dbOriginal));
                long start2 = System.nanoTime();
                db2.ordenarPorAlgoritmo("selectionSort", "plays");
                double tSelection = (System.nanoTime() - start2) / 1_000_000_000.0;
                // MERGE
                SongDataBase db3 = new SongDataBase(new ArrayList<>(dbOriginal));
                long start3 = System.nanoTime();
                db3.ordenarPorAlgoritmo("mergeSort", "plays");
                double tMerge = (System.nanoTime() - start3) / 1_000_000_000.0;
                // QUICK
                SongDataBase db4 = new SongDataBase(new ArrayList<>(dbOriginal));
                long start4 = System.nanoTime();
                db4.ordenarPorAlgoritmo("quickSort", "plays");
                double tQuick = (System.nanoTime() - start4) / 1_000_000_000.0;
                out.println(i + "," + tInsertion + "," + tSelection + "," + tMerge + "," + tQuick);
            }
            out.close();
        }
    }
    private static void ejecutarExperimento2()
    {
        int[] sizes = {1024, 2048, 4096, 8192, 16384, 32768};
        for (int n : sizes)
        {
            Out out = new Out("exp2_resultados_" + n + ".csv");
            out.println("instancia,topglobal,t_lineal,t_binaria");
            int numTopGlobales = n / 50;
            String[] TopglobalesBuscados = {
                "TopGlobal_0",
                "TopGlobal_" + (n / 200),
                "TopGlobal_" + (n / 100),
                "TopGlobal_" + (3 * n / 200),
                "TopGlobal_" + (numTopGlobales - 1)
            };
            for (int i = 0; i < 100; i++)
            {
                long seed = n + i;
                ArrayList<Song> dbOriginal = DataGenerator.generateDataBase(n, seed);
                for (String artist : TopglobalesBuscados)
                {
                    // búsqueda Lineal
                    SongDataBase dbLineal = new SongDataBase(dbOriginal);
                    long startLineal = System.nanoTime();
                    for (int k = 0; k < 1000; k++) {dbLineal.sequentialSearch(artist);}
                    double tLineal = (System.nanoTime() - startLineal) / 1_000_000_000.0;
                    // búsqueda Binaria
                    SongDataBase dbBinaria = new SongDataBase(new ArrayList<>(dbOriginal));
                    dbBinaria.ordenarPorAlgoritmo("quickSort", "artist"); // ordena primero
                    long startBinaria = System.nanoTime();
                    for (int k = 0; k < 1000; k++) {dbBinaria.binarySearch(artist);}
                    double tBinaria = (System.nanoTime() - startBinaria) / 1_000_000_000.0;
                    out.println(i + "," + artist + "," + tLineal + "," + tBinaria);
                }
            }
            out.close();
        }
    }
}