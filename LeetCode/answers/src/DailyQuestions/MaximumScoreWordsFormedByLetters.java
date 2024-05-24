package DailyQuestions;

import java.util.*;

public class MaximumScoreWordsFormedByLetters {

    private Map<Character, Integer> scoreMap;
    private Map<Character, Integer> lettersMap;
    private int maxScore;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = 0;
        scoreMap = createScoreMap(score);
        lettersMap = createLettersMap(letters);
        backtrack(words, 0, 0);
        return maxScore;
    }

    private void backtrack(String[] words, int start, int currentScore) {
        if (start == words.length) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }

        // Case 1: Do not include the current word
        backtrack(words, start + 1, currentScore);

        // Case 2: Try to include the current word if possible
        Map<Character, Integer> wordMap = createLettersMap(words[start].toCharArray());
        if (isWordScorable(wordMap)) {
            removeWordLetters(wordMap);
            int wordScore = calculateWordScore(wordMap);
            backtrack(words, start + 1, currentScore + wordScore);
            addWordLetters(wordMap);
        }
    }

    private int calculateWordScore(Map<Character, Integer> wordMap) {
        int score = 0;
        for (Map.Entry<Character, Integer> entry : wordMap.entrySet()) {
            score += scoreMap.get(entry.getKey()) * entry.getValue();
        }
        return score;
    }

    private void removeWordLetters(Map<Character, Integer> wordMap) {
        for(char each : wordMap.keySet()) {
            lettersMap.put(each, lettersMap.get(each) - wordMap.get(each));
        }
    }

    private void addWordLetters(Map<Character, Integer> wordMap) {
        for(char each : wordMap.keySet()) {
            lettersMap.put(each, lettersMap.get(each) + wordMap.get(each));
        }
    }

    private boolean isWordScorable(Map<Character, Integer> wordMap) {
        for(char each : wordMap.keySet()) {
            if(lettersMap.getOrDefault(each, 0) < wordMap.get(each)) return false;
        }
        return true;
    }

    private Map<Character, Integer> createScoreMap(int[] score) {
        Map<Character, Integer> map = new HashMap<>();
        for(int index = 0; index < 26; index++) {
            map.put((char) ('a' + index), score[index]);
        }
        return map;
    }

    private Map<Character, Integer> createLettersMap(char[] letters) {
        Map<Character, Integer> map = new HashMap<>();
        for(int index = 0; index < letters.length; index++) {
            map.put(letters[index], map.getOrDefault(letters[index], 0) + 1);
        }
        return map;
    }
}
