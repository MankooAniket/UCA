import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class Transversals {
    public static void preOrderRecursive(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrderRecursive(root.leftChild);
        preOrderRecursive(root.rightChild);
    }

    public static void preOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            Node curr = st.pop();
            System.out.print(curr.data + " ");

            if (curr.rightChild != null) {
                st.push(curr.rightChild);
            }
            if (curr.leftChild != null) {
                st.push(curr.leftChild);
            }
        }
    }

    public static void inOrderRecursive(Node root) {
        if (root == null) {
            return;
        }

        inOrderRecursive(root.leftChild);
        System.out.print(root.data + " ");
        inOrderRecursive(root.rightChild);
    }

    // public static void inOrderIterative(Node root) {
    //     Stack<Node> st = new Stack<>();

    // }

    public static void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(root.leftChild);
        postOrderRecursive(root.rightChild);
        System.out.print(root.data + " ");
    }

    // public static void postOrderIterative(Node root) {
    // }

    public static void BFS(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if (curr.leftChild != null) {
                    q.add(curr.leftChild);
                }
                if (curr.rightChild != null) {
                    q.add(curr.rightChild);
                }
            }
        }

    }
}
