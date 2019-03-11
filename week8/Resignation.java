package week8;

import java.util.Scanner;

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

    solution(N, input);
  }

  public static int solution(int N, int[][] inputArr) {
    int result = 0;

    int[] period = inputArr[0];
    int[] price = inputArr[1];

    for (int i = 0; i < N; i++) {
      int start = period[i];
      System.out.format("start: %d", i);
      for (int j = start + i; j < N; j += period[j]) {
        System.out.format(" %d", j);
      }
      System.out.println();
    }

    return result;
  }
}
