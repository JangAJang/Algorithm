package DailyQuestions;

public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        Map<String, Integer> atomCounts = parseFormula(formula);
        // 원소 이름을 알파벳 순으로 정렬
        List<String> elements = new ArrayList<>(atomCounts.keySet());
        Collections.sort(elements);

        // 결과 문자열을 생성
        StringBuilder result = new StringBuilder();
        for (String element : elements) {
            result.append(element);
            int count = atomCounts.get(element);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }

    private Map<String, Integer> parseFormula(String formula) {
        Map<String, Integer> atomCounts = new HashMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        int n = formula.length();
        int i = 0;

        while (i < n) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                // 괄호 시작: 현재 맵을 스택에 푸시
                stack.push(atomCounts);
                atomCounts = new HashMap<>();
                i++;
            } else if (ch == ')') {
                // 괄호 끝: 스택에서 맵을 꺼내서 곱셈 적용
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                if (!stack.isEmpty()) {
                    Map<String, Integer> top = atomCounts;
                    atomCounts = stack.pop();
                    for (Map.Entry<String, Integer> entry : top.entrySet()) {
                        atomCounts.put(entry.getKey(), atomCounts.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplicity);
                    }
                }
            } else {
                // 원소 파싱
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);

                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int count = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;

                atomCounts.put(element, atomCounts.getOrDefault(element, 0) + count);
            }
        }

        return atomCounts;
    }
}
