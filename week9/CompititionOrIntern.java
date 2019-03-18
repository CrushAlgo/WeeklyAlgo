package week9;

import java.util.Scanner;

public class CompititionOrIntern {

  public static void main(String[] args) {
    int result = 0;

    Scanner scan = new Scanner(System.in);

    String[] input = scan.nextLine().split(" ");
    int female = Integer.parseInt(input[0]);
    int male = Integer.parseInt(input[1]);
    int intern = Integer.parseInt(input[2]);

    //(여성 수 / 2) = 팀 구성인원
    int feTeam = (female / 2);
    int leftFemale = (female % 2);

    // (여성 팀 -  남성 팀) = 남은 남성
    int leftMale = Math.abs(feTeam - male);

  }
}
