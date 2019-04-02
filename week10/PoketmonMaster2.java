package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PoketmonMaster2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] inputs = Arrays.asList(br.readLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int N = inputs[0] + 1;  // 포켓몬 수
    int M = inputs[1];  // 도감에서 찾아야 할 포켓몬의 수

    String[] nameArr = new String[N];
    Map<String, String> nameMap = new HashMap();

    for (int i = 1; i < N; i++) {
      String name = br.readLine();

      nameArr[i] = name;
      nameMap.put(name, String.valueOf(i));
    }

    String[] goals = new String[M];
    for (int i = 0; i < M; i++) {
      String input = br.readLine();

      if(isInteger(input)) {
        goals[i] = nameArr[Integer.parseInt(input)];
      } else {
        goals[i] = nameMap.get(input);
      }
    }

    for(String str : goals) {
      System.out.println(str);
    }
  }

  public static boolean isInteger(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
