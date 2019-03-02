package week4;

import java.util.Scanner;

public class MinBoundary2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int x = scan.nextInt();
    int y = scan.nextInt();
    int w = scan.nextInt();
    int h = scan.nextInt();

    int minX = (w-x) > x ? x : (w-x);
    int minY = (h-y) > y ? y : (h-y);

    if(minX > minY) System.out.println(minY);
    else System.out.println(minX);
  }
}
