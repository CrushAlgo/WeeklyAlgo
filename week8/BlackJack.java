package week8;

import java.util.*;

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
