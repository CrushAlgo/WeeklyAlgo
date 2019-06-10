package week14;

import java.util.Scanner;

public class DateCalculation {

  private static final Scanner scan = new Scanner(System.in);

  public void solve(int E, int S, int M) {
    int tempE = 0;
    int tempS = 0;
    int tempM = 0;
    int year = 0;

    while((tempE != E) || (tempS != S) || (tempM != M)) {
      year++;

      int leftE = ((tempE + 1) % 16);
      int leftS = ((tempS + 1) % 29);
      int leftM = ((tempM + 1) % 20);

      // 나누어 떨어지면 '0' 이기 때문에 '1 -> 15 -> 1' 을 맞춰주기 위해서 나누어 떨어질 때, '1'로 돌려준다.
      tempE = (leftE == 0) ? 1 : leftE;
      tempS = (leftS == 0) ? 1 : leftS;
      tempM = (leftM == 0) ? 1 : leftM;

//      System.out.format("tempE: %d, tempS: %d, tempM: %d \n", tempE, tempS, tempM);

//      if(year>10000) break;
    }

    System.out.println(year);
  }

  public static void main(String[] args) {
    int E = scan.nextInt(); // 1 -> 15
    int S = scan.nextInt(); // 1 -> 28
    int M = scan.nextInt(); // 1 -> 19

    new DateCalculation().solve(E, S, M);
  }
}
