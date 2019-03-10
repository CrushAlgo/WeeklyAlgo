import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-08-10.
 */
public class Main {
    public static void main(String[] args) throws Exception{
        Main problem1057 = new Main();
        problem1057.solve();
    }
    BufferedReader br;
    public void solve() throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));

        long peoples = lRead();
        long kim = lRead();
        long leem = lRead();

        peoples = (long)(Math.ceil((double)Math.sqrt((double)peoples)));

        for(int i=0;i<=peoples;i++) {
            if(Math.round((double)kim/2)==Math.round((double)leem/2)) {
                System.out.println(i+1);
                break;
            } else {
                kim = Math.round((double)kim/2);
                leem = Math.round((double)leem/2);
            }
        }
    }

    public int iRead() throws Exception {
        return Integer.parseInt(readWord());
    }

    public double dRead() throws Exception {
        return Double.parseDouble(readWord());
    }

    public long lRead() throws Exception {
        return Long.parseLong(readWord());
    }

    public String readWord() throws IOException {
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
}

