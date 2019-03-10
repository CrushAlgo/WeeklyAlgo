package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bingo2 {

  public static int N = 5;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[][] bingoBoard = new String[N][N];
    String[][] bingoNum = new String[N][N];

    for (int i = 0; i < (N + N); i++) {
      if (i < 5) bingoBoard[i] = br.readLine().split(" ");
      else bingoNum[i - 5] = br.readLine().split(" ");
    }

    System.out.println(solution(bingoBoard, bingoNum));
  }

  public static int solution(String[][] bingoBoard, String[][] bingoNum) {
    int result = 0;
    int bingo = 0;

    int[][] checkingBoard = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        result++;

        int[] bingoIndex = searchIndex(bingoNum[i][j], bingoBoard);

        if (checkingBoard[bingoIndex[0]][bingoIndex[1]] != 1) checkingBoard[bingoIndex[0]][bingoIndex[1]] = 1;
        else continue;

        System.out.println("---" + result + "---");
        view(checkingBoard);

        bingo = bingoRowColumn(checkingBoard) + bingoDiagonal(checkingBoard);
        System.out.println("bingo: " + bingo);
        System.out.println();

        if (bingo >= 3) return result;
      }
    }

    return result;
  }

  public static int[] searchIndex(String num, String[][] bignoBoard) {
    int[] result = new int[2];

    boolean flag = false;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (bignoBoard[i][j].equals(num)) {
          result[0] = i;
          result[1] = j;

          flag = true;
          break;
        } else continue;
      }
      if (flag) break;
    }

    return result;
  }

  public static int bingoRowColumn(int[][] checkingBoard) {
    int result = 0;

    int rowSum = 0;
    int colSum = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        //row
        rowSum += checkingBoard[i][j];
        //column
        colSum += checkingBoard[j][i];
      }
      if (rowSum == N) result++;
      if (colSum == N) result++;

      rowSum = 0;
      colSum = 0;
    }

    return result;
  }

  public static int bingoDiagonal(int[][] checkingBoard) {
    int result = 0;

    int diaLSum = 0;
    int diaRSum = 0;
    for (int i = 0; i < N; i++) {
      //왼쪽 위 부터 우하향
      diaLSum += checkingBoard[i][i];
      //오른쪽 위부터 좌하향
      diaRSum += checkingBoard[i][N - 1 - i];
    }

    if (diaLSum == 5) result++;
    if (diaRSum == 5) result++;

    return result;
  }

  public static void view(int[][] board) {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
}
