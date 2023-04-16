import java.util.*;

import static java.lang.Integer.MAX_VALUE;

class Solution {

    public int solution(int x, int y, int n) {
        int[] D = new int[y + 1];
        for (int i = x + 1; i <= y; i++) {
            int a = i / 2 > 0 && i % 2 == 0 && x <= i / 2 ? D[i / 2] : MAX_VALUE;
            int b = i / 3 > 0 && i % 3 == 0 && x <= i / 3 ? D[i / 3] : MAX_VALUE;
            int c = x <= i - n ? D[i - n] : MAX_VALUE;
            int d = Math.min(a, Math.min(b, c));
            D[i] = d < MAX_VALUE ? d + 1 : MAX_VALUE;
        }
        return D[y] < MAX_VALUE ? D[y] : -1;
    }
}