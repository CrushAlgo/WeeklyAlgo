package week12;

import java.util.Scanner;

public class RabbitMove {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int N = sc.nextInt();
    int K = sc.nextInt();
    sc.nextLine();

    String comm = sc.nextLine();

    sc.close();

    int[][] map = new int[N][N];

    int num = 1;
    for (int i = 0; i < N; i++) {
      if ((i % 2) == 0) {
        int col = 0;

        for (int row = i; row >= 0; row--, col++) {
          if (map[row][col] == 0) map[row][col] = num++;
        }

      } else {
        int row = 0;

        for (int col = i; col >= 0; col--, row++) {
          if (map[row][col] == 0) map[row][col] = num++;
        }
      }
    }

    num = (N * N);
    for (int i = 0; i < (N - 1); i++) {
      if ((i % 2) == 0) {
        int col = N - 1;

        for (int row = (N - i - 1); row < N; row++, col--) {
          if (map[row][col] == 0) map[row][col] = num--;
        }

      } else {
        int row = N - 1;

        for (int col = (N - i - 1); col < N; col++, row--) {
          if (map[row][col] == 0) map[row][col] = num--;
        }
      }
    }

    int row = 0;
    int col = 0;
    int result = 1;

    for (int i = 0; i < comm.length(); i++) {
      char c = comm.charAt(i);

      switch (c) {
        case 'R':
          result += map[row][++col];
          break;
        case 'D':
          result += map[++row][col];
          break;
        case 'L':
          result += map[row][--col];
          break;
        case 'U':
          result += map[--row][col];
          break;
      }
    }

    System.out.println(result);

  }
}
