package assignment;
import java.util.Scanner;

public class BOJ2439 {
    /*
    2439번 : 별 찍기 - 2
    정숫값을 입력받고 n에 저장
    n-1번 공백 출력, 1번 별 출력, 줄 바꾸기
    n-2번 공백 출력, 2번 별 출력, 줄 바꾸기
    .
    .
    .
    n-n번 공백 출력, n번 별 출력, 줄 바꾸기
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // i는 1부터 n까지 n번 실행
        for(int i = 1; i <= n; i++) {
            // (n - i)번 실행
            for(int j = n-i; j >= 1; j--) {
                // 공백 출력
                System.out.print(' ');
            }

            // i번 실행
            for(int j = 1; j <= i; j++) {
                // 별 출력
                System.out.print('*');
            }

            // 줄 바꾸기
            System.out.println();
        }
        sc.close();
    }
}
