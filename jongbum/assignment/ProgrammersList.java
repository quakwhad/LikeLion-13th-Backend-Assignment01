package assignment;

import java.util.ArrayList;
import java.util.Scanner;

// 프로그래머스 문제에 제출할 답에 해당하는 클래스
class Solution {
    // 1 <= n <= 4 / slicer.length = 3 / 5 <= num_list.length <= 30
    // slicer[0] = a, slicer[1] = b, slicer[2] = c
    public int[] solution(int n, int[] slicer, int[] num_list) {
        // num_list의 크기는 문제 조건에 따라 가변적이기 때문에
        // num_list가 어떤 배열인지에 관계없이
        // num_list의 크기를 맞춰줄 수 있는 배열 리스트 선언
        ArrayList<Integer> answerList = new ArrayList<>();

        // n == 1일 때, num_list의 처음부터 b+1번째 인덱스까지 복사
        if(n == 1) {
            // i는 0부터 b까지, 1만큼 증가
            for(int i = 0; i <= slicer[1]; i++) {
                // 배열 리스트에 num_list[i] 삽입
                answerList.add(num_list[i]);
            }
        }

        // n == 2일 때, num_list의 a+1번째부터 마지막 인덱스까지 복사
        else if(n == 2) {
            // i는 a부터 num_list.length-1까지, 1만큼 증가
            for(int i = slicer[0]; i < num_list.length; i++) {
                // 배열 리스트에 num_list[i] 삽입
                answerList.add(num_list[i]);
            }
        }

        // n == 2일 때, num_list의 a+1번째부터 b+1번째 인덱스까지 복사
        else if(n == 3) {
            // i는 a부터 b까지, 1만큼 증가
            for(int i = slicer[0]; i <= slicer[1]; i++) {
                // 배열 리스트에 num_list[i] 삽입
                answerList.add(num_list[i]);
            }
        }
        // n의 범위가 1 이상 4 이하의 정수이므로 마지막으로 남은 경우는 n == 4
        // n == 4일 때, a+1번째부터 b+1번째 인덱스까지 c 간격으로 복사
        else {
            // i는 a부터 b까지, c만큼 증가
            for(int i = slicer[0]; i <= slicer[1]; i+=slicer[2]) {
                // 배열 리스트에 num_list[i] 삽입
                answerList.add(num_list[i]);
            }
        }

        // 지금까지 배열 리스트에 배열을 복사했습니다.
        // 하지만 이 문제의 리턴 형식은 배열이기 때문에 배열 리스트를 배열로 바꿔서 리턴해야 합니다.
        // 리턴해줄 배열 선언 및 배열 리스트를 배열로 바꾼 후 삽입
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

public class ProgrammersList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n 선언 및 입력
        int n = sc.nextInt();

        // slicer 선언, slicer의 크기는 3으로 고정이기 때문에 배열로 선언했습니다.
        int[] slicer = new int[3];
        // slicer 입력
        for(int i = 0; i < 3; i++)
            slicer[i] = sc.nextInt();


        // 크기가 9인 num_list 선언, testcase가 [1,2,3,4,5,6,7,8,9]라서 9로 선언했습니다.
        int[] num_list = new int[9];

        // num_list 입력
        for(int i = 0; i < num_list.length; i++) {
            // num_list에 값 입력
            num_list[i] = sc.nextInt();
        }

        // Solution 클래스를 사용하기위해 sol 선언
        Solution sol = new Solution();
        // Solution 클래스의 solution 메서드 사용
        int[] answer = sol.solution(n, slicer, num_list);

        // for-each문을 사용해 결과 출력
        for(int i : answer) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}