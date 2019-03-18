package week9;

import java.util.Scanner;

public class Change {

  private static int[] MONEY = {500, 100, 50, 10, 5, 1};

  public static void main(String[] args) {
    int result = 0;

    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    scan.nextLine();

    int change = 1000 - N;
    int index = 0;
    while(change > 0) {
      result += (change / MONEY[index]);

      change = (change % MONEY[index++]);
    }

    System.out.println(result);
  }
}
