package com.pakpark.week6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrainTrain {

  public static void main(String[] args) {

    //내린 사람, 탄 사람
    Scanner scan = new Scanner(System.in);

    int trainSize = 4;
    String[] input = new String[trainSize];
    for(int i=0; i<trainSize; i++) {
      input[i] = scan.nextLine();
    }

    int maxPassenger = 0;
    int exPassenger = 0;
    int stay = 0;

    for (int i = 0; i < trainSize; i++) {
      String[] trainInfo = input[i].split(" ");

      int out = Integer.parseInt(trainInfo[0]);
      int in = Integer.parseInt(trainInfo[1]);

      stay = (exPassenger - out) + in;

      if(stay > maxPassenger) {
        maxPassenger = stay;
      }

      exPassenger = stay;
    }

    System.out.println(maxPassenger);
  }
}
