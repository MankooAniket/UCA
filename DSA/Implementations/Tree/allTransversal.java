import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
        this.node = node;
        this.state = state;
    }
}

public class allTransversal {
    public static void allTransversalInOne(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if (root == null) {
            return;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair curr = st.pop();

            if (curr.state == 1) {
                pre.add(curr.node.data);

                curr.state++;
                st.push(curr);

                if (curr.node.leftChild != null) {
                    st.push(new Pair(curr.node.leftChild, 1));
                }
            }

            else if (curr.state == 2) {
                in.add(curr.node.data);

                curr.state++;
                st.push(curr);

                if (curr.node.rightChild != null) {
                    st.push(new Pair(curr.node.rightChild, 1));
                }
            }

            else {
                post.add(curr.node.data);
            }
        }
        
        System.out.println("PreOrder: " + pre);
        System.out.println("InOrder: " + in);
        System.out.println("PostOrder: " + post);
    }
}
