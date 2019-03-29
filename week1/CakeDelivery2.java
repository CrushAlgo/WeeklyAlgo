import java.util.Arrays;
import java.util.Scanner;

public class CakeDelivery2 {

  static int[] X = {-1, 1, 0, 0};
  static int[] Y = {0, 0, -1, 1};
  static int DIRE_SIZE = 4;

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

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

  public static int solution(Point bakery, Point[] customer) {
    int result = 0;
    int size = customer.length;

    Point start = bakery;
    for (int i = 0; i < size; i++) {
      int minDist = Integer.MAX_VALUE;

      int startX = start.x;
      int startY = start.y;

      Point next = customer[i];

      for (int j = 0; j < DIRE_SIZE; j++) {
        int x = next.x + X[j];
        int y = next.y + Y[j];

        if (x < 1 || x > 100000 || y < 1 || y > 100000) continue;

        int distance = (Math.abs(startX - x) + Math.abs(startY - y));

        if (distance < minDist) minDist = distance;
      }

      result += minDist;

      start = next;
    }


    return result;
  }
}
