package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
8 -> 10 -> 2

314 = 3*(8*8) + 1*(8) + 4(1) -> 192 + 8 + 4 -> 204
204 = 128 + 64 + 8 + 4 -> 11001100


 */
public class OctalToBinary {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] octal = br.readLine().split("");
    int digit = octal.length;

    int binary = 0;
    for (int i = 0; i < digit; i++) {
      int num = Integer.parseInt(octal[i]);
      binary += (num * (int) Math.pow(8, (digit - 1) - i));
    }

    int multiple = 0;
    digit = -1;

    List<Integer> biList = new LinkedList<>();
    while (binary > 0) {
      if (binary <= multiple) {
        if (binary == multiple) biList.add(digit);
        else {
          digit = (digit - 1);
          biList.add(digit);
        }

        binary -= (int) Math.pow(2, digit);
        multiple = 0;
        digit = 0;
      } else {
        digit++;
        multiple = (int) Math.pow(2, digit);
      }
    }

    int size = ((LinkedList<Integer>) biList).getFirst() + 1;
    int count = biList.size() - 1;
    int[] result = new int[size];

    for(int i = 0; i < size; i++) {
      if(i == biList.get(count)) {
        result[i] = 1;
        count--;
      } else {
        result[i] = 0;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = (result.length - 1); i >=0; i--) {
      sb.append(result[i]);
    }

    System.out.println(sb.toString());
  }
}
