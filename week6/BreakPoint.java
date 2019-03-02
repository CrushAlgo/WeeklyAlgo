package week6;

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

    for (Integer iter : graph.keySet()) {
      System.out.println(iter + " : " + Arrays.toString(graph.get(iter).toArray()));
    }

    for (Integer iter : graph.keySet()) {
      Map<Integer, List<Integer>> tempMap = removePoint(iter, graph);
      System.out.format("삭제 된 point: %d, 그래프: %s \n", iter, search2(tempMap));
      System.out.println("삭제 후 main 그래프 상태: " + tempMap.keySet());
      System.out.println();
    }
  }

  /**
   * queue를 이용한 탐색.
   * - 시작점을 잡고, 시작점에 연결된 간선 만큼의 지점들을 넣늗다.
   * - 그 지점에 연결된 또 다른 지점들을 넣으면서 검사.
   */
  public static Set<Integer> search2(Map<Integer, List<Integer>> graph) {
    //탐색한 정점들 모아 놓은 리스트.
    Set<Integer> pointSet = new HashSet<>();

    //첫번쨰 정점.
    int start = graph.keySet().iterator().next();

    //Queue, 정점을 시작으로 형제를 먼저 탐색.
    Queue<Integer> queue = new LinkedList<>();

    queue.add(start);

    //탐색, (BFS)
    while (!queue.isEmpty()) {
      int point = queue.poll();
      pointSet.add(point);

      List<Integer> brothers = graph.get(point);
      for (int broIter : brothers) {
        if (!pointSet.contains(broIter)) {
          queue.add(broIter);
          pointSet.add(broIter);
        }
      }
    }

    return pointSet;
  }

  /**
   * Map copy, java 에서는 Deep Copy 가 지원 되지 않으므로 새로운 객체를 생성해서 하나씩 복사해야한다.
   * https://offbyone.tistory.com/370
   * @param point
   * @param graph
   * @return
   */
  public static Map<Integer, List<Integer>> removePoint(int point, Map<Integer, List<Integer>> graph) {
    Map<Integer, List<Integer>> tempGraph = new HashMap<>();
    for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
      tempGraph.put(entry.getKey(), entry.getValue());
    }

    System.out.format("복사한 graph: %s \n", Arrays.toString(tempGraph.entrySet().toArray()));

    tempGraph.remove(point);

    for (int mapIter : tempGraph.keySet()) {
      List<Integer> pointList = tempGraph.get(mapIter);
      if (pointList.contains(point)) {
        System.out.format("delete: %d, boolean: %s \n", point, pointList.remove(point));
      }
    }

    System.out.println("삭제 포인트: " + point);
    for (Integer iter : tempGraph.keySet()) {
      System.out.println(iter + " : " + Arrays.toString(tempGraph.get(iter).toArray()));
    }

    return tempGraph;
  }
}
