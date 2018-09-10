package firstLab;

import java.io.*;
import java.util.concurrent.*;

public class Occurrence implements Occurrences{

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ConcurrentLinkedQueue<String> list =  new ConcurrentLinkedQueue<>();

    @Override
    public void getOccurrences(String[] resources, String[] words, String res) throws IOException {

        for (String resource : resources) {
            executorService.submit(new Resources(resource, words, list));
        }
        executorService.shutdown();

        final boolean done;
        try {
            done = executorService.awaitTermination(5, TimeUnit.MINUTES);
            System.out.println(("Все файлы обработаны?\n" + done));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        listWriteFile(list, res);

    }

    private void listWriteFile(ConcurrentLinkedQueue<String> list, String res) {

        File file = new File(res);

        if (file.exists() && list != null) {
            try (Writer writer = new FileWriter(file)){
                writer.write("");
                for (String strList : list) {
                    writer.write(strList + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

