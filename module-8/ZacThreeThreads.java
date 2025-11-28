import java.util.Random;

public class ZacThreeThreads{

    final Integer MIN_COUNT = 10_000;
    final Random RANDOM = new Random();
    final char[] SYMBOLS = "!@#$%^&*()-_=+[{]};:'\\\",<.>/?`~".toCharArray();
    

    public char randomLetter(){
        char randomLetter = (char) (RANDOM.nextInt(26) + 'A');
        return randomLetter;
    }

    public char randomNumber(){
        char randomNum = (char) (RANDOM.nextInt(10) + '0');
        return randomNum;
    }

    public char randomSymbol(){
        char randomSym = SYMBOLS[RANDOM.nextInt(SYMBOLS.length)];
        return randomSym;
    }


    // First thread, random letters
    public class LetterThread extends Thread{
        StringBuilder sb = new StringBuilder();
        @Override
        public void run(){
            for (int i = 0; i < MIN_COUNT; i++) {
                char letter = randomLetter();
                sb.append(letter + " ");
            }
            System.out.println("Letter Thread\n\t" + sb);
        }
    }

    // Second thread, random numbers
    public class NumberThread extends Thread{
        StringBuilder sb = new StringBuilder();
        @Override
        public void run(){
            for (int i = 0; i < MIN_COUNT; i++) {
                char number = randomNumber();
                sb.append(number + " ");
            }
            System.out.println("Number Thread\n\t" + sb);
        }
    }

    // Third thread, random symbols
    public class SymbolThread extends Thread{
        StringBuilder sb = new StringBuilder();
        @Override
        public void run(){
            for (int i = 0; i < MIN_COUNT; i++) {
                char symbol = randomSymbol();
                sb.append(symbol + " ");
            }
            System.out.println("Symbol Thread\n\t" + sb);
        }
    }


    // Tests threads
    public static void threadTests(){
        System.out.println("---Thread Test---\n");

        ZacThreeThreads main = new ZacThreeThreads();

        Thread letterThread = new Thread(main.new LetterThread(), "LetterThread");
        Thread numberThread = new Thread(main.new NumberThread(), "NumberThread");
        Thread symbolThread = new Thread(main.new SymbolThread(), "SymbolThread");
        
        letterThread.start();
        numberThread.start();
        symbolThread.start();

    }


    public static void main(String [] args){
        threadTests();
    }
}