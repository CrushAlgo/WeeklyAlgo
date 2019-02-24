package week4;

import java.util.*;

/**
 * # 참고 사이트, '개발 일기' 블로그.
 * https://a1010100z.tistory.com/entry/%EB%B0%B1%EC%A4%80%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-2251-%EB%AC%BC%ED%86%B5-javaBFS
 */
public class WaterBasket {

  /**
   * Queue 에 객체로 저장하기 위한 inner class (Water)
   */
  class Water {
    int water_a;
    int water_b;

    Water(int param1, int param2) {
      this.water_a = param1;
      this.water_b = param2;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int A = scan.nextInt();
    int B = scan.nextInt();
    int C = scan.nextInt();

    if (A <= 0 || B <= 0 || C <= 0 || A > 201 || B > 201 || C > 201) return;

    divide(A, B, C);
  }

  public static void divide(int bucket_A, int bucket_B, int bucket_C) {
    WaterBasket wb = new WaterBasket();

    Queue<Water> water_queue = new LinkedList<>();  // 현재 3개의 bucket에 들어있는 물의 양
    boolean[][] check_bucket = new boolean[bucket_A + 1][bucket_B + 1]; // bucket A와 B에 들어갈 수 있는 경우의 수

    List<Integer> result = new ArrayList<>();

    // 처음 상태
    water_queue.add(wb.new Water(0, 0));
    check_bucket[0][0] = true;

    while (!water_queue.isEmpty()) {
      Water water = water_queue.poll(); //큐에서 물의 상태를 뽑아낸다.

      int water_A = water.water_a;
      int water_B = water.water_b;

      int water_C = bucket_C - (water_A + water_B);

      if (water_A == 0) result.add(water_C);

      // bucket A 에 물이 있으면, bucket B 나 C 로 옮긴다.
      if (water_A > 0) {
        // bucket A -> bucket B
        /**
         * bucket A, B 에 있는 물의 합이 옮기려는 물통 bucket B 의 용량보다 크다면,
         * bucket B 에는 이미 있는 물(water_A) 를 제외한 용량만 수용할 수 있다.
         */
        int left_water = (water_A + water_B) > bucket_B ? (bucket_B - water_B) : water_A; // 옮길 수 있는 물의 양

        int a = water_A - left_water;
        int b = water_B + left_water;
        if (!check_bucket[a][b]) {
          water_queue.add(wb.new Water(a, b));
          check_bucket[a][b] = true;
        }

        /**
         * bucket A -> bucket C
         * bucket C 보다 클 수가 없다(?) => 처음 물을 채울 때 bucket C에 채우기 때문에
         */
        int c = bucket_C - (water_A + water_C);
        if (!check_bucket[0][c]) {
          water_queue.add(wb.new Water(0, c));
          check_bucket[0][c] = true;
        }
      }

      // bucket B -> bucket A, C
      if (water_B > 0) {
        // bucket B -> bucket A
        int left_water = (water_A + water_B) > bucket_A ? (bucket_A - water_A) : water_B;

        int a = water_A + left_water;
        int b = water_B - left_water;
        if (!check_bucket[a][b]) {
          water_queue.add(wb.new Water(a, b));
          check_bucket[a][b] = true;
        }

        /** 이해 못함 **/
        // bucket B -> bucket C
        if (!check_bucket[water_A][0]) {
          water_queue.add(wb.new Water(water_A, 0));
          check_bucket[water_A][0] = true;
        }
      }

      // bucket C -> bucket A, B
      if (water_C > 0) {
        // bucket C -> bucket A
        int left_water = (water_C + water_A) > bucket_A ? (bucket_A - water_A) : water_C;

        int a = water_A + left_water;
        int c = bucket_C - (water_A + water_C);
        if (!check_bucket[a][c]) {
          water_queue.add(wb.new Water(a, c));
          check_bucket[a][c] = true;
        }

        // bucket C -> bucket B
        left_water = (water_C + water_B) > bucket_B ? (bucket_B - water_B) : water_C;
        int b = water_B + left_water;
        if (!check_bucket[water_A][b]) {
          water_queue.add(wb.new Water(water_A, b));
          check_bucket[water_A][b] = true;
        }
      }
    }

    Collections.sort(result);

    for(int i: result) {
      System.out.print(i + " ");
    }
  }

}
