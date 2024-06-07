package DailyQuestions;

public class ReplaceWords {

    private Map<String, String> dictionaryMap;

    public String replaceWords(List<String> dictionary, String sentence) {
        createDictionary(dictionary);
        String answer = "";
        for(String word : sentence.split(" ")) {
            answer += findPrefix(word);
        }
        return answer.trim();
    }

    private String findPrefix(String word) {
        for(int index = 1; index <= word.length(); index++) {
            String prefix = word.substring(0, index);
            if(dictionaryMap.containsKey(prefix)) {
                return dictionaryMap.get(prefix) + " ";
            }
        }
        return word + " ";
    }

    private void createDictionary(List<String> dictionary) {
        dictionaryMap = new HashMap<>();
        for(String word : dictionary) {
            dictionaryMap.put(word, word);
        }
    }
}
