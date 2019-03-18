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

    System.out.println(solution2(N, input));
  }

  /*
  마지막 날에 대한 정보가 확실해야 된다.
  period 를 합해서 오다가, 마지막 인덱스 혹은, 마지막 날에 합산.

  idx : 0 1 2 3 4 5 6
  날짜 : 1 2 3 4 5 6 7
  기간 : 3 5 1 1 2 4 2

  start : 0 / date : 1 / period : 3
  idx1 : 0 + period = 3 / date : 4 / period : 1
  idx2 : idx1 + period = 4 / date : 5 / period : 2
  idx3 : idx2 + period = 6 / date : 7 / period : 2  // 불가능, 왜냐하면 '기간'이 날짜를 넘어선다. 'date + period = N + 1'  이 마지노선
   */

  public static int solution2(int N, int[][] inputArr) {
    int result = 0;

    int[] periodArr = inputArr[0];
    int[] priceArr = inputArr[1];

    int start = 0, next1 = 0, next2 = 0, date = 0, period = 0;
    int priceSum = 0;

    for (int i = 0; i < N; i++) {
      start = i;
      period = periodArr[i];
      priceSum = priceArr[i];

      next1 = start + period;  // 다음 인덱스
      for (int j = i + 1; j < N; j++) {
        if (period + periodArr[j] > N + 1) break;
        else {
          if ((j + 1) + periodArr[j] <= N + 1) {
            priceSum = priceArr[i] + priceArr[j];
            next2 = j + periodArr[j];
          } else break;
        }
        for (int k = next2; k < N; k++) {
          date = k + 1;
          if (date + periodArr[k] <= N + 1) {
            priceSum += priceArr[k];
          } else break;
        }

        if (priceSum > result) result = priceSum;
      }
      System.out.println(result);
    }

    return result;
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

          if (periodSum >= N) {
            if (periodSum > N) priceSum -= price[j];

            if (priceSum > result) result = priceSum;

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
