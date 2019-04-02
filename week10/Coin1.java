package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.asList(br.readLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int N = input[0];
    int goal = input[1];

    int[] coin = new int[N];
    for (int i = 0; i < N; i++) {
      coin[i] = Integer.parseInt(br.readLine());
    }

    System.out.println(solution(goal, coin));
  }

  public static int solution(int goal, int[] coin) {
    int result = 0;
    int left = goal;

    int index = coin.length;
    while(left != 0) {
      index--;

      if(left < coin[index]) continue;
      else {
        result += (left / coin[index]);
        left = (left % coin[index]);
      }
    }

    return result;
  }
}
