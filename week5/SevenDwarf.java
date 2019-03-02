package week5;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarf {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int[] heights = new int[9];

    int all_sum = 0;
    for (int i = 0; i < 9; i++) {
      heights[i] = scan.nextInt();
      if(heights[i] > 100 || heights[i] <= 0) return;
      all_sum += heights[i];
    }

    // 하나 고정하고 뒤로 쭉,
    boolean flag = false;
    for (int i = 0; i < 8; i++) {
      int fake_dwarf1 = heights[i];
      for (int j = i + 1; j < 9; j++) {
        int fake_dwarf2 = heights[j];

        if (all_sum - (fake_dwarf1 + fake_dwarf2) == 100) {
          heights[i] = 0;
          heights[j] = 0;

          flag = true;

          if(flag) break;
        }
      }
      if(flag) break;
    }

    Arrays.sort(heights);

    for (int i = 2; i < 9; i++) {
      System.out.println(heights[i]);
    }
  }
}

