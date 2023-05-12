package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File parentDir = new File(args[0]);
        File[] temp = parentDir.listFiles();
        File dir1 = temp[0];
        File dir2 = temp[1];

        analyse(dir1);
        analyse(dir2);
    }

    public static void analyse(File dir) throws IOException {
        System.out.printf("*********************************** FOR DIRECTORY '%s' ***********************************\n", dir.getName());
        FileReader fr;
        BufferedReader br;
        String line = "";
        String[] lineArray;
        Map<String, HashMap<String, Integer>> nextWordsMap = new HashMap<>();

        for (File file: dir.listFiles()) {
            System.out.printf("*********************************** FOR FILE '%s' ***********************************\n", file.getName());
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
            double totalNum = 0.0; 
            for (String key: nextWordsMap.keySet()) {
                System.out.println(key);
                totalNum = nextWordsMap.get(key).values().stream()
                    .reduce(0, (accumulative, element) -> accumulative + element);

                for (String value: nextWordsMap.get(key).keySet()) {
                    double dprob = nextWordsMap.get(key).get(value) / totalNum;
                    String prob = dprob == 1 ? String.format("%.0f", dprob) : String.format("%.1f", dprob);
                    System.out.printf("      %s %s\n", value, prob);
                }
            }
        }
    }
}
