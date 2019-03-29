package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelfReplicationNumber {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    String[] result = new String[N];
    for (int i = 0; i < N; i++) {
      String input = br.readLine();

      int number = Integer.parseInt(input);
      int digit = input.length();

      String multiple = String.valueOf((int) Math.pow(number, 2));
      int mulSize = multiple.length();

      String goal = multiple.substring(mulSize - digit, mulSize);

      result[i] = (goal.equals(input)) ? "YES" : "NO";
    }

    for (String str : result) {
      System.out.println(str);
    }
  }
}
