package week7;

import java.util.Scanner;

public class ClimbingStair2 {

  public static void main(String[] args) {
    int N;
    int[] stairs;

    try (Scanner scan = new Scanner(System.in)) {
      N = scan.nextInt();
      scan.nextLine();

      stairs = new int[N];
      for (int i = 0; i < N; i++) {
        stairs[i] = scan.nextInt();
        scan.nextLine();
      }
    }

    System.out.println(solution(N, stairs));
  }

  public static int solution(int N, int[] stairs) {
    int result = 0;

    int[] DP = new int[N];

    for (int i = 0; i < N; i++) {
      //case1: 현재칸 값 + 전칸 값 + 전전전칸 까지의 최대값, case2: 현재칸 값 + 전전칸 값 까지의 최대값.
      int case1 = stairs[i], case2 = stairs[i];

      //i = 1 일 때, 현재칸 vs 현재칸 + 전칸, 당연히 후자가 크다.
      if ((i - 1) >= 0) {
        case1 += stairs[i - 1];
        if ((i - 2) >= 0) case2 += DP[i - 2];
        if ((i - 3) >= 0) case1 += DP[i - 3];
      }

      //i = 0 일 때, 일단 넣어여 한다.
      DP[i] = Math.max(case1, case2);

      result = DP[i];
    }

    return result;
  }
}
