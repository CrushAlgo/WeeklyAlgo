package week9;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumValues {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] tc = scan.nextLine().split(" ");
    int arrSize = Integer.parseInt(tc[0]);
    int arrTc = Integer.parseInt(tc[1]);

    int[] arr = new int[arrSize];
    for (int i = 0; i < arrSize; i++) {
      arr[i] = scan.nextInt();
      scan.nextLine();
    }

    int[] result = new int[arrSize];
    for (int i = 0; i < arrTc; i++) {
      String[] rangeInput = scan.nextLine().split(" ");
      int[] range = Arrays.asList(rangeInput).stream().mapToInt(Integer::parseInt).toArray();

      result[i] = solution(range, arr);
      System.out.println(result[i]);
    }
  }

  public static int solution(int[] range, int[] arr) {
    int result = 0;

    int size = (range[1] - range[0]) + 1;
    int[] tempArr = new int[size];

    int index = 0;
    for (int i = range[0] - 1; i <= range[1] - 1; i++) {
      tempArr[index++] = arr[i];
    }

    Arrays.sort(tempArr);

    result = tempArr[0];

    return result;
  }
}
