package week7;

import java.util.Arrays;
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

    System.out.println(solution(stairs));
  }

  /**
   * 현재 서 있는 칸까지의 최대 값을 생각해 봤을 때, 두가지 경우의 수가 발생한다.
   * 1. 전칸을 밝고 현재 칸을 밟는 경우.
   * 2. 전전 칸을 밟고 현재 칸을 밟는 경우.
   * <p>
   * 근데, 세 칸을 연속으로 밟을 수 없기 때문에, '1'의 경우 조건을 추가해 줘야한다.
   * 세 칸을 연속으로 밟지 않으려면, 현재칸, 전칸, 전전전칸을 밟아야한다. (cf, 전전칸, 이걸 밟으면 안됨)
   * 따라서, 위의 '1'의 경우에 조건을 추가한다.
   * <p>
   * 1. '전전전칸을 밟고' + 전칸을 밟고 현재 칸을 밟는 경우.
   *
   * @param stairs
   * @return
   */
  public static int solution(int[] stairs) {
    int result = 0;

    int[] DP = Arrays.copyOf(stairs, stairs.length);

    for (int i = 0; i < stairs.length; i++) {
      int case1 = stairs[i], case2 = stairs[i];
      if (i - 1 >= 0) {
        case1 += DP[i - 2];
        case2 += stairs[i - 1];
        if (i - 3 >= 0) case2 += DP[i - 3];
      }

      DP[i] = Math.max(case1, case2);
      result = DP[i];
    }

    return result;
  }
}
