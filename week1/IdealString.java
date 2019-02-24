package week1;

import java.util.*;

/**
 * 1. 'Ideal String', 배열의 첫번째 인덱스를 1이라고 했을 때, 가장 먼저 나오는 알파벳에 해당하는 인덱스 만큼 알파벳이 나와야 한다.
 * 2. 문자열의 길이를 사용자로 부터 입력 받는다.
 * 3. 해당 길이에 대한 가장 빠른(?) 'Ideal String' 을 출력하고, 해당하는 길이에 'Ideal String' 이 없다면, '-1'을 출력한다.
 */
public class IdealString {

  public static void main(String[] args) {
    setAlphabat();

    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();
    if (input > 100) return;

    System.out.println(idealString(input));
  }

  public static char[] ALPHABAT = new char[25];

  /**
   * @return 알파벳 배열.
   */
  public static void setAlphabat() {
    for (int i = 0; i < 25; i++) {
      ALPHABAT[i] = (char) (65 + i);
    }
  }

  /**
   * 인덱스의 갯수를 명시해 놓는 배열을 하나 만들어 놓는다.
   *
   * @param length
   */
  public static String idealString(int length) {
    String result = "";

    List<String> idealString = new LinkedList<>();
    int[] indexArr = new int[length];
    int idealSum = 0;
    int idealNum = 1;
    int index = 0;
    int preIndex = 0;

    while (length != idealSum) {     // 6 != 0 / 6 != 1 / 6 != 3
      indexArr[index] = idealNum;   // indexArr: [1] / [1, 2] / [1, 2, 0, 3]
//      System.out.format("indexArr: %s \n", Arrays.toString(indexArr));

      idealSum += indexArr[index];  // idealSum:  1 / 3 / 6
      if (idealSum > length) {
        idealSum -= indexArr[index];

        for (int i = index - 1; i > preIndex; i--) {
          idealSum += indexArr[i];

          if (idealSum == length) break;
          else {
            idealSum -= indexArr[i];
          }

          if(i == preIndex - 1) return "-1";
        }
    }

      preIndex = index;
      index = idealSum;           //  index: 1 / 3 / 6
      idealNum = index + 1;                 //  idealNum: 1 / 2 / 3
    }

    return Arrays.toString(indexArr);
  }

}