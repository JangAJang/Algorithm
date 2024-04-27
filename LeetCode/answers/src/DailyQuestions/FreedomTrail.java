package DailyQuestions;

public class FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, 0, new Integer[ring.length()][key.length()]);
    }

    private int dfs(String ring, String key, int ringIndex, int keyIndex, Integer[][] memo) {
        if (keyIndex == key.length()) return 0; // 모든 키를 스펠링 한 경우

        if (memo[ringIndex][keyIndex] != null) return memo[ringIndex][keyIndex]; // 메모이제이션

        char targetChar = key.charAt(keyIndex);
        int minSteps = Integer.MAX_VALUE;

        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) == targetChar) {
                int clockWise = Math.abs(i - ringIndex); // 시계 방향 회전 횟수
                int counterClockWise = ring.length() - clockWise; // 반시계 방향 회전 횟수

                int stepsToAlign = Math.min(clockWise, counterClockWise) + 1; // 회전을 통해 문자를 12:00 방향에 맞추는 횟수
                int stepsAfterAlign = dfs(ring, key, i, keyIndex + 1, memo); // 중앙 버튼을 누르기 위해 추가로 필요한 회전 횟수

                minSteps = Math.min(minSteps, stepsToAlign + stepsAfterAlign); // 최소 회전 횟수 갱신
            }
        }

        memo[ringIndex][keyIndex] = minSteps; // 최소 회전 횟수 메모이제이션
        return minSteps;
    }
}
