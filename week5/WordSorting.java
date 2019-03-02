package week5;

import java.util.*;

public class WordSorting implements Comparator<WordSorting.Word> {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int count = scan.nextInt();
    scan.nextLine();
    Set<String> wordSet = new LinkedHashSet<>();

    for (int i = 0; i < count; i++) {
      wordSet.add(scan.nextLine());
    }

    solution(wordSet);
  }

  public static void solution(Set<String> wordSet) {
    WordSorting wordSorting = new WordSorting();

    List<WordSorting.Word> wordList = new ArrayList<>();

    for (String str : wordSet) {
      wordList.add((wordSorting).new Word(str, str.length()));
    }

    Collections.sort(wordList, wordSorting);

    for (Word wordIter : wordList) {
      System.out.println(wordIter.word);
    }
  }

  @Override
  public int compare(Word o1, Word o2) {
    if (o1.length == o2.length) return dictionaryOrder(o1.word, o2.word);
    else return (o1.length > o2.length == true) ? 1 : -1;
  }

  /**
   * inner class
   */
  public class Word {
    String word;
    int length;

    public Word(String word, int length) {
      this.word = word;
      this.length = length;
    }
  }

  public static int dictionaryOrder(String word1, String word2) {
    int result = 0;

    int length = word1.length();
    for (int i = 0; i < length; i++) {
      if (word1.charAt(i) == word2.charAt(i)) continue;
      else result = (word1.charAt(i) > word2.charAt(i) == true) ? 1 : -1;
    }

    return result;
  }
}
