package week7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://kwanghyuk.tistory.com/4
public class ClimbingStair {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    scan.nextLine();

    int[] stairs = new int[N];
    for (int i = 0; i < N; i++) {
      stairs[i] = scan.nextInt();
      scan.nextLine();
    }

    System.out.println(solution(N, stairs));
  }

  public static int solution(int N, int[] stairs) {
    int result = 0;

    List<List<Integer>> cases = new ArrayList<>();

    int sum = 0;
    boolean[] stepCheaker = {false, false, false};

    for (int i = 0; i < 8; i++) {
      int[] step;

      if (i == 4) step = new int[]{0, 2, 1};
      else step = new int[]{0, 1, 2};

      int left = (i % 4);

      switch (left) {
        case 0:
          stepCheaker[0] = false;
          stepCheaker[1] = false;
          break;
        case 1:
          stepCheaker[0] = true;
          stepCheaker[1] = false;
          break;
        case 2:
          stepCheaker[0] = false;
          stepCheaker[1] = true;
          break;
        case 3:
          stepCheaker[0] = true;
          stepCheaker[1] = true;
          break;
      }

      List<Integer> steps = new ArrayList<>();

      while (N != sum) {
        if (N < sum) {
          steps.clear();
          break;
        }

        if (!stepCheaker[0] || !stepCheaker[1]) {
          sum += step[1];
          steps.add(step[1]);

          if (!stepCheaker[0]) stepCheaker[0] = true;
          else if (stepCheaker[0] && !stepCheaker[1]) stepCheaker[1] = true;

//          System.out.format("sum : %d, step : %d \n", sum, step[1]);
        } else if(!stepCheaker[2]){
          sum += step[2];
          steps.add(step[2]);

          stepCheaker[0] = false;
          stepCheaker[1] = true;
          // '2' 다음에 '1', '1' 나오면 안된다.

//          System.out.format("sun : %d, step : %d \n", sum, step[2]);
        } else {
          sum += step[2];
          steps.add(step[2]);

          stepCheaker[0] = false;
          stepCheaker[1] = true;
        }
      }
      sum = 0;
      cases.add(steps);

      System.out.println(Arrays.toString(cases.toArray()));
    }

    int max = 0;
    for (List<Integer> listIter : cases) {
      int temp = 0;

      if (listIter.isEmpty()) continue;
      else {
        int index = 0;
        for (int i = 0; i < listIter.size(); i++) {
          index += listIter.get(i) - 1;
          temp += stairs[index];
        }

        if (max < temp) max = temp;
      }
    }

    result = max;

    return result;
  }
}
