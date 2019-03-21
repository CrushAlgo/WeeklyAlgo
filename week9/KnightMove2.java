package week9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightMove2 {

  public static int[] X_POINTS = {-2, -1, 1, 2, 2, 1, -1, -2};
  public static int[] Y_POINTS = {1, 2, 2, 1, -1, -2, -2, -1};
  public static int BFS_SIZE = 8;

  public static void main(String[] args) {
    int[] result;

    try (Scanner scan = new Scanner(System.in)) {
      int TC = scan.nextInt();
      scan.nextLine();

      result = new int[TC];

      for (int i = 0; i < TC; i++) {
        int N = scan.nextInt();
        scan.nextLine();

        int[] start = Arrays.asList(scan.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int[] goal = Arrays.asList(scan.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

//        System.out.format("TC: %d, N: %d, start: %s, goal: %s \n", TC, N, Arrays.toString(start), Arrays.toString(goal));

        Knight knight = new Knight(start[0], start[1]);

        knight.setMap(N);
        knight.setStart(start[0], start[1]);
        knight.setGoal(goal[0], goal[1]);

        result[i] = knight.solution(knight);
      }
    }

    for(int i=0; i<result.length; i++) {
      System.out.println(result[i]);
    }
  }

  static class Knight {
    int x, y;

    int[][] map;
    int[][] temp;
    int mapSize;

    int[] X_POINTS = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] Y_POINTS = {1, 2, 2, 1, -1, -2, -2, -1};
    int BFS_SIZE = 8;

    Queue<Knight> QUEUE = new LinkedList<>();

    public Knight(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public void setMap(int N) {
      this.mapSize = N;

      this.map = new int[mapSize][mapSize];
      this.temp = new int[mapSize][mapSize];
    }

    public void setStart(int x, int y) {
      temp[x][y] = 1;
    }

    public void setGoal(int x, int y) {
      map[x][y] = -1;
    }

    public boolean bfs(Knight knight) {
      boolean result = false;

      for (int i = 0; i < BFS_SIZE; i++) {
        int x = knight.x + X_POINTS[i];
        int y = knight.y + Y_POINTS[i];

        if (x < 0 || x > (mapSize - 1) || y < 0 || y > (mapSize - 1)) continue;

        if (temp[x][y] == 0) {
          temp[x][y] = 1;
          QUEUE.add(new Knight(x, y));
        }

        if (map[x][y] == -1) {
          result = true;
          break;
        }
      }

      return result;
    }

    public int solution(Knight knight) {
      int count = 0;
      boolean flag = false;

      QUEUE.add(knight);
      while (!QUEUE.isEmpty()) {
        int size = QUEUE.size();

        for (int i = 0; i < size; i++) {
          Knight oKnight = QUEUE.poll();
          if(map[oKnight.x][oKnight.y] == -1) return 0;

          flag = bfs(oKnight);

          if (flag) break;
        }

        count++;
        if (flag) break;
      }

      return count;
    }
  }
}
