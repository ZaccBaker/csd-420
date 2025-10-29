import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.concurrent.ThreadLocalRandom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Main{
    static int[] randomIntNumbers(int limitAmount){
        Random random = new Random();
        return IntStream.generate(() -> random.nextInt(100) + 1)
                        .distinct()
                        .limit(limitAmount)
                        .toArray();
    }


    static double[] randomDoubleNumbers(int limitAmount){
        return DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(100) + 1)
                            .distinct()
                            .limit(limitAmount)
                            .toArray();
    }


    static void directoryCheck(Path directory){
        if(Files.notExists(directory)){
            try {
                Files.createDirectories(directory);
                System.out.println("\tDirectory created successfully.");
            } catch (IOException e) {
                System.out.println("\tFailed to create directory. " + e.getMessage());
            }
        }else{
            System.out.println("\tDirectory already exists.");
        }
    }


    static void createDat(Path directory, File file){
        
        if(file.exists()){
            System.out.println("\tThe Dat file already exists.");
        }else{
            try{
                file.createNewFile();
                System.out.println("\tDat file created successfully.");
            } catch (Exception e) {
                System.out.println("\tFailed to create dat file. " + e.getMessage());
            }
        }
    }
    

    static void exportArrays(int[] intArray, double[] doubleArray, File file){
        try(FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw)){
            
            bw.newLine();
            
            for(int n : intArray){
                bw.write(n + " ");
            }

            bw.newLine();

            for(double n : doubleArray){
                bw.write(n + " ");
            }

            System.out.println("\tSuccessfully appended data to Dat file.");

        } catch (IOException e) {
            System.out.println("\tFailed to create dat file. " + e.getMessage());
        }
    }


    public static void main(String[] args){
        int limit = 5;

        Path directory = Paths.get("../exports/");
        String fileName = "zacbaker-datafile.dat";

        String filePath = directory.toString() + "\\" + fileName;
        File file = new File(filePath);

        int[] randomIntArray = randomIntNumbers(limit);
        double[] randomDoubleArray = randomDoubleNumbers(limit);

        System.out.println("Output Prompt");
        directoryCheck(directory);
        createDat(directory, file);
        exportArrays(randomIntArray, randomDoubleArray, file);
    }
}