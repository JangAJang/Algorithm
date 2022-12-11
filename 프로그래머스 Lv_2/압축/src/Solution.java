import java.util.*;

class Solution {

    HashMap<String, Integer> dictionary = new HashMap<>();

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        initializeDictionary();
        LZW(list, msg);
        return getAnswer(list);
    }

    private int[] getAnswer(List<Integer> list){
        int[] answer = new int[list.size()];
        int index = 0;
        for (int num : list) {
            answer[index] = num;
            index++;
        }
        return answer;
    }

    private void initializeDictionary(){
        for (int i = 0; i < 26; i++) {
            dictionary.put(Character.toString('A'+i), i + 1);
        }
    }

    private void LZW(List<Integer> list, String str) {
        for (int i = 0; i < str.length(); i++) {
            String subStr = str.substring(0, i + 1);
            if (isNewKey(subStr)) {
                addNewWordInDictionary(subStr);
                addToAnswer(list, makeNewWord(str, i));
                LZW(list, str.substring(i));
                break;
            }
            if (i + 1 == str.length()) {
                list.add(dictionary.get(str.substring(0, i + 1)));
            }
        }
    }

    private void addToAnswer(List<Integer> list, String newWord){
        list.add(dictionary.get(newWord));
    }

    private void addNewWordInDictionary(String subStr){
        dictionary.put(subStr, dictionary.size() + 1);
    }

    private String makeNewWord(String str, int index){
        return str.substring(0, index);
    }

    private boolean isNewKey(String subStr){
        return !dictionary.containsKey(subStr);
    }
}