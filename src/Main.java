import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Numbers file path
        String numbersPath = "C:\\Java_Code\\Sorter\\src\\NumbersFolder\\NumbersFile.txt";
        arrayToTerminal(new RadixSorter(numbersPath, 4).getResult());
    }

    public static void arrayToTerminal(ArrayList<Integer> sortedNumberArray) {
        System.out.println("Radix Sıralama Tamamlandı.");
        System.out.println("Sonuçlar :");
        for (int number : sortedNumberArray) {
            System.out.println(number);
        }
    }
}
