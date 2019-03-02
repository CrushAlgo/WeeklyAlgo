package week6;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int test = scan.nextInt();
    scan.nextLine();

    String[] bracketArr = new String[test];
    for (int i = 0; i < test; i++) {
      bracketArr[i] = scan.nextLine();
    }

    for (String str : bracketArr) {
      System.out.println(solution(str));
    }
  }

  public static String solution(String input) {
    String result = "NO";

    Stack<Character> checker = new Stack<>();
    for (int i = 0; i < input.length(); i++) {
      if (i == 0 && input.charAt(i) == ')') {
        return result;
      }
      else if (input.charAt(i) == '(') {
        checker.push('(');
      }
      else if (input.charAt(i) == ')') {
        if(checker.empty()) return result;
        else checker.pop();
      }
    }

    if (checker.isEmpty()) result = "YES";

    return result;
  }
}
