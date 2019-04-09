import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-08-19.
 *
 * 문제
 * 한수는 지금 (x, y)에 있다.
 * 직사각형의 왼쪽 아래 꼭지점은 (0, 0)에 있고, 오른쪽 위 꼭지점은 (w, h)에 있다.
 * 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
 *
 * Input
 * 첫째 줄에 x y w h가 주어진다.
 * w와 h는 1,000보다 작거나 같은 자연수이고, x는 1보다 크거나 같고,
 * w-1보다 작거나 같은 자연수이고, y는 1보다 크거나 같고, h-1보다 작거나 같은 자연수이다.
 *
 * Output
 * 첫째 줄에 문제의 정답을 출력한다.
 *
 * Example
 *
 * Input            Output
 *
 * 6 2 10 3         1
 */
public class Main {

    BufferedReader br;

    public static void main(String[] args) throws IOException{
        Main main = new Main();
        main.solve();
    }

    public void solve() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int min = 0;
        int x = iRead();
        int y = iRead();
        int w = iRead();
        int h = iRead();
        int minW = x - 0;
        int minH = y - 0;
        int minWW = Math.abs(x-w);
        int minHH = Math.abs(y-h);

        min = minW;
        if(min>minH) {
            min = minH;
        }

        if(min > minWW) {
            min = minWW;
        }

        if(min>minHH) {
            min = minHH;
        }

        System.out.println(min);
    }

    String readWorld() throws IOException{

        StringBuilder b = new StringBuilder();
        int c;
        c = br.read();
        while (c >= 0 && c <= ' ')
            c = br.read();
        if (c < 0)
            return "";
        while (c > ' ') {
            b.append((char) c);
            c = br.read();
        }
        return b.toString();
    }

    int iRead() throws IOException {
        return Integer.parseInt(readWorld());
    }
}

