package week12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark2 {

  static class Shark {
    int x, y;
    private int eat = 0;
    private int level = 2;
    private int dist = 0;

    private void initialize(int x, int y) {
      this.x = x;
      this.y = y;
    }

    private void eat() {
      this.eat++;

      if (this.level == this.eat) {
        this.level++;
        this.eat = 0;
      }
    }

    private int getLevel() {
      return this.level;
    }

    public int getDist() {
      return dist;
    }

    public void setDist(int dist) {
      this.dist += dist;
    }
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static final Scanner sc = new Scanner(System.in);

  public static int[] X = {-1, 0, 1, 0};
  public static int[] Y = {0, -1, 0, 1};

  private void solve() {
    int N = sc.nextInt();

    Shark shark = new Shark();

    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int input = sc.nextInt();

        if (input == 9) {
          shark.initialize(i, j);
          input = 0;
        }

        map[i][j] = input;
      }
    }

    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(shark.x, shark.y));

    int queSize = queue.size();

    boolean[][] check = new boolean[N][N];
    check[shark.x][shark.y] = true;

    boolean flag = false;

    int dist = 0;
    while (!queue.isEmpty()) {
      flag = false;

      for(int i = 0; i < queSize; i++) {
        Point temp = queue.poll();

        int x = temp.x;
        int y = temp.y;

        int point = map[x][y];

        if (point > 0 && point < shark.getLevel()) {
          shark.eat();
          shark.setDist(dist);
          map[x][y] = 0;

          dist = 0;

          for (int j = 0; j < N; j++) Arrays.fill(check[j], false);

          System.out.format("x: %d, y: %d, level: %d \n", x, y, shark.getLevel());

          queue = new LinkedList<>();
          queue.add(new Point(x, y));

          continue;
        }

        for(int k = 0; k < 4; k++) {
          int xp = x + X[k];
          int yp = y + Y[k];

          if(xp < 0 || xp >= N || yp < 0|| yp >= N) break;

          if(map[xp][yp] <= shark.getLevel() && !check[xp][yp]) {
            queue.add(new Point(xp, yp));
            check[xp][yp] = true;

            flag = true;
          }
        }

      }

      queSize = queue.size();
      dist++;
    }

    System.out.println(shark.getDist());
  }

  public static void main(String[] args) {
    new BabyShark2().solve();
  }
}
