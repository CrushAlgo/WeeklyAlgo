package week1;

import java.util.Random;
import java.util.Scanner;

public class IceBerg {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // N과 M은 3 이상 300 이하이다
    String[] num = scan.nextLine().split(" ");
    N = Integer.parseInt(num[0]);
    M = Integer.parseInt(num[1]);

    ICEBERG_MAP_TEMP = new int[N][M];
    CHUNK_MAP = new boolean[N][M];
    SINGLE_CHUNK_MAP = new boolean[N][M];

    if (N < 3 && N > 300 && M < 3 && M > 300) return;
    else {
      String[] row = null;
      ICEBERG_MAP = new int[N][M];
      int limit = 0;

      for (int i = 0; i < N; i++) {
        row = scan.nextLine().split(" ");

        for (int k = 0; k < M; k++) {
          int number = Integer.parseInt(row[k]);
          if(number > 0) limit++;
          if(limit > 10000) return;
          ICEBERG_MAP[i][k] = number;
        }
      }
    }

//    setting(N, M);
    mapView(ICEBERG_MAP);

    boolean result = false; // 빙산이 두 덩어리로만 나눠지면 되기 때문에 'true', 'false' 검사로 가능.
    int count = 0;
    int iceSum = 0;

    while (!result) {
      count++;

      globalWarming();
      checkIceberg(ICEBERG_MAP);

      System.out.println("높이 : 빙산 상태");
      mapView(ICEBERG_MAP);
      System.out.println();

      System.out.println("덩어리 : 빙산 떨어짐 정도");
      mapView(CHUNK_MAP);
      System.out.println();

      for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < M - 1; j++) {

          if (ICEBERG_MAP[i][j] != 0 && !CHUNK_MAP[i][j]) {
            result = true;
            break;
          } else {
            iceSum += ICEBERG_MAP[i][j];
          }
        }

        if (result) break;
      }

      mapReset(CHUNK_MAP);

      if (iceSum == 0) {
        result = true;
        count = 0;
      }

      iceSum = 0;
    }

    System.out.println(count);

    System.out.println("높이 : 빙산 상태");
    mapView(ICEBERG_MAP);
    System.out.println();

    System.out.println("덩어리 : 빙산 떨어짐 정도");
    checkIceberg(ICEBERG_MAP);
    mapView(CHUNK_MAP);
  }

  public static int N;
  public static int M;

  //배열에는 10,000 개 이하의 정수만 수용.
  public static final int ICE_LIMIT = 10000;

  //첫 행과 열, 마지막 행과 열은 '0'으로 채워진다.
  public static int[][] ICEBERG_MAP;
  public static int[][] ICEBERG_MAP_TEMP; //snapshot

  public static boolean[][] CHUNK_MAP;
  public static boolean[][] SINGLE_CHUNK_MAP;

  public void input(int N, int M) {

  }

  /**
   * - 사용자로 부터 행과 열 입력 받아서 '빙산' 세팅
   * - 첫 행과 열, 마지막 행과 열은 '0'으로 채워진다.
   *
   * @param row    , 행
   * @param column , 열
   */
  public static void setting(int row, int column) {
    N = row;
    M = column;

    ICEBERG_MAP = new int[N][M];
    ICEBERG_MAP_TEMP = new int[N][M];
    CHUNK_MAP = new boolean[N][M];
    SINGLE_CHUNK_MAP = new boolean[N][M];

    Random ran = new Random();
    int iceCount = 0;
    for (int i = 1; i < N - 1; i++) { // 첫 행, 마지막 행 제외
      for (int j = 1; j < M - 1; j++) { // 첫 열, 마지막 열 제외
        int iceLife = ran.nextInt(11);

        if (iceLife != 0) iceCount++;
        if (iceCount > ICE_LIMIT) return;

        ICEBERG_MAP[i][j] = iceLife;
      }
    }
  }

  public static void mapView(int[][] map) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void mapView(boolean[][] map) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j]) System.out.print("+" + " ");
        else System.out.print(0 + " ");
      }
      System.out.println();
    }
  }

  public static void mapReset(boolean[][] map) {
    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {
        map[i][j] = false;
      }
    }
  }

  /**
   * - 해당 칸에 대해 상하좌우 '0'의 갯수 파악하기.
   * - 윗 행이 먼저 삭제되고, 다음 행 검사하게 되면 결과 달라진다.(snapshot 개념이 필요)
   */
  public static void globalWarming() {
    int melting = 0;  // 빙산 주변의 '0' 갯수.

    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {
        // 상
        if (ICEBERG_MAP[i - 1][j] == 0) melting++;
        // 하
        if (ICEBERG_MAP[i + 1][j] == 0) melting++;
        // 좌
        if (ICEBERG_MAP[i][j - 1] == 0) melting++;
        // 우
        if (ICEBERG_MAP[i][j + 1] == 0) melting++;

        ICEBERG_MAP_TEMP[i][j] = melting;

        melting = 0;
      }
    }

    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {
        // 빙산의 최소 높이는 '0'
        if (ICEBERG_MAP[i][j] < ICEBERG_MAP_TEMP[i][j]) ICEBERG_MAP[i][j] = 0;
        else ICEBERG_MAP[i][j] -= ICEBERG_MAP_TEMP[i][j];
      }
    }
  }

  /**
   * 숫자로 표기되어 있는 부분, 찾아서 표기.
   *
   * @param x 좌표.
   * @param y 좌표.
   */
  public static void visit(int x, int y) {

    CHUNK_MAP[x][y] = true;

    //하
    if (ICEBERG_MAP[x + 1][y] != 0 && !CHUNK_MAP[x + 1][y]) {
      CHUNK_MAP[x + 1][y] = true;
      visit(x + 1, y);
    }

    //상
    if (ICEBERG_MAP[x - 1][y] != 0 && !CHUNK_MAP[x - 1][y]) {
      CHUNK_MAP[x - 1][y] = true;
      visit(x - 1, y);
    }

    //우
    if (ICEBERG_MAP[x][y + 1] != 0 && !CHUNK_MAP[x][y + 1]) {
      CHUNK_MAP[x][y + 1] = true;
      visit(x, y + 1);
    }

    //좌
    if (ICEBERG_MAP[x][y - 1] != 0 && !CHUNK_MAP[x][y - 1]) {
      CHUNK_MAP[x][y - 1] = true;
      visit(x, y - 1);
    }
  }

  public static void checkIceberg(int[][] map) {
    boolean flag = false;

    for (int i = 1; i < N - 1; i++) {
      for (int j = 1; j < M - 1; j++) {

        if (map[i][j] != 0) {
          visit(i, j);
          flag = true;
          break;
        } else continue;
      }

      if (flag == true) break;
    }

  }

}
