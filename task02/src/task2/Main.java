package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        Map<String, List<String>> nextWordsMap = new HashMap<>();
        for (File file: dir.listFiles()) {
            System.out.println("*********************** FOR FILE *********************************** " + file.getName());
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
            }
        }
    }
}
