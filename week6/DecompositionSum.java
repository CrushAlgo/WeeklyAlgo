package week6;

import java.util.*;

public class DecompositionSum {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int input = scan.nextInt();

    System.out.println(solution(input));
  }

  public static int solution(int N) {
    int result = 0;

    for (int i = 1; i <= N; i++) {
      String candidate = String.valueOf(i);

      int sum = i;
      for (int j = 0; j < candidate.length(); j++) {
        sum += candidate.charAt(j) - '0';
      }

      if(N == sum) {
        result = i;
        break;
      }
    }

    return result;
  }
}
