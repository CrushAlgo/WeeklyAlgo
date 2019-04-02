package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PoketmonMaster {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] inputs = Arrays.asList(br.readLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int N = inputs[0];  // 포켓몬 수
    int M = inputs[1];  // 도감에서 찾아야 할 포켓몬의 수

    Set<Poketmon> PoketmonBook = new TreeSet<>(new Poketmon());
    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      PoketmonBook.add(new Poketmon(i, name));
    }

    for (Poketmon p : PoketmonBook) {
      System.out.format("num: %d, name: %s \n", p.num, p.name);
    }

//    System.out.format("검색 : %s \n", ((TreeSet<Poketmon>) PoketmonBook).headSet("Spearow"));
  }

  static class Poketmon implements Comparator<Poketmon> {
    int num;
    String name;

    public Poketmon() {}

    public Poketmon(int num, String name) {
      this.num = num;
      this.name = name;
    }

    @Override
    public int compare(Poketmon o1, Poketmon o2) {
      return o1.name.compareTo(o2.name);
    }
  }
}
