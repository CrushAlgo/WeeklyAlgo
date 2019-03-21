package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] input = scan.nextLine().split(" ");
    int column = Integer.parseInt(input[0]);
    int row = Integer.parseInt(input[1]);

    ROW = row;
    COLUMN = column;

    BOX = new String[row][column];
    TEMP_MAP = new String[row][column];

    Tomato t = new Tomato();
    for (int i = 0; i < row; i++) {
      t.setMap(i, scan.nextLine().split(" "));
    }

    System.out.println(solution());
  }

  public static String[][] TEMP_MAP;
  public static String[][] BOX;
  public static int[] X_POINT = {-1, 1, 0, 0};  //상하좌우
  public static int[] Y_POINT = {0, 0, -1, 1};
  public static int SIZE = 4;
  public static Queue<Tomato> RIPE_QUEUE = new LinkedList<>();
  public static int ROW, COLUMN;
  public static int RAW_TOMATO;
  public static int COUNT;

  int x, y;

  public Tomato() {
  }

  ;

  public Tomato(int x, int y) {
    this.x = x;
    this.y = y;
  }

  private void checkRipe(int x, int y) {
    TEMP_MAP[x][y] = "1";
    RIPE_QUEUE.add(new Tomato(x, y));
  }

  public void setMap(int row, String[] input) {
    for (int i = 0; i < input.length; i++) {
      if (input[i].equals("1")) checkRipe(row, i);
      if (input[i].equals("0")) RAW_TOMATO++;

      BOX[row][i] = input[i];
    }
  }

  public static int solution() {
    int date = 0;
    boolean flag = false;

    while (!RIPE_QUEUE.isEmpty()) {
      int count = RIPE_QUEUE.size();  //date 계산을 위해 익은 토마토의 갯수 만큼 돌려준다.

      for (int i = 0; i < count; i++) {
        Tomato tomato = RIPE_QUEUE.poll();
        flag = bfs(tomato);

        if(flag) break;
      }

      if(COUNT > 0) date++;
      System.out.println("date: " + date);
      view(TEMP_MAP);

      if(flag) break;
    }

    if(COUNT < RAW_TOMATO) date = -1;

    return date;
  }

  // '1' 익은 토마토, '0' 안 익은 토마토, '-1' 토마토 없음
  public static boolean bfs(Tomato tomato) {
    boolean result = false;

    int nowX = tomato.x;
    int nowY = tomato.y;

    for (int i = 0; i < SIZE; i++) {
      int x = nowX + X_POINT[i];
      int y = nowY + Y_POINT[i];

      if (x < 0 || x >= ROW || y < 0 || y >= COLUMN) continue;

      if (BOX[x][y].equals("0") && TEMP_MAP[x][y] == null) {
        RIPE_QUEUE.add(new Tomato(x, y));
        TEMP_MAP[x][y] = "1";
        COUNT++;
      }

      if(RAW_TOMATO == COUNT) {
        result = true;
        break;
      }
    }

    return result;
  }

  public static void view(String[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }
}
