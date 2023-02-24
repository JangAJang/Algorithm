class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int index;
        int move = length - 1;
        for(int position = 0; position < name.length(); position++){
            answer += countToChangeChar(name.charAt(position));
            index = position + 1;
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }
            move = Math.min(Math.min(move, position * 2 + length - index), (length - index) * 2 + position);
        }
        return answer + move;
    }

    private int countToChangeChar(char c){
        return Math.min(stickUp(c), stickDown(c));
    }

    private int stickUp(char c){
        return c - 'A';
    }

    private int stickDown(char c){
        return 'Z' - c + 1;
    }
}