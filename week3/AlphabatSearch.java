package week3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/*
https://www.acmicpc.net/problem/10809
 */
public class AlphabatSearch {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] input = scan.nextLine().split("");

    System.out.println(Arrays.toString(search(input)));

  }

  public static int[] search(String[] input) {
    String[] alphabat = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    int[] result = new int[26];

    for(int i=0; i<26; i++) {
      result[i] = -1;
    }

    Set<String> alphaSet = new HashSet<>();

    for (int i = 0; i < input.length; i++) {
      if (!alphaSet.contains(input[i])) {
        for (int j = 0; j < alphabat.length; j++) {
          if(input[i] == alphabat[j]) {
            System.out.println(input[i]);
            result[j] = i;
          }
        }
      } else {
        alphaSet.add(input[i]);
      }
    }

    return result;
  }
}
