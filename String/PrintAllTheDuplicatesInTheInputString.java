package String;

import java.util.HashMap;
import java.util.Map;

public class PrintAllTheDuplicatesInTheInputString {
    public static void printDuplicates(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Print characters with count > 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String input = "programming";
        printDuplicates(input);
    }
}
