import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main{
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        ArrayList<E> uniqueArray = new ArrayList<>();
        list.stream()
            .filter(e -> !uniqueArray.contains(e))
            .forEach(uniqueArray::add);
        return uniqueArray;
    }


    public static ArrayList<Integer> getNumbers(){
        Random random = new Random();
        ArrayList<Integer> randomArray = IntStream.generate(() -> random.nextInt(20) + 1)
                        .limit(50)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
        return randomArray;
    }


    public static void main(String [] args){
        ArrayList<Integer> randomArray = getNumbers();
        System.out.println("Random Array - Original");
        randomArray.forEach(e -> System.out.printf("%-10s", e));

        System.out.println();
        System.out.println();

        ArrayList<Integer> uniqueArray = removeDuplicates(randomArray);
        System.out.println("Unique Array - Sorted");
        uniqueArray.forEach(e -> System.out.printf("%-10s", e));
    }
}