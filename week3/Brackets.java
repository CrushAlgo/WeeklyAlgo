package week3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/2504
 */
public class Brackets {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

//    String input = scan.nextLine();
    String test = "(()[[]])([])";
    solution(test);

  }

  // '(()[[]])([])' -> '(()[[]])' (2+3*3)*2

  public static char[] brackets = {'(', ')', '[', ']'};

  public static void solution(String input) {
    Stack<Character> stack = new Stack<>();
    Stack<Character> count = new Stack<>();

    boolean openFlag = false;
    boolean closeFlag = false;

    for (int i = 0; i < input.length(); i++) {
      if (i == 0 && (input.charAt(i) == ')' || input.charAt(i) == ']')) {
        return;
      } else {
        if ((input.charAt(i) == brackets[0]) ||
                (input.charAt(i) == brackets[2])) {
          openFlag = true;
        } else {
          openFlag = false;
        }

        switch (input.charAt(i)) {
          case '(':
            stack.push(brackets[0]);
            if(i > 0) {
              //닫는 괄호 다음에 여는 괄호 들어왔을 때.
              if(closeFlag) {
                count.push('+');
                closeFlag = false;
              } else {
                //여는 괄호 다음에 여는 괄호 들어왔을 때.
                count.push('*');
              }
            }

            count.push('2');

            break;
          case '[':
            stack.push(brackets[2]);
            if(i > 0) {
              //닫는 괄호 다음에 여는 괄호 들어왔을 때.
              if(closeFlag) {
                count.push('+');
                closeFlag = false;
              } else {
                count.push('*');
              }
            }

            count.push('3');

            break;
          case ')':
            stack.pop();
            closeFlag = true;

            break;
          case ']':
            stack.pop();
            closeFlag = true;

            break;
        }
      }
    }

    char[] result = new char[count.capacity()];
    for(int i=0; i<count.capacity(); i++) {

    }
    System.out.println(Arrays.toString(count.toArray()));
  }

}
