package com.pakpark.week5;

import java.util.*;

public class SortInside {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String input = scan.nextLine();
    int length = input.length();
    int[] input_arr = new int[length];

    for (int i = 0; i < length; i++) {
      input_arr[i] = Character.getNumericValue(input.charAt(i));
    }

    int start = input.length() - 1;
    for(int i = start; i > 0 ; i--) {
      for(int j = start; j > 0; j--) {
        if (input_arr[j] > input_arr[j- 1]) {
          int temp = input_arr[j];
          input_arr[j] = input_arr[j - 1];
          input_arr[j - 1] = temp;
        }
      }
    }

    for(int i=0; i<length; i++) {
      System.out.print(input_arr[i]);
    }
  }
}
