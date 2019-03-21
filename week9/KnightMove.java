package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KnightMove {

  public static int[] X_POINTS = {-2, -1, 1, 2, 2, 1, -1, -2};
  public static int[] Y_POINTS = {1, 2, 2, 1, -1, -2, -2, -1};
  public static int BFS_SIZE = 8;

  public static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
              "x=" + x +
              ", y=" + y +
              '}';
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int TC = scan.nextInt();
    scan.nextLine();

    for (int i = 0; i < TC; i++) {
      int range = scan.nextInt();
      scan.nextLine();

      String[] points = scan.nextLine().split(" ");
      String[] goals = scan.nextLine().split(" ");


      Point point = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
      Point goal = new Point(Integer.parseInt(goals[0]), Integer.parseInt(goals[1]));

      System.out.format("TC: %d, range: %d, points: %s, goal: %s \n", TC, range, point.toString(), goal.toString());

      int[][] map = new int[range][range];

      Queue<Point> queue = new LinkedList<>();
      queue.add(point);
      int count = 0;

      while (!queue.isEmpty()) {
        count++;

        Point candiPoint = queue.poll();

        System.out.println("count: " + count + "candiPoint: " + candiPoint.toString());

        int x = candiPoint.x;
        int y = candiPoint.y;

        if(x == goal.x && y == goal.y) break;

        if (x < 0 || x > range || y < 0 || y > range) continue;
        else {
          for (int j = 0; j < BFS_SIZE; j++) {
            x += X_POINTS[j];
            y += Y_POINTS[j];

            if(count > 0) queue.add(new Point(x, y));
          }
        }
      }
      System.out.println(count);
    }

  }
}
