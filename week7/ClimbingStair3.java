package week7;

import java.util.Scanner;

public class ClimbingStair3 {

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

    int[] accumulateScore = new int[N];
    accumulateScore[0] = stairs[0];
    accumulateScore[1] = Math.max(stairs[0] + stairs[1], stairs[1]);
    accumulateScore[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

    int case1 = 0;  // 현재칸 + 전전칸 까지의 최대값
    int case2 = 0;  // 현재칸 + 전칸 + 전전전칸 까지의 최대값
    for (int i = 3; i < N; i++) {
      case1 = stairs[i] + accumulateScore[i - 2];
      case2 = stairs[i] + stairs[i - 1] + accumulateScore[i - 3];
      accumulateScore[i] = Math.max(case1, case2);
    }

    result = accumulateScore[N - 1];

    return result;
  }
}
