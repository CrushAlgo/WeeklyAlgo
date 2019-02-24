package week3;

import java.util.Scanner;

public class Sugar {
  public static void main(String[] args) {
    try(Scanner scan = new Scanner(System.in)){
      int N = scan.nextInt();

      int quotient = N/5;
      int remainder = N%5;
      int threePack = 0;

      if(remainder == 0) {
        System.out.format("%d", quotient + threePack);
        return;
      }

      while(quotient >= 0){
        if((remainder%3) == 0){
          threePack = remainder/3;
          break;
        }

        quotient--;
        remainder += 5;
      }

      System.out.format("%d", (quotient < 0) ? -1 : quotient + threePack);
    }
  }
}