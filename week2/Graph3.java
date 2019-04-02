import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
4 5 1
1 2
1 3
1 4
2 4
3 4

4 4 1
1 3
1 2
2 4
3 4
 */
public class Graph3 {

  public static int VERTEX;
  public static int TRUNK;

  public static int START;

  public static int[][] GRAPH;
  public static int[][] TEMP;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.asList(br.readLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    VERTEX = (input[0] + 1);  // index start -> '1'
    TRUNK = input[1];
    START = input[2];

    int[][] trunks = new int[TRUNK][2];
    for (int i = 0; i < TRUNK; i++) {
      trunks[i] = Arrays.asList(br.readLine().split(" "))
              .stream()
              .mapToInt(Integer::parseInt)
              .toArray();
    }

    Graph3 g = new Graph3();
    g.solution(VERTEX, TRUNK, START, trunks);
  }


  /*------------------------------------------------------------*/


  public void solution(int v, int t, int s, int[][] trunks) {
    setGraph(v, trunks);
    setTemp();

    /*
    System.out.println("--GRAPH--");
    view(GRAPH);

    System.out.println("--TEMP--");
    view(TEMP);
    */

    dfs(s);
    System.out.println();
    bfs(s);
  }

  public void setGraph(int v, int[][] trunks) {
    GRAPH = new int[v][v];

    for (int i = 0; i < trunks.length; i++) {
      int x = trunks[i][0];
      int y = trunks[i][1];

      GRAPH[x][y] = 1;
      GRAPH[y][x] = 1;
    }
  }

  public void setTemp() {
    TEMP = new int[VERTEX][VERTEX];
  }

  public void view(int[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
  }

  public void dfs(int start) {
    Stack<Integer> stack = new Stack<>();
    boolean[] check = new boolean[VERTEX];

    stack.push(start);
    check[start] = true;

    boolean flag = false;
    int count = 0;
    while (!stack.isEmpty()) {
      int v = stack.peek();
      count++;
      flag = false;

      if((VERTEX - 1) > count) System.out.print(v + " ");
      else System.out.print(v);

      for (int i = 1; i < GRAPH[v].length; i++) {
        if (GRAPH[v][i] == 1 && !check[i]) {
          stack.push(i);
          check[i] = true;

          flag = true;

          break;
        }
      }

      if (!flag) break;
    }
  }

  public void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] check = new boolean[VERTEX];

    queue.add(start);
    check[start] = true;

    int count = 0;
    while (!queue.isEmpty()) {
      int v = queue.poll();
      count++;

      if ((VERTEX - 1) > count) System.out.print(v + " ");
      else System.out.print(v);

      for (int i = 0; i < GRAPH[v].length; i++) {
        if (GRAPH[v][i] == 1 && !check[i]) {
          queue.add(i);
          check[i] = true;
        }
      }
    }
  }
}
