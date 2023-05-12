package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println("For directory: " + dir.getName());
        FileReader fr;
        BufferedReader br;
        String line = "";
        String[] lineArray;
        Map<String, List<String>> nextWordsMap = new HashMap<>();

        for (File file: dir.listFiles()) {
            System.out.println("*********************** FOR FILE *********************************** " + file.getName());
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                lineArray = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

                for (int i = 0; i < lineArray.length - 1; i++) {
                    // if hashmap.getkey() got value, add line[i+1]
                    System.out.printf("[%s, %s] index: %d\n", lineArray[i], lineArray[i+1], i);

                    // if (nextWordsMap.get(lineArray[i]) != null) {
                    //     nextWordsMap.put(lineArray[i], hashArray.add(lineArray[i + 1]));
                    // }
                    nextWordsMap.computeIfAbsent(lineArray[i], k -> new ArrayList<>()).add(lineArray[i+1]);
                }

                // reduce the hashmap's string
            }
        }

        System.out.println(nextWordsMap.toString());
    }
}
