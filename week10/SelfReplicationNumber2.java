package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelfReplicationNumber2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String[] goal = new String[N];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      int length = input.length();

      int num = Integer.parseInt(input);
      int multiple = (int) Math.pow(num, 2);

      String mulStr = String.valueOf(multiple);

      if(mulStr.substring(mulStr.length() - length, mulStr.length()).equals(input)) {
        goal[i] = "YES";
      } else {
        goal[i] = "NO";
      }
    }

    for(int i=0; i<N; i++) {
      System.out.println(goal[i]);
    }
  }
}
