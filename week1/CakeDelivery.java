import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * CLASS CAKEDELIVERY {
 *   MAIN()
 *   SOLUTION()
 *
 *   STATIC CLASS POINT{
 *     METHODS() ...
 *   }
 * }
 */
public class CakeDelivery {
  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      int N = scan.nextInt();
      scan.nextLine();

      int[] start = Arrays.asList(scan.nextLine().split(" "))
              .stream()
              .mapToInt(Integer::parseInt)
              .toArray();

      Point bakerty = new Point(start[0], start[1]);
      Point[] customers = new Point[N];
      for (int i = 0; i < N; i++) {
        int[] customer = Arrays.asList(scan.nextLine().split(" "))
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();

        customers[i] = new Point(customer[0], customer[1]);
      }

      System.out.println(solution(bakerty, customers));
    }
  }

  public static int solution(Point bakery, Point[] customers) {
    Point p = new Point();
    int result = 0;

    Point start = bakery;
    for (int i = 0; i < customers.length; i++) {
      Point goal = customers[i];

      List<Point> goalList = p.setGoal(goal);

      result += p.minDistance(start, goalList);

      start = goal;
    }

    return result;
  }

  static class Point {
    int x, y;

    int[] pointX = {-1, 1, 0, 0};
    int[] pointY = {0, 0, -1, 1};

    public Point() {
    }

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    // 좌표 x, y 는 1에서 100,000
    public List<Point> setGoal(Point point) {
      List<Point> nextPointsList = new ArrayList<>();

      nextPointsList.add(point);

      int size = 4;
      for (int i = 0; i < size; i++) {
        int xp = point.x + pointX[i];
        int yp = point.y + pointY[i];

        if (xp < 1 || xp > 100000 || yp < 1 || yp > 100000) continue;

        nextPointsList.add(new Point(xp, yp));
      }

      return nextPointsList;
    }

    public int minDistance(Point start, List<Point> goalList) {
      int result = Integer.MAX_VALUE;

      int x1 = start.x;
      int y1 = start.y;

      for (int i = 0; i < goalList.size(); i++) {
        Point goal = goalList.get(i);

        int x2 = goal.x;
        int y2 = goal.y;

        int distance = (Math.abs(x1 - x2) + Math.abs(y1 - y2));

        if (distance < result) result = distance;
      }

      return result;
    }
  }
}
