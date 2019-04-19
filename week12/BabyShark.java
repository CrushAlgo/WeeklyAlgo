package week12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark {

  static class Shark {
    int x, y;
    int eat;

    private int level = 2;

    public Shark(int x, int y) {
      this.x = x;
      this.y = y;
    }

    private void setX(int x) {
      this.x = x;
    }

    private void setY(int y) {
      this.y = y;
    }

    private void eat() {
      eat++;

      if (eat == level) {
        level++;
        eat = 0;
      }
    }

    private int getLevel() {
      return this.level;
    }

    private int getDistance(int x, int y) {
      return Math.abs(this.x - x) + Math.abs(this.y - y);
    }
  }


  private static final Scanner sc = new Scanner(System.in);

  private static final int[] X = {-1, 0, 1, 0}; // 상 좌 하 우
  private static final int[] Y = {0, -1, 0, 1};

  private void solve(int[][] map, int sharkX, int sharkY) {
    Shark shk = new Shark(sharkX, sharkY);

    Queue<Shark> queue = new LinkedList<>();
    queue.add(shk);

    boolean f = false;
    int count = 0;

    int size = map.length;

    boolean[][] check = new boolean[size][size];

    int result = 0;
    int distance = 0;
    while (!queue.isEmpty()) {

      Shark temp = queue.poll();
      int sx = temp.x;
      int sy = temp.y;

      //먹이감의 위치에 도달
      int point = map[sx][sy];
      if(point > 0 && point < shk.getLevel()) {
        check = new boolean[size][size];
        map[sx][sy] = 0;

        result += distance;
        queue = new LinkedList<>();

        shk.setX(sx);
        shk.setY(sy);

        shk.eat();

        System.out.format("Shark X: %d, Y: %d, Level: %d, eat: %d, length: %d \n", sx, sy, shk.getLevel(), shk.eat, distance);
        view(map);
        System.out.println();

        distance = 0;
      }

      boolean flag = false;
      for (int i = 0; i < 4; i++) {
        int x = sx + X[i];
        int y = sy + Y[i];

        if(x < 0 || x >= map.length || y < 0 || y >= map.length) continue;

        int level = map[x][y];

        if(level <= shk.getLevel() && !check[x][y]) {
          queue.add(new Shark(x, y));
          check[x][y] = true;

          flag = true;
        } else continue;
      }

      if(flag) distance++;
    }

    System.out.println(result);
  }

  public static void main(String[] args) {
    int N = sc.nextInt();

    int[][] map = new int[N][N];

    int sharkX = 0;
    int sharkY = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = sc.nextInt();

        if (map[i][j] == 9) {
          map[i][j] = 0;
          sharkX = i;
          sharkY = j;
        }
      }
    }

    new BabyShark().solve(map, sharkX, sharkY);
  }

  private static void view(int[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void view(boolean[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
