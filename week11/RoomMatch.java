package week11;

import java.util.Scanner;

public class RoomMatch {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();

    // 학년 마다 남/여 인원 수만 체크
    int[][] a = new int[7][2];  // 1~6학년, 성별(남 - '1'/여 - '0')

    for (int i = 0; i < n; i++) {
      int s = sc.nextInt();
      int g = sc.nextInt();

      a[g][s]++;
    }

    // 방 배정은 학생의 수에서 방에 수용 인원을 나누어 구한다.
    int c = 0;
    for(int i = 1; i <= 6; i++) {

      for(int j = 0; j < 2; j++) {
        int f = a[i][j];

        c += (f / m);

        if((f % m) != 0) c++;
      }

    }

    System.out.println(c);
//    view(a);
  }

  private void view(int[][] m) {
    for (int i = 1; i < m.length; i++) {
      System.out.format("%d 학년, 남: %d, 여 : %d \n", i, m[i][1], m[i][0]);
    }
  }

  public static void main(String[] args) {
    new RoomMatch().solve();
  }
}
