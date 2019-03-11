package week8;

import java.util.Scanner;

public class Bingo {

  public static int SIZE = 5;

  public static void main(String[] args) {
    String[][] bingo = new String[SIZE][SIZE];
    String[][] bingoNum = new String[SIZE][SIZE];

    try (Scanner scan = new Scanner(System.in)) {
      for (int i = 0; i < (SIZE + SIZE); i++) {

        if (i < 5) bingo[i] = scan.nextLine().split(" ");
        else bingoNum[i - 5] = scan.nextLine().split(" ");
      }
    }

    System.out.println(solution(bingo, bingoNum));
  }

  public static int solution(String[][] bingo, String[][] bingoNum) {
    int result = 0;

    int[] row = new int[SIZE];      //0,1,2,3,4
    int[] column = new int[SIZE];   //0,1,2,3,4

    //대각선 (0,0) (1,1) ... (4,4), (0,4) (1,3) ... (4,0), 인덱스가 같던지 합이 4가 되던지
    int leftDiagonal = 0;
    int rightDiagonal = 0;

    int bingoCnt = 0;
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        int num = Integer.parseInt(bingoNum[i][j]);
        int[] indexArr = bingoIndex(num, bingo);

        row[indexArr[0]]++;
        column[indexArr[1]]++;

        //대각선을 잘못 설정.
        //왼쪽 위에서 부터 우하향 하는 대각선은, 2차원 배열 상의 인덱스 가 같다.
        if (indexArr[0] == indexArr[1]) leftDiagonal++;
        //오른쪽 위에서 부터 좌하향 하는 대각선은, 인덱스의 합이 '4'이다.
        if ((indexArr[0] + indexArr[1]) == 4) rightDiagonal++;

        if (row[indexArr[0]] == 5) bingoCnt++;
        if (column[indexArr[1]] == 5) bingoCnt++;

        if (leftDiagonal == 5) {
          bingoCnt++;
          leftDiagonal++; //계속 카운트 되는 걸 방지
        }
        if (rightDiagonal == 5) {
          bingoCnt++;
          rightDiagonal++;
        }

        result++;
        if (bingoCnt >= 3) {
          return result;
        }
      }
    }

    return result;
  }

  public static int[] bingoIndex(int num, String[][] bingo) {
    int[] result = new int[2];

    boolean flag = false;
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        int bNum = Integer.parseInt(bingo[i][j]);
        if (bNum == num) {
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


}
