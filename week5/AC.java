package com.pakpark.week5;

import java.util.*;

  public class AC {

    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      int testCase = scan.nextInt();
      scan.nextLine();

      String[] RDFunc = new String[testCase];
      int[] arrSize = new int[testCase];
      String[] strArr = new String[testCase];

      for (int i = 0; i < testCase; i++) {
        RDFunc[i] = scan.nextLine();
        arrSize[i] = scan.nextInt();
        scan.nextLine();
        strArr[i] = scan.nextLine().replaceAll("[^0-9]", "");
      }

      for (int i = 0; i < strArr.length; i++) {
        //AC함수
        String RD = RDFunc[i];
        int RDFuncLength = RDFunc[i].length();

        //배열
        String arr = strArr[i];

        for (int j = 0; j < RDFuncLength; j++) {
          char func = RD.charAt(j);

          if (arr.isEmpty()) {
            System.out.println("error");
            break;
          }

          if (func == 'R') {
            arr = (new StringBuffer(arr)).reverse().toString();
          } else {
            arr = arr.substring(1, arr.length());
          }
        }

        System.out.println(arr.split("").toString());
      }

    }

  private static int[] acFunc(String functions, String array) {
    //R, 뒤집기 / D, 첫번째 인덱스 삭제
    int length = array.length();
    String[] str_arr = array.substring(1, length - 1).split(",");
    List<String> result = new LinkedList<>(Arrays.asList(str_arr));

    String[] function_arr = functions.split("");
    for (String function : function_arr) {
      if (result.get(0).equals("")) {
        return null;
      }

      if (function.equals("R")) reverse(result);
      else {
        delete(result);
      }
    }

    String[] IntegerArr = result.toArray(new String[result.size()]);
    int[] primitiveArr = new int[IntegerArr.length];
    for (int i = 0; i < IntegerArr.length; i++) {
      primitiveArr[i] = Integer.parseInt(IntegerArr[i]);
    }

    return primitiveArr;
  }

  public static List<String> reverse(List<String> arr) {
    Collections.reverse(arr);
    return arr;
  }

  private static int[] reverse(int[] arr) {
    Integer[] IntegerArr = new Integer[arr.length];

    for (int i = 0; i < arr.length; i++) {
      IntegerArr[i] = Integer.valueOf(arr[i]);
    }

    Arrays.sort(IntegerArr, Collections.reverseOrder());

    int[] result = new int[IntegerArr.length];
    for (int i = 0; i < IntegerArr.length; i++) {
      result[i] = IntegerArr[i].intValue();
    }

    return result;
  }


  public static List<String> delete(List<String> arr) {

    if (arr.isEmpty()) return null;
    else {
      arr.remove(0);
      return arr;
    }
  }
}
