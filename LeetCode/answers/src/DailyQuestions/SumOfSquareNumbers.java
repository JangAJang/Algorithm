package DailyQuestions;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int)Math.sqrt(c);

        int[] arr = new int[end+1];

        for(int index = 0; index < arr.length; index++) {
            arr[index] = index * index;
        }

        // 배열의 값을 이용한 투포인터를 구현해야한다.
        // arr[start] + arr[end]의 값을 보고, 작다면 start가 증가하고, 크다면 end가 감소한다.
        // start <= end인 동안 반복시켜보자.
        // 반복이 너무 많다.
        // mid를 이용해 연산해야 한다.
        // mid를 어떻게 적용할까?
        // arr[mid]*2를 이용해 mid를 이동시킨다?
        while(start <= end) {
            long value = c -  arr[end];
            System.out.println(value);

            if(arr[start] == value) return true;

            if(arr[start] < value) {
                start++;
                continue;
            }

            end--;
            continue;
        }

        return false;
    }
}
