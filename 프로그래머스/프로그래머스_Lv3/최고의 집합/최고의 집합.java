class Solution {
    public int[] solution(int n, int s) {
        int[] array = new int[n];
        if(s/n == 0) {
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        for(int index = 0; index < n; index ++) {
            array[index] = s/n;
        }
        int left = s % n;
        int index = n - 1;
        while (left > 0) {
        array[index]++;
        index = (index - 1 + n) % n;
        left--;
        }
        return array;
    }
}