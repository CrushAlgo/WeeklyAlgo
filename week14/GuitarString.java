package week14;

import java.util.Scanner;

/*
성공

끊어진 기타 줄 N 과 기타줄 브랜드 M 개 가 주어진다.
 */
public class GuitarString {

  private static final Scanner scan = new Scanner(System.in);

  public void solve(int N, int M, int[][] brand) {
    int result = 0;

    int minSet = Integer.MAX_VALUE;
    int minUnit = Integer.MAX_VALUE;

    for (int i = 0; i < M; i++) {
      int set = brand[i][0];
      int unit = brand[i][1];

      minSet = (set < minSet) ? set : minSet;
      minUnit = (unit < minUnit) ? unit : minUnit;
    }

    int six = (N / 6);
    int one = (N % 6);

    int temp1 = 0;  // set + unit
    int temp2 = 0;  // unit
    int temp3 = 0;  // set (N > 6)


    temp1 = (six * minSet) + (one * minUnit);
    temp2 = (N * minUnit);
    temp3 = (N > 6) ? ((six + 1) * minSet) : minSet;

    result = (temp1 > temp2) ?
            ((temp2 > temp3) ? temp3 : temp2) :
            ((temp1 > temp3) ? temp3 : temp1);

    System.out.println(result);
  }

  public static void main(String[] args) {
    int N = scan.nextInt();
    int M = scan.nextInt();
    scan.nextLine();

    int[][] brand = new int[M][2];

    for (int i = 0; i < M; i++) {
      brand[i][0] = scan.nextInt();
      brand[i][1] = scan.nextInt();
    }

    new GuitarString().solve(N, M, brand);
  }
}
