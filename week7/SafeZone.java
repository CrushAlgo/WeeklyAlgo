package week7;

import java.util.Scanner;

public class SafeZone {

  public static void main(String[] args) {
    int N;
    int[][] area;
    int min = 100;
    int max = 0;

    try (Scanner scan = new Scanner(System.in)) {
      N = scan.nextInt();
      scan.nextLine();

      area = new int[N][N];

      for (int i = 0; i < N; i++) {
        String[] height = scan.nextLine().split(" ");
        int tempMin, tempMax = 0;
        for (int j = 0; j < height.length; j++) {
          area[i][j] = Integer.parseInt(height[j]);
          tempMin = area[i][j];
          tempMax = area[i][j];

          if (tempMin < min) min = tempMin;
          if (tempMax > max) max = tempMax;
        }
      }
    }

    System.out.println(solution(N, area, min, max));
  }

  public static int solution(int N, int[][] area, int min, int max) {
    int result = 1; //비가 오지 않은 경우 모든 구역이 '안전 구역'으로 묶임

    boolean[][] safeZone = new boolean[N][N];
    for (int i = min; i <= max; i++) {
      int rain = i;
      int temp = 0;

      for (int r = 0; r < area.length; r++) {       //행
        for (int c = 0; c < area[r].length; c++) {  //열
          if (area[r][c] > rain) safeZone[r][c] = true;
          else safeZone[r][c] = false;
        }
      }

      for (int k = 0; k < safeZone.length; k++) {
        for (int l = 0; l < safeZone[k].length; l++) {
          if (safeZone[k][l]) {
            visit(safeZone, k, l);
            temp++;
          } else continue;
        }
      }

      if (temp > result) result = temp;
    }

    return result;
  }

  // 탐색을 해 가면서, 탐색한 부분을 넓혀가고, 탐색이 안이루어 진 부분을 탐색할 때 카운트
  public static void visit(boolean[][] safeZone, int x, int y) {
    safeZone[x][y] = false;

    //상
    if ((x > 0) && safeZone[x - 1][y]) {
      safeZone[x - 1][y] = false;
      visit(safeZone, x - 1, y);
    }
    //하
    if ((x < safeZone.length - 1) && safeZone[x + 1][y]) {
      safeZone[x + 1][y] = false;
      visit(safeZone, x + 1, y);
    }
    //좌
    if ((y > 0) && safeZone[x][y - 1]) {
      safeZone[x][y - 1] = false;
      visit(safeZone, x, y - 1);
    }
    //우
    if ((y < safeZone.length - 1) && safeZone[x][y + 1]) {
      safeZone[x][y + 1] = false;
      visit(safeZone, x, y + 1);
    }
  }

  public static void view(boolean[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        if (map[i][j]) System.out.print(1 + " ");
        else System.out.print(0 + " ");
      }
      System.out.println();
    }
  }
}
