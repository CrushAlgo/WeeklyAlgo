package week7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Calendar{

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();

    input = solution(input);
    System.out.println(input);
  }

  /**
   * 일주일은 7일, 'date' 나누기 '7'의 나머지를 'day' 로 설정.
   * : (1 % 7) = 1, (2 % 7) = 2 ... (31 % 7) = 3, (32 % 7) = 4
   *
   * @param input
   */
  public static String solution(String input) {
    String result = "";

    String[] inputs = input.split(" ");

    int month = Integer.parseInt(inputs[0]);
    int date = Integer.parseInt(inputs[1]);

    String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    //1,3,5,7,8,10,12월-31일 4,6,9,11월-30일 2월-28일
    //1월 1일은 'MON'
    int sum = 0;

    List<Integer> one = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
    //2월 : 28일

    for (int i = 1; i < month; i++) {
      if (i == 2) sum += 28;
      else if(one.contains(i)) sum += 31;
      else sum += 30; // 4,6,9,11월
    }

    date += sum;

    result = day[date % 7];

    return result;
  }
}
