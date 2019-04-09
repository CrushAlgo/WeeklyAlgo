package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PipeMove2 {

  static class Point {
    int x, y;
    Direction d;

    public Point(int x, int y, Direction d) {
      this.x = x;
      this.y = y;
      this.d = d;
    }
  }

  static enum Direction {
    ROW, COLUMN, DIAGONAL
  }

  private static int[] X = {0, 1, 1};
  private static int[] Y = {1, 1, 0};

  private int solve() throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int result = 0;

    int n = Integer.parseInt(br.readLine());

    int[][] map = new int[n][n];
    for (int i = 0; i < n; i++) {
      map[i] = Arrays.asList(br.readLine().split(" "))
              .stream()
              .mapToInt(Integer::parseInt)
              .toArray();
    }

    Point point = new Point(0, 1, Direction.ROW);

    boolean[][] check = new boolean[n][n];

    Queue<Point> queue = new LinkedList<>();
    queue.add(point);

    check[point.x][point.y] = true;

    while (!queue.isEmpty()) {
      Point next = queue.poll();

      int x = next.x;
      int y = next.y;
      Direction DIRE = next.d;

      if (x == (n - 1) && y == (n - 1)) {
        result++;
        continue;
      }

      switch (DIRE) {

        case ROW:
          if (y != n - 1) {
            if (map[x + X[0]][y + Y[0]] == 0) {
              queue.add(new Point(x + X[0], y + Y[0], Direction.ROW));
              check[x + X[0]][y + Y[0]] = true;
            }
          }

          if (x < n - 1 && y < n - 1) {
            if(map[x + X[0]][y + Y[0]] == 0
                    && map[x + X[1]][y + Y[1]] == 0
                    && map[x + X[2]][y + Y[2]] == 0) {
              queue.add(new Point(x + X[1], y + Y[1], Direction.DIAGONAL));
              check[x + X[1]][y + Y[1]] = true;
            }
          }

          break;

        case DIAGONAL:
          if (y < n - 1) {
            if (map[x + X[0]][y + Y[0]] == 0) {
              queue.add(new Point(x + X[0], y + Y[0], Direction.ROW));
              check[x + X[0]][y + Y[0]] = true;
            }
          }

          if (x < n - 1) {
            if (map[x + X[2]][y + Y[2]] == 0) {
              queue.add(new Point(x + X[2], y + Y[2], Direction.COLUMN));
              check[x + X[2]][y + Y[2]] = true;
            }
          }

          if (x < n - 1 && y < n - 1) {
            if(map[x + X[0]][y + Y[0]] == 0
                    && map[x + X[1]][y + Y[1]] == 0
                    && map[x + X[2]][y + Y[2]] == 0) {
              queue.add(new Point(x + X[1], y + Y[1], Direction.DIAGONAL));
              check[x + X[1]][y + Y[1]] = true;
            }
          }

          break;

        case COLUMN:
          if (x < n - 1) {
            if (map[x + X[2]][y + Y[2]] == 0) {
              queue.add(new Point(x + X[2], y + Y[2], Direction.COLUMN));
              check[x + X[2]][y + Y[2]] = true;
            }

            if (x < n - 1 && y < n - 1) {
              if(map[x + X[0]][y + Y[0]] == 0
                      && map[x + X[1]][y + Y[1]] == 0
                      && map[x + X[2]][y + Y[2]] == 0) {
                queue.add(new Point(x + X[1], y + Y[1], Direction.DIAGONAL));
                check[x + X[1]][y + Y[1]] = true;
              }
            }

            break;
          }
      }

    }


    return result;
  }


  public static void main(String[] args) throws Exception{
    int r = new PipeMove2().solve();

    System.out.println(r);
  }
}
