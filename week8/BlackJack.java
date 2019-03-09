package week8;

import java.util.*;

/**
 * - 첫째줄에 '카드의 갯수, N' 과 '블랙젝 숫자 인, M' 이 주어진다.
 * - 'N' 개의 카드 중 '3'장을 골라, 'M' 에 가장 가까운 숫자를 만들어야 한다.
 * <p>
 * # solution
 * : 3장의 합이 'M'과 가장 가까운 걸 알아야 한다. -> 'M' - '3장의 합' 이 가장 작은 것이 제일 가까울 것.
 * : 'N' 장의 경우의 수를 따져야 한다.
 * - 만약, 'M' 을 넘는 카드 가 있다면 배제한다.
 * - 카드는 서로 다르기 때문에 최소 '1', '2', 'K' 가 될 것이기 때문에, 'M' - 'K' 가 3보다 작은 카드는 배제한다.
 * (하지만 주어진 'N' 의 범위가 '3' 이상 부터 임으로, 최소는 '3', '4', 따라서 'M' - 'K' 가 7보다 작은 카드는 배제한다.)
 * - 전체 비교 한다. (브루트 포스)
 * : 'M' 과 'N' 이 똑같으면 종
 */
public class BlackJack {

  public static void main(String[] args) {
    int N, M;
    Integer[] cards;
    try (Scanner scan = new Scanner(System.in)) {
      String[] input = scan.nextLine().split(" ");
      N = Integer.parseInt(input[0]);
      M = Integer.parseInt(input[1]);

      cards = new Integer[N];
      String[] inputCards = scan.nextLine().split(" ");
      for (int i = 0; i < N; i++) {
        cards[i] = Integer.valueOf(inputCards[i]);
      }
    }

    System.out.println(solution(M, cards));
  }

  public static int solution(int M, Integer[] cards) {
    int result = 0;

//    List<Integer> cardList = new ArrayList<>(Arrays.asList(cards));
//    for (Iterator<Integer> iter = cardList.iterator(); iter.hasNext();) {
//      int num = iter.next();
//      if (num >= M || (M - num) < 7) iter.remove();
//      else continue;
//    }
//    System.out.println(Arrays.asList(cardList));

    List<Integer> cardListOrdered = new LinkedList<Integer>(Arrays.asList(cards));
    int size = cardListOrdered.size();

    int minus = 0;
    for (int i = 0; i < size - 2; i++) {
      int firPick = cardListOrdered.get(i);
      for (int j = i + 1; j < size - 1; j++) {
        int secPick = cardListOrdered.get(j);
        for (int k = j + 1; k < size; k++) {
          int thiPick = cardListOrdered.get(k);
          int sum = (firPick + secPick + thiPick);
          int diff = (M - sum);

          if(sum <= M && (M - sum) < (M - result)) result = sum;
        }
      }
    }

    return result;
  }
}
