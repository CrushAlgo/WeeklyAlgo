package week7;

import java.io.*;
import java.util.*;

public class BinarySearchTree {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Node node = new Node();

    List<String> list = new ArrayList<>();
    String line = null;
    while (!(line = br.readLine()).equals("")) {
      list.add(line);
    }

    for (int i = 0; i < list.size(); i++) {
      int value = Integer.parseInt(list.get(i));
      if(i == 0) node.root = new Node(value);
      else node.insert(value);
    }

    node.back(node.root);
  }
}

class Node {
  int value;

  Node leftNode;
  Node rightNode;
  Node root;

  public Node(int value) {
    this.value = value;
    this.leftNode = null;
    this.rightNode = null;
  }

  public Node() {
    this.leftNode = null;
    this.rightNode = null;
  }

  public Node search(Node root, int value) {
    int rValue = root.value;

    if (rValue > value) {
      if (root.leftNode == null) return root;
      else return search(root.leftNode, value);
    } else {
      if (root.rightNode == null) return root;
      return search(root.rightNode, value);
    }
  }

  public void insert(int value) {
    Node beforeNode = search(root, value);
    Node newNode = new Node(value);

    int beforeValue = beforeNode.value;

    if (beforeValue > value) beforeNode.leftNode = newNode;
    else beforeNode.rightNode = newNode;
  }

  public void back(Node root) {
    if (root != null) {
      back(root.leftNode);
      back(root.rightNode);
      System.out.println(root.value);
    }
  }
}