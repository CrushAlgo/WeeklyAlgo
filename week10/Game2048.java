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
2 2 2
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

5
2 2 4 8 16
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
16 8 4 2 2

5
16 0 0 0 0
8 0 0 0 0
4 0 0 0 0
2 0 0 0 0
2 0 0 0 0

5
2 2 4 8 16
2 0 0 0 8
4 0 0 0 4
8 0 0 0 2
16 8 4 2 2
 */

/*
풀이
: 맵을 4방면으로 돌려보고, 큰 값을 갖는 맵을 다시 돌린다. 최종적으로 남은 맵의 최대값을 출력한다.
: 5번이라는 카운트를 어떻게 줄 것이냐.
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

    int max = solution(N, board);

    System.out.println(max);
  }

  static int solution(int N, int[][] board) {
    int result = 0;

    BoardGame bg = new BoardGame(N, 0);
    bg.setBoard(board);

    Queue<BoardGame> queue = new LinkedList<>();
    queue.add(bg);

    int tempMax = 0;
    while (!queue.isEmpty()) {
      BoardGame temp = queue.poll();    // 입력 받은 BG 객체를 꺼내온다.

      int[][] pollBoard = temp.getBoard();
      int count = temp.getCount() + 1;

      if (count > 5) break;

      System.out.format("-----count : %d --- temp : %d \n", count, tempMax);
      temp.view();

      BoardGame up = new BoardGame(N, count);
      BoardGame down = new BoardGame(N, count);
      BoardGame left = new BoardGame(N, count);
      BoardGame right = new BoardGame(N, count);  // 꺼내온 BG 객체에는 'board' 가 있고, 각 'up', 'down', ... 객체에 'board' 를 복사

      up.setBoard(pollBoard);
      down.setBoard(pollBoard);
      left.setBoard(pollBoard);
      right.setBoard(pollBoard);

      up.up2();
      down.down2();
      left.left2();
      right.right2();

      System.out.println();
      System.out.println("---up---");
      up.view();

      System.out.println("---down---");
      down.view();

      System.out.println("---left---");
      left.view();

      System.out.println("---right---");
      right.view();

      System.out.println();


      int upMax = up.maxValue();
      int downMax = down.maxValue();
      int leftMax = left.maxValue();
      int rightMax = right.maxValue();

      if(tempMax < result) tempMax = result;

      result = Math.max(
              Math.max(upMax, downMax),
              Math.max(leftMax, rightMax)
      );

      if (result == up.maxValue()) queue.add(up);
      if (result == down.maxValue()) queue.add(down);
      if (result == left.maxValue()) queue.add(left);
      if (result == right.maxValue()) queue.add(right);
    }

    return tempMax;
  }

  static class BoardGame {
    static int SIZE;
    int[][] board;

    int count;

    public BoardGame(int N, int count) {
      this.SIZE = N;
      this.count = count;
    }

    public int[][] getBoard() {
      return this.board;
    }

    public void setBoard(int[][] board) {
      int row = board.length;
      int col = board[0].length;

      this.board = new int[row][col];

      for (int i = 0; i < row; i++) {
        this.board[i] = board[i].clone();
      }
    }

    public int getCount() {
      return this.count;
    }

    public void setCount() {
      this.count++;
    }

    public void up2() {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int col = 0; col < SIZE; col++) {
        for (int row = 0; row < SIZE; row++) {
          int now = row;

          if (board[now][col] == 0) continue;
          else {
            int value = board[now][col];

            while (now > 0) {
              now--;

              if (board[now][col] == value && !check[now][col]) {
                board[now][col] = (value * 2);
                board[now + 1][col] = 0;

                check[now][col] = true;

                value = (value * 2);
              }

              if (board[now][col] == 0) {
                board[now][col] = value;
                board[now + 1][col] = 0;
              }
            }
          }
        }
      }
    }

    public void down2() {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int col = (SIZE - 1); col >= 0; col--) {
        for (int row = (SIZE - 1); row >= 0; row--) {
          int now = row;

          if (board[now][col] == 0) continue;
          else {
            int value = board[now][col];

            while (now < (SIZE - 1)) {
              now++;

              if (board[now][col] == value && !check[now][col]) {
                board[now][col] = (value * 2);
                board[now - 1][col] = 0;

                check[now][col] = true;

                value = (value * 2);
              }

              if (board[now][col] == 0) {
                board[now][col] = value;
                board[now - 1][col] = 0;
              }
            }
          }
        }
      }
    }

    public void left2() {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int row = 0; row < SIZE; row++) {
        for (int col = 0; col < SIZE; col++) {
          int now = col;

          if (board[row][now] == 0) continue;
          else {
            int value = board[row][now];

            while (now > 0) {
              now--;

              if (board[row][now] == value && !check[row][now]) {
                board[row][now] = (value * 2);
                board[row][now + 1] = 0;

                check[row][now] = true;

                value = (value * 2);
              }

              if (board[row][now] == 0) {
                board[row][now] = value;
                board[row][now + 1] = 0;
              }
            }
          }
        }
      }
    }

    public void right2() {
      boolean[][] check = new boolean[SIZE][SIZE];

      for (int row = 0; row < SIZE; row++) {
        for (int col = (SIZE - 1); col >= 0; col--) {
          int now = col;

          if (board[row][now] == 0) continue;
          else {
            int value = board[row][now];

            while (now < (SIZE - 1)) {
              now++;

              if (board[row][now] == value && !check[row][now]) {
                board[row][now] = (value * 2);
                board[row][now - 1] = 0;

                check[row][now] = true;

                value = (value * 2);
              }

              if (board[row][now] == 0) {
                board[row][now] = value;
                board[row][now - 1] = 0;
              }
            }
          }
        }
      }
    }

    public int maxValue() {
      int max = 0;

      for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
          if (board[i][j] > max) max = board[i][j];
        }
      }

      return max;
    }

    public void view() {
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }
    }
  }

}
