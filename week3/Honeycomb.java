import java.io.*;

public class Honeycomb {

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    System.out.println(solution(N));
  }

  public static int solution(int N) {
    int result = 1;

    int start = 1;
    while(N > start) {
      start += (6 * result);
      result++;
    }

    return result;
  }
}
