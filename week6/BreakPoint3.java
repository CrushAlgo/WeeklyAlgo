package week6;

import java.util.*;

/*
7 7
1 4
4 5
5 1
1 6
6 7
2 7
7 3

output
3
1 6 7
 */

public class BreakPoint3 {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {
    int n = sc.nextInt();
    int m = sc.nextInt();

    List<Integer>[] l = new ArrayList[(n + 1)]; // 0 제외

    for (int i = 0; i <= n; i++) {
      l[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      int v1 = sc.nextInt();
      int v2 = sc.nextInt();

      l[v1].add(v2);
      l[v2].add(v1);
    }

    boolean[] c = new boolean[(n + 1)];
    c[0] = true;

    int r = 0;
    StringBuilder p = new StringBuilder();

    for (int i = 1; i <= n; i++) {
      int s = (i % (n - 1)) + 1;

      boolean[] cc = c.clone();
      cc[i] = true;

      cc = dfs(l, cc, s, i);

      if(isConn(cc)) continue;
      else {
        r++;
        p.append(i + " ");
      }

    }

    System.out.println(r);
    System.out.println(p.toString());
  }

  private boolean[] dfs(List<Integer>[] l, boolean[] cc, int v, int bp) {
    cc[v] = true;

    for (int i : l[v]) {

      if (!cc[i] && i != bp) {
        cc[i] = true;
        dfs(l, cc, i, bp);
      }

    }

    return cc;
  }

  private boolean isConn(boolean[] cc) {
    boolean r = true;

    for(boolean b : cc) {

      if(!b) {
        r = false;
        break;
      }

    }

    return r;
  }

  public static void main(String[] args) {
    new BreakPoint3().solve();
  }
}
