package week13;

import java.util.*;

public class LongSubSequence {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int N = sc.nextInt();
    sc.nextLine();

    int[] arr = Arrays.asList(sc.nextLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int[] dp = new int[N];
    Arrays.fill(dp, 1);

    int result = dp[0];

    for (int i = 1; i < N; i++) {
      for (int j = 0; j <= i; j++) {
        if (arr[j] > arr[i] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
        }
      }

      if(dp[i] > result) result = dp[i];
      else continue;
    }

    System.out.println(result);
  }
}

