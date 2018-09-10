package firstLab;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File myFolder = new File("d://testBig");

        //Не знал, как сгенерированные файлы поместить в массив строк
        //Написал метод listFileInArray, который это делает
        File[] files = myFolder.listFiles();
        String[] fileArray = listFileInArray(files);

        Occurrence occurrence = new Occurrence();

        try {
            occurrence.getOccurrences(fileArray,
//                    new String[]{
//                             "file:C://Users//Kirill//Desktop//text1.txt"
//                            , "file:C://Users//Kirill//Desktop//text0.txt"
//                            , "file:C://Users//Kirill//Desktop//text2.txt"
//                            },
                    new String[]{"srp", "rbtbjjgrt", "da", "fbsrwer"}, "txt1");
        } catch (IOException e) {
            e.printStackTrace();
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
