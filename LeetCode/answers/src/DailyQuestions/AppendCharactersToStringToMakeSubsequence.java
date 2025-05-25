import java.util.*;

class  AppendCharactersToStringToMakeSubsequence {

    public int appendCharacters(String s, String t) {
        int tIndex = 0;
        for(int index = 0; index < s.length(); index++) {
            if(tIndex < t.length() && s.charAt(index) == t.charAt(tIndex)) {
                tIndex++;
            }
        }
        return t.length() - tIndex;
    }
}
