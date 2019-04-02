package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OctalToBinary2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();   // 8진수

    solution(input);
  }

  public static void solution(String input) {
    int num = octalToInt(input);
    String result = intToBinary(num);

    System.out.println(result);
  }

  public static String intToBinary(int num) {
    String result = "";
    int[] biArr = null;

    if(num == 0) {
      return "1";
    }

    int square = 0;
    int multiple = 0;
    int temp = 0;
    int left = num;

    while(left != 0) {
      while (left >= multiple) {
        temp = multiple;
        multiple = (int) Math.pow(2, square++);
      }

      if(biArr == null) {
        biArr = new int[square -1];
        biArr[square - 2] = 1;
      }
      else biArr[square - 2] = 1;

      left -= temp;

      square = 0;
      multiple = 0;
    }

    for(int i = biArr.length - 1; i >=0; i--) {
      result += biArr[i];
    }

    return result;
  }

  public static int octalToInt(String input) {
    int result = 0;
    int octal = 8;

    int square = input.length() - 1;
    for (int i = 0; i < input.length(); i++) {
      int num = Character.getNumericValue(input.charAt(i));

      result += (num * Math.pow(octal, square--));
    }

    return result;
  }
}
