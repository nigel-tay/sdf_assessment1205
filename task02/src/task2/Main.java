package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        // Try and read both files first
        File parentDir = new File(args[0]);
        File[] temp = parentDir.listFiles();
        File dir1 = temp[0];
        File dir2 = temp[1];

        analyse(dir1);
        // analyse(dir2);
    }

    public static void analyse(File dir) throws IOException {
        System.out.printf("*********************************** FOR DIRECTORY '%s' ***********************************", dir.getName());
        FileReader fr;
        BufferedReader br;
        String line = "";
        String[] lineArray;
        Map<String, HashMap<String, Integer>> nextWordsMap = new HashMap<>();

        for (File file: dir.listFiles()) {
            System.out.printf("*********************************** FOR FILE '%s' ***********************************", file.getName());
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                lineArray = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (int i = 0; i < lineArray.length - 1; i++) {
                    nextWordsMap.computeIfAbsent(lineArray[i], k -> new HashMap<String, Integer>())
                                .merge(lineArray[i+1], 1, Integer::sum);
                }

            }
            // total occurence
            int totalNum = 0; 
            for (String key: nextWordsMap.keySet()) {
                System.out.println(key + "\n");
                totalNum = nextWordsMap.get(key).values().stream()
                    .reduce(0, (accumulative, element) -> accumulative + element);
                // for (int i = 0; i < nextWordsMap.get(key).size(); i++) {
                //     System.out.println();
                // }
                System.out.println(nextWordsMap.get(key);
            }
        }
        /* 
        {

            word : {hi: 1, the: 4}
            dog : {hi: 1, the: 4}

        }
        */
    }
}
