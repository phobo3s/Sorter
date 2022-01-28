import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Numbers file path
        String numbersPath = "C:\\Java_Code\\Sorter\\src\\NumbersFolder\\NumbersFile.txt";
        File numbersFile = new File(numbersPath);
        // Take numbers to an ArrayList
        ArrayList<Integer> numbersList = numberFileReader(numbersFile);
        ArrayList<Integer> sortedNumberArray = new ArrayList<Integer>();
        sortedNumberArray = radixSort(numbersList, sortedNumberArray);

    }

    public static ArrayList<Integer> numberFileReader(File numbersFile) {
        ArrayList<Integer> numbersList = new ArrayList<Integer>();
        try {
            Scanner reader = new Scanner(numbersFile);
            while (reader.hasNextLine()) {
                numbersList.add(Integer.parseInt(reader.nextLine()));
            }
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }
        return numbersList;
    }

    public static ArrayList<Integer> radixSort(ArrayList<Integer> numberArray, ArrayList<Integer> sortedNumberArray) {
        int[] digitArray = new int[9];
        // Radix sort implementation
        for (int i = 0; i <= 3; i++) {
            for (int number : numberArray) {
                try {
                    digitArray[Integer.parseInt(String.valueOf(number).substring(
                            String.valueOf(number).length() - i - 1, String.valueOf(number).length() - i))]++;
                } catch (StringIndexOutOfBoundsException e) {
                    // e.getStackTrace();
                } catch (Exception e) {
                    // e.getStackTrace();
                }
            }
            for (int j = 0; j <= 9; j++) {
                for (int k = 1; k <= digitArray[j]; k++) {
                    sortedNumberArray.add();
                }
            }

        }
        return sortedNumberArray;
    }

}
