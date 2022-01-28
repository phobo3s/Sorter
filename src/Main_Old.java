import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Main_Old {

    public static void main(String[] args) {
        // Numbers file path
        String numbersPath = "C:\\Java_Code\\Sorter\\src\\NumbersFolder\\NumbersFile.txt";
        File numbersFile = new File(numbersPath);
        // Take numbers to an ArrayList
        ArrayList<Integer> numbersList = numberFileReader(numbersFile);
        ArrayList<String> sortedNumberArray = new ArrayList<String>();
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

    public static ArrayList<String> radixSort(ArrayList<Integer> numberArray, ArrayList<String> sortedNumberArray) {
        // Special array that index is digit and value is the count of that digit.
        int[] digitArray = new int[10];
        // Radix sort implementation
        // Sort for every digit.
        for (int i = 0; i <= 3; i++) {
            Arrays.fill(digitArray, 0);
            for (int number : numberArray) {
                // get the (length - i). digit of the number.
                // count the occurence of this digit and write to digitArray.
                try {
                    // Construct digitArray
                    digitArray[Integer.parseInt(String.valueOf(number).substring(
                            String.valueOf(number).length() - i - 1, String.valueOf(number).length() - i))]++;
                } catch (StringIndexOutOfBoundsException e) {
                    // ;
                } catch (Exception e) {
                    // e.getStackTrace();
                }
            }
            // Sort digitArray
            if (i == 0) {
                for (int j = 0; j <= 9; j++) {
                    for (int k = 1; k <= digitArray[j]; k++) {
                        sortedNumberArray.add(String.valueOf(j));
                    }
                }
            } else {
                int index = 0;
                for (int j = 0; j <= 9; j++) {
                    for (int k = 1; k <= digitArray[j]; k++) {
                        sortedNumberArray.set(index, j + sortedNumberArray.get(index));
                        index++;
                    }
                }
            }
            System.out.println("bla");
        }
        return sortedNumberArray;
    }

}
