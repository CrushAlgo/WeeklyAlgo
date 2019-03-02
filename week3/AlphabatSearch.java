import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AlphabatSearch {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] input = scan.nextLine().split("");

    search(input);
  }

  public static void search(String[] input) {
    String[] alphabat = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    int[] result = new int[26];

    for (int i = 0; i < 26; i++) {
      result[i] = -1;
    }

    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < alphabat.length; j++) {
        if(input[i].equals(alphabat[j]) && result[j] == -1) {
          result[j] = i;
          break;
        }
      }
    }

    for(int i : result) {
      System.out.print(i + " ");
    }
  }
}
