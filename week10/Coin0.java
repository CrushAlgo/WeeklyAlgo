package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Coin0 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.asList(br.readLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int N = input[0];
    int K = input[1];   // goal

    int[] coins = new int[N];
    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(coins);

    int left = 0;
    int count = 0;
    for (int i = (N - 1); i >= 0; i--) {
      int coin = coins[i];

      left = (K % coin);
      if (left < K) {
        count += (K / coin);
        K = left;
      }
    }

    System.out.println(count);
  }
}

/*
10 4793
1
5
10
50
100
500
1000
5000
10000
50000
 */
