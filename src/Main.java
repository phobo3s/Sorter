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
        ArrayList<Integer> sortedNumberArray = radixSort(numbersList, 3);
        sortedNumbersToTerminal(sortedNumberArray);
    }

    public static void sortedNumbersToTerminal(ArrayList<Integer> sortedNumberArray) {
        System.out.println("Radix Sıralama Tamamlandı.");
        System.out.println("Sonuçlar :");
        for (int number : sortedNumberArray) {
            System.out.println(number);
        }
    }

    public static ArrayList<ArrayList<Integer>> radixBucketsCreator() {
        // 10 arraylist for 10 digits inside an array list.
        ArrayList<ArrayList<Integer>> radixBuckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= 9; i++) {
            radixBuckets.add(new ArrayList<Integer>());
        }
        return radixBuckets;
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

    public static ArrayList<Integer> radixSort(ArrayList<Integer> numberArray, int highestDigitCount) {
        // Digit counts start from 0 so minus 1.
        highestDigitCount = highestDigitCount - 1;
        // get radix buckets.
        ArrayList<ArrayList<Integer>> radixBuckets = radixBucketsCreator();
        // for every digit.
        for (int i = 0; i <= highestDigitCount; i++) {
            for (int number : numberArray) {
                // find i'nth digit
                int digit;
                try {
                    digit = findNthDigit(number, i);
                    radixBuckets.get(digit).add(number);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                }
            }
            // From buckets to numberArray
            numberArray.clear();
            for (ArrayList<Integer> bucket : radixBuckets) {
                if (bucket.size() != 0) {
                    for (int num : bucket) {
                        numberArray.add(num);
                    }
                }
                bucket.clear();
            }
            System.out.println("Soldan " + i + ". basamak bitti.");
        }
        return numberArray;
    }

    public static Integer findNthDigit(Integer number, Integer n) throws Exception {
        // n is from last digit. Starts with 0.
        int digit;
        // now it starts with 1. Sorry.
        n = n + 1;
        if (n > number.toString().length()) {
            digit = 0;
            // throw new Exception("OutOfIntegerDigitsError");
        }
        digit = (number % (int) Math.pow(10, n)) - (number % (int) Math.pow(10, (n - 1)));
        digit = digit / (int) Math.pow(10, (n - 1));
        return digit;
    }

}
