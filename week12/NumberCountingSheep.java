package week12;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberCountingSheep {

  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int N = sc.nextInt();

    String[] r = new String[N];

    for(int i = 0; i < N; i++) {
      int num = sc.nextInt();

      int j = 1;

      boolean[] check = new boolean[10];
      int cCount = 0;

      Set<Integer> numSet = new HashSet<>();

      boolean flag = false;

      int num2 = 0;
      while(cCount != 10) {

        num2 = (num * j++);
        String t = String.valueOf(num2);

        System.out.format("num: %d \n", num2);

        if(numSet.contains(num2)) {
          flag = true;
          break;
        }

        numSet.add(num2);

        for(int k = 0; k < t.length(); k++) {
          int c = t.charAt(k) - '0';

          if(check[c]) continue;
          else {
            check[c] = true;
            cCount++;
          }
        }
      }

      if(flag) r[i] = "INSOMNIA";
      else r[i] =String.valueOf(num2);
    }

    for(int i = 0; i < r.length; i++) {
      System.out.format("CASE #%d: %s", i + 1, r[i]);
      if(i != r.length - 1) System.out.println();
    }
  }
}
