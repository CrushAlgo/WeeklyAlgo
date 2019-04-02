import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input = Arrays.asList(br.readLine().split(" "))
            .stream()
            .mapToInt(Integer::parseInt)
            .toArray();

    int vertex = input[0];
    int trunk = input[1];
    int start = input[2];

    int[][] vertexes = new int[trunk][2];

    for (int i = 0; i < trunk; i++) {
      String[] vInput = br.readLine().split(" ");

      vertexes[i][0] = Integer.parseInt(vInput[0]) - 1;
      vertexes[i][1] = Integer.parseInt(vInput[1]) - 1;
    }

    Graph graph = new Graph(vertex, trunk);
    graph.setGraph(vertexes);

    solution(graph, start - 1);

    br.close();
  }

  public static void solution(Graph graph, int start) {
    Graph g = graph;
    Point point = g.getStart(start);

    g.dfs(point);
    g.resetTemp();
    System.out.println();

    g.bfs(point);
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" +
              "x=" + x +
              ", y=" + y +
              '}';
    }
  }

  static class Graph {
    int vertex;
    int trunk;

    int[][] map;
    int[][] temp;

    public Graph(int v, int t) {
      this.vertex = v;
      this.trunk = t;

      map = new int[v][v];
      temp = new int[v][v];
    }

    public void setGraph(int[][] input) {
      for (int i = 0; i < this.trunk; i++) {
        map[input[i][0]][input[i][1]] = 1;
        map[input[i][1]][input[i][0]] = 1;
      }
    }

    // 시작점 찾기
    public Point getStart(int start) {
      Point point = null;

      for (int i = 0; i < this.vertex; i++) {
        if (map[start][i] == 1) {
          point = new Point(start, i);

          temp[start][i] = 1;
          temp[i][start] = 1;

          break;
        }
      }

      return point;
    }

    public void dfs(Point point) {
      Stack<Point> stack = new Stack<>();
      stack.push(point);

      Set<Integer> pointSet = new HashSet<>();

      boolean flag = false;
      boolean popFlag = false;

      while (!stack.empty()) {
        flag = false;

        point = stack.peek();
        if (popFlag) {
          stack.pop();
          popFlag = false;
        }
        pointSet.add(point.x);

        int x = point.y;
        int y = point.x;

        for (int i = 0; i < this.vertex; i++) {
          if (map[x][i] == 1 && temp[x][i] != 1) {
            if (pointSet.contains(x)) popFlag = true;

            stack.push(new Point(x, i));

            temp[x][i] = 1;
            temp[i][x] = 1;

            flag = true;

            break;
          }
        }

        if (!flag) break;
      }

      int[] result = new int[this.vertex];
      int idx = 0;
      while (!stack.empty()) {
        Point p = stack.pop();
        result[idx++] = p.x;
      }

      for (int i = result.length - 1; i >= 0; i--) {
        System.out.print(result[i] + 1 + " ");
      }
    }

    public void bfs(Point point) {
      Queue<Point> queue = new LinkedList<>();
      queue.add(point);

      boolean flag = false;
      int count = 0;
      while (!queue.isEmpty()) {
        flag = false;

        Point p = queue.poll();

        int x = p.x;
        int y = p.y;


        for (int i = 0; i < this.vertex; i++) {
          if (map[x][i] == 1 && temp[x][i] != 1) {
            queue.add(new Point(i, x));

            flag = true;

            temp[x][i] = 1;
            temp[i][x] = 1;

          }
        }

        if(count < this.vertex) {
          System.out.print((x + 1) + " ");
          count++;
        }
      }
    }

    public void resetTemp() {
      this.temp = new int[this.vertex][this.vertex];
    }

    public void view(int[][] map) {
      for (int i = 0; i < this.vertex; i++) {
        for (int j = 0; j < this.vertex; j++) {
          System.out.print(map[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
