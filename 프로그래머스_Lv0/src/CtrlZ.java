public class CtrlZ {
    // lv0. 컨트롤 제트
    class Solution {
        public int solution(String s) {
            String[] split = s.split(" ");
            int result = 0;
            for(int index = 0; index < split.length; index++){
                if(split[index].equals("Z")) {
                    result -= Integer.parseInt(split[index - 1]);
                    continue;
                }
                result += Integer.parseInt(split[index]);
            }
            return result;
        }
    }
}
