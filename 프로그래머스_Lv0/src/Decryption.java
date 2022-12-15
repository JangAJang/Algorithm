public class Decryption {
    //lv0. 암호 해독
    class Solution {
        public String solution(String cipher, int code) {
            StringBuilder stringBuilder = new StringBuilder();
            for(int index = code-1; index < cipher.length(); index += code){
                stringBuilder.append(cipher.charAt(index));
            }
            return stringBuilder.toString();
        }
    }
}
