import java.util.Arrays;
import java.util.Scanner;

public class HarfWaveNumber {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int tc = sc.nextInt();

    long[] r = new long[tc];

    for (int i = 0; i < tc; i++) {
      int n = sc.nextInt();

      long[] a;

      if (n <= 5) {

        a = new long[]{1, 1, 1, 2, 2};

      } else {

        a = new long[n];

        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        a[4] = 2;

        // k = (k[i - 5] + (k - 1))
        for (int j = 5; j < n; j++) {
          a[j] = (a[j - 5] + a[j - 1]);
        }

      }

      r[i] = a[n - 1];
    }

    for(long i : r) {
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    new HarfWaveNumber().solve();
  }

}
