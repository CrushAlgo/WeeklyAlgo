package week12;

import java.util.*;

public class KakaoMoney {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int N = sc.nextInt();

    int[] flow = new int[N];
    int[] left = new int[N];

    for (int i = 0; i < N; i++) {
      flow[i] = sc.nextInt();
      left[i] = sc.nextInt();
    }

    int kMoney = 0;

    List<List<Integer>> resultList = new LinkedList<>();

    for (int i = 0; i < N; i++) {

      int withdraw = 0;

      kMoney += flow[i];

      if (kMoney > 0) continue;
      else {
        withdraw = -kMoney + left[i];

        kMoney = left[i];
      }

      List<Integer> list = new LinkedList<>();
      for (int j = 1; j <= withdraw; j++) {

        if ((withdraw % j == 0)) list.add(j);
        else continue;

      }

      List<Integer> rList = new LinkedList<>();

      int lastIdx = list.size() - 1;
      for (int j = lastIdx; j >= 0; j--) {

        int candidate = list.get(j);

        int sum = (i == 0 ? 0 : left[i - 1]);

        while (sum < Math.abs(flow[i])) {
          sum += candidate;
        }

        // 가능한 최소 입금 금액
        if ((sum + flow[i]) == left[i]) {
          rList.add(candidate);
        }
      }

      resultList.add(rList);
      System.out.format("최소 충전 금액 : %d , 약수 : %s \n", withdraw, Arrays.toString(rList.toArray()));
    }

    // list 두 개 비교해서 겹치는 것만 뽑아낸다.
    Set<Integer> result = null;

    int s = resultList.size() - 1;
    for (int i = s; i >= 0; i-- ) {
      boolean flag = false;

      if(i == s) {
        result = new HashSet<>(resultList.get(i));
        flag = true;
      }
      else {

        for (int w : resultList.get(i)) {
          if (result.contains(w)) {
            flag = true;
          }
        }
      }

      if(!flag) {
        result.clear();
        result.add(-1);
        break;
      }
    }

    System.out.println(result.iterator().next());
  }

  public static void main(String[] args) {
    new KakaoMoney().solve();
  }
}
