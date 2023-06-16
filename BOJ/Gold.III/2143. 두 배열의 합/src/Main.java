import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.Arrays.stream;

class Main {
    static int[] A,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        A = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        B = stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        //초기화


        //부배열 쌍
        ArrayList<Integer> accumA = new ArrayList<>();
        ArrayList<Integer> accumB = new ArrayList<>();


        //부배열 구하기
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += A[j];
                accumA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                accumB.add(sum);
            }
        }

        //부배열 정렬
        Collections.sort(accumA);
        Collections.sort(accumB);


        //이중배열 투포인터
        int aSize = accumA.size();
        int bSize = accumB.size();

        //왼쪽은 왼쪽부터, 오른쪽은 오른쪽부터 배열을 진행한다.
        long cnt = 0;
        int leftPointer = 0;
        int rightPointer = accumB.size() - 1;

        //정렬을 했기 때문에, 왼쪽 + 오른쪽 합이 크면 오른쪽에서 <- , 작으면 왼쪽에서 -> 으로 가서 크기를 비교한다.
        while (leftPointer < aSize && rightPointer >= 0) {
            int sum = accumA.get(leftPointer) + accumB.get(rightPointer);

            //같을시에 정렬을 했기 때문에 같은 수는 일렬로 쭈르륵 있을것이다.
            //그럼 연속된 같은 수는 묶어서 A배열의 개수 * B 배열의 개수 를 더해 counting 해준다.
            //ex A[1,1,1,2,3,4], B[1,3,3,4] 일 경우, 합 4를 찾으면
            //ACnt = 연속된 1이 3개 = 3, BCnt = 연속된 3이 2개 = 2
            //Cnt += 3*2 (6가지 경우가 나오므로)
            if (sum == T) {

                int a = accumA.get(leftPointer);
                int b = accumB.get(rightPointer);
                long leftCnt = 0;
                long rightCnt = 0;

                while(leftPointer < aSize && accumA.get(leftPointer) == a){
                    leftCnt++;
                    leftPointer++;
                }
                while(rightPointer >= 0 && accumB.get(rightPointer) == b){
                    rightCnt++;
                    rightPointer--;
                }
                cnt += leftCnt * rightCnt;
                //작으면 -> 가서 크기를 키운다
            } else if (sum < T) {
                leftPointer++;
                //크면 <- 가서 크기를 줄인다.
            } else if (sum > T) {
                rightPointer--;
            }
        }


        System.out.println(cnt);


    }

}