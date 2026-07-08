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

    public static void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.leftChild;
            }

            curr = st.pop();
            System.out.print(curr.data + " ");

            curr = curr.rightChild;
        }
    }

    public static void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(root.leftChild);
        postOrderRecursive(root.rightChild);
        System.out.print(root.data + " ");
    }

    public static void postOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty()) {
            Node curr = st1.pop();
            st2.push(curr);

            if (curr.leftChild != null) {
                st1.push(curr.leftChild);
            }

            if (curr.rightChild != null) {
                st1.push(curr.rightChild);
            }
        }

        while (!st2.isEmpty()) {
            System.out.print(st2.pop().data + " ");
        }
    }

    public static void postOrderOneStack(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> st = new Stack<>();
        Node lastVisited = null;
        Node curr = root;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.leftChild;
            }

            Node peekNode = st.peek();

            if (peekNode.rightChild != null && lastVisited != peekNode.rightChild) {
                curr = peekNode.rightChild;
            } else {
                System.out.print(peekNode.data + " ");
                lastVisited = st.pop();
            }
        }
        return;
    }

    public static void BFS(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node front = q.poll();

            if (front == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                System.out.print(front.data + " ");
                if (front.leftChild != null) {
                    q.add(front.leftChild);
                }
                if (front.rightChild != null) {
                    q.add(front.rightChild);
                }
            }
        }

    }

    public static void BFSWithoutNull(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if (curr.leftChild != null) {
                    q.add(curr.leftChild);
                }
                if (curr.rightChild != null) {
                    q.add(curr.rightChild);
                }
            }
            System.out.println();
        }
    }

    public static void reverseBFS(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        Stack<Node> st = new Stack<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                st.push(curr);

                if (curr.rightChild != null) {
                    q.add(curr.rightChild);
                }

                if (curr.leftChild != null) {
                    q.add(curr.leftChild);
                }
            }

            st.push(null);
        }

        while (!st.isEmpty()) {
            if (st.peek() == null) {
                System.out.println();
                st.pop();
            } else {
                System.out.print(st.pop().data + " ");
            }
        }
    }
}
