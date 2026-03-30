import java.util.Scanner;

public class BinaryTree {

  static int idx = 0;

  public static Node buildTree(int[] arr) {
    if (idx >= arr.length || arr[idx] == -1) {
      idx++;
      return null;
    }

    Node root = new Node(arr[idx++]);
    root.leftChild = buildTree(arr);
    root.rightChild = buildTree(arr);

    return root;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Size: ");
    int size = sc.nextInt();

    int[] arr = new int[size];
    System.out.print("Input: ");
    for (int i = 0; i < size; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println();
    System.out.println();

    sc.close();

    Node root = buildTree(arr);

    System.out.println("Deapth-First Transversal:-");

    System.out.print("Pre-Order Transversal: ");
    Transversals.preOrderRecursive(root);

    System.out.println();

    System.out.print("In-Order Transversal: ");
    Transversals.inOrderRecursive(root);

    System.out.println();

    System.out.print("Post-Order Transversal: ");
    Transversals.postOrderRecursive(root);

    System.out.println();
    System.out.println();

    System.out.println("Breadth-First Transversal/Level-Order Transversal:-");
    Transversals.BFS(root);

    System.out.println();
  }
}
