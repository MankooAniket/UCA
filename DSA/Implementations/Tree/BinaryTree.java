import java.util.Scanner;

public class BinaryTree {

  static int idx = 0;
  static int diameter = 0;

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

  public static int height(Node root) {
    if (root == null) {
      return 0;
    }

    int leftDepth = height(root.leftChild);
    int rightDepth = height(root.rightChild);
    int maxDepth = 1 + Math.max(leftDepth, rightDepth);

    diameter = Math.max(diameter, leftDepth + rightDepth);

    return maxDepth;
  }

 // The following approch is O(n^2). There is a optimised way to calculate diameter by calculating it everytime during height function.

  public static int diameter(Node root) {
    if (root == null) {
      return 0;
    }

    int option1 = height(root.leftChild) + height(root.rightChild) + 1;
    int option2 = diameter(root.leftChild);
    int option3 = diameter(root.rightChild);

    return Math.max(option1, Math.max(option2, option3));
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

    // System.out.println("Deapth-First Transversal:-");

    // System.out.print("Pre-Order Transversal: ");
    // Transversals.preOrderRecursive(root);

    // System.out.println();

    // System.out.print("In-Order Transversal: ");
    // Transversals.inOrderRecursive(root);

    // System.out.println();

    // System.out.print("Post-Order Transversal: ");
    // Transversals.postOrderOneStack(root);

    // System.out.println();
    // System.out.println();

    // System.out.println("Breadth-First Transversal/Level-Order Transversal:-");
    // Transversals.BFSWithoutNull(root);

    // System.out.println();

    // System.out.println("Reverse BFS:-");
    // Transversals.reverseBFS(root);

    // System.out.println();

    // System.out.println("All Order in One Transversal: ");
    // allTransversal.allTransversalInOne(root);

    System.out.println("Height/Depth of Tree: " + height(root));
    // System.out.println("Diameter of Tree: " + diameter(root));
    System.out.println("Diameter of Tree: " + diameter);
  }
}
