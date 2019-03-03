import java.util.Scanner;

public class Sugar2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    scan.nextLine();

    System.out.println(solution(N));
  }

  public static int solution(int N) {
    int result = 0;

    int three = 0;

    int five = (N / 5);
    int left = (N % 5);

    if ((N % 5) == 0) return five;
    else {
      while (five >= 0) {
        if ((left % 3) == 0) {
          three = (left / 3);
          break;
        }

        five--;
        left += 5;
      }

      result = (five < 0) ? -1 : five + three;
    }

    return result;
  }
}
