package firstLab;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Resources implements Runnable{
    private static final Logger LOGGER = Logger.getLogger(Resources.class);
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
                LOGGER.error(e.getMessage());
            }
            Scanner scanner = new Scanner(url.openStream()).useDelimiter("[.!?]");
            while (scanner.hasNext()) {
                searchWordsInArrayAndAdd(scanner.next());
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
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


