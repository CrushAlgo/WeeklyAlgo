package week2;

import java.util.Scanner;

public class ContinueSum {

  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int count = scan.nextInt();
    scan.nextLine();

    if (count < 0 && count > 100000) return;
    System.out.println(maxSum(count));
  }

  public static int maxSum(int input) {
    int[] intArr = new int[input];
    String[] inputArr = new String[input];

    inputArr = scan.nextLine().split(" ");

    for (int i = 0; i < input; i++) {
      intArr[i] = Integer.parseInt(inputArr[i]);
    }

    int max = intArr[0];  //max value initialize
    int sum = 0;
    for (int i = 0; i < input; i++) {
      for (int j = i; j < input; j++) {
        sum += intArr[j];
        if(sum > max) max = sum;
      }
      sum = 0;
    }

    return max;
  }
}
