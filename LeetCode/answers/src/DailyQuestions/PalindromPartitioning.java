package DailyQuestions;
import java.util.*;

public class PalindromPartitioning {

    private Map<String, Boolean> map;
    private List<List<String>> answer;

    public List<List<String>> partition(String s) {
        map = new HashMap<>();
        answer = new ArrayList<>();
        backTrackSubstring(s.split(""), new ArrayList<>(), 0);
        return answer;
    }

    private void backTrackSubstring(String[] arr,
                                    List<String> sequenceResult,
                                    int start)
    {
        if(start == arr.length) {
            if(String.join("", sequenceResult).length() == arr.length) {
                answer.add(new ArrayList<>(sequenceResult));
            }
            return;
        }

        String text = "";
        for(int index = start; index < arr.length; index++) {
            text += arr[index];
            if(isPalindrom(text)) sequenceResult.add(text);
            backTrackSubstring(arr, sequenceResult, index+1);
            if(isPalindrom(text)) sequenceResult.remove(sequenceResult.size()-1);
        }
    }

    private boolean isPalindrom(final String text) {
        if(map.containsKey(text))
            return map.get(text);

        if(text.length() == 1) {
            map.put(text, true);
            return true;
        }

        int length = text.length();
        for(int index = 0; index < length/2; index++) {
            if(text.charAt(index) != text.charAt(length - 1 - index)) {
                map.put(text, false);
                return false;
            }
        }
        map.put(text, true);
        return true;
    }
}

// DP가 아닌 백트래킹부터 생각해보자. 나중에 어떻게 DP로 바꿀지 생각해보자.
// a, a, a, b라는 discussion 예시로 만들어보자.
// a -> a -> a -> b로 들어간다. b에서 answer에 추가하고 재귀를 벗어난다.
// a -> a -> ab로 들어간다. 이전에서 길이를 늘려서 체크한다. 팰린드롬이 아니다. 재귀 끝
// a -> aa -> b로 들어간다. 팰린드롬이다. 체크해준다.
// a -> aab 아니다.
// aa -> a -> b로 들어간다. 팰린드롬이다.
// 이런식으로 체크해주면 될 것 같다. 하지만 각 문자열이 팰린드롬인지 기존에 체크한 것을 다시 체크하는 소요를 줄이고 싶다. 이제 진짜 Map을 써보자.
