package week6;

import java.util.*;

public class BreakPoint2 {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    int t = sc.nextInt();

    List<Integer>[] m = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      m[i] = new ArrayList<>();
    }

    for (int i = 0; i < t; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      m[v1].add(v2);
      m[v2].add(v1);
    }

    Graph g = new Graph(n);
    g.initialize(m);

    int bc = 0;
    List<Integer> l = new LinkedList<>();

    for (int i = 1; i <= n; i++) {

      if (g.isBreakPoint2(i)) {
        bc++;
        l.add(i);
      }

    }

    System.out.println(bc);
    if (l.size() == 0) System.out.println(0);
    else {
      for (Integer i : l) {
        System.out.print(i + " ");
      }
    }
  }

  /**
   * 1. 그래프 탐색 확인 메소드
   */
  static class Graph {
    int n;
    List<Integer>[] m;

    public Graph(int n) {
      this.n = (n + 1);
    }

    public void initialize(List<Integer>[] m) {
      this.m = m;
    }

    // list
    public boolean isBreakPoint2(int v) {
      boolean r = false;

      int v2 = (v % (n - 1)) + 1;

      Stack<Integer> s = new Stack<>();
      boolean[] c = new boolean[n];
      c[0] = true;

      s.push(v2);
      c[v] = true;  // 단절점 후보
      c[v2] = true;

      boolean f;
      while (!s.empty()) {
        int vv = s.peek();

        f = false;

        for(int i : m[vv]) {
          if(!c[i] && v != i) {
            s.push(i);
            c[i] = true;

            f = true;

            break;
          }
        }

        if(!f) s.pop();
      }

      for(boolean b : c) {

        if(!b) {
          r = true;
          break;
        }

      }

      return r;
    }

    /*
    public boolean isBreakPoint(int v) {
      boolean r = false;

      int[][] t = remove(v);

      Stack<Integer> s = new Stack<>();
      boolean[] c = new boolean[n];

      c[0] = true;

      int sv = (v % (n - 1)) + 1;
      s.push(sv);

      c[v] = true;
      c[sv] = true;

      boolean f = false;
      while (!s.empty()) {
        int v2 = s.peek();

        f = false;

        for (int i = 0; i < n; i++) {

          if (t[v2][i] == 1 && !c[i]) {
            s.push(i);

            c[i] = true;
            f = true;

            break;
          }

        }

        if (!f) s.pop();
      }

      for (boolean b : c) {

        if (!b) {
          r = true;
          break;
        }

      }

      return r;
    }

    public boolean isConnected() {
      Stack<Integer> s = new Stack<>();
      boolean[] c = new boolean[n];

      c[0] = true;

      boolean r = true;

      s.push(1);
      c[1] = true;

      boolean f = false;
      while (!s.empty()) {
        int v = s.peek();

        f = false;

        for (int i = 1; i < n; i++) {

          if (m[v][i] == 1 && !c[i]) {
            s.push(i);
            c[i] = true;
            f = true;

            break;
          }

        }

        if (!f) s.pop();
      }

      for (boolean b : c) {

        if (!b) {
          r = false;
          break;
        }

      }

      return r;
    }

    private int[][] remove(int v) {
      List<Integer>[] t = new ArrayList[n - 1];

      for (int r = 0; r < n; r++) {

        if (r == v) {

          Arrays.fill(t[v], 0);
          continue;
        }

        for (int c = 1; c < n; c++) {

          if (c == v) {
            t[r][v] = 0;
            continue;
          }

          t[r][c] = m[r][c];

        }

      }

      return t;
    }
    */

    public void view(int[][] m) {
      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[i].length; j++) {
          System.out.print(m[i][j] + " ");
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    new BreakPoint2().solve();
  }
}
