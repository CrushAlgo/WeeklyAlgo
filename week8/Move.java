package week8;

import java.util.*;

public class Move {

  public static void main(String[] args) {
    int N;
    int[] xArr, yArr;

    try (Scanner scan = new Scanner(System.in)) {
      N = scan.nextInt();
      scan.nextLine();

      String[] xInput = scan.nextLine().split(" ");
      String[] yInput = scan.nextLine().split(" ");

      xArr = new int[N];
      yArr = new int[N];
      for (int i = 0; i < N; i++) {
        xArr[i] = Integer.parseInt(xInput[i]);
        yArr[i] = Integer.parseInt(yInput[i]);
      }
    }

    System.out.println(solution(N, xArr, yArr));
  }

  public static int solution(int N, int[] xArr, int[] yArr) {
    int result = 0;

    /*
    N = 4
    (1 % 4) = 1, .. (3 % 4) = 3, (4 % 4) = 0
    N으로 수를 나누면, 0 ~ (N-1) 사이의 수를 출력한다.
    이를 이용해서 배열의 인덱스를 설정한다.
     */
    List<Integer> tempXList = new LinkedList<>();
    List<Integer> tempYList = new LinkedList<>();

    /*
    곱, N*N 행렬 두개를 만들어서 곱 연산을 실행한다.
     */
    int[][] xMatrix = new int[N][N];
    int[][] yMatrix = new int[N][N];

    for (int i = 0; i < N; i++) {
      int count = 0;
      int start = i;
      while (count < N) {
        int index = (start % N);
        xMatrix[i][count] = xArr[index];
        yMatrix[i][count] = yArr[index];

        start++;
        count++;
      }
    }

    //곱
    int S = 0;
    for (int i = 0; i < N; i++) {           //고정
      int[] temp = xMatrix[i];
      for (int k = 0; k < N; k++) {          //행
        for (int j = 0; j < N; j++) {       //열
          S += (temp[j] * yMatrix[j][k]);
        }
        if (S > result) result = S;

        S = 0;
      }
    }

    return result;
  }
}
