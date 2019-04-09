package week11;

import java.util.Scanner;

public class CroatiaAlpha {
  private static final Scanner sc = new Scanner(System.in);

  private String[] croati = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

  private void solve() {
    String s = sc.nextLine();

    for(int i = 0; i < croati.length; i++) {
      s = s.replaceAll(croati[i], String.valueOf(i));
    }

    System.out.println(s.length());
  }

  public static void main(String[] args) {
    new CroatiaAlpha().solve();
  }
}
