import java.io.*;
import java.util.Arrays;

public class AlphabatSearch2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    br.close();

    int[] result = new int[26];
    Arrays.fill(result, -1);

    //ASCII code, 97 = 'a'
    for (int i = 0; i < input.length(); i++) {
      int index = (int) input.charAt(i) - 97;
      if(result[index] == -1) result[index] = i;
      else continue;
    }

    for(int i : result) bw.write(i + " ");
    bw.close();
  }
}
