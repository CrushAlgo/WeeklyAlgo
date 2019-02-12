package com.pakpark.Forth;

import java.util.Scanner;

public class TenCut2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String str = scan.nextLine();

    for (int i = 0; i < str.length(); i++) {
      if ((i % 10) == 0) System.out.println();
      System.out.print(str.charAt(i));
    }
  }
}
