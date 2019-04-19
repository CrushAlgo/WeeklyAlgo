package week12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark3 {
  //입력
  static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int N = sc.nextInt();

    int x = 0;
    int y = 0;

    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int input = sc.nextInt();

        if (input == 9) {
          x = i;
          y = j;

          map[i][j] = 0;
        } else map[i][j] = input;

      }
    }

    new BabyShark3().solve(x, y, map, N);
  }

  //아기 상어 클래스
  static class Shark {
//    int x;
//    int y;
    private int eat = 0;
    private int level = 2;
    private int distance = 0;

//    private void initialize(int x, int y) {
//      this.x = x;
//      this.y = y;
//    }

    private void eat() {
      this.eat++;

      if (this.eat == this.level) {
        this.level++;
        this.eat = 0;
      }
    }

    private int getLevel() {
      return this.level;
    }

    private void addDistance(int dist) {
      this.distance += dist;
    }

    private int getDistance() {
      return this.distance;
    }
  }

  //이동 포인트 클래스
  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  /**
   * 메소드
   */
  private void solve(int x, int y, int[][] map, int N) {
    //아기상어 정의
    Shark babyShark = new Shark();
//    babyShark.initialize(x, y);

    int bsLevel = babyShark.getLevel();

    //사방탐색
    int[] moveX = {-1, 0, 1, 0};  // 상좌하우
    int[] moveY = {0, -1, 0, 1};

    Queue<Point> queue = new LinkedList<>();
    boolean[][] check = new boolean[N][N];

    queue.add(new Point(x, y));
    check[x][y] = true;

    //BFS, 회차 순으로 이동거리를 측정
    int distance = 0;

    while (!queue.isEmpty()) {

      //회차 순으로
      int qSize = queue.size();

      for (int i = 0; i < qSize; i++) {
        //먹잇감 찾기
        Point temp = queue.poll();

        int pointX = temp.x;
        int pointY = temp.y;
        int pointLevel = map[pointX][pointY];

        if (map[pointX][pointY] > 0 && pointLevel < bsLevel) {
          System.out.format("먹잇감 위치, x: %d, y: %d, dist: %d, level: %d \n", pointX, pointY, distance, babyShark.getLevel());
          view(map);

          map[pointX][pointY] = 0;

          babyShark.eat();
          bsLevel = babyShark.getLevel();
          babyShark.addDistance(distance);

          distance = 0;

          queue = new LinkedList<>();
          qSize = i;

          for(int j = 0; j < N; j++) {
            Arrays.fill(check[j], false);
          }
        }

        // 사방탐색
        for (int j = 0; j < 4; j++) {
          int pointX2 = pointX + moveX[j];
          int pointY2 = pointY + moveY[j];

//          System.out.format("사방탐색 위치, x: %d, y: %d \n", pointX2, pointY2);

          if(pointX2 < 0 || pointX2 >= N || pointY2 < 0 || pointY2 >= N) continue;


          if (map[pointX2][pointY2] <= bsLevel && !check[pointX2][pointY2]) {
            queue.add(new Point(pointX2, pointY2));
            check[pointX2][pointY2] = true;
          }
        }
      }

      distance++;
    }

    System.out.println(babyShark.getDistance());
  }

  public static void view(int[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j <map[i].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
