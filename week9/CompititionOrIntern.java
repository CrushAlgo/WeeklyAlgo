package week9;

import java.util.Arrays;
import java.util.Scanner;

public class CompititionOrIntern {

  public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
      String[] input = scan.nextLine().split(" ");

      int[] tc = strToInt(input);
      System.out.println(solution1(tc));
    }
  }

  public static int solution1(int[] input) {
    int female = input[0];
    int male = input[1];
    int intern = input[2];

    int team = 0;
    while (female >= 2 && male >= 1) {
      female -= 2;
      male -= 1;

      if((female + male) < intern) break;
      team++;
    }

    return team;
  }

  public static int[] strToInt(String[] strArr) {
    return Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
  }
}
