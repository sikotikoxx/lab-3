// Ariel Olea y Santiago González
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
                StopwatchCPU timer1 = new StopwatchCPU();
                db1.ordenarPorAlgoritmo("insertionSort", "plays");
                double tInsertion = timer1.elapsedTime();
                // SELECTION
                SongDataBase db2 = new SongDataBase(new ArrayList<>(dbOriginal));
                StopwatchCPU timer2 = new StopwatchCPU();
                db2.ordenarPorAlgoritmo("selectionSort", "plays");
                double tSelection = timer2.elapsedTime();
                // MERGE
                SongDataBase db3 = new SongDataBase(new ArrayList<>(dbOriginal));
                StopwatchCPU timer3 = new StopwatchCPU();
                db3.ordenarPorAlgoritmo("mergeSort", "plays");
                double tMerge = timer3.elapsedTime();
                // QUICK
                SongDataBase db4 = new SongDataBase(new ArrayList<>(dbOriginal));
                StopwatchCPU timer4 = new StopwatchCPU();
                db4.ordenarPorAlgoritmo("quickSort", "plays");
                double tQuick = timer4.elapsedTime();
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
            out.println("instancia,artista,t_lineal,t_binaria");
            int numArtistas = n / 50;
            String[] artistasBuscados = {
                    "Artista_0",
                    "Artista_" + (n / 200),
                    "Artista_" + (n / 100),
                    "Artista_" + (3 * n / 200),
                    "Artista_" + (numArtistas - 1)
            };
            for (int i = 0; i < 100; i++)
            {
                long seed = n + i;
                ArrayList<Song> dbOriginal = DataGenerator.generateDataBase(n, seed);
                for (String artist : artistasBuscados)
                {
                    // búsqueda Lineal
                    SongDataBase dbLineal = new SongDataBase(dbOriginal);
                    StopwatchCPU timerLineal = new StopwatchCPU();
                    for (int k = 0; k < 1000; k++) {dbLineal.sequentialSearch(artist);}
                    double tLineal = timerLineal.elapsedTime();
                    // Búsqueda Binaria
                    SongDataBase dbBinaria = new SongDataBase(new ArrayList<>(dbOriginal));
                    dbBinaria.ordenarPorAlgoritmo("quickSort", "artist"); // ordena primero
                    StopwatchCPU timerBinaria = new StopwatchCPU();
                    for (int k = 0; k < 1000; k++) {dbBinaria.binarySearch(artist);}
                    double tBinaria = timerBinaria.elapsedTime();
                    out.println(i + "," + artist + "," + tLineal + "," + tBinaria);
                }
            }
            out.close();
        }
    }
}
