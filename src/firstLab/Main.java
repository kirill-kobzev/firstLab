package firstLab;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        File myFolder = new File("d://testBig");

        File[] files = myFolder.listFiles();
        String[] fileArray = listFileInArray(files);

        Occurrence occurrence = new Occurrence();

        try {
            occurrence.getOccurrences(fileArray,
                    new String[]{"srp", "rbtbjjgrt", "da", "starter"}, "txt1");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

    }


    public static String[] listFileInArray(File[] files) {
        int arrayLenght = files.length;
        String[] fileArray = new String[arrayLenght];
        for (int i = 0; i < arrayLenght; i++) {
            fileArray[i] = "file:d://testBig//" + files[i].getName();
        }

        return fileArray;
    }

}
