// package Tree;

// public class BinarySearchTree<Key extends Comparable<Key>, Value> {

//   }

//   // public Key min() {

//   // }

//   // public Key max() {

//   // }

//   // public Key floor(Key key) {

//   // }

//   // public Key ceil(Key key) {

//   // }

//   public Value get(Key key) {
//     return get(root, key);
//   }

//   private Value get(Node x, Key key) {
//     if (x == null)
//       return null;

//     int cmp = key.compareTo(x.key);

//     if (cmp == 0)
//       return x.value;
//     else if (cmp < 0)
//       return get(x.left, key);
//     else
//       return get(x.right, key);
//   }

//   public void put();
// }
