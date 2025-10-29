import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main{ 
    static void readFile(File file){
        
        ArrayList<Integer> intArray = new ArrayList<>();
        ArrayList<Double> doubleArray = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            
            String line;

            while ((line = br.readLine()) != null) {
                
                if (line.trim().isEmpty()) continue;
                
                String[] lineArray = line.trim().split("\\s+");

                for(String value : lineArray){
                    if (value.contains(".")) {
                        doubleArray.add(Double.parseDouble(value));
                        
                    }else if (!value.contains(".")){
                        intArray.add(Integer.parseInt(value));
                    }
                }
            }

            System.out.println("Int Array: " + intArray);
            System.out.println("Double Array: " + doubleArray);

        } catch (IOException  e) {
            System.out.println("\tFailed to create dat file. " + e.getMessage());
        }  
    }

    
    static ArrayList<Integer> intValues(ArrayList<String> list){

        ArrayList<Integer> intArray = new ArrayList<>();

        for(String value : list){
            if (!value.contains(".")){
                System.out.println("Int " + value);
                intArray.add(Integer.parseInt(value));
            }
        }
        return intArray;
    }


    public static void main(String[] args){

        Path directory = Paths.get("../exports/");
        String fileName = "zacbaker-datafile.dat";

        String filePath = directory.toString() + "\\" + fileName;
        File file = new File(filePath);

        readFile(file);
    }
}