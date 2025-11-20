import java.util.Comparator;

public class Algorithm {
    // Comparable bubble sort, compareTo
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        int n = list.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    // Switch order
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    
    // Comparator bubble sort, compare
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator){
        int n = list.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    // Switch order
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
