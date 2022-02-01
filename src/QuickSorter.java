import java.io.File;
import java.util.ArrayList;

public class QuickSorter {

    private ArrayList<Integer> resultArray;

    public QuickSorter(String numbersPath) {
        File numbersFile = new File(numbersPath);
        ArrayList<Integer> numberArrayList = new ArrayList<Integer>(
                HelperFunctions.NumberFileToListReader(numbersFile));
        // this.resultArray = radixSort(numberArrayList,
        // findMaxDigitCount(numberArrayList));
    }

}
