package week11;

import java.util.Scanner;

public class IntTriangle {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();

    int r = 0;

    int[] a;
    int[] b = new int[500];

    int p = 0;

    for (int i = 1; i <= n; i++) {
      a = new int[i];

      int m = 0;

      for (int j = 0; j < i; j++) {
        a[j] = sc.nextInt();
      }

      // (0,1), (2,3), (4,5)
      for (int k = 0; k < i; k++) {

        if (k == 0) b[k] += a[k];
        else {

        }

      }

      for (int h = 0; h < i; h++) {
        System.out.print(b[h] + " ");
      }
      System.out.println();

//      r += m;

    }

//    System.out.println(r);
  }

  public static void main(String[] args) {
    new IntTriangle().solve();
  }
}
