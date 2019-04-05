package week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AC2 {

  private static final Scanner sc = new Scanner(System.in);

  private void solve() {

    int tc = sc.nextInt();
    sc.nextLine();

    String[] r = new String[tc];

    for (int k = 0; k < tc; k++) {

      String s = sc.nextLine();
      int n = Integer.parseInt(sc.nextLine());
      String i = sc.nextLine();

      ACArr a = new ACArr(n);

      a.initialize(i);

      boolean flag = false;
      for (String c : s.split("")) {

        if (c.equals("R")) {

          a.change();
          flag = true;

        }
        else {
          if(a.empty()) {

            flag = false;
            break;

          }

          flag = a.delete();

          if (!flag) break;

        }

      }

      if (flag) r[k] = a.print();
      else r[k] = "error";

    }

    for(String s : r) {
      System.out.println(s);
    }
  }

  static class ACArr {

    int[] arr;
    int s;
    int e;
    int n;

    public ACArr(int n) {
      this.arr = new int[n];
      this.s = 0;
      this.e = (n - 1);
      this.n = n;
    }

    public void initialize(String i) {
      String[] ia = i.replaceAll("[\\[\\]]", "").split(",");

      int s = ia.length;

      for(int k = 0; k < s; k++) {
        int v = 0;

        if(ia[k].equals("")) break;
        else v = Integer.parseInt(ia[k]);

        this.arr[k] = v;
      }

    }

    public void change() {
      int temp = s;

      this.s = e;
      this.e = temp;
    }

    public boolean delete() {
      boolean result = false;

      if (arr[s] != -1) {
        arr[s] = -1;

        s = (s < e) ? s + 1 : s - 1;

        result = true;
      }

      return result;
    }

    public boolean empty() {
      boolean r = false;

      if(s < 0 || s >= n || e >= n || e < 0) r = true;
      else r = false;

      return r;
    }

    public String print() {
      StringBuilder r = new StringBuilder();

      List<Integer> l = new ArrayList<>();

      for (int s : arr) {

        if (s == -1) continue;
        else l.add(s);

      }

      int n = l.size();

      r.append("[");

      if (s < e) {

        for (int i = 0; i < n; i++) {

          if (i == (n - 1)) r.append(l.get(i));
          else r.append(l.get(i) + ",");

        }

      } else {

        for (int i = (n - 1); i >= 0; i--) {

          if (i == 0) r.append(l.get(i));
          else r.append(l.get(i) + ",");

        }

      }

      r.append("]");

      return r.toString();
    }

  }

  public static void main(String[] args) {
    new AC2().solve();
  }
}
