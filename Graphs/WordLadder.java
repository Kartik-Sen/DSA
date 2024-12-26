package Graphs;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert word list to a set for quick lookup
        Set<String> wordSet = new HashSet<>(wordList);

        // If the endWord is not in the dictionary, return 0
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // BFS queue (word, current level)
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        // Mark the beginning word as visited immediately
        wordSet.remove(beginWord); // Remove from set to prevent revisiting

        int level = 1; // starting from level 1

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process the current level
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Try all possible one-character transformations
                for (int j = 0; j < word.length(); j++) {
                    char[] wordArray = word.toCharArray();

                    // Try changing each character to every possible letter
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        // If newWord is the endWord, return the current level + 1
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If the new word is in the dictionary, add it to the queue and remove it from
                        // the set
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // Remove from set to prevent revisiting
                        }
                    }
                }
            }

            // Increase level after processing current level
            level++;
        }

        // If no transformation path exists
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + result);
    }
}
