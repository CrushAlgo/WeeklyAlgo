package week8;

import java.util.Scanner;

/*
이차원 배열에 정보들을 표시해서 계산 한다.
 */
public class Resignation {

  public static void main(String[] args) {
    int N;
    int[][] input;

    try (Scanner scan = new Scanner(System.in)) {
      N = scan.nextInt();
      scan.nextLine();

      input = new int[2][N];
      for (int i = 0; i < N; i++) {
        String[] tp = scan.nextLine().split(" ");

        input[0][i] = Integer.parseInt(tp[0]);
        input[1][i] = Integer.parseInt(tp[1]);
      }
    }

    System.out.println(solution(N, input));
  }

  public static int solution(int N, int[][] inputArr) {
    int result = 0;

    int[] period = inputArr[0];
    int[] price = inputArr[1];

    int periodSum = 0;
    int priceSum = 0;

    for (int i = 0; i < N; i++) {   //고정
      int start = period[i];  //인덱스
      periodSum += start;
      priceSum += price[i];

      System.out.format("start: %d \n", i);

      for (int k = start; k < N; k++) { //첫번째 날을 거친 후 인덱스 부터 계산
        System.out.print(k + " : ");
        for (int j = k + i; j < N; j += period[j]) {
          System.out.print(j + " ");

          periodSum += period[j];
          priceSum += price[j];

          if(periodSum >= N) {
            if(periodSum > N ) priceSum -= price[j];

            if(priceSum > result) result = priceSum;

            System.out.print(" / " + result);

            break;
          }
        }
        priceSum = price[i];
        periodSum = start;

        System.out.println();
      }
    }

    return result;
  }
}
