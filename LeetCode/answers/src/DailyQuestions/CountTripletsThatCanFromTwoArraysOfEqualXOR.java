package DailyQuestions;

public class CountTripletsThatCanFromTwoArraysOfEqualXOR {

    public int countTriplets(int[] arr) {
        int count = 0;
        for(int from = 0; from < arr.length-1; from++) {
            int xorValue = arr[from];
            for(int to = from+1; to < arr.length; to++) {
                xorValue ^= arr[to];
                if(xorValue == 0) {
                    count += to - from;
                }
            }
        }
        return count;
    }
}

// XOR의 특성 x ^ x = 0, x ^ 0 = x
// 이걸 이용할 수 있다.
// i^(i+1)^(i+2)...k = i^...(j-1) ^ j^...k
// 그리고 i~(j-1) = a, j~k = b일 때, a ^ b = 0이다.
// 그러면 i^(i+1)^...^k = 0인 i와 k를 구하고 그 속에서 j가 몇개인지 찾아보자.
// 어떻게 j를 찾을 수 있을까?
// 하나도 XOR를 하지 않으면 0, 전체를 XOR하면 0이다.

// 그러면 1~n까지를 XOR한 값을 x라고 할 때, 2~n을 XOR한 값은 얼마일까? x ^ 1이다.
// 1 ^ 2 ^ 2를 하면 1 ^ ( 2 ^ 2)에서 2가 소거된다.
// 그래서 위의 방식으로 XOR연산으로 제거할 수 있다.

// 위의 설명이 왜 있냐, 전체를 XOR한 값 0에서 i+1번째를 XOR하면 0 ^ (i+1)이다.
// 첫 번째꺼만 XOR 하면 0 ^ (i+1)이다.
// 즉, j는 셀 필요 없다. i, k의 배열 전체 길이 - 1해주면 된다.
// Example1을 보면 이해가 될 것이다. 0~2가 i, k일 때 j는 1, 2가 가능하다. (전체 길이 3 - 1)
// 그냥 k-i값만큼 누적시켜주면 된다. 
