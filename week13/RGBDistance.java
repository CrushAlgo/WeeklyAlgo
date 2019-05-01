package week13;

import java.util.Arrays;
import java.util.Scanner;

public class RGBDistance {

  private static final Scanner sc = new Scanner(System.in);

  static class RGB {
    int red, green, blue;

    public RGB(int red, int green, int blue) {
      this.red = red;
      this.green = green;
      this.blue = blue;
    }

    @Override
    public String toString() {
      return "RGB{" +
              "red=" + red +
              ", green=" + green +
              ", blue=" + blue +
              '}';
    }
  }

  /*
  각 집 마다 RGB 색으로 칠 했을 때의 최소값을 구한다.
  기준은 'R', 'G', 'B'
   */
  private void solve(int N, RGB[] rgbArr) {
    int[][] eachResult = new int[N][3];   //집의 개수(N), RGB(3)

    //각 집마다 돌면서 RGB 최소값을 구한다.
    for (int i = 0; i < N; i++) {
      int red = rgbArr[i].red;
      int green = rgbArr[i].green;
      int blue = rgbArr[i].blue;

      if (i == 0) {
        eachResult[i] = new int[]{red, green, blue};
      } else {
        //조건, RGB 색상이 연속 되면 안된다.
        for (int j = 0; j < 3; j++) {
          switch (j) {
            case 0:
              eachResult[i][j] = Math.min((eachResult[i - 1][1] + red), (eachResult[i - 1][2] + red));
              break;

            case 1:
              eachResult[i][j] = Math.min((eachResult[i - 1][0] + green), (eachResult[i - 1][2] + green));
              break;

            case 2:
              eachResult[i][j] = Math.min((eachResult[i - 1][0] + blue), (eachResult[i - 1][1] + blue));
              break;
          }
        }
      }

    }

    Arrays.sort(eachResult[N - 1]);
    System.out.println(eachResult[N - 1][0]);
  }

  public static void main(String[] args) {
    int N = sc.nextInt();
    sc.nextLine();

    RGB[] rgbArr = new RGB[N];

    for (int i = 0; i < N; i++) {
      int red = sc.nextInt();
      int green = sc.nextInt();
      int blue = sc.nextInt();

      rgbArr[i] = new RGB(red, green, blue);
    }

    new RGBDistance().solve(N, rgbArr);
  }
}
