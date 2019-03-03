import java.io.*;
import java.math.BigInteger;

public class FibonacciNumberThird {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int input = Integer.parseInt(br.readLine());
    br.close();

    System.out.println(solution2(input));
  }

  /**
   * 'BigInteger' 거대 무한 정수 사칙연산.
   * : 자바의 64비트 정수형인 long 형으로도 담을 수 없는 정수 연산이 필요할 경우 사용.
   * :'BigInteger'는 숫자의 크기에 제한이 없다, 사실상 무한대의 정수를 저장 할 수 있다.
   * : 기본 자료형의 사칙연산과 달리 '+, -, *, /, %, ...' 의 기호로 연산 할 수 없고, 메소드를 사용해야 한다.
   * <p>
   * # http://mwultong.blogspot.com/2007/01/java-biginteger-big-int-plus-minus.html
   *
   * @param N
   * @return1
   */
  public static BigInteger solution1(int N) {
    BigInteger result = new BigInteger("0");
    BigInteger f1 = new BigInteger("0");
    BigInteger f2 = new BigInteger("1");

    if (N == 0) return result;
    result = f1.add(f2);

    for (int i = 2; i < N; i++) {
      f1 = f2;
      f2 = result;
      result = f1.add(f2);
    }

    return result.remainder(BigInteger.valueOf(1000000));
  }

  /**
   * 피사노 주기(Pisano Period)
   * : 피보나치 수를 'K' 로 나눈 나머지는 항상 주기를 가지게 된다.
   * : 피보나치 수를 '3'으로 나누었을 때, 주기의 길이는 '8'이다.
   * => 'N' 번 까지의 피보나치 수를 '3'으로 나눈 몫이 '8'개씩 반복 된다.
   * => 주기의 길이가 'P' 이면, 'N' 번째 피보나치 수를 'M' 으로 나눈 나머지는 'N % P' 번째 피보나치 수를 'M' 으로 나눈 나머지와 같다.
   *
   * https://www.acmicpc.net/blog/view/28
   * @param N
   * @return
   */
  public static BigInteger solution2(int N) {
    int mod = 1000000;
    int P = (mod / 10 * 15);

    BigInteger[] fibo = new BigInteger[P];
    fibo[0] = new BigInteger("0");
    fibo[1] = new BigInteger("1");

    for (int i = 2; i < P; i++) {
      fibo[i] = fibo[i-1].add(fibo[i-2]);
      fibo[i] = fibo[i].remainder(BigInteger.valueOf(mod));
    }

    return fibo[N%P] ;
  }

  /**
   * Recursive
   * - 'N' 번쨰 피보나치 수.
   * - 'N'번째 피보나치 수는, 'N-1' 번째와 'N-2' 번째 수의 합이다.
   * @param N
   * @return
   */
  public static int solution3(int N) {
    if (N <= 1) {
      System.out.format("solution2: %d \n", N);
      return N;
    } else {
      return solution3(N - 1) + solution3(N - 2);
    }
  }
}
