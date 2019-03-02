package week4;

import java.util.Scanner;

/**
 * 주어진 입력에 대해 10개씩 출력한다고 생각했다.
 * 10개를 판단하는 기준으로 문자 배열을 읽어 가면서 10에 해당하는 인덱스를 산술계산을 통해 파악.
 */
public class TenCut {
  public static void main(String[] args) {
    //첫째 줄에 단어가 주어진다. 단어는 알파벳 소문자와 대문자로만 이루어져 있으며, 길이는 100을 넘지 않는다. 길이가 0인 단어는 주어지지 않는다.
    Scanner scan = new Scanner(System.in);
    String test = scan.nextLine();
    tenCut(test);
  }

  public static void tenCut(String str) {
    String[] strArr = str.split("");

    int index = 0;

    for (int i = 0; i < strArr.length; i++) {
      index = i + 1;
      System.out.print(strArr[i]);
      if(index%10 == 0) {
        System.out.println();
      }
    }
  }
}
