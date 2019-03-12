package week8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Registance {

  public static String[] COLOR = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
  public static int SIZE = COLOR.length;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] input = new String[3];
    for (int i = 0; i < 3; i++) {
      input[i] = scan.nextLine();
    }

    System.out.println(solution(input));
  }

  public static long solution(String[] color) {
    long result = 0;

    String first = color[0];
    String second = color[1];
    String third = color[2];

    int firIdx = 0;
    int secIdx = 0;
    int thiIdx = 0;

    for(int i=0; i<SIZE; i++) {
      if(COLOR[i].equals(first)) firIdx = i;
      if(COLOR[i].equals(second)) secIdx = i;
      if(COLOR[i].equals(third)) thiIdx = i;
    }

    result = ((firIdx * 10) + secIdx) * (long) Math.pow(10, thiIdx);

    return result;
  }
}
