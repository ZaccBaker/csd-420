import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String [] args){
        // Comparable test values
        Integer[] testComparable_1 = {1,8,19,21,54,14,6};
        Integer[] testComparable_2 = {88,9,12,3,58,48,2};
        Integer[] testComparable_3 = {72,42,64,18,14,7,91};

        Algorithm.bubbleSort(testComparable_1);
        Algorithm.bubbleSort(testComparable_2);
        Algorithm.bubbleSort(testComparable_3);

        // Comparator test values
        Integer[] testComparator_1 = {9,8,15,4,3,1,31};
        Integer[] testComparator_2 = {8,64,13,21,84,38};
        Integer[] testComparator_3 = {12,0,35,22,18,47};
        Integer[] testComparator_4 = {12,0,35,6,18,47};

        // Set comparator types, ascending & descending
        Comparator<Integer> ascending = (a, b) -> a - b;
        Comparator<Integer> descending = (a, b) -> b - a;
        
        Algorithm.bubbleSort(testComparator_1, ascending);
        Algorithm.bubbleSort(testComparator_2, ascending);
        Algorithm.bubbleSort(testComparator_3, ascending);
        Algorithm.bubbleSort(testComparator_4, descending);

        // Output
        System.out.println("Comparable Output");
        System.out.println(Arrays.toString(testComparable_1));
        System.out.println(Arrays.toString(testComparable_2));
        System.out.println(Arrays.toString(testComparable_3));

        System.out.println();
        
        System.out.println("Comparable Output");
        System.out.println(Arrays.toString(testComparator_1));
        System.out.println(Arrays.toString(testComparator_2));
        System.out.println(Arrays.toString(testComparator_3));
        System.out.println(Arrays.toString(testComparator_4));
    }
}