package firstLab;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Resources implements Runnable{

    private String resource;
    private String[] words;
    private ConcurrentLinkedQueue list;

    public Resources(String resource, String[] words, ConcurrentLinkedQueue list) {
        this.resource = resource;
        this.words = words;
        this.list = list;
    }

    @Override
    public void run() {
        this.list = list;
        try {
            URL url = null;
            try {
                url = new URL(resource);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Scanner scanner = new Scanner(url.openStream()).useDelimiter("[.!?]");
            while (scanner.hasNext()) {
                searchWordsInArrayAndAdd(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchWordsInArrayAndAdd(String str){
        for (String word: words){
            if(str.toLowerCase().contains(word.toLowerCase())){
                list.add(str);
            }
        }

    }
}


