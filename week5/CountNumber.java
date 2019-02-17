package com.pakpark.week5;

import java.util.Scanner;

public class CountNumber {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int A = scan.nextInt();
    int B = scan.nextInt();
    int C = scan.nextInt();

    long ABC = (A * B * C);

    String abc_str = String.valueOf(ABC);
    int length = abc_str.length();

    int[] result = new int[10];


    for(int i=0; i<length; i++) {
      result[abc_str.charAt(i) - '0']++;
    }

    for(int i=0; i<10; i++) {
      System.out.println(result[i]);
    }
  }
}
