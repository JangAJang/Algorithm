package DailyQuestions;

import java.util.*;

public class SubarraysSumsDivisibleByK {
    
    public int subarraysDivByK(int[] nums, int k) {
        Tree segmentTree = Tree.createSegment(nums, 0, nums.length - 1);
        int count = countSubarraysDivisibleByK(nums, k, segmentTree);
        return count;
    }

    private int countSubarraysDivisibleByK(int[] nums, int k, Tree segmentTree) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumModKCount = new HashMap<>();
        prefixSumModKCount.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            int mod = ((prefixSum % k) + k) % k;
            count += prefixSumModKCount.getOrDefault(mod, 0);
            prefixSumModKCount.put(mod, prefixSumModKCount.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}

class Tree {
    private int start;
    private int end;
    private int sum;

    private Tree left;
    private Tree right;

    public Tree(int start, int end, int sum, Tree left, Tree right) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    public static Tree createSegment(int[] arr, int start, int end) {
        if (start == end) return new Tree(start, end, arr[start], null, null);

        int mid = (start + end) / 2;
        Tree left = Tree.createSegment(arr, start, mid);
        Tree right = Tree.createSegment(arr, mid + 1, end);
        int sum = left.sum + right.sum;

        return new Tree(start, end, sum, left, right);
    }

    public int rangeSum(int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l <= start && r >= end) {
            return sum;
        }
        return (left != null ? left.rangeSum(l, r) : 0) +
                (right != null ? right.rangeSum(l, r) : 0);
    }
}


// 2차원 배열을 사용했을 때 문제가 있었다.
// 시간 초과가 나온다.
// 확실히 최대 3만개의 경우의 수가 있을 때, 이를 2차원 배열로 돌리는 것은 효율적이지 못하다.
// 그렇다면 다른 방법은 무엇이 있을까?
// 맵을 사용하는 방법도 있다.
// 세그먼트 트리를 쓰면 어떨까?
// 세그먼트 트리의 방식을 생각해보자.
// 반씩 나누어 각 반의 합을 담는다.
// 합의 반을 통해서 %k == 0인 count를 세면 어떨까?
