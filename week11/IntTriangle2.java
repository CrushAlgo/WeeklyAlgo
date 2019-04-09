package week11;

import java.util.Arrays;
import java.util.Scanner;

public class IntTriangle2 {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    sc.nextLine();

    int[][] stair = new int[n + 1][n + 1];

    int r = 0;

    for (int i = 1; i <= n; i++) {

      stair[i] = Arrays.asList(sc.nextLine().split(" "))
              .stream()
              .mapToInt(Integer::parseInt)
              .toArray();

      for (int j = 0; j < i; j++) {
        if(j == 0) {
          stair[i][j] += stair[i - 1][j];
        } else if (j == (i - 1)) {
          stair[i][j] += stair[i - 1][j - 1];
        } else {
          stair[i][j] += Math.max(stair[i - 1][j - 1], stair[i - 1][j]);
        }

        if(stair[i][j] > r) r = stair[i][j];
      }
    }

    System.out.println(r);
  }

  public static void main(String[] args) {
    new IntTriangle2().solve();
  }
}
