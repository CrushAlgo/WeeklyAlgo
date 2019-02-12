package com.pakpark.Third;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
https://www.acmicpc.net/problem/2504
 */
public class Brackets {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String input = scan.nextLine();
    bracketsTest(input);

  }

  // '(()[[]])([])' -> '(()[[]])' (2+3*3)*2

  public static String[] brackets = {"(", ")", "[", "]"};

  public static void bracketsTest(String input) {
    int length = input.length();
    String[] bracketArr = new String[length];
    bracketArr = input.split("");

    System.out.println(Arrays.toString(bracketArr));

    Stack<String> braStack = new Stack<>();

    // ")", "]" 닫는 괄호로 시작할 경우, 올바르지 못한 괄호열(?)

    // 올바른 괄호열 인지 부터 파악.
    for (int i = 0; i < length; i++) {
      if (i == 0) {
        if (bracketArr[i] == brackets[1] || bracketArr[i] == brackets[3]) {
          break;
        }
      } else {
        // push 하는 경우, 여는 괄호 인 경우, 혹은 스텍 비어있는 경우.
        if(braStack.empty() || brackets[0] == bracketArr[i] || brackets[2] == bracketArr[i]) {
          braStack.push(bracketArr[i]);
        }
        // pop 하는 경우, 닫는 괄호 인 경우, 혹은 마지막 문자일 경우.
        else{

        }
      }
    }
  }
}
