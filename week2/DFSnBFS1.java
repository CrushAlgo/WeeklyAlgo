import java.util.*;

/*
참고
https://github.com/hotehrud/acmicpc/blob/master/algorithm/graph/1260_AdjacencyList.java
 */

/**
 * 리스트
 */
public class DFSnBFS1 {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int v = sc.nextInt();

    List<Integer>[] l = new ArrayList[n + 1];

    for (int i = 0; i <= n; i++) {
      l[i] = new ArrayList<>();
    }

    boolean[] c = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      l[v1].add(v2);
      l[v2].add(v1);
    }

    Arrays.stream(l).forEach(i -> Collections.sort(i));

    //dfs(l, c, v);
    dfs(l, c, v, false);
    System.out.println();
    Arrays.fill(c, false);
    bfs(l, c, v);

  }

  // 재귀 - DFS
  public static void dfs(List<Integer>[] l, boolean[] c, int v) {
    if (c[v]) return;

    c[v] = true;
    System.out.print(v + " ");

    for (int v1 : l[v]) {

      if (!c[v1]) dfs(l, c, v1);

    }
  }

  /**
   * 스택 - DFS
   *
   * @param flag - 'DFS' 탐색을 위한 'flag'
   */
  public static void dfs(List<Integer>[] l, boolean[] c, int v, boolean flag) {
    Stack<Integer> s = new Stack<>();

    s.push(v);
    c[v] = true;

    System.out.print(v + " ");

    while (!s.empty()) {
      v = s.peek();

      flag = false;

      for (int v1 : l[v]) {

        if (!c[v1]) {
          s.push(v1);

          System.out.print(v1 + " ");

          flag = true;
          c[v1] = true;

          break;
        }

      }

      if (!flag) s.pop();
    }

  }

  public static void bfs(List<Integer>[] l, boolean[] c, int v) {
    Queue<Integer> q = new LinkedList<>();

    q.add(v);
    c[v] = true;


    while (!q.isEmpty()) {
      v = q.poll();

      System.out.print(v + " ");

      for (int v1 : l[v]) {

        if (!c[v1]) {
          q.add(v1);
          c[v1] = true;
        }

      }

    }

  }


  public static void main(String[] args) {
    new DFSnBFS1().solve();
  }
}
