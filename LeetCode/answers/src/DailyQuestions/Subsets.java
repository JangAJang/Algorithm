package DailyQuestions;

import java.util.*;

public class Subsets {

    private Map<Integer, List<Integer>> map;

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        map = new HashMap<>();
        // 2의 제곱마다 요소 1개짜리 데이터 추가
        map.put(0, new ArrayList<>());
        for(int index = 0; index < nums.length; index++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[index]);
            map.put((int)Math.pow(2, index), list);
        }

        //Map을 이용한 데이터 추가
        for(int index = 0; index < Math.pow(2, nums.length); index++) {
            if(map.containsKey(index)) {
                answer.add(map.get(index));
                continue;
            }

            int suffix = findMaxPowerOfTwo(index);
            int prefix = index - suffix;
            List<Integer> list = new ArrayList<>();
            list.addAll(map.get(prefix));
            list.addAll(map.get(suffix));
            map.put(index, list);
            answer.add(list);
        }
        return answer;
    }

    private int findMaxPowerOfTwo(int value) {
        value |= value >> 1;
        value |= value >> 2;
        value |= value >> 4;
        value |= value >> 8;
        value |= value >> 16;
        return (value + 1) >> 1;
    }

    // 순회를 줄이는 방법
    // Map?
    // 0일 땐 빈 리스트
    // 1일 땐 0번 인덱스만
    // 2일 땐 1번 인덱스만
    // 3번일 땐? => 1, 2을 합친다.
    // 4번일 땐? => 3번을 넣는다.
    // 5번일 땐? => 1, 4
    // 6 => 2, 4
    // 5, 6을 어떻게 만들까? => 최대 2진수값을 찾는다. 4, 4를 뺀다. 뺀 놈의 값을 넣어준다.
    // dp처럼 가능할까?
}
