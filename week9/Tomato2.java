package week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato2 {

  static int ROW, COLUMN;
  static String[][] BOX = new String[ROW][COLUMN];

  public static void main(String[] args) {
    Tomato t = new Tomato();
    Scanner scan = new Scanner(System.in);

    String[] input = scan.nextLine().split(" ");
    int column = Integer.parseInt(input[0]);
    int row = Integer.parseInt(input[1]);

    ROW = row;
    COLUMN = column;

    BOX = new String[row][column];
    t.TEMP_BOX = new String[row][column];

    for (int i = 0; i < row; i++) {
      BOX[i] = scan.nextLine().split(" ");
    }

    System.out.println(t.solution());
  }

  static class Tomato {
    int x, y;
    String[][] TEMP_BOX = new String[ROW][COLUMN];
    Queue<Tomato> TOMATO_QUEUE = new LinkedList<>();
    int RAW;
    int COUNT;  // 익힌 토마토의 갯수(bfs 검색 한 노드 갯수 파악)

    int[] X_POINT = {-1, 1, 0, 0};
    int[] Y_POINT = {0, 0, -1, 1};
    int DIRECTION = 4;

    public Tomato() {
    }

    public Tomato(int x, int y) {
      this.x = x;
      this.y = y;
    }

    // 익은 토마토("1") 표시, 안 토마토 갯수 파악
    public void setTempBox(String[][] box) {
      for (int i = 0; i < box.length; i++) {
        for (int j = 0; j < box[i].length; j++) {
          if (box[i][j].equals("1")) {
            TEMP_BOX[i][j] = "1";
            TOMATO_QUEUE.add(new Tomato(i, j));
          }

          if (box[i][j].equals("0")) RAW++;
        }
      }
    }

    public boolean bfs(Tomato tomato) {
      boolean result = false;

      for (int i = 0; i < DIRECTION; i++) {
        int x = tomato.x + X_POINT[i];
        int y = tomato.y + Y_POINT[i];

        if (x < 0 || x > (ROW - 1) || y < 0 || y > (COLUMN - 1)) continue;  // BOX 범위 넘어 갈 경우

        if (BOX[x][y].equals("0") && TEMP_BOX[x][y] == null) {
          TEMP_BOX[x][y] = "1";
          TOMATO_QUEUE.add(new Tomato(x, y));

          COUNT++;
        }

        if (COUNT == RAW) {  // 다 익힘.
          result = true;
          break;
        }
      }

      return result;
    }

    public static int solution() {
      int date = 0;
      boolean flag = false;

      Tomato t = new Tomato();
      t.setTempBox(BOX);

      while (!t.TOMATO_QUEUE.isEmpty()) {
        int dateSize = t.TOMATO_QUEUE.size();

        for (int i = 0; i < dateSize; i++) {
          flag = t.bfs(t.TOMATO_QUEUE.poll());

          if(flag) break;
        }

        if(t.COUNT> 0) date++;

        if(flag) break;
      }

      if(t.RAW > t.COUNT) date = -1;

      return date;
    }
  }
}
