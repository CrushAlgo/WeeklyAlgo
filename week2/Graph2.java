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
    graph.view();

    solution(graph, start - 1);

    br.close();
  }

  public static void solution(Graph graph, int start) {
    Graph g = graph;
    Point point = g.getStart(start);

//    g.dfs(point);
  }

  static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
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

    // 시작점 찾
    public Point getStart(int start) {
      Point point = null;

      for(int i = 0; i < this.vertex; i++) {
        if(map[start][i] == 1) {
          point = new Point(start, i);

          temp[start][i] = 1;
          temp[i][start] = 1;

          break;
        }
      }

      return point;
    }

    /*
    public List<Point> dfs(Point point) {
      Stack<Point> stack = new Stack<>();
      stack.push(point);

      boolean flag = false;

      while (!stack.empty()) {
        point = stack.peek();

        int x = point.y;
        int y = point.x;

        for (int i = 0; i < this.vertex; i++) {
          if (map[x][i] == 1 && temp[x][i] != 1) {
            stack.push(new Point(x, i));

            temp[x][i] = 1;
            temp[i][x] = 1;

            break;
          }
        }
      }

      for(Integer iter :  result){
        System.out.print(iter + " ");
      }

      return pointList;
    }
    */

    public void view() {
      for (int i = 0; i < this.vertex; i++) {
        for (int j = 0; j < this.vertex; j++) {
          System.out.print(this.map[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}
