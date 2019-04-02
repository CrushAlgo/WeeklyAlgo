package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
3
0 0 0
4 4 4
8 8 8

3
0 2 0
0 0 2
2 2 0

4
0 2 0 2
2 2 2 0
0 4 2 2
2 2 2 8

4
0 2 0 2
2 2 2 0
0 4 2 2
2 8 2 8
 */
public class Game2048 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      board[i] = Arrays.asList(br.readLine().split(" "))
              .stream()
              .mapToInt(Integer::parseInt)
              .toArray();
    }

    solution(N, board);
  }

  public static void solution(int N, int[][] board) {
    BoardGame bg = new BoardGame(N);

    Queue<int[][]> queue = new LinkedList<>();
    queue.add(board);

    int[] boardCnt = new int[4];  // up, down, left, right
    while (!queue.isEmpty()) {
      int[][] temp = queue.poll();

      int[][] up, down, left, right;

      up = copyArr(temp);
      down = copyArr(temp);
      left = copyArr(temp);
      right = copyArr(temp);

      bg.down(down);
      bg.up(up);
      bg.left(left);
      bg.right(right);

      int max = Math.max(
                  Math.max(bg.maxValue(up), bg.maxValue(down)),
                  Math.max(bg.maxValue(left), bg.maxValue(right))
                );

      System.out.println(max);

      if (max == bg.maxValue(up)) queue.add(up);
      if (max == bg.maxValue(down)) queue.add(down);
      if (max == bg.maxValue(left)) queue.add(left);
      if (max == bg.maxValue(right)) queue.add(right);

      System.out.println(queue.size());
      break;
    }
  }

  public static int[][] copyArr(int[][] board) {
    int row = board.length;     //행
    int col = board[0].length;  //열

    int[][] temp = new int[row][col];

    for (int i = 0; i < board.length; i++) {
      temp[i] = board[i].clone();
    }

    return temp;
  }

  static class BoardGame {
    static int SIZE;

    public BoardGame(int N) {
      this.SIZE = N;
    }

    public int[][] up(int[][] board) {
      boolean[][] check = new boolean[SIZE][SIZE];

      /*
      '0'을 만나면 쭉쭉 올라가게 한다. 한 열씩
       */
      for (int i = 0; i < SIZE; i++) {  // 열
        for (int j = 0; j < SIZE; j++) {  // 행
          if (board[j][i] == 0) continue;
          else {
            int point = j;
            int value = board[j][i];

            while (point != 0) {
              point--;

              if (board[point][i] == 0) {
                board[point][i] = value;
                board[point + 1][i] = 0;
              } else if (board[point][i] == value && !check[point][i]) {
                board[point][i] = (value * 2);
                board[point + 1][i] = 0;

                //check
                check[point][i] = true;
              } else break;
            }
          }
        }
      }

      return board;
    }

    public int[][] down(int[][] board) {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int i = 0; i < SIZE; i++) {    //행
        for (int j = (SIZE - 1); j >= 0; j--) {  //열
          if (board[j][i] == 0) continue;
          else {
            int point = j;
            int value = board[j][i];

            while (point != (SIZE - 1)) {
              point++;

              if (board[point][i] == 0) {
                board[point][i] = value;
                board[point - 1][i] = 0;
              } else if (board[point][i] == value && !check[point][i]) {
                board[point][i] = (value * 2);
                board[point - 1][i] = 0;

                check[point][i] = true;
              } else break;
            }
          }
        }
      }

      return board;
    }

    public int[][] left(int[][] board) {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int i = 0; i < SIZE; i++) {    //행
        for (int j = 0; j < SIZE; j++) {  //열
          if (board[i][j] == 0) continue;
          else {
            int point = j;
            int value = board[i][j];

            while (point != 0) {
              point--;

              if (board[i][point] == 0) {
                board[i][point] = value;
                board[i][point + 1] = 0;
              } else if (board[i][point] == value && !check[i][point]) {
                board[i][point] = (value * 2);
                board[i][point + 1] = 0;

                check[i][point] = true;
              } else break;
            }
          }
        }
      }

      return board;
    }

    public int[][] right(int[][] board) {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int i = 0; i < SIZE; i++) {
        for (int j = (SIZE - 1); j >= 0; j--) {
          if (board[i][j] == 0) continue;
          else {
            int point = j;
            int value = board[i][j];

            while (point != (SIZE - 1)) {
              point++;

              if (board[i][point] == 0) {
                board[i][point] = value;
                board[i][point - 1] = 0;
              } else if (board[i][point] == value && !check[i][point]) {
                board[i][point] = (value * 2);
                board[i][point - 1] = 0;

                check[i][point] = true;
              } else break;
            }
          }
        }
      }

      return board;
    }

    public int maxValue(int[][] board) {
      int max = 0;

      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          if (board[i][j] > max) max = board[i][j];
        }
      }

      return max;
    }

    public void view(int[][] board) {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }
    }
  }

}
