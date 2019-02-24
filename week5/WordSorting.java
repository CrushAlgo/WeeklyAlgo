package week5;

import java.util.*;

public class WordSorting {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int count = scan.nextInt();
    scan.nextLine();
    Map<String, Integer> input_length = new HashMap<>();

    while (count != 0) {
      String input = scan.nextLine();
      input_length.put(input, input.length());

      count--;
    }
  }
}
