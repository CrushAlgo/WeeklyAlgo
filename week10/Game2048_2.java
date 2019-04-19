package week10;

import java.util.Arrays;
import java.util.Scanner;

/*
3
2 0 0
2 0 0
0 0 0

3
2 0 0
2 0 0
4 0 0

4
2 0 0 0
2 0 0 2
4 0 2 0
4 2 0 0

 */
public class Game2048_2 {

  enum Direction {
    UP, DOWN, LEFT, RIGHT
  }

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    sc.nextLine();

    int[][] map = new int[n][n];
    for (int i = 0; i < n; i++) {
      map[i] = Arrays.asList(sc.nextLine().split(" "))
              .stream()
              .mapToInt(Integer::parseInt)
              .toArray();
    }

    System.out.println("original map");
    view(map);

    System.out.println();

    System.out.println("up");
    map = move(map, n, Direction.UP);
    view(map);
  }

  private int[][] move(int[][] map, int n, Direction DIRE) {

    if (DIRE.equals(Direction.UP) || DIRE.equals(Direction.LEFT)) {
      for (int col = 0; col < n; col++) {
        int row = 0;

        while (row < (n - 1)) {
          int v1 = map[row][col];
          int v2 = map[row + 1][col];

          if (v1 == 0) continue;

          if (v1 == v2) {
            map[row][col] = (v1 * 2);
            map[row + 1][col] = 0;

            while (row > 0) {

            }

          }

          row++;
        }
      }
    }

    return map;
  }

  private void view(int[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    new Game2048_2().solve();
  }
}
