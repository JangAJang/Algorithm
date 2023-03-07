public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = solution.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        String b = solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        String c = solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}