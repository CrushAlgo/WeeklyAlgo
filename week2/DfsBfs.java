import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class DfsBfs {

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] input = Arrays.asList(scanner.nextLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int vertex = input[0];
    int trunk = input[1];
    int start = input[2];

    int[][] map = new int[vertex + 1][vertex + 1];

    for (int i = 0; i < trunk; i++) {
      String[] line = scanner.nextLine().split(" ");

      int v1 = Integer.parseInt(line[0]);
      int v2 = Integer.parseInt(line[1]);

      map[v1][v2] = 1;
      map[v2][v1] = 1;
    }

    solution(vertex, start, map);
  }

  static String solution(int v, int s, int[][] map) {
    String result = "";

    Graph graph = new Graph(v, s);
    graph.setMap(map);

    //Integer[] dfsArr = graph.dfs();
    Integer[] dfsArr = graph.recursiveDFS(s);
    Integer[] bfsArr = graph.bfs();

    for (int i = 0; i < dfsArr.length; i++) {
      if ((dfsArr.length - 1) == i) System.out.print(dfsArr[i]);
      else System.out.print(dfsArr[i] + " ");
    }

    System.out.println();

    for (int i = 0; i < bfsArr.length; i++) {
      if ((bfsArr.length - 1) == i) System.out.print(bfsArr[i]);
      else System.out.print(bfsArr[i] + " ");
    }

    return result;
  }

  static class Graph {
    int[][] map;
    int start;
    int vertex;

    public Graph(int vertex, int start) {
      this.vertex = vertex;
      this.start = start;
    }

    public void setMap(int[][] map) {
      this.map = map;
    }

    public Integer[] bfs() {
      List<Integer> result = new LinkedList<>();

      Queue<Integer> queue = new LinkedList<>();
      queue.add(start);
      result.add(start);

      boolean[] check = new boolean[vertex + 1];
      check[start] = true;

      int idx = 0;
      while (!queue.isEmpty()) {
        int now = queue.poll();

        for (int i = 0; i < map[now].length; i++) {
          if (map[now][i] == 1 && !check[i]) {
            queue.add(i);

            check[i] = true;

            result.add(i);
          }
        }
      }

      return result.stream().toArray(Integer[]::new);
    }

    public Integer[] recursiveDFS(int v) {
      boolean[] checker = new boolean[vertex + 1];

      boolean flag = false;

      int result = 0;
      for (int mapItr = 0; mapItr < vertex; mapItr++) {
        if (map[v][mapItr] == 1 && !checker[v]) {
          checker[v] = true;
          flag = true;
          result = mapItr;

          recursiveDFS(mapItr);
        }
      }

      List<Integer> resultList = new LinkedList<>();
      if(flag) resultList.add(result);

      return resultList.toArray(new Integer[resultList.size()]);
    }

    public Integer[] dfs() {
      int[] result = new int[vertex];

      Stack<Integer> stack = new Stack<>();
      stack.push(start);

      boolean[] check = new boolean[vertex + 1];
      check[start] = true;
      result[0] = start;

      boolean flag;
      int idx = 0;
      while (!stack.empty()) {
        int now = stack.peek();

        flag = false;


        for (int i = 0; i < map[now].length; i++) {
          if (map[now][i] == 1 && !check[i]) {
            stack.push(i);
            check[i] = true;

            flag = true;

            result[++idx] = i;

            break;
          }
        }

        if (!flag) break;
      }

      return stack.toArray(new Integer[stack.size()]);
    }
  }
}
