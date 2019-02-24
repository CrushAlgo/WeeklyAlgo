package week2;

import java.util.*;

public class Card {

  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    int count = scan.nextInt();
    if (count < 0 && count > 1000000) return;
    else {
      System.out.println(CardCounting(count));
    }
  }

  /**
   * @param input (1 <= N <= 1,000,000)
   */
  public static long CardCounting(int input) {
    long[] cardArr = new long[input];
    long card = 0;

    Map<Long, Integer> cardMap = new HashMap<>(); //키, 값 형식의 배열

    for (int i = 0; i < input; i++) {
      card = scan.nextLong();

      cardArr[i] = card;
      if (cardMap.containsKey(card)) {
        cardMap.put(card, cardMap.get(card) + 1);
      } else {
        cardMap.put(card, 1);
      }
    }

    int maxValue = 0;
    long maxCard = 0;
    Iterator<Long> cardMapIter = cardMap.keySet().iterator();
    int cardMapSize = cardMap.size();

    //maxCard 를 '0'으로 확정을 지을 수 없다. 카드의 범위가 '0'을 포함하기 때문에.
    for (int i = 0; i < cardMapSize; i++) {
      if(i == 0) {
        maxCard = cardMapIter.next();
        maxValue = cardMap.get(maxCard);
      }
      else {
        card = cardMapIter.next();
        int value = cardMap.get(card);

        if(value > maxValue) {
          maxValue = value;
          maxCard = card;
        }

        //최대값이 같을 경우 카드에 적힌 숫자가 적은 걸 출력해 줘야 한다.
        if(value == maxValue) {
          if(maxCard > card) maxCard = card;
        }
      }
//      System.out.format("max card : %d , max value : %d \n", maxCard, maxValue);
    }

    /*
    System.out.println(Arrays.toString(cardArr));
    System.out.println(Arrays.toString(cardSet.toArray()));

    cardMap.forEach((k, v) -> {
      System.out.println(k + ", " + v);
    });
    */

    return maxCard;
  }
}
