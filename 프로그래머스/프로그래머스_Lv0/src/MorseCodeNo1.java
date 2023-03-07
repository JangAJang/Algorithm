import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MorseCodeNo1 {
    // lv0. 모스 부호
    class Solution {

        private HashMap<String, String> morseDecoder = new HashMap<>();

        public String solution(String letter) {
            initializeMorse();
            return Arrays.stream(letter.split(" ")).map(s-> morseDecoder.get(s)).collect(Collectors.joining(""));
        }

        private void initializeMorse(){
            morseDecoder.put(".-", "a");
            morseDecoder.put("-...", "b");
            morseDecoder.put("-.-.", "c");
            morseDecoder.put("-..", "d");
            morseDecoder.put(".", "e");
            morseDecoder.put("..-.", "f");
            morseDecoder.put("--.", "g");
            morseDecoder.put("....", "h");
            morseDecoder.put("..", "i");
            morseDecoder.put(".---", "j");
            morseDecoder.put("-.-", "k");
            morseDecoder.put(".-..", "l");
            morseDecoder.put("--", "m");
            morseDecoder.put("-.", "n");
            morseDecoder.put("---", "o");
            morseDecoder.put(".--.", "p");
            morseDecoder.put("--.-", "q");
            morseDecoder.put(".-.", "r");
            morseDecoder.put("...", "s");
            morseDecoder.put("-", "t");
            morseDecoder.put("..-", "u");
            morseDecoder.put("...-", "v");
            morseDecoder.put(".--", "w");
            morseDecoder.put("-..-", "x");
            morseDecoder.put("-.--", "y");
            morseDecoder.put("--..", "z");
        }
    }
}
