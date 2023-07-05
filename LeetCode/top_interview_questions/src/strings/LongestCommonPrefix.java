package strings;

import java.util.*;

public class LongestCommonPrefix {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            Arrays.sort(strs, Comparator.comparingInt(String::length));
            for(char each : strs[0].toCharArray()) {
                sb.append(each);
                for(String str : strs) {
                    if(!str.substring(0, sb.length()).equals(sb.toString())){
                        return sb.toString().substring(0, sb.length()-1);
                    }

                }
            }

            return sb.toString();
        }
    }
}
