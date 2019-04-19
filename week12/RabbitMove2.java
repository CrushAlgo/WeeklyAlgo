package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RabbitMove2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    String COMM = br.readLine();

    int[] row = new int[(N * N) + 1];
    int[] col = new int[(N * N) + 1];

    int idx = 1;
    for (int i = 0; i < N; i++) {

      if ((i % 2) == 0) {
        int c = 0;

        for (int r = i; r >= 0; r--, c++) {
          row[idx] = r;
          col[idx] = c;

          idx++;
        }
      } else {
        int r = 0;

        for (int c = i; c >= 0; c--, r++) {
          row[idx] = r;
          col[idx] = c;

          idx++;
        }
      }
    }

    idx = (N * N);
    for (int i = 0; i < (N - 1); i++) {
      if((i % 2) == 0) {
        int c = N - 1;

        for(int r = (N - i) - 1; r < N; r++, c--) {
          row[idx] = r;
          col[idx] = c;

          idx--;
        }
      } else {
        int r = N - 1;
        for(int c = (N - i) - 1; c < N; c++, r--) {
          row[idx] = r;
          col[idx] = c;

          idx--;
        }
      }
    }

    int x = 0;
    int y = 0;

    int result = 1;
    for (int i = 0; i < COMM.length(); i++) {
      char c = COMM.charAt(i);

      switch(c) {
        case 'R' :
          y++;
          break;
        case 'D' :
          x++;
          break;
        case 'L' :
          y--;
          break;
        case 'U' :
          x--;
          break;
      }

      for(int j = 1; j < row.length; j++) {
        if(row[j] == x && col[j] == y) {
          result += j;
          break;
        }
      }
    }

    System.out.println(result);
  }
}
