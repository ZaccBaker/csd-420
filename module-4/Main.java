import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main{
    public static LinkedList<Integer> getNumbers(int size){
        Random random = new Random();
        LinkedList<Integer> randomList = IntStream.generate(() -> random.nextInt(100)+ 1)
                                            .limit(size)
                                            .boxed()
                                            .collect(Collectors.toCollection(LinkedList::new));
        return randomList;
    }


    public static long traverseIterator(LinkedList<Integer> list){
        long start = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long end = System.nanoTime();
        return end - start;
    }


    public static long traverseGet(LinkedList<Integer> list){
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.nanoTime();
        return end - start;
    }


    public static void main(String [] args){
        int[] listSizes = {50_000, 500_000};
        
        for(int size : listSizes){
            LinkedList<Integer> randomList = getNumbers(size);

            System.out.println("\n\n-- Size <" + size + "> --");

            long iteratorTime = traverseIterator(randomList);
            System.out.printf("Iterator time: %.3f ms%n", iteratorTime / 1_000_000.0);

            long getTime = traverseGet(randomList);
            System.out.printf("Get time: %.3f ms%n", getTime / 1_000_000.0);
        }
    }
}

/*  Comment Section
 *  
 *  The LinkedList uses a lambda expression to return random integers between 1 and 100
 *      the size of the list is gotten from the main method. Dependent on whether the main 
 *      forEach loop is 50,000 or 500,000. This separates the creation of the LinkedList
 *      from the traverse processes.
 * 
 *  50,000 size
 *      ~ Iteration took 2.372 ms
 *      ~ Get took 955.310 ms (less than a second)
 * 
 *  500,000 size
 *      ~ Iteration took 4.718 ms
 *      ~ Get took 137,740.950 ms (approximately 2 minutes 17 seconds)
 * 
 *  Differences
 *      The main difference between the iteration and the get(index) method is that 
 *          the iteration between 50-500k elements is about double the time (rounding up, ~1.98).
 *          However, the get(index) method shows a significant difference. The 500k LinkedList took
 *          about 144.18 times longer, totally about 2 minutes and 17 seconds where as the 50k 
 *          LinkedList took  less than a second. Adding more values shows the gap between the two and how
 *          they handle traversing a list and how efficient they are at it. 
 * 
 *  Summary
 *      ~ Iteration is more efficient, especially for larger lists
 *      ~ Get(index) is incredibly inefficient, significantly longer
 */