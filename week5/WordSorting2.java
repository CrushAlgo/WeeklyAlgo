package week5;

import java.util.*;

public class WordSorting2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int tour = scan.nextInt();
    scan.nextLine();

    //순서를 보장하는 Map
    Map<String, Integer> word_length_map = new LinkedHashMap<>();

    for (int i = 0; i < tour; i++) {
      String word = scan.nextLine();
      word_length_map.put(word, word.length());
    }

    Map<String, Integer> sortedMap = sortByValue(word_length_map);

    sortedMap.forEach((k, v) -> {
      System.out.format("%s \n", k);
    });
  }

  private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

    //{'key', 'value'} => {'key=value'}
    List<Map.Entry<String, Integer>> list =
            new LinkedList<>(unsortMap.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      public int compare(Map.Entry<String, Integer> o1,
                         Map.Entry<String, Integer> o2) {
        if(o1.getValue() == o2.getValue()) {
          for(int i=0; i<o1.getValue(); i++) {
            if(o1.getKey().charAt(i) == o2.getKey().charAt(i)) continue;
            else return o1.getKey().charAt(i) < o2.getKey().charAt(i) ? -1 : 1;
          }
        }
        return (o1.getValue()).compareTo(o2.getValue());
      }
    });

    Map<String, Integer> sortedMap = new LinkedHashMap<>();
    for(Map.Entry<String, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }
}
