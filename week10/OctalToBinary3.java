package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OctalToBinary3 {

  static final String[] OCTAL_ARR_ZERO = {
          "000",
          "001",
          "010",
          "011",
          "100",
          "101",
          "110",
          "111"
  };  // 0, 1, 2, 3, 4, 5, 6, 7, 8

  static final String[] OCTAL_ARR_NON_ZERO = {
          "0",
          "1",
          "10",
          "11",
          "100",
          "101",
          "110",
          "111"
  };

  /*
  '9' 일 때는? -> 8진법 = '11' -> '001' + '001'
  '19' 일 때는? -> 8진법 = '23' -> '010' + '011'

  8진수 '314' -> '011' + '001' + '100' => '011001100'
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      int num = Character.getNumericValue(input.charAt(i));

      if(i==0) sb.append(OCTAL_ARR_NON_ZERO[num]);
      else sb.append(OCTAL_ARR_ZERO[num]);
    }

    System.out.println(sb.toString());
  }
}
