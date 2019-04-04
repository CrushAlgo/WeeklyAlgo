import java.util.*;

/*
참고
https://github.com/hotehrud/acmicpc/blob/master/algorithm/graph/1260_AdjacencyMatrix.java
 */

/**
 * 인접행렬
 */
public class DFSnBFS2 {

  private static Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    int t = sc.nextInt();
    int s = sc.nextInt();

    int[][] m = new int[n + 1][n + 1];

    boolean[] c = new boolean[n + 1];

    for (int i = 0; i < t; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      m[v1][v2] = 1;
      m[v2][v1] = 1;
    }

    sc.close();

    //dfs(m, c, s);
    dfs(m, c, s, false);
    System.out.println();
    Arrays.fill(c, false);  // 정점 체크 배열 초기화
    bfs(m, c, s);

  }

  // 재귀 - DFS
  public static void dfs(int[][] m, boolean[] c, int v) {
    int n = m.length;

    c[v] = true;
    System.out.print(v + " ");

    // 인접행렬 크기, 정점의 시작이 '1' 부터여서 행렬의 인덱스와 정점을 맞추기 위해 행렬 크기를 '1' 키움.
    for (int i = 1; i < n; i++) {

      if (m[v][i] == 1 && !c[i]) {
        dfs(m, c, i);
      }

    }
  }

  /**
   * 스택 - DFS
   * @param flag  - 'DFS' 탐색 시, 간선을 타고 타고 들어가야 하기 때문에, 탐색에 제한을 두기 위한 'flag'
   */
  public static void dfs(int[][] m, boolean[] c, int v, boolean flag) {
    Stack<Integer> s = new Stack<>();
    int n = m.length;

    s.push(v);
    c[v] = true;

    System.out.print(v + " ");

    while (!s.empty()) {
      v = s.peek();

      flag = false;

      for (int i = 1; i < n; i++) {

        if(m[v][i] == 1 && !c[i]) {
          s.push(i);

          System.out.print(i + " ");

          c[i] = true;
          flag = true;
        }

      }

      if(!flag) s.pop();
    }
  }

  // 큐 - BFS
  public static void bfs(int[][] m, boolean[] c, int v) {
    Queue<Integer> q = new LinkedList<>();
    int n = m.length;

    q.add(v);
    c[v] = true;

    while (!q.isEmpty()) {

      v = q.poll();
      System.out.print(v + " ");

      for (int i = 1; i < n; i++) {

        if (m[v][i] == 1 && !c[i]) {
          q.add(i);
          c[i] = true;
        }

      }

    }

  }

  public static void main(String[] args) {
    new DFSnBFS2().solve();
  }
}
