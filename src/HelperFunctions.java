import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelperFunctions {

    public static ArrayList<Integer> NumberFileToListReader(File numbersFile) {
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

}
