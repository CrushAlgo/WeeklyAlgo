package week11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
6
0 0 0 0 0 0
0 1 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
 */

public class PipeMove {

  private static final Scanner sc = new Scanner(System.in);

  private int[] arrow = {2, 3, 4};  // 가로, 대각, 세로

  private void solve() {
    int n = sc.nextInt();
    sc.nextLine();

    int[][] map = new int[n][n];
    boolean[][] check = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(check[i], true);
      for (int j = 0; j < n; j++) {
        map[i][j] = sc.nextInt();
        if(map[i][j] == 1) check[i][j] = false;
      }
    }

    map[0][1] = arrow[0];  //now;

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 1});

    int count = 0;

    boolean f = false;
    while (!queue.isEmpty()) {
      f = false;

      int[] p = queue.poll();
      int x = p[0];
      int y = p[1];

      check[x][y] = false;

      if (x == n - 1 && y == n - 1) continue;

      int now = map[x][y];
      if (x == n - 1 || y == n - 1) continue;

      if (now == 2) {  // 가로: x + 1 / x+1, y+1
        if (check[x][y + 1]) {
          queue.add(new int[]{x, y + 1});
          map[x][y + 1] = arrow[0];

          f = true;
        }

        if (check[x + 1][y] && check[x + 1][y + 1] && check[x][y + 1]) {
          queue.add(new int[]{x + 1, y + 1});
          map[x + 1][y + 1] = arrow[1];

          f = true;
        }
      }

      if (now == 3) {  // 가로: x + 1 / x+1, y+1
        if (check[x + 1][y]) {
          queue.add(new int[]{x + 1, y});
          map[x + 1][y] = arrow[2];

          f = true;
        }

        if (check[x + 1][y + 1] && check[x + 1][y] && check[x][y + 1]) {
          queue.add(new int[]{x + 1, y + 1});
          map[x + 1][y + 1] = arrow[1];

          f = true;
        }

        if (check[x][y + 1]) {
          queue.add(new int[]{x, y + 1});
          map[x][y + 1] = arrow[0];

          f = true;
        }
      }

      if (now == 4) {
        if (check[x + 1][y]) {
          queue.add(new int[]{x + 1, y});
          map[x + 1][y] = arrow[2];

          f = true;
        }

        if (check[x + 1][y + 1] && check[x + 1][y] && check[x][y + 1]) {
          queue.add(new int[]{x + 1, y + 1});
          map[x + 1][y + 1] = arrow[1];

          f = true;
        }
      }

      if (f) count++;
    }

    System.out.println(count);
  }

  public static void main(String[] args) {
    new PipeMove().solve();
  }
}
