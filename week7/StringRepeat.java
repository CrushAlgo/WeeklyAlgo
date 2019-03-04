package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringRepeat {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] input = new String[N];

    for (int i = 0; i < N; i++) {
      input[i] = br.readLine();
    }

    br.close();

    solution(N, input);
  }

  public static void solution(int N, String[] input) {
    int testCase = N;

    String[][] cases = new String[N][2];
    for(int i=0; i<N; i++) {
      cases[i] = input[i].split(" ");

      int repeat = Integer.parseInt(cases[i][0]);
      String str = cases[i][1];

      StringBuffer sb = new StringBuffer();
      for(int j=0; j<str.length(); j++) {
        for(int k=0; k<repeat; k++){
          sb.append(str.charAt(j));
        }
      }

      System.out.println(sb.toString());
    }

  }
}
