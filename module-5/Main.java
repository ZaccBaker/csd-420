import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Main{
    public static String readFile(){
        final String FILE_NAME = "collection_of_words.txt";

        File myFile = new File(FILE_NAME);
        StringBuilder allData = new StringBuilder();

        try (Scanner reader = new Scanner(myFile)){
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                allData.append(data).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured: " + e);
        }
        String finalData = allData.toString();
        return finalData;
    }


    public static Set<String> uniqueWords(String paragraph){
        String[] words = paragraph.split(" ");
        Set<String> uniqueSet = new HashSet<>();

        for (String word : words) {
            String currentWord = word.trim().replaceAll("[.,]", "").toLowerCase();
            uniqueSet.add(currentWord);
        }
        return uniqueSet;
    }


    public static void ascendingOrder(TreeSet<String> finalSet){
        System.out.println("\nAscending Order");
        for (String word : finalSet) {
            System.out.printf("\t- %s%n",word);
        }
    }

    public static void descendingOrder(TreeSet<String> finalSet){
        Iterator<String> reverseOrder = finalSet.descendingIterator();
        System.out.println("\nDescendingOrder");
        while (reverseOrder.hasNext()) {
            System.out.printf("\t- %s%n",reverseOrder.next());
        }
    }


    public static void main(String [] args){
        String data = readFile();
        System.out.printf("Paragraph\n\t%s\n",data);

        Set<String> uniqueSet = uniqueWords(data);

        TreeSet<String> finalSet = new TreeSet<>(uniqueSet);
        ascendingOrder(finalSet);
        descendingOrder(finalSet);
    }
}