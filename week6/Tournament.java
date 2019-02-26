package week6;

import java.util.*;

public class Tournament {

  public static void main(String[] args) {
    System.out.println(solution("16 8 9"));
  }

  public static int solution(String N) {
    int round = 0;  // 1라운드 부터 시작.

    String[] input = N.split(" ");

    int kim = Integer.parseInt(input[1]);
    int im = Integer.parseInt(input[2]);

    while (true) {
      round++;

      kim = (int) Math.ceil(kim / 2.0);
      im = (int) Math.ceil(im / 2.0);

      if (kim == im) break;
    }

    return round;
  }
}
