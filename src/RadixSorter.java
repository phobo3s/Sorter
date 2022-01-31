import java.io.File;
import java.util.ArrayList;

public class RadixSorter {

    private ArrayList<Integer> resultArray;

    public RadixSorter(String numbersPath) {
        File numbersFile = new File(numbersPath);
        ArrayList<Integer> numberArrayList = new ArrayList<Integer>(
                HelperFunctions.NumberFileToListReader(numbersFile));
        this.resultArray = radixSort(numberArrayList, findMaxDigitCount(numberArrayList));
    }

    public ArrayList<Integer> getResult() {
        return this.resultArray;
    }

    public ArrayList<ArrayList<Integer>> radixBucketsCreator() {
        // 10 arraylist for 10 digits inside an array list.
        ArrayList<ArrayList<Integer>> radixBuckets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= 9; i++) {
            radixBuckets.add(new ArrayList<Integer>());
        }
        return radixBuckets;
    }

    public ArrayList<Integer> radixSort(ArrayList<Integer> numberArray, int highestDigitCount) {
        // Digit counts start from 0 so minus 1.
        highestDigitCount = highestDigitCount - 1;
        // get radix buckets.
        ArrayList<ArrayList<Integer>> radixBuckets = radixBucketsCreator();
        // for every digit.
        for (int i = 0; i <= highestDigitCount; i++) {
            for (int number : numberArray) {
                // find i'nth digit
                int digit;
                digit = findNthDigit(number, i);
                radixBuckets.get(digit).add(number);
            }
            // From buckets to numberArray
            numberArray.clear();
            // sor is starting from 0 so itis ascending order.
            for (ArrayList<Integer> bucket : radixBuckets) {
                if (bucket.size() != 0) {
                    for (int num : bucket) {
                        numberArray.add(num);
                    }
                }
                bucket.clear();
            }
            // System.out.println("Soldan " + i + ". basamak bitti.");
        }
        return numberArray;
    }

    public Integer findNthDigit(Integer number, Integer n) {
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

    public Integer findMaxDigitCount(ArrayList<Integer> numberArray) {
        int maxDigitCount = 0;
        for (int num : numberArray) {
            for (int i = 1; i <= 100; i++) {
                if (num < Math.pow(10, i) && i > maxDigitCount) {
                    maxDigitCount = i;
                }
            }
            if (maxDigitCount == 0) {
                maxDigitCount = String.valueOf(num).length();
            }
        }
        return maxDigitCount;
    }

}
