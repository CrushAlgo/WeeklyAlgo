package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchTree2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeNode treeNode = new TreeNode();

    String line = null;
    while (!(line = br.readLine()).equals("")) {
      treeNode.insertBST(treeNode, Integer.parseInt(line));
    }

    treeNode.postOrder(treeNode);
  }

}

class TreeNode {

  public int key;
  public TreeNode leftNode;
  public TreeNode rightNode;

  private TreeNode root;

  public TreeNode() {
    this.leftNode = null;
    this.rightNode = null;
  }

  public TreeNode(int key) {
    this.key = key;
    this.leftNode = null;
    this.rightNode = null;
  }

  /**
   * # 트리 탐색 메소드
   * 'key'에 해당하는 노드 찾는 메소드, 찾으면 해당 노드를 반환한다.
   * - 검색 메소드를 먼저 구현해야 하는데, 숫자로 들어오는 값에 대해, 이진 트리에 어느 곳에 위치 할 수 있는지 일단 검색을 한 후에 노드를 추가해야 한다.
   *
   * @param treeNode
   * @param key
   * @return
   */
  public TreeNode searchBST(TreeNode treeNode, int key) {
    if (root == null) return null;  // 탐색 실패.

    int nodekey = treeNode.key;

    if (nodekey == key) return treeNode;
    else if (nodekey > key) return searchBST(treeNode.leftNode, key);
    else return searchBST(treeNode.rightNode, key);
  }

  public TreeNode insertBST(TreeNode root, int key) {
    TreeNode tempNode = root;
    TreeNode preNode = tempNode;

    while (tempNode != null) {
      if (tempNode.key == key) return null;

      preNode = tempNode;

      if (tempNode.key > key) tempNode = tempNode.leftNode;
      else tempNode = tempNode.rightNode;
    }

    TreeNode newNode = new TreeNode(key);
    if (root == null) {
      this.root.key = key;
      return this.root; // root 노드 생성.
    }
    else if (preNode.key > key) preNode.leftNode = newNode;
    else preNode.rightNode = newNode;

    return root;
  }


  public void postOrder(TreeNode treeNode) {
    if (treeNode != null) {
      postOrder(treeNode.leftNode);
      postOrder(treeNode.rightNode);

      /*
      출력문이 마지막에 있으면 'postorder (후위)'
      중간에 있으면, 'inorder (중위)'
      처음에 있으면, 'preorder (전위)'
       */
      System.out.println(treeNode.key);
    }
  }
}
