package com.pakpark.Forth;

import java.util.Scanner;

/**
 * 주어진 점(x,y)에서 가로, 세로 방향으로 거리를 측정 했을 때 가장 작은 값이 직사각형의 경계까지 가는 최소값이라고 생각했다.
 * 시작점이 (0,0) 이고 대각의 끝 점이 (w,h) 이기 때문에 음수를 고려할 필요 없었다.
 */
public class MinBoundary {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] input = scan.nextLine().split(" ");
    int x = Integer.parseInt(input[0]);
    int y = Integer.parseInt(input[1]);
    int w = Integer.parseInt(input[2]);
    int h = Integer.parseInt(input[3]);

    minLength(x, y, w, h);
  }

  public static void minLength(int x, int y, int w, int h) {
    int minX = x;
    int minY = y;

    if(minX > (w-x)) minX = (w-x);
    if(minY > (h-y)) minY = (h-y);

    if(minX > minY) System.out.println(minY);
    else System.out.println(minX);
  }
}
