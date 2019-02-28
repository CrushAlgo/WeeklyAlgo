package week6;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * List 초기화
 * : List<Object> list = Arrays.asList(obj1, obj2, ...);
 * = places 고정, 변경이 안된다.
 * : List<Object> list = new ArraysList<>(Arrays.asList(obj1, obj2, ...));
 * = 변경 가능.
 */
public class BreakPoint {

  public static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

//    String[] vertexEdge = scan.nextLine().split(" ");
//    int vertex = Integer.parseInt(vertexEdge[0]);
//    int edge = Integer.parseInt(vertexEdge[1]);
//
//    String[] points = new String[vertex];
//    for (int i = 0; i < vertex; i++) {
//      points[i] = scan.nextLine();
//    }

    int testVertex = 7;
    int testEdge = 7;
    String[] testPoints = {"1 4", "4 5", "5 1", "1 6", "6 7", "2 7", "7 3"};
    solution(testVertex, testEdge, testPoints);
  }

  public static void solution(int vertexs, int edges, String[] points) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < edges; i++) {
      String[] point = points[i].split(" ");
      int point1 = Integer.parseInt(point[0]);
      int point2 = Integer.parseInt(point[1]);

      if (graph.containsKey(point1)) {
        graph.get(point1).add(point2);
      } else {
        graph.put(point1, new ArrayList<>(Arrays.asList(point2)));
      }

      if (graph.containsKey(point2)) {
        graph.get(point2).add(point1);
      } else {
        graph.put(point2, new ArrayList<>(Arrays.asList(point1)));
      }
    }

    Iterator pointIter = graph.keySet().iterator();
    int start = Integer.parseInt(pointIter.next().toString());
    int next = Integer.parseInt(pointIter.next().toString());

    graph.remove(start);

    int searchResult = search(next, graph);

    if(searchResult == 0) System.out.println("완전연결");
    else System.out.println("간선 없다");

//    for (Integer iter : graph.keySet()) {
//      System.out.println(iter + " : " + Arrays.toString(graph.get(iter).toArray()));
//    }
  }

  public static int search(int point, Map<Integer, List<Integer>> graph) {
    List<Integer> pointEdge = graph.get(point);

    //point 에 간선이 없을 때
    if(pointEdge.isEmpty()) return -1;

    int nextPoint = 0;
    for(int i=0; i<pointEdge.size(); i++) {
      int p = pointEdge.get(i);

      if(list.contains(p)) continue;
      else {
        nextPoint = p;
        list.add(p);
        return search(nextPoint, graph);
      }
    }

    return 0;
  }
}
