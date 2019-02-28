package week4;

import java.util.Scanner;

public class SearchingFraction {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int input = scan.nextInt();

    int index = 0;
    int sum = 0;
    int pre_sum = 0;
    while (input > sum) {
      pre_sum = sum;

      sum += index + 1; // 등차수열
      index++;
    }

    //줄에서의 위치
    int point = (input - pre_sum);

    int mother = 1;
    int son = 1;

    //홀수면 아래에서 위로 분모 증가, 분자 감소
    if(index % 2 == 1) {
      mother = point;
      son = (index - point) + 1;
    } else {
      mother = (index - point) + 1;
      son = point;
    }

    System.out.println(son + "/" + mother);
  }
}