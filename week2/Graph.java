package com.pakpark.Second;

import java.util.*;

public class Graph {

  public static void main(String[] args) {
    String[] input = scan.nextLine().split(" ");

    int vertex = Integer.parseInt(input[0]);
    int link = Integer.parseInt(input[1]);
    int start = Integer.parseInt(input[2]);

    graphSearch(vertex, link, start);
  }

  public static Scanner scan = new Scanner(System.in);

  public static Node[] list;
  private static int n;

  private Set<Integer> vertexSet = new HashSet<>();

  public class Node {
    int vertex; // 정점.  배열의 정점을 표현하는 건 이 vertex.
    Node link;  // 간선.
  }

  public Graph(int v) {
    list = new Node[v + 1]; // 정점 배열의 갯수. Ndoe 배열의 index 와 입력 받은 vertex를 맞춰 주기 위한 작업. list[0] 은 버리고 간다.
    this.n = v;
  }

  /**
   * 양방향 그래프.
   * - 두 정점 사이에 여러개의 간선이 있을 수 있다.
   *
   * @param v1, vertex1
   * @param v2, vertex2
   */
  public void insertEdge(int v1, int v2) {
    if (v1 < 0 || v1 > n || v2 < 0 || v2 > n) {
      return;
    } else {
      Node newNode1 = new Node();

      newNode1.vertex = v2;
      newNode1.link = list[v1];

      list[v1] = newNode1;

      Node newNode2 = new Node();

      newNode2.vertex = v1;
      newNode2.link = list[v2];

      list[v2] = newNode2;
    }
  }

  public void printAdjList() {
    for (int i = 1; i <= n; i++) {
      System.out.format("정점 %d 의 인접리스트 \n", i);
      for (Node temp = list[i]; temp != null; temp = temp.link) {
        System.out.format(" -> %d ", temp.vertex);
      }
      System.out.println();
    }
  }

  public static void graphSearch(int vertex, int link, int start) {
    Graph graph = new Graph(vertex);

    for (int i = 0; i < link; i++) {
      String[] vertexs = scan.nextLine().split(" ");

      int v1 = Integer.parseInt(vertexs[0]);
      int v2 = Integer.parseInt(vertexs[1]);

      graph.insertEdge(v1, v2);
    }

    graph.printAdjList();
    graph.bfs(start);
  }

  /**
   * BFS, 너비우선탐색.
   * 방문 할 수 있는 정점이 여러개인 경우, 정점 번호가 작은 것 부터 탐색.
   */
  public void bfs(int start) {
    int min = start;
    int next = 0;
    List<Integer> tempList = new ArrayList<>();
    Queue<Integer> result = new LinkedList<>();

    result.add(start);
    for (Node temp = list[min]; temp != null; temp = temp.link) {
      tempList.add(temp.vertex);
    }

    Arrays.sort(tempList.toArray());
    next = tempList.get(0); //next temp;

    for (int i = 0; i < tempList.size(); i++) {
      ((LinkedList<Integer>) result).add(tempList.get(i));
    }

    tempList.clear();

    System.out.println(Arrays.toString(result.toArray()));
  }
}
